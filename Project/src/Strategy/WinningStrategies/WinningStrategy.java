package Strategy.WinningStrategies;

import Models.Board;
import Models.Player;

public interface WinningStrategy {
    Player checkWinner(Board board);
}
