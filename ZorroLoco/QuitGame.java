public class QuitGame implements Command{
    @Override
    public void execute() {
        System.out.println("Goodbye, Thanks for Playing!");
        Application.printArt("bye.txt");
        System.exit(0);
    }

}
