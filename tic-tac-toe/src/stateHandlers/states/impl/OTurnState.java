package stateHandlers.states.impl;

import stateHandlers.context.GameContext;
import entities.Player;
import enums.Symbol;
import stateHandlers.states.GameState;

public class OTurnState implements GameState {
    @Override
    public void next(GameContext context, Player player, Boolean isWon) {
        if(isWon){
            context.setCurrentGameState(player.getSymbol() == Symbol.X ? new XWonState() : new OWonState());
        }else {
            // Switch to OTurnState
            context.setCurrentGameState(new XTurnState());
        }
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}
