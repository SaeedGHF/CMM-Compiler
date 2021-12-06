grammar Cmm;

@header{
     import main.ast.nodes.*;
     import main.ast.nodes.declaration.*;
     import main.ast.nodes.declaration.struct.*;
     import main.ast.nodes.expression.*;
     import main.ast.nodes.expression.operators.*;
     import main.ast.nodes.expression.values.*;
     import main.ast.nodes.expression.values.primitive.*;
     import main.ast.nodes.statement.*;
     import main.ast.types.*;
     import main.ast.types.primitives.*;
     import java.util.*;
 }

cmm returns[Program cmmProgram]:
    NEWLINE* p = program {$cmmProgram = $p.programRet;} NEWLINE* EOF;

program returns[Program programRet]:
    {$programRet = new Program();
     int line = 1;
     $programRet.setLine(line);}
    (s = structDeclaration {$programRet.addStruct($s.structDeclarationRet);})*
    (f = functionDeclaration {$programRet.addFunction($f.functionDeclarationRet);})*
    m = main {$programRet.setMain($m.mainRet);};

//todo
main returns[MainDeclaration mainRet]:
    MAIN LPAR RPAR body;

//todo
structDeclaration returns[StructDeclaration structDeclarationRet]:
    STRUCT identifier ((BEGIN structBody NEWLINE+ END) | (NEWLINE+ singleStatementStructBody SEMICOLON?)) NEWLINE+;

//todo
singleVarWithGetAndSet :
    type identifier functionArgsDec BEGIN NEWLINE+ setBody getBody END;

//todo
singleStatementStructBody :
    varDecStatement | singleVarWithGetAndSet;

//todo
structBody :
    (NEWLINE+ (singleStatementStructBody SEMICOLON)* singleStatementStructBody SEMICOLON?)+;

//todo
getBody :
    GET body NEWLINE+;

//todo
setBody :
    SET body NEWLINE+;

//todo
functionDeclaration returns[FunctionDeclaration functionDeclarationRet]:
    (type | VOID ) identifier functionArgsDec body NEWLINE+;

//todo
functionArgsDec :
    LPAR (type identifier (COMMA type identifier)*)? RPAR ;

functionArguments returns[ArrayList<Expression> args]:
    {$args = new ArrayList<Expression>();}
    (expression {$args.add($expression.exp);} (COMMA expression {$args.add($expression.exp);})*)?;

body returns[Statement stmt]:
     (blockStatement {$stmt = $blockStatement.stmt;} |
     (NEWLINE+ singleStatement {$stmt = $singleStatement.stmt;} (SEMICOLON)?));

loopCondBody returns[Statement stmt]:
     (s1=blockStatement {
        $stmt = $s1.stmt;
     } | (NEWLINE+ s2=singleStatement {
        $stmt = $s2.stmt;
     }));

blockStatement returns[Statement stmt]:
    BEGIN {
        BlockStmt block = new BlockStmt();
        block.setLine($BEGIN.line);
    } (NEWLINE+ (s1=singleStatement SEMICOLON {
        block.addStatement($s1.stmt);
    })* s2=singleStatement {
        block.addStatement($s2.stmt);
    } (SEMICOLON)?)+ {
        $stmt = block;
    } NEWLINE+ END;

varDecStatement returns[Statement stmt]:
    type identifier {
        $stmt = new VarDecStmt();
        $stmt.setLine($type.varType.line);
        VariableDeclaration varDec = new VariableDeclaration($identifier.ID, $type.varType);
    } (ASSIGN orExpression {
        varDec.setDefaultValue($orExpression.exp);
    })? {
        $stmt.addVar(varDec);
    } (COMMA id_=identifier {
        VariableDeclaration varDec_ = new VariableDeclaration($id_.ID, $type.varType);
    } (ASSIGN e_=orExpression {
        varDec_.setDefaultValue($e_.exp);
    })? {
        $stmt.addVar(varDec_);
    })*;

functionCallStmt returns[Statement stmt]:
    e=otherExpression {
        Expression instance = $e.exp;
    } ((LPAR {
        FunctionCall fc = new FunctionCall(instance);
        fc.setLine($LPAR.line);
    } functionArguments {fc.setArgs($functionArguments.args);} RPAR {
        instance = fc;
    }) | (DOT identifier {
        StructAccess sa = new StructAccess(instance, $identifier.ID);
        sa.setLine($DOT.line);
        instance = sa;
    }))*
    (LPAR {
        FunctionCall fc_ = new FunctionCall(instance);
        fc_.setLine($LPAR.line);
    } functionArguments {fc_.setArgs($functionArguments.args);} RPAR)
    {
        $stmt = new FunctionCallStmt(fc_);
        $stmt.setLine($LPAR.line);
    };

returnStatement returns[Statement stmt]:
    RETURN {$stmt = new ReturnStmt();}
    (expression {$stmt.setReturnedExpr($expression.exp);})?;

