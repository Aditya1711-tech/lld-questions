package entities;

import enums.Symbol;
import stateHandlers.context.GameContext;

public class Board {
    private int rows;
    private int columns;
    private Symbol[][] grid;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        grid = new Symbol[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                grid[i][j] = Symbol.EMPTY;
            }
        }
    }

    public boolean isValidMove(Position move) {
        return move.getRow() >= 0 && move.getRow() < rows && move.getCol() >= 0 && move.getCol() < columns;
    }

    public void makeMove(Position pos, Symbol symbol) {
        grid[pos.getRow()][pos.getCol()] = symbol;
    }

    public void checkGameState(GameContext context, Player currentPlayer) {
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] != Symbol.EMPTY && isWinningLine(grid[i])) {
                context.getCurrentGameState().next(context, currentPlayer, true);
                return;
            }
        }
        for (int i = 0; i < columns; i++) {
            Symbol[] column = new Symbol[rows];
            for (int j = 0; j < rows; j++) {
                column[j] = grid[j][i];
            }
            if (column[0] != Symbol.EMPTY && isWinningLine(column)) {
                context.getCurrentGameState().next(context, currentPlayer, true);
                return;
            }
        }
        Symbol[] diagonal1 = new Symbol[Math.min(rows, columns)];
        Symbol[] diagonal2 = new Symbol[Math.min(rows, columns)];
        for (int i = 0; i < Math.min(rows, columns); i++) {
            diagonal1[i] = grid[i][i];
            diagonal2[i] = grid[i][columns - 1 - i];
        }
        if (diagonal1[0] != Symbol.EMPTY && isWinningLine(diagonal1)) {
            context.getCurrentGameState().next(context, currentPlayer, true);
            return;
        }
        if (diagonal2[0] != Symbol.EMPTY && isWinningLine(diagonal2)) {
            context.getCurrentGameState().next(context, currentPlayer, true);
            return;
        }
        context.getCurrentGameState().next(context, currentPlayer, false);
        // Additional logic to handle a draw or continue in progress can be added
        // here
    }

    private boolean isWinningLine(Symbol[] line) {
        Symbol first = line[0];
        for (Symbol s : line) {
            if (s != first) {
                return false;
            }
        }
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Symbol symbol = grid[i][j];
                switch (symbol) {
                    case X:
                        System.out.print(" X ");
                        break;
                    case O:
                        System.out.print(" O ");
                        break;
                    case EMPTY:
                    default:
                        System.out.print(" . ");
                }
                if (j < columns - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < rows - 1) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }
}
