import java.io.*;

public class Application {
    static String encoding = "UTF8";

    public static void main(String[] args)  {
        printArt("fox.txt");
        GameMenu menu = new GameMenu();
        GameFlow game = GameFlow.INSTANCE.getInstance();
        game.setAllStates();
        //game.getState(0).toString();
        menu.start();    }

    public static void printArt(String filename) {
        File file = new File("materials/" + filename);

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding))) {
                String line = null;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("file doesn't exist");
        }
    }
}