ifStatement returns[Statement stmt]:
    IF expression {$stmt = new ConditionalStmt($expression.exp);}
    (loopCondBody {$stmt.setThenBody($loopCondBody.stmt);} |
    body {$stmt.setThenBody($body.stmt);}
    elseStatement {$stmt.setElseBody($elseStatement.stmt);});

elseStatement returns[Statement stmt]:
     NEWLINE* ELSE loopCondBody {$stmt = $loopCondBody.stmt;};

loopStatement returns[Statement stmt]:
    whileLoopStatement {$stmt = $whileLoopStatement.stmt;} |
    doWhileLoopStatement {$stmt = $doWhileLoopStatement.stmt;};

whileLoopStatement returns[Statement stmt]:
    WHILE expression loopCondBody {
        $stmt = new LoopStmt();
        $stmt.setLine($WHILE.line);
        $stmt.setCondition($expression.exp);
        $stmt.setBody($loopCondBody.stmt);
    };

doWhileLoopStatement returns[Statement stmt]:
    DO body NEWLINE* WHILE expression {
        $stmt = new LoopStmt();
        $stmt.setLine($DO.line);
        $stmt.setCondition($expression.exp);
        $stmt.setBody($body.stmt);
    };

displayStatement returns[Statement stmt]:
    DISPLAY LPAR expression RPAR {
        $stmt = new DisplayStmt($expression.exp);
        $stmt.setLine($DISPLAY.line);
    };

assignmentStatement returns[Statement stmt]:
    orExpression ASSIGN expression {
        $stmt = new AssignmentStmt($orExpression.exp, $expression.exp);
        $stmt.setLine($ASSIGN.line);
    };

singleStatement returns[Statement stmt]:
    ifStatement {$stmt = $ifStatement.stmt;} |
    displayStatement {$stmt = $displayStatement.stmt;} |
    functionCallStmt {$stmt = $functionCallStmt.stmt;} |
    returnStatement {$stmt = $returnStatement.stmt;} |
    assignmentStatement {$stmt = $assignmentStatement.stmt;} |
    varDecStatement {$stmt = $varDecStatement.stmt;} |
    loopStatement {$stmt = $loopStatement.stmt;} |
    append {$stmt = new ListAppendStmt($append.exp);} |
    size {$stmt = new ListSizeStmt($size.exp);};

expression returns[Expression exp]:
    e1=orExpression {
        $exp = $e1.exp;
    } (op = ASSIGN e2=expression {
        $exp = new BinaryExpression($exp, $e2.exp, BinaryOperator.assign);
        $exp.setLine($op.line);
    })?;

orExpression returns[Expression exp]:
    e1=andExpression {
        $exp = $e1.exp;
    } (op = OR e2=andExpression {
        $exp = new BinaryExpression($exp, $e2.exp, BinaryOperator.or);
        $exp.setLine($op.line);
    })*;

andExpression returns[Expression exp]:
    e1=equalityExpression {
        $exp = $e1.exp;
    } (op = AND e2=equalityExpression {
        $exp = new BinaryExpression($exp, $e2.exp, BinaryOperator.and);
        $exp.setLine($op.line);
    })*;

equalityExpression returns[Expression exp]:
    e1=relationalExpression {
        $exp = $e1.exp;
    } (op = EQUAL e2=relationalExpression {
        $exp = new BinaryExpression($exp, $e2.exp, BinaryOperator.eq);
        $exp.setLine($op.line);
    })*;

relationalExpression returns[Expression exp]:
    e1=additiveExpression {
        $exp = $e1.exp;
    } ((op_gt = GREATER_THAN e2=additiveExpression {
        $exp = new BinaryExpression($exp, $e2.exp, BinaryOperator.gt);
        $exp.setLine($op_gt.line);
    }) | (op_lt = LESS_THAN e3=additiveExpression {
        $exp = new BinaryExpression($exp, $e3.exp, BinaryOperator.lt);
        $exp.setLine($op_lt.line);
    }))*;

additiveExpression returns[Expression exp]:
    e1=multiplicativeExpression {
        $exp = $e1.exp;
    } ((op_plus = PLUS e2=multiplicativeExpression {
        $exp = new BinaryExpression($exp, $e2.exp, BinaryOperator.add);
        $exp.setLine($op_plus.line);
    }) | (op_minus = MINUS e3=multiplicativeExpression {
        $exp = new BinaryExpression($exp, $e3.exp, BinaryOperator.sub);
        $exp.setLine($op_minus.line);
    }))*;

multiplicativeExpression returns[Expression exp]:
    e1=preUnaryExpression {
        $exp = $e1.exp;
    } ((op_mult = MULT e2=preUnaryExpression {
        $exp = new BinaryExpression($exp, $e2.exp, BinaryOperator.mult);
        $exp.setLine($op_mult.line);
    }) | (op_div = DIVIDE e3=preUnaryExpression {
        $exp = new BinaryExpression($exp, $e3.exp, BinaryOperator.div);
        $exp.setLine($op_div.line);
    }))*;

