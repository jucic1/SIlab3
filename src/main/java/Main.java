import Mancala.HumanPlayer;
import Mancala.Bot;
import Mancala.Mancala;

public class Main {
    public static void main(String[] args) {
        HumanPlayer human = new HumanPlayer();
        HumanPlayer human2 = new HumanPlayer();
        Bot bot = new Bot();
        Mancala mancala = new Mancala(human2, human);
        mancala.run();
    }
}
