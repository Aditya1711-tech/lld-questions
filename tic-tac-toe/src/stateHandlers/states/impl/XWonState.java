package stateHandlers.states.impl;

import stateHandlers.context.GameContext;
import entities.Player;
import stateHandlers.states.GameState;

public class XWonState implements GameState {

    @Override
    public void next(GameContext context, Player player, Boolean isWon) {

    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}