preUnaryExpression returns[Expression exp]:
    (op_not=NOT e1=preUnaryExpression {
        $exp = new UnaryExpression($e1.exp, UnaryOperator.not);
        $exp.setLine($op_not.line);
    }) | (op_minus=MINUS e2=preUnaryExpression {
        $exp = new UnaryExpression($e2.exp, UnaryOperator.minus);
        $exp.setLine($op_minus.line);
    }) | e3=accessExpression {
        $exp = $e3.exp;
    };

accessExpression returns[Expression exp]:
    otherExpression {$exp = $otherExpression.exp;}
    ((LPAR {
        FunctionCall fc = new FunctionCall($exp);
        fc.setLine($LPAR.line);
        $exp = fc;
    } functionArguments {fc.setArgs($functionArguments.args);} RPAR) | (DOT identifier {
        StructAccess sa = new StructAccess($exp, $identifier.ID);
        sa.setLine($DOT.line);
        $exp = sa;
    }))* ((LBRACK expression RBRACK {
        ListAccessByIndex labi = new ListAccessByIndex($exp, $expression.exp);
        labi.setLine($LBRACK.line);
        $exp = labi;
    }) | (DOT identifier {
        StructAccess sa = new StructAccess($exp, $identifier.ID);
        sa.setLine($DOT.line);
        $exp = sa;
    }))*;

otherExpression returns[Expression exp]:
    value {$exp = $value.val;} |
    identifier {$exp = $identifier.ID;} |
    LPAR (functionArguments) RPAR {
        $exp = new ExprInPar($functionArguments.args);
        $exp.setLine($LPAR.line);
    } |
    size {$exp = $size.exp;} |
    append {$exp = $append.exp;};

size returns[Expression exp]:
    SIZE LPAR e1=expression RPAR {
        $exp = new ListSize($e1.exp);
        $exp.setLine($LPAR.line);
    };

append returns[Expression exp]:
    APPEND LPAR e1=expression COMMA e2=expression RPAR
    {
        $exp = new ListAppend($e1.exp, $e2.exp);
        $exp.setLine($APPEND.line);
    };

value returns[Value val]:
    b=boolValue {$val = $b.val;} |
    i=INT_VALUE {$val = new IntValue(Integer.parseInt($i.text));};

boolValue returns[Value val]:
    TRUE {$val = new BoolValue(true);} |
    FALSE {$val = new BoolValue(false);};

identifier returns[Identifier ID]:
    name=IDENTIFIER {$ID = new Identifier($name.text);};

type returns[Type varType]:
    INT {$varType = new IntType();} |
    BOOL {$varType = new BoolType();} |
    LIST SHARP type {$varType = new ListType($type.varType);} |
    STRUCT identifier {$varType = new StructType($identifier.ID);} |
    fptrType {$varType = $fptrType.fptr;};

fptrType returns[Type fptr]:
    {
        ArrayList<Type> argsType = new ArrayList<Type>();
        Type retType;
    }
    FPTR LESS_THAN (VOID {
        Type vt = new VoidType();
        argsType.add(vt);
    } | (firstType=type {
        argsType.add($firstType.varType);
    } (COMMA tp=type {
        argsType.add($tp.varType);
    })*)) ARROW (retType=type {
        retType = $retType.varType;
    } | retVoid=VOID {
        retType = new VoidType();
    }) GREATER_THAN
    {
        $fptr = new FptrType(argsType, retType);
    };

MAIN: 'main';
RETURN: 'return';
VOID: 'void';

SIZE: 'size';
DISPLAY: 'display';
APPEND: 'append';

IF: 'if';
ELSE: 'else';

PLUS: '+';
MINUS: '-';
MULT: '*';
DIVIDE: '/';


EQUAL: '==';
ARROW: '->';
GREATER_THAN: '>';
LESS_THAN: '<';


AND: '&';
OR: '|';
NOT: '~';

TRUE: 'true';
FALSE: 'false';

BEGIN: 'begin';
END: 'end';

INT: 'int';
BOOL: 'bool';
LIST: 'list';
STRUCT: 'struct';
FPTR: 'fptr';
GET: 'get';
SET: 'set';
WHILE: 'while';
DO: 'do';

ASSIGN: '=';
SHARP: '#';
LPAR: '(';
RPAR: ')';
LBRACK: '[';
RBRACK: ']';

COMMA: ',';
DOT: '.';
SEMICOLON: ';';
NEWLINE: '\n';

INT_VALUE: '0' | [1-9][0-9]*;
IDENTIFIER: [a-zA-Z_][A-Za-z0-9_]*;


COMMENT: ('/*' .*? '*/') -> skip;
WS: ([ \t\r]) -> skip;