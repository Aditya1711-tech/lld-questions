package playerStrategies;

import entities.Board;
import entities.Position;


public interface PlayerStrategy {
    Position makeMove(Board board);
}
