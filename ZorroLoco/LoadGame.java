import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Scanner;

//загрузить игру из предложенных файлов
public class LoadGame implements Command{

    private static File directory;

    @Override
    public void execute() {
        Path path = Path.of("saves/");
//        if (Files.isDirectory(path)) {
//            System.out.println("Folder");
//            try (DirectoryStream<Path> directory = Files.newDirectoryStream(path)) {
//                if (directory.iterator().hasNext()) {
//                    System.out.println("Folder has files");
//                }
//            } catch (NullPointerException | IOException e) {
//                throw new RuntimeException(e);
//            }
//        }

        try{
            directory = new File("saves/");

        int i=0;
        for (String f: Objects.requireNonNull(directory.list())) {
            i++;
            System.out.println(i+". "+f);
        }

        if (i!=0)
        {
            System.out.println("Choose the save, enter the save number");

            int num=0;
            do{
                Scanner scanner = new Scanner(System.in);
                try{
                    num = scanner.nextInt();
                    if(num<1 || num>i)
                    {
                        System.out.println("No such save number, please enter again");
                        continue;
                    }
                } catch (Exception e) {
                    System.out.println("The number of the save file is needed!");
                    continue;
                }
            }while(num<1 || num>i);


            try (ObjectInputStream inputFile = new ObjectInputStream(new FileInputStream(Objects.requireNonNull(directory.listFiles())[num-1]))){
                Integer index = (Integer) inputFile.readObject();
                GameFlow game = GameFlow.INSTANCE.getInstance();
                if (index != null) game.setCurrentIndex(index);
                game.getState(index).toString();
                game.flow();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else System.out.println("No saved games. Please start a new game");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

}
