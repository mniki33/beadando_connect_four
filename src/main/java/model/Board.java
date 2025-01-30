package model;

import java.util.Arrays;
import java.util.Objects;

public class Board {
    static int N=6;
    static int M=7;
    int[][] board = new int[N][M]; // 0 - empty, -1 - red, 1 - yellow

    public static int getN() {
        return N;
    }

    public static void setN(int n) {
        N = n;
    }

    public static int getM() {
        return M;
    }

    public static void setM(int m) {
        M = m;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    @Override
    public String toString() {
        return "Board{" +
                "board=" + Arrays.deepToString(board) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Board board1 = (Board) o;
        return Objects.deepEquals(board, board1.board);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(board);
    }
}
