import exception.FullColumnException;
import game.Game;
import model.Board;
import model.Move;
import service.BoardService;

public class Main {
    public static void main (String[] args) {
        Game game = new Game();
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        game.printBoard();
        while (true){
            System.out.println(game.getGameState().getPlayerName()+"> ");
            String command = scanner.nextLine();
            game.processCommand(command);
        }

    }


}
