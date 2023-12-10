import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public enum GameFlow implements Serializable {
    INSTANCE(0);
    private Integer currentIndex = 0;
    private GameFlow(Integer currentIndex) {
    }
    public GameFlow getInstance() {
        return INSTANCE;
    }

    public GameState getState(Integer index) {
        return allStates.get(index);
    }

    public Integer getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(Integer currentIndex) {
        this.currentIndex = currentIndex;
    }

    public void setAllStates() {
        this.allStates.add(new GameState(0, "\nEvery morning our Foxey would get up, have breakfast, and go see Buddy Squirrel. \nThis morning was not an exception. But when Foxey merrily marched to their usual meeting place, Buddy Squirrel was nowhere to be seen. \nAfter waiting and waiting for the friend Foxey became restless.\n" +
                "\"Buddy Squirrel has never missed a single meeting like this before. \nWhat if something bad has happened to him?\", thought Foxey. \nWhat should Foxey do? \n\n1 __ Go home\n2 __ Start the search\n3 __ Main Menu\n", 1, 2, null));
        this.allStates.add(new GameState(1, "\nUpon returning home Foxey finds Buddy Squirrel there! \n" +
                "Turns out, Buddy Squirrel came to the meeting place in advance and saw there a swarm of angry bees. \nNaturally, he rushed to warn Foxey about the bees, but they missed each other on their way. \nAt last our friends have found each other! \n" +
                "The Game ends successfully!!! \n3 __ Main Menu\n".toUpperCase(), null, null, "won.txt"));
        this.allStates.add(new GameState(2, "\nAll the inhabitants of the wood are doing important things and do not pay any attention to Foxey and its problem. \nBut what if any of them has seen Buddy Squirrel this morning?\n" +
                "Please help Foxey decide what to do: \n \n1 __ Ask around about Buddy Squirrel \n2 __ Start searching alone \n3 __ Main Menu\n", 3, 4, null));
        this.allStates.add(new GameState(3, "\nWhile Foxey was trying to make a decision, all the forest folk have dispersed. \nThe only ones left were Wolfy and Owley. \nHowever, Owley's memory is unreliable, and Wolfy may get very irritated because of all the questions. \nWhat should Foxey choose to do? \n \n1 __ Question Owley \n2 __ Ask Wolfy\n3 __ Main Menu\n", 5, 6, null));
        this.allStates.add(new GameState(4, "\nFoxey has been roaming the woods for too long in search of the friend \nand has got lost without realizing it. \nNow it's Foxey that needs rescuing!\n" +
                "Game ends very sadly!".toUpperCase() + "\n3 __ Main Menu", null, null, "lost.txt"));
        this.allStates.add(new GameState(5, "\nOwley did not want to talk for a long time, but finally said that \nsaw Buddy Squirrel running deep into the woods. \nAll the forest folk know that it is very dangerous there, deep inside the forest. \nIf Buddy Squirrel is indeed there, than some urgent help may be needed!\n \n1 __ Trust Owley and venture deep into the woods \n2 __ Owley is not at all worthy of any trust, start searching alone \n3 __ Main Menu\n", 7, 4, null));
        this.allStates.add(new GameState(6, "\nWolfy turned out to be rather friendly, but not very useful. \nThe only thing Wolfy said was that roaming the forests alone is not a good idea for a small fox. \nSo, what should Foxey do now?\n \n1 __ Wolfy is right, go home! \n2 __ Search for Buddy Squirrel alone \n3 __ Main Menu\n", 1, 4, null));
        this.allStates.add(new GameState(7, "\nDeep in the woods Foxey encounters Lazy Bear. \nLazy Bear is ready to tell everything it knows in exchange for some honey.\n \n1 __ No, too much time is lost already! Start searching alone \n2 __ Seize the opportunity and go get some honey \n3 __ Main Menu\n", 4, 8, null));
        this.allStates.add(new GameState(8, "\nFoxey found the honey rather quickly, but there was a swarm of angry Honey Bees flying around it. \nFoxey has always been afraid of bees, \nbut he is also afraid of not being able to find Buddy Squirrel.\n \n1 __ Wait for the bees to go away \n2 __ Try to sneak up to the honey and steal it right away \n3 __ Main Menu\n", 9, 10, null));
        this.allStates.add(new GameState(9, "\nFoxey waited a little and the angry Honey Bees went away. Foxey collected some honey without a problem, but suddenly felt very, very hungry!  What should Foxey do?\n \n1 __ Eat some honey and get some rest \n2 __ Hurry up and take the honey to Lazy Bear \n3 __ Main Menu\n", 11, 12, null));
        this.allStates.add(new GameState(10, "\nIt definitely wasn't the best idea to steal honey! Honey Bees have bitten Foxey and now it is Foxey, who needs help! \n" +
                "Game ends very sadly!!!".toUpperCase() + "\n3 __ Main Menu", null, null, "lost.txt"));
        this.allStates.add(new GameState(11, "\nLazy Bear was pleased and told Foxey that he knows the Squirrel family very well, \nand that Buddy Squirrel would never venture into the deep woods alone! \nLazy Bear assured Foxey that Squirrels never get into any troubles and that \nOwls cannot be trusted. Lazy Bear kept trying to persuade Foxey to return home.\n \n1 __ Lazy Bear hasn't got a clue, need to keep searching. Start searching alone \n2 __ Maybe Lazy Bear is right, and there is no reason to panic. Go home \n3 __ Main Menu\n", 4, 1, null));
        this.allStates.add(new GameState(12, "\nWhile Foxey was eating the honey, angry Honey Bees returned and have bitten poor little Foxey. \nNow it needs medical help and can't continue the seatch! \n" +
                "The game ends in failure".toUpperCase() + "\n3 __ Main Menu", null, null, "lost.txt"));
    }

    private ArrayList<GameState> allStates = new ArrayList<>();

    private static HashMap<Integer, Command> commands = new HashMap<>();

    public void stateMenu() {
        commands.put(1, new NextFirst());
        commands.put(2, new NextSecond());
        commands.put(3, new CallMenu());
    }
    public void flow() {
        stateMenu();
        int item = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            if (scanner.hasNextInt()) {
                item = scanner.nextInt();
                if (item < 1 || item > 3) {
                    System.out.println("Valid choices are 1, 2, or 3!");
                }
            } else {
                System.out.println("Please enter number for menu item!");
            }

        } while (item < 1 || item > 3);

        runCommand(item);
    }

    static public void runCommand(int item) {
        commands.get(item).execute();
    }

    static public Object objectCommand(int item)
    {
        return commands.get(item);
    }
}


