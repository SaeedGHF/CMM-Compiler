package main.visitor;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.*;
import main.ast.nodes.declaration.struct.StructDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.values.primitive.*;
import main.ast.nodes.statement.*;
import main.ast.types.Type;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.items.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

public class Visitor<T> implements IVisitor<T> {
    private HashMap<String, SymbolTable> allStructsSymbolTable = new HashMap<String, SymbolTable>();
    private HashMap<String, SymbolTable> allFunctionsSymbolTable = new HashMap<String, SymbolTable>();

    public static void createNewSymbolTable() {
        SymbolTable.push(new SymbolTable(SymbolTable.top));
    }

    public SymbolTableItem createVarDecSymbolItem(VariableDeclaration varDeclaration) {
        VariableSymbolTableItem varDec = new VariableSymbolTableItem(varDeclaration.getVarName());
        varDec.setType(varDeclaration.getVarType());
        return ((SymbolTableItem) varDec);
    }

    public SymbolTableItem createFunctionDecSymbolTableItem(FunctionDeclaration funcDeclaration) {
        FunctionSymbolTableItem funcDec = new FunctionSymbolTableItem(funcDeclaration);
        return ((SymbolTableItem) funcDec);
    }

    public SymbolTableItem createStructDecSymbolTableItem(StructDeclaration structDeclaration) {
        StructSymbolTableItem structDec = new StructSymbolTableItem(structDeclaration);
        return ((SymbolTableItem) structDec);
    }

    public SymbolTableItem createNoItemSymbolTableItem(Identifier id) {
        NoItemSymbolTableItem noItem = new NoItemSymbolTableItem(id);
        return ((SymbolTableItem) noItem);
    }

    public void putToSymbolTable(SymbolTableItem item) {
        try {
            SymbolTable.top.put(item);
        } catch (ItemAlreadyExistsException error) {
            System.out.println("____ ItemAlreadyExistsException.");
        }
    }


    @Override
    public T visit(Program program) {
        return null;
    }

    @Override
    public T visit(FunctionDeclaration functionDeclaration) {
        return null;
    }

    @Override
    public T visit(MainDeclaration mainDeclaration) {
        return null;
    }

    @Override
    public T visit(VariableDeclaration variableDeclaration) {
        return null;
    }

    @Override
    public T visit(StructDeclaration structDeclaration) {
        return null;
    }

    @Override
    public T visit(SetGetVarDeclaration setGetVarDeclaration) {
        return null;
    }

    @Override
    public T visit(AssignmentStmt assignmentStmt) {
        return null;
    }

    @Override
    public T visit(BlockStmt blockStmt) {
        return null;
    }

    @Override
    public T visit(ConditionalStmt conditionalStmt) {
        return null;
    }

    @Override
    public T visit(FunctionCallStmt functionCallStmt) {
        return null;
    }

    @Override
    public T visit(DisplayStmt displayStmt) {
        return null;
    }

    @Override
    public T visit(ReturnStmt returnStmt) {
        return null;
    }

    @Override
    public T visit(LoopStmt loopStmt) {
        return null;
    }

    @Override
    public T visit(VarDecStmt varDecStmt) {
        return null;
    }

    @Override
    public T visit(ListAppendStmt listAppendStmt) {
        return null;
    }

    @Override
    public T visit(ListSizeStmt listSizeStmt) {
        return null;
    }

    @Override
    public T visit(BinaryExpression binaryExpression) {
        return null;
    }

    @Override
    public T visit(UnaryExpression unaryExpression) {
        return null;
    }

    @Override
    public T visit(Identifier identifier) {
        return null;
    }

    @Override
    public T visit(ListAccessByIndex listAccessByIndex) {
        return null;
    }

    @Override
    public T visit(StructAccess structAccess) {
        return null;
    }

    @Override
    public T visit(FunctionCall functionCall) {
        return null;
    }

    @Override
    public T visit(IntValue intValue) {
        return null;
    }

    @Override
    public T visit(BoolValue boolValue) {
        return null;
    }

    @Override
    public T visit(ListSize listSize) {
        return null;
    }

    @Override
    public T visit(ListAppend listAppend) {
        return null;
    }

    @Override
    public T visit(ExprInPar exprInPar) {
        return null;
    }
}
