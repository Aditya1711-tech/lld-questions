package stateHandlers.states.impl;

import stateHandlers.context.GameContext;
import entities.Player;
import stateHandlers.states.GameState;

public class OWonState implements GameState {
    @Override
    public void next(GameContext context, Player player, Boolean isWon) {

    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}
