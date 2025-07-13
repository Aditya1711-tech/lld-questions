package stateHandlers.context;

import stateHandlers.states.GameState;
import stateHandlers.states.impl.XTurnState;

public class GameContext {
    private GameState currentGameState;

    public GameContext() {
        this.currentGameState = new XTurnState();
    }

    public GameState getCurrentGameState() {
        return currentGameState;
    }

    public void setCurrentGameState(GameState currentGameState) {
        this.currentGameState = currentGameState;
    }
}
