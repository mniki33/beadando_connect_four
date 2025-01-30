package service;
import model.Board;
import model.Move;
import exception.FullColumnException;


public class BoardService {
    Board board;
    static int N = Board.getN();
    static int M = Board.getM();

    public BoardService (Board board){
        this.board = board;
    }

    public boolean isFull(){
        boolean foundEmpty = false;
        int[][] arr = board.getBoard();
        for (int col = 0; col<M; col++) if (arr[0][col] == 0) foundEmpty = true;
        return !foundEmpty;
    }

    public boolean hasWon(int player) {
        return false;

    }

    public void doMove(Move move) throws FullColumnException {
        int[][] arr = board.getBoard();
        int actualCol = move.getCol();
        int row=0;
        while (row<N && arr[row][actualCol] == 0 ) row++;
        if (row ==N) arr[N-1][actualCol] = move.getPlayer();
        else if (!(arr[0][actualCol] == 0)) throw new FullColumnException();
        else arr[row-1][actualCol] = move.getPlayer();
    }

}
