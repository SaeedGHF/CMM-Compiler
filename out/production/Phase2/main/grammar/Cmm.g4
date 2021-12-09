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

main returns[MainDeclaration mainRet]:
    MAIN LPAR RPAR body {
        MainDeclaration dec = new MainDeclaration();
        dec.setLine($MAIN.line);
        dec.setBody($body.stmt);
        $mainRet = dec;
    };

structDeclaration returns[StructDeclaration structDeclarationRet]:
    STRUCT identifier {
        StructDeclaration dec = new StructDeclaration();
        dec.setLine($STRUCT.line);
        dec.setStructName($identifier.ID);
    } ((BEGIN structBody {
        BlockStmt block = new BlockStmt();
        block.setLine($BEGIN.line);
        block.setStatements($structBody.stmt);
        Statement stmt = block;
        dec.setBody(stmt);
    } NEWLINE+ END) | (NEWLINE+ singleStatementStructBody {
        dec.setBody($singleStatementStructBody.stmt);
    } SEMICOLON?)) NEWLINE+
    {$structDeclarationRet = dec;};

singleVarWithGetAndSet returns[Statement stmt]:
    type identifier {
        SetGetVarDeclaration dec = new SetGetVarDeclaration();
        dec.setLine($identifier.ID.getLine());
        dec.setVarName($identifier.ID);
        dec.setVarType($type.varType);
    } functionArgsDec {
        dec.setArgs($functionArgsDec.args);
    } BEGIN NEWLINE+ setBody {
        dec.setSetterBody($setBody.stmt);
    } getBody {
        dec.setGetterBody($getBody.stmt);
    } END {
        $stmt = dec;
    };

singleStatementStructBody returns[Statement stmt]:
    varDecStatement {
        $stmt = $varDecStatement.stmt;
    } | singleVarWithGetAndSet {
        $stmt = $singleVarWithGetAndSet.stmt;
    };

structBody returns [ArrayList<Statement> stmt]:
    {ArrayList<Statement> statements = new ArrayList<Statement>();}
    (NEWLINE+ (singleStatementStructBody {
        statements.add($singleStatementStructBody.stmt);
    } SEMICOLON)* singleStatementStructBody {
        statements.add($singleStatementStructBody.stmt);
    } SEMICOLON?)+
    {$stmt = statements;};

getBody returns[Statement stmt]:
    GET body {
        $stmt = $body.stmt;
    } NEWLINE+;

setBody returns[Statement stmt]:
    SET body {
        $stmt = $body.stmt;
    } NEWLINE+;

functionDeclaration returns[FunctionDeclaration functionDeclarationRet]:
    {FunctionDeclaration dec = new FunctionDeclaration();}
    (type {dec.setReturnType($type.varType);} | VOID {
        Type voidType = new VoidType();
        dec.setReturnType(voidType);
    }) identifier {
        dec.setFunctionName($identifier.ID);
        dec.setLine($identifier.ID.getLine());
    } functionArgsDec {
        dec.setArgs($functionArgsDec.args);
    } body {
        dec.setBody($body.stmt);
    } NEWLINE+
    {$functionDeclarationRet = dec;};

functionArgsDec returns[ArrayList<VariableDeclaration> args]:
    {ArrayList<VariableDeclaration> a = new ArrayList<VariableDeclaration>();}
    LPAR (type identifier {
        VariableDeclaration dec = new VariableDeclaration($identifier.ID, $type.varType);
        a.add(dec);
    } (COMMA type identifier {
        VariableDeclaration dec_ = new VariableDeclaration($identifier.ID, $type.varType);
        a.add(dec_);
    })*)? RPAR {
        $args = a;
    };

functionArguments returns[ArrayList<Expression> args]:
    {$args = new ArrayList<Expression>();}
    (expression {$args.add($expression.exp);} (COMMA expression {$args.add($expression.exp);})*)?;

body returns[Statement stmt]:
     (blockStatement {$stmt = $blockStatement.stmt;} |
     (NEWLINE+ singleStatement {$stmt = $singleStatement.stmt;} (SEMICOLON)?));

loopCondBody returns[Statement stmt]:
     (blockStatement {$stmt = $blockStatement.stmt;} |
     (NEWLINE+ singleStatement {$stmt = $singleStatement.stmt;}));

blockStatement returns[Statement stmt]:
    BEGIN {
        BlockStmt block = new BlockStmt();
        block.setLine($BEGIN.line);
    } (NEWLINE+ (singleStatement SEMICOLON {
        block.addStatement($singleStatement.stmt);
    })* singleStatement {
        block.addStatement($singleStatement.stmt);
    } (SEMICOLON)?)+ {
        $stmt = block;
    } NEWLINE+ END;

