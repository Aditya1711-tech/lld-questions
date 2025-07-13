package entities;

import enums.Symbol;
import playerStrategies.PlayerStrategy;

public class Player {
    Symbol symbol;
    PlayerStrategy playerStrategy;

    public Player (Symbol symbol , PlayerStrategy playerStrategy){
        this.symbol = symbol;
        this.playerStrategy = playerStrategy;
    }

    public Symbol getSymbol(){
        return symbol;
    }

    public PlayerStrategy getPlayerStrategy(){
        return playerStrategy;
    }
}
