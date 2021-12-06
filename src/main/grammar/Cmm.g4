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

<<<<<<< HEAD
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
=======
functionArguments returns[ArrayList<Expression> args]: {
        $args = new ArrayList<Expression>();
    } (e1=expression {
        $args.add($e1.exp);
    } (COMMA e2=expression {
        $args.add($e2.exp);
    })*)?;

//todo
body returns[BlockStmt bodystmt]:
     (blockStatement | (NEWLINE+ singleStatement (SEMICOLON)?));

//todo
loopCondBody returns[BlockStmt loopCond]:
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
ifStatement returns[ConditionalStmt ifStmt]:
    ifLine = IF
    ex1 = expression
//    {
//        $ifStmt = new ConditionalStmt($ex1.exp);
//        $ifStmt.setLine($ifLine.getLine());
//    }
    (loopCondBody | body elseStatement);

//todo
elseStatement returns [Statement elseStmt] :
     NEWLINE*
     elseLine = ELSE lpcond = loopCondBody
     {
//        $elseStmt = $lpcond.loopCond;
//        $elseStmt.setLine($elseLine.getLine());
     };
>>>>>>> ec5215cd4008bc58a9475921e85b0d300d056675

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

<<<<<<< HEAD
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
=======
//not sure for while condition
whileLoopStatement returns[LoopStmt whilestmt]:
    whLine = WHILE ex1 = expression lpbdy = loopCondBody
    {
        $whilestmt = new LoopStmt();
//        ConditionalStmt cond1 = new ConditionalStmt($ex1.exp);
        $whilestmt.setCondition($ex1.exp);
        $whilestmt.setBody($lpbdy.loopCond);
        $whilestmt.setLine($whLine.getLine());
    };


doWhileLoopStatement returns[LoopStmt dowhile]:
    doLine = DO bd1 = body
    {
        $dowhile = new LoopStmt();
        $dowhile.setBody($bd1.bodystmt);
        $dowhile.setLine($doLine.getLine());
    }
    NEWLINE*
    whLine = WHILE ex2 = expression
    {
//        ConditionalStmt cond1 = new ConditionalStmt($ex2.exp);
        $dowhile.setCondition($ex2.exp);

    };


displayStatement returns [DisplayStmt display] :
  disLine = DISPLAY LPAR ex1 = expression
  {
    $display = new DisplayStmt($ex1.exp);
    $display.setLine($disLine.getLine());
  }
  RPAR;


assignmentStatement returns [AssignmentStmt assign]:
    orexp = orExpression assingLine = ASSIGN ex1 = expression
    {
        $assign = new AssignmentStmt($orexp.exp, $ex1.exp);
        $assign.setLine($assingLine.getLine());
    };

//todo
singleStatement :
// returns [Statement singlestmt]
    ifStatement | displayStatement | functionCallStmt | returnStatement | assignmentStatement
    | varDecStatement | loopStatement | append | size;
>>>>>>> ec5215cd4008bc58a9475921e85b0d300d056675

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
<<<<<<< HEAD
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
=======
    e1=otherExpression {
        $exp = $e1.exp;
    } ((LPAR args=functionArguments RPAR {
        $exp = new FunctionCall($exp, $args.args);
//        $exp.setLine($LPAR.line);
    }) | (DOT id=identifier {
        $exp = new StructAccess($exp, $id.ID);
        $exp.setLine($DOT.line);
    }))* ((LBRACK e2=expression RBRACK {
        $exp = new ListAccessByIndex($exp, $e2.exp);
//        $exp.setLine($LBRACK.line);
    }) | (DOT id=identifier {
        $exp = new StructAccess($exp, $id.ID);
        $exp.setLine($DOT.line);
    }))*;

otherExpression returns[Expression exp]:
    e1=value {
        $exp = $e1.val;
    } | e2=identifier {
        $exp = $e2.ID;
    } | LPAR (args=functionArguments) RPAR {
        $exp = new ExprInPar($args.args);
//        $exp.setLine($LPAR.line);
    } | size {
        $exp = $size.exp;
    } | append {
        $exp = $append.exp;
    };
>>>>>>> ec5215cd4008bc58a9475921e85b0d300d056675

size returns[Expression exp]:
    sizeLine = SIZE LPAR e1=expression RPAR {
        $exp = new ListSize($e1.exp);
        $exp.setLine($sizeLine.line);
    };

append returns[Expression exp]:
    appendLine = APPEND LPAR e1=expression COMMA e2=expression RPAR
    {
        $exp = new ListAppend($e1.exp, $e2.exp);
        $exp.setLine($appendLine.getLine());
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
<<<<<<< HEAD
    LIST SHARP type {$varType = new ListType($type.varType);} |
    STRUCT identifier {$varType = new StructType($identifier.ID);} |
    fptrType {$varType = $fptrType.fptr;};
=======
    LIST SHARP listType=type {$varType = new ListType($listType.varType);} |
    STRUCT structID=identifier {$varType = new StructType($structID.ID);} |
    fptr=fptrType {$varType = $fptr.fptype;};
>>>>>>> ec5215cd4008bc58a9475921e85b0d300d056675


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