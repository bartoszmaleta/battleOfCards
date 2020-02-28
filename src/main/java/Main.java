import controller.Game;
import exception.RandomizeDeckException;
import java.io.FileNotFoundException;

// Remember to change path of "Cards.xml"
// TODO:
//       - presentation: projectStructure from IDE
//       - more graphics
//       - healthCalculating loadingBar
//       - clearScreen()
//       - allignment
//       - experience dependency
//       - level dependency
//       - coins dependency
//       - coins deposit after draw
//       - better newLines()
//       - menu during game
//       - attack() and bet() break into smaller methods
//       - calculateHealth() move to one method = "update"
//       - show name of Smurf on his card image
//       - change some characters to emoji
//       - add more colours
//       - high scores
//       - emoji of the player
//       -

public class Main {
    public static void main(String[] args) throws RandomizeDeckException, FileNotFoundException {
        Game game = new Game();
    }
}
