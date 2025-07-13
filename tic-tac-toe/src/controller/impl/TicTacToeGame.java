package controller.impl;

import controller.BoardGames;
import entities.Board;
import stateHandlers.context.GameContext;
import entities.Player;
import entities.Position;
import enums.Symbol;
import stateHandlers.states.GameState;
import playerStrategies.PlayerStrategy;
import stateHandlers.states.impl.OWonState;
import stateHandlers.states.impl.XWonState;

public class TicTacToeGame implements BoardGames {
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private GameContext gameContext;
    // Initializes the game board and players with their respective strategies.
    // Sets the current player to playerX. can be set to playerO as well
    public TicTacToeGame(PlayerStrategy xStrategy, PlayerStrategy oStrategy,
                         int rows, int columns) {
        board = new Board(rows, columns);
        playerX = new Player(Symbol.X, xStrategy);
        playerO = new Player(Symbol.O, oStrategy);
        currentPlayer = playerX;
        gameContext = new GameContext();
    }
    @Override
    // Loop continues until the game state indicates that the game is over.
    public void play() {
        do {
            // print the current state of the game
            board.printBoard();
            // current player makes the move
            Position move = currentPlayer.getPlayerStrategy().makeMove(board);
            board.makeMove(move, currentPlayer.getSymbol());
            // checks game state for win/draw
            board.checkGameState(gameContext, currentPlayer);
            switchPlayer();
        } while (!gameContext.getCurrentGameState().isGameOver());
        announceResult();
    }
    // Alternates the current player after each move.
    // Ensures both players take turns
    private void switchPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }
    // Displays the outcome of the game based on the final game state.
    private void announceResult() {
        GameState state = gameContext.getCurrentGameState();
        if (state instanceof XWonState) {
            System.out.println("Player X wins!");
        } else if (state instanceof OWonState) {
            System.out.println("Player O wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}
