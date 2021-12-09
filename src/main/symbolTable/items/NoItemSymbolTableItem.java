package main.symbolTable.items;

import main.ast.nodes.expression.Identifier;
import main.symbolTable.SymbolTable;

public class NoItemSymbolTableItem extends SymbolTableItem {
    public static final String START_KEY = "NoItem_";
    private SymbolTable NoItemSymbolTable;

    public NoItemSymbolTableItem(Identifier id) {
        this.name = id.getName();
    }

    @Override
    public String getKey() {
        return START_KEY + this.name;
    }
}