varDecStatement returns[Statement stmt]:
    type identifier {
        VarDecStmt decStmt = new VarDecStmt();
        decStmt.setLine($identifier.ID.getLine());
        VariableDeclaration varDec = new VariableDeclaration($identifier.ID, $type.varType);
    } (ASSIGN orExpression {
        varDec.setDefaultValue($orExpression.exp);
    })? {
        decStmt.addVar(varDec);
    } (COMMA identifier {
        VariableDeclaration varDec_ = new VariableDeclaration($identifier.ID, $type.varType);
    } (ASSIGN e_=orExpression {
        varDec_.setDefaultValue($e_.exp);
    })? {
        decStmt.addVar(varDec_);
    })*
    {
        $stmt = decStmt;
    };

functionCallStmt returns[Statement stmt]:
    otherExpression {
        Expression instance = $otherExpression.exp;
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
    (LPAR functionArguments RPAR)
    {
        FunctionCall call = new FunctionCall(instance);
        call.setLine($LPAR.line);
        call.setArgs($functionArguments.args);
        $stmt = new FunctionCallStmt(call);
        $stmt.setLine($LPAR.line);
    };

returnStatement returns[Statement stmt]:
    RETURN {
        ReturnStmt ret = new ReturnStmt();
    }
    (expression {ret.setReturnedExpr($expression.exp);})?
    {
        $stmt = ret;
    };

ifStatement returns[Statement stmt]:

    IF expression {ConditionalStmt con = new ConditionalStmt($expression.exp);}
    (loopCondBody {con.setThenBody($loopCondBody.stmt);} |
    body {con.setThenBody($body.stmt);}
    elseStatement {con.setElseBody($elseStatement.stmt);})
    {$stmt = con;};

elseStatement returns[Statement stmt]:
     NEWLINE* ELSE loopCondBody {$stmt = $loopCondBody.stmt;};

loopStatement returns[Statement stmt]:
    whileLoopStatement {$stmt = $whileLoopStatement.stmt;} |
    doWhileLoopStatement {$stmt = $doWhileLoopStatement.stmt;};

whileLoopStatement returns[Statement stmt]:
    WHILE expression loopCondBody {
        LoopStmt loop = new LoopStmt();
        loop.setLine($WHILE.line);
        loop.setCondition($expression.exp);
        loop.setBody($loopCondBody.stmt);
        $stmt = loop;
    };

doWhileLoopStatement returns[Statement stmt]:
    DO body NEWLINE* WHILE expression {
        LoopStmt loop = new LoopStmt();
        loop.setLine($DO.line);
        loop.setCondition($expression.exp);
        loop.setBody($body.stmt);
        $stmt = loop;
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
    append {ListAppendStmt app = new ListAppendStmt($append.exp); $stmt = app;} |
    size {ListSizeStmt s = new ListSizeStmt($size.exp); $stmt = s;};

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

size returns[ListSize exp]:
    sizeLine = SIZE LPAR e1=expression RPAR {
        $exp = new ListSize($e1.exp);
        $exp.setLine($sizeLine.line);
    };

append returns[ListAppend exp]:
    APPEND LPAR e1=expression COMMA e2=expression RPAR
    {
        ListAppend app = new ListAppend($e1.exp, $e2.exp);
        app.setLine($APPEND.getLine());
        $exp = app;
    };

value returns[Value val]:
    b=boolValue {$val = $b.boolVal;} |
    i=INT_VALUE
    {
        $val = new IntValue(Integer.parseInt($i.text));
        $val.setLine($i.getLine());
    };

boolValue returns[Value boolVal]:
    trueLine = TRUE
    {
        $boolVal = new BoolValue(true);
        $boolVal.setLine($trueLine.getLine());
    } |
    falseLine = FALSE
    {
        $boolVal = new BoolValue(false);
        $boolVal.setLine($falseLine.getLine());
    };

identifier returns[Identifier ID]:
    name=IDENTIFIER
    {
        $ID = new Identifier($name.text);
        $ID.setLine($name.getLine());
    };

type returns[Type varType]:
    INT {$varType = new IntType();} |
    BOOL {$varType = new BoolType();} |
    LIST SHARP type {$varType = new ListType($type.varType);} |
    STRUCT identifier {$varType = new StructType($identifier.ID);} |
    fptrType {$varType = $fptrType.fptype;};


fptrType returns[FptrType fptype] locals[ArrayList<Type> Ltype]:
    (FPTR
    {
        $Ltype = new ArrayList<>();
    }
    (LESS_THAN (VOID
    {
        VoidType vid = new VoidType();
        $Ltype.add(vid);
    }
     | (t1 = type
     {
        $Ltype.add($t1.varType);
     }
     (COMMA t2 = type
     {
        $Ltype.add($t2.varType);
     }
     )*)) ARROW (
     t3 = type
          {
             $fptype = new FptrType($Ltype, $t3.varType);
          }
          | VOID
          {
            VoidType vd = new VoidType();
             $fptype = new FptrType($Ltype, vd);
          }) GREATER_THAN));

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