public class CallMenu implements Command{
    @Override
    public void execute() {
        GameMenu menu = new GameMenu();
        menu.ingame();
    }
}
