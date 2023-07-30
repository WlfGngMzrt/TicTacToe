package Models;
import Strategy.BotPlayingStrategy.BotPlayingStrategy;

public class Bot extends Player{

    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(long id, String name, Symbol symbol, BotDifficultyLevel botDifficultyLevel, BotPlayingStrategy botPlayingStrategy) {
        super(id, name, PlayerType.BOT, symbol);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = botPlayingStrategy;
    }

    public Move makeMove(Board board)
    {
        Move move = botPlayingStrategy.makeMove(board);
        move.setPlayer(this);
        return move;
    }

    public Bot(long id, String name, PlayerType playerType, Symbol symbol) {
        super(id, name, playerType, symbol);
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public BotPlayingStrategy getBotPlayingStrategy() {
        return botPlayingStrategy;
    }

    public void setBotPlayingStrategy(BotPlayingStrategy botPlayingStrategy) {
        this.botPlayingStrategy = botPlayingStrategy;
    }
}
