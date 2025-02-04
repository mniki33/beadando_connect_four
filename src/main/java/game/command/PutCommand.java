package game.command;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exception.FullColumnException;
import game.Game;
import model.Board;
import model.Move;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PutCommand implements Command {

    private static final Pattern PATTERN = Pattern.compile("(\\d{1,2})$");
    private static final Logger logger = LoggerFactory.getLogger(Command.class);

    @Override
    public Pattern getPattern() {
        return PATTERN;
    }

    @Override
    public void execute(Matcher matcher, Game game) {
        int col = Integer.parseInt(matcher.group(1))-1;
        if (col < 0 || col >= Board.getM()) {
            System.out.println("Invalid column number.");
            logger.error("Put command execution error: invalid column number");
            return;
        }
        Move move = new Move();
        move.setCol(col);
        move.setPlayer(game.getGameState().getHuman());
        try {
            game.getBoardService().doMove(move);
            logger.info("put command executed into col {}.", col+1);
        } catch (FullColumnException fcex) {
            System.err.println("You put in a fulled column.");
            logger.error("The human put in a fulled column.");
        }
        game.getGameState().setPlayer(game.getGameState().getHuman() * -1);
        game.printBoard();
        game.aiMove();
        game.printBoard();

    }


}
