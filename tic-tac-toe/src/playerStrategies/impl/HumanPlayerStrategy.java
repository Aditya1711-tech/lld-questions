package playerStrategies.impl;

import entities.Board;
import entities.Position;
import playerStrategies.PlayerStrategy;

import java.util.Scanner;

public class HumanPlayerStrategy implements PlayerStrategy {
    private final Scanner scanner;
    private final String playerName;

    public HumanPlayerStrategy(String playerName) {
        this.scanner = new Scanner(System.in);
        this.playerName = playerName;
    }

    @Override
    public Position makeMove(Board board) {
        while (true) {
            System.out.printf(
                    "%s, enter your move (row [0-2] and column [0-2]): ", playerName);
            try {
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                Position move = new Position(row, col);

                if (board.isValidMove(move)) {
                    return move;
                }

                System.out.println("Invalid move. Try again.");
            } catch (Exception e) {
                System.out.println(
                        "Invalid input. Please enter row and column as numbers.");
                scanner.nextLine(); // Clear input buffer
            }
        }
    }
}
