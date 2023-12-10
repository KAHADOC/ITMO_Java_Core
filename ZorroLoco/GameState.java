import java.io.Serializable;
import java.util.HashMap;

public record GameState(Integer index, String scene, Integer nextVar1, Integer nextVar2, String artFile) implements Serializable {
    @Override
    public String toString() {
        System.out.println(scene + "\n");
          if (artFile != null) Application.printArt(artFile);
          return "scene='" + scene + "\n";
    }

}
