package stateHandlers.states;

import stateHandlers.context.GameContext;
import entities.Player;

public interface GameState {
    void next(GameContext context, Player player, Boolean isWon);
    boolean isGameOver();
}
