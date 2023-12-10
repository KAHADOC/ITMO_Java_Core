import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class GameMenu {
    private static HashMap<Integer, Command> commandMap = new HashMap<>();

    public GameMenu() {
        commandMap.put(1, new StartGame());
        commandMap.put(2, new LoadGame());
        commandMap.put(3, new QuitGame());
        commandMap.put(4, new SaveGame());
        commandMap.put(5, new ContinueGame());
    }
    public void start()  {
        System.out.println("\n\t Main Game Menu\n Please choose an action:\n" +
                " 1 __ Start New Game\n 2 __ Load Saved Game\n 3 __ Quit Game");
        int item=0;
        Scanner scanner = new Scanner(System.in);
        do {
            if (scanner.hasNextInt()) {
                item = scanner.nextInt();
                if (item<1 || item>3)
                {
                    System.out.println("Valid choices are 1, 2, or 3!");
                    continue;
                }
            }
            else {
                System.out.println("Please enter number for menu item!");
                continue;
            }

        } while (item < 1 || item > 3);

        runCommand(item);
    }
    public void ingame()  {
        System.out.println("\n\t Main Game Menu\n Please choose an action:\n" +
                " 1 __ Start New Game\n 2 __ Load Saved Game\n 3 __ Quit Game\n 4 __ Save Game\n 5 __ Continue Game\n");
        int item=0;
        Scanner scanner = new Scanner(System.in);
        do {
            if (scanner.hasNextInt()) {
                item = scanner.nextInt();
                if (item<1 || item>5)
                {
                    System.out.println("Valid choices are digits 1 to 5!");
                    continue;
                }
            }
            else {
                System.out.println("Please enter number for menu item!");
                continue;
            }

        } while (item < 1 || item > 5);

        runCommand(item);
    }

    static public void runCommand(int item) {
        commandMap.get(item).execute();
    }

    static public Object objectCommand(int item)
    {
        return commandMap.get(item);
    }
}
