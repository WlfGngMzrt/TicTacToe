package Models;
import java.util.List;
import java.util.ArrayList;

public class Board {
    private int size;
    private List<List<Cell>> board;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setCells(List<List<Cell>> board) {
        this.board = board;
    }

    public Board(int size) {
        this.size = size;
        this.board = new ArrayList<>();

        for(int i = 0; i < size; i++)
        {
            this.getBoard().add(new ArrayList<>());
            for(int j = 0; j < size; j++)
            {
                this.getBoard().get(i).add(new Cell(i,j));
            }
        }
    }

    public void printBoard()
    {
        for(int i = 0; i < size; i++)
        {
            List<Cell> row = board.get(i);
            for(int j = 0 ; j < size; j++)
            {
                row.get(j).display();
            }
            System.out.println();
        }
    }

}
