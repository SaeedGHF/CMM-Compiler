package main.visitor.name;

import main.ast.nodes.*;
import main.ast.nodes.declaration.*;
import main.ast.nodes.declaration.struct.*;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.values.primitive.*;
import main.ast.nodes.statement.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.visitor.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ASTTreePrinter extends Visitor<Void> {
    public void messagePrinter(int line, String message) {
        System.out.println("Line " + line + ": " + message);
    }

    @Override
    public Void visit(Program program) {
        createNewSymbolTable();
        messagePrinter(program.getLine(), program.toString());
        ArrayList<StructDeclaration> structs = program.getStructs();
        for (StructDeclaration struct : structs) {
            struct.accept(this);
        }
        ArrayList<FunctionDeclaration> functions = program.getFunctions();
        for (FunctionDeclaration function : functions) function.accept(this);

        MainDeclaration main = program.getMain();
        main.accept(this);
        ArrayList<Boolean> structDecIsValid = new ArrayList<Boolean>();
        for (int i = 0; i < structs.size(); i++) {
            try {
                SymbolTable.top.put(this.createStructDecSymbolTableItem(structs.get(i)));
                structDecIsValid.add(true);
            } catch (ItemAlreadyExistsException error) {
                messagePrinter(structs.get(i).getLine(), "Duplicate struct " + structs.get(i).getStructName().getName());
                structDecIsValid.add(false);
            }
        }
        return null;
    }

    @Override
    public Void visit(FunctionDeclaration functionDec) {
        messagePrinter(functionDec.getLine(), functionDec.toString());

        return null;
    }

    @Override
    public Void visit(MainDeclaration mainDec) {
        messagePrinter(mainDec.getLine(), mainDec.toString());
        return null;
    }

    @Override
    public Void visit(VariableDeclaration variableDec) {
        messagePrinter(variableDec.getLine(), variableDec.toString());

        return null;
    }

    @Override
    public Void visit(StructDeclaration structDec) {
        messagePrinter(structDec.getLine(), structDec.toString());
        return null;
    }

    @Override
    public Void visit(SetGetVarDeclaration setGetVarDec) {
        //todo
        return null;
    }

    @Override
    public Void visit(AssignmentStmt assignmentStmt) {
        //todo
        return null;
    }

    @Override
    public Void visit(BlockStmt blockStmt) {
        //todo
        return null;
    }

    @Override
    public Void visit(ConditionalStmt conditionalStmt) {
        //todo
        return null;
    }

    @Override
    public Void visit(FunctionCallStmt functionCallStmt) {
        //todo
        return null;
    }

    @Override
    public Void visit(DisplayStmt displayStmt) {
        //todo
        return null;
    }

    @Override
    public Void visit(ReturnStmt returnStmt) {
        //todo
        return null;
    }

    @Override
    public Void visit(LoopStmt loopStmt) {
        //todo
        return null;
    }

    @Override
    public Void visit(VarDecStmt varDecStmt) {
        //todo
        return null;
    }

    @Override
    public Void visit(ListAppendStmt listAppendStmt) {
        //todo
        return null;
    }

    @Override
    public Void visit(ListSizeStmt listSizeStmt) {
        //todo
        return null;
    }

    @Override
    public Void visit(BinaryExpression binaryExpression) {
        //todo
        return null;
    }

    @Override
    public Void visit(UnaryExpression unaryExpression) {
        //todo
        return null;
    }

    @Override
    public Void visit(FunctionCall funcCall) {
        //todo
        return null;
    }

    @Override
    public Void visit(Identifier identifier) {
        //todo
        return null;
    }

    @Override
    public Void visit(ListAccessByIndex listAccessByIndex) {
        //todo
        return null;
    }

    @Override
    public Void visit(StructAccess structAccess) {
        //todo
        return null;
    }

    @Override
    public Void visit(ListSize listSize) {
        //todo
        return null;
    }

    @Override
    public Void visit(ListAppend listAppend) {
        //todo
        return null;
    }

    @Override
    public Void visit(ExprInPar exprInPar) {
        //todo
        return null;
    }

    @Override
    public Void visit(IntValue intValue) {
        //todo
        return null;
    }

    @Override
    public Void visit(BoolValue boolValue) {
        //todo
        return null;
    }
}
