public class ContinueGame implements Command{
    @Override
    public void execute() {
        GameFlow game = GameFlow.INSTANCE.getInstance();
        game.getState(game.getCurrentIndex()).toString();
        game.flow();
    }

}
