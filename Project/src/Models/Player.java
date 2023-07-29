package Models;

import Exceptions.InvalidColumnNumberException;
import Exceptions.InvalidRowNumberException;

import java.util.Scanner;

public class Player {
    private long id;
    private String name;
    private PlayerType playerType;
    private Symbol symbol;

    private Scanner scanner;

    public Player(long id, String name, PlayerType playerType, Symbol symbol, Scanner scanner) {
        this.id = id;
        this.name = name;
        this.playerType = playerType;
        this.symbol = symbol;
        this.scanner = new Scanner(System.in);
    }

    public Move makeMove(Board board)
    {
        System.out.println("Please enter the row for the move");
        int row = scanner.nextInt();
        System.out.println("Please enter the column for the move");
        int col = scanner.nextInt();

        //validate the move throw exception if required
        if(row < 1 || row > board.dimension)
        {
            throw new InvalidRowNumberException("Please select a row greater than 0 and less than " + board.dimension + 1);
        }
        if(col < 1 || col > board.dimension)
        {
            throw new InvalidColumnNumberException("Please select a column greater than 0 and less than " + board.dimension + 1);
        }

        //move contains two things
        //1. the cell to which we move and
        //2. the player who is moving
        return new Move(new Cell(row,col,this),this);

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
