import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveGame implements Command{

    static Integer saveIndex;
    private static File file = null;

    @Override
    public void execute() {
        GameFlow game = GameFlow.INSTANCE.getInstance();
        saveIndex = game.getCurrentIndex();
        Date date = new Date();
        SimpleDateFormat formatForDate = new SimpleDateFormat("yyyy-MM-dd-hh-mm");
        file = new File("saves/"+ formatForDate.format(date) +".ser");

        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (ObjectOutputStream outFile = new ObjectOutputStream(new FileOutputStream(file))){
            outFile.writeObject(saveIndex);
            System.out.println("Game was saved successfully!");
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Unable to save the game!");
        } finally {
            GameMenu menu = new GameMenu();
            menu.ingame();
        }


    }

    public void setSaveStep(GameState saveState) {
        this.saveIndex = saveState.index();
    }
}
