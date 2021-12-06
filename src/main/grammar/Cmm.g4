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

functionArguments returns[ArrayList<Expression> args]: {
        $args = new ArrayList<Expression>();
    } (e1=expression {
        $args.add($e1.exp);
    } (COMMA e2=expression {
        $args.add($e2.exp);
    })*)?;

//todo
body :
     (blockStatement | (NEWLINE+ singleStatement (SEMICOLON)?));

//todo
loopCondBody :
     (blockStatement | (NEWLINE+ singleStatement ));

//todo
blockStatement :
    BEGIN (NEWLINE+ (singleStatement SEMICOLON)* singleStatement (SEMICOLON)?)+ NEWLINE+ END;

//todo
varDecStatement :
    type identifier (ASSIGN orExpression )? (COMMA identifier (ASSIGN orExpression)? )*;

//todo
functionCallStmt :
     otherExpression ((LPAR functionArguments RPAR) | (DOT identifier))* (LPAR functionArguments RPAR);

//todo
returnStatement :
    RETURN (expression)?;

//todo
ifStatement :
    IF expression (loopCondBody | body elseStatement);

//todo
elseStatement :
     NEWLINE* ELSE loopCondBody;

//todo
loopStatement :
    whileLoopStatement | doWhileLoopStatement;

//todo
whileLoopStatement :
    WHILE expression loopCondBody;

//todo
doWhileLoopStatement :
    DO body NEWLINE* WHILE expression;

//todo
displayStatement :
  DISPLAY LPAR expression RPAR;

//todo
assignmentStatement :
    orExpression ASSIGN expression;

//todo
singleStatement :
    ifStatement | displayStatement | functionCallStmt | returnStatement | assignmentStatement
    | varDecStatement | loopStatement | append | size;

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
        $exp = new UnaryExpression(UnaryOperator.not);
        $exp.setLine($op_not.line);
    }) | (op_minus=MINUS e2=preUnaryExpression {
        $exp = new UnaryExpression(UnaryOperator.minus);
        $exp.setLine($op_minus.line);
    }) | e3=accessExpression {
        $exp = $e3.exp;
    };

accessExpression returns[Expression exp]:
    e1=otherExpression {
        $exp = e1.exp;
    } ((LPAR args=functionArguments RPAR {
        $exp = new FunctionCall($exp, $args.args);
        $exp.setLine($LPAR.line);
    }) | (DOT id=identifier {
        $exp = new StructAccess($exp, $id.ID);
        $exp.setLine($DOT.line);
    }))* ((LBRACK e2=expression RBRACK {
        $exp = new ListAccessByIndex($exp, $e2.exp);
        $exp.setLine($LBRACK.line);
    }) | (DOT id=identifier {
        $exp = new StructAccess($exp, $id.ID);
        $exp.setLine($DOT.line);
    }))*;

otherExpression returns[Expression exp]:
    e1=value {
        $exp = e1.val;
    } | e2=identifier {
        $exp = e2.ID;
    } | LPAR (args=functionArguments) RPAR {
        $exp = new ExprInPar($args.args);
        $exp.setLine($LPAR.line);
    } | size {
        $exp = $size.exp;
    } | append {
        $exp = $append.exp;
    };

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
    b=boolValue {$val = b.val} |
    i=INT_VALUE {$val = new IntValue(Integer.parseInt($i.text))};

boolValue returns[Value val]:
    TRUE {$val = new BoolValue(True);} |
    FALSE {$val = new BoolValue(False);};

identifier returns[Identifier ID]:
    name=IDENTIFIER {$ID = new Identifier($name.text);};

type returns[Type varType]:
    INT {$varType = new IntType();} |
    BOOL {$varType = new BoolType();} |
    LIST SHARP listType=type {$varType = new ListType($listType.varType);} |
    STRUCT structID=identifier {$varType = new StructType($structID.ID);} |
    fptr=fptrType {$varType = $fptr.fptr;};

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