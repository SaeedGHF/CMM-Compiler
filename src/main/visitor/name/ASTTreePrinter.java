package main.visitor.name;

import main.ast.nodes.*;
import main.ast.nodes.declaration.*;
import main.ast.nodes.declaration.struct.*;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.values.primitive.*;
import main.ast.nodes.statement.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.items.SymbolTableItem;
import main.visitor.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ASTTreePrinter extends Visitor<Void> {

    public void messagePrinter(int line, String message) {
        System.out.println("Line " + line + ": " + message);
    }

    @Override
    public Void visit(Program program) {
        messagePrinter(program.getLine(), program.toString());
        createNewSymbolTable();
        ArrayList<StructDeclaration> structs = program.getStructs();
        for (StructDeclaration struct : structs) {
            try {
                SymbolTable.top.put(this.createStructDecSymbolTableItem(struct));
            } catch (ItemAlreadyExistsException error) {
                messagePrinter(struct.getLine(), "Duplicate struct " + struct.getStructName().getName());
            }
            try {
                SymbolTable.top.put(this.createNoItemSymbolTableItem(struct.getStructName()));
            } catch (ItemAlreadyExistsException error) {
                //messagePrinter(struct.getLine(), "Duplicate struct " + struct.getStructName().getName());
            }
            struct.accept(this);
        }
        ArrayList<FunctionDeclaration> functions = program.getFunctions();
        for (FunctionDeclaration function : functions) {
            function.accept(this);
        }
        MainDeclaration main = program.getMain();
        main.accept(this);
        return null;
    }

    @Override
    public Void visit(FunctionDeclaration functionDec) {
        messagePrinter(functionDec.getLine(), functionDec.toString());

        try {
            SymbolTable.top.put(this.createFunctionDecSymbolTableItem(functionDec));
        } catch (ItemAlreadyExistsException error) {
            messagePrinter(functionDec.getLine(), "Duplicate function " + functionDec.getFunctionName().getName());
        }
        try {
            SymbolTable.top.put(this.createNoItemSymbolTableItem(functionDec.getFunctionName()));
        } catch (ItemAlreadyExistsException error) {
            messagePrinter(functionDec.getLine(), "Name of function " + functionDec.getFunctionName().getName() + " conflicts with a struct’s name");
        }

        return null;
    }

    @Override
    public Void visit(MainDeclaration mainDec) {
        messagePrinter(mainDec.getLine(), mainDec.toString());
        mainDec.getBody().accept(new Visitor<>());
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
        messagePrinter(setGetVarDec.getLine(), setGetVarDec.toString());
        return null;
    }

    @Override
    public Void visit(AssignmentStmt assignmentStmt) {
        messagePrinter(assignmentStmt.getLine(), assignmentStmt.toString());
        return null;
    }

    @Override
    public Void visit(BlockStmt blockStmt) {
        messagePrinter(blockStmt.getLine(), blockStmt.toString());
        return null;
    }

    @Override
    public Void visit(ConditionalStmt conditionalStmt) {
        messagePrinter(conditionalStmt.getLine(), conditionalStmt.toString());
        return null;
    }

    @Override
    public Void visit(FunctionCallStmt functionCallStmt) {
        messagePrinter(functionCallStmt.getLine(), functionCallStmt.toString());
        return null;
    }

    @Override
    public Void visit(DisplayStmt displayStmt) {
        messagePrinter(displayStmt.getLine(), displayStmt.toString());
        return null;
    }

    @Override
    public Void visit(ReturnStmt returnStmt) {
        messagePrinter(returnStmt.getLine(), returnStmt.toString());
        return null;
    }

    @Override
    public Void visit(LoopStmt loopStmt) {
        messagePrinter(loopStmt.getLine(), loopStmt.toString());
        return null;
    }

    @Override
    public Void visit(VarDecStmt varDecStmt) {
        messagePrinter(varDecStmt.getLine(), varDecStmt.toString());
        return null;
    }

    @Override
    public Void visit(ListAppendStmt listAppendStmt) {
        messagePrinter(listAppendStmt.getLine(), listAppendStmt.toString());
        return null;
    }

    @Override
    public Void visit(ListSizeStmt listSizeStmt) {
        messagePrinter(listSizeStmt.getLine(), listSizeStmt.toString());
        return null;
    }

    @Override
    public Void visit(BinaryExpression binaryExpression) {
        messagePrinter(binaryExpression.getLine(), binaryExpression.toString());
        return null;
    }

    @Override
    public Void visit(UnaryExpression unaryExpression) {
        messagePrinter(unaryExpression.getLine(), unaryExpression.toString());
        return null;
    }

    @Override
    public Void visit(FunctionCall funcCall) {
        messagePrinter(funcCall.getLine(), funcCall.toString());
        return null;
    }

    @Override
    public Void visit(Identifier identifier) {
        messagePrinter(identifier.getLine(), identifier.toString());
        return null;
    }

    @Override
    public Void visit(ListAccessByIndex listAccessByIndex) {
        messagePrinter(listAccessByIndex.getLine(), listAccessByIndex.toString());
        return null;
    }

    @Override
    public Void visit(StructAccess structAccess) {
        messagePrinter(structAccess.getLine(), structAccess.toString());
        return null;
    }

    @Override
    public Void visit(ListSize listSize) {
        messagePrinter(listSize.getLine(), listSize.toString());
        return null;
    }

    @Override
    public Void visit(ListAppend listAppend) {
        messagePrinter(listAppend.getLine(), listAppend.toString());
        return null;
    }

    @Override
    public Void visit(ExprInPar exprInPar) {
        messagePrinter(exprInPar.getLine(), exprInPar.toString());
        return null;
    }

    @Override
    public Void visit(IntValue intValue) {
        messagePrinter(intValue.getLine(), intValue.toString());
        return null;
    }

    @Override
    public Void visit(BoolValue boolValue) {
        messagePrinter(boolValue.getLine(), boolValue.toString());
        return null;
    }
}
