public class NextSecond implements Command{
    @Override
    public void execute() {
        GameFlow game = GameFlow.INSTANCE.getInstance();
        Integer index = game.getState(game.getCurrentIndex()).nextVar2();
        if (index != null) game.setCurrentIndex(index);
        game.getState(game.getCurrentIndex()).toString();
        game.flow();
    }
}