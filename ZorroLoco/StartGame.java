import java.io.IOException;
import java.util.Scanner;

public class StartGame implements Command {

    @Override
    public void execute()  {
        System.out.println("\nStarting a New Game");
        GameFlow game = GameFlow.INSTANCE.getInstance();
        game.setAllStates();
        game.setCurrentIndex(0);
        game.getState(0).toString();
        game.flow();
    }
}






