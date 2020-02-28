import controller.Game;
import exception.RandomizeDeckException;
import java.io.FileNotFoundException;

// Remember to change path of "Cards.xml"
// TODO:
//       - more graphics                                                COOL FEATURE
//       - healthCalculating loadingBar                                 COOL FEATURE
//       - clearScreen()                                                HARD IN INTELLIJ
//       - allignment                                                   COOL FEATURE
//       - experience dependency                                        MUST HAVE
//       - level dependency                                             MUST HAVE
//       - coins dependency                                             MUST HAVE
//       - coins deposit after draw                                     MUST HAVE
//       - better newLines()                                            HARD IN INTELLIJ
//       - menu during game                                             MUST HAVE
//       - attack() and bet() break into smaller methods                FUTURE
//       - calculateHealth() move to one method = "update"              FUTURE
//       - show name of Smurf on his card image                         MUST HAVE
//       - change some characters to emoji                              DONE (NOT IN INTELLIJ)
//       - add more colours                                             DONE
//       - high scores                                                  FUTURE
//       - emoji of the player                                          DONE
//       -
//       -
//       - presentation: projectStructure from IDE, github network, uml, todos on basecamp
//                       , images of cardDisplay and stats, XML example, img todos in Main Class
//                       , github branches,

public class Main {
    public static void main(String[] args) throws RandomizeDeckException, FileNotFoundException {
        Game game = new Game();
    }
}
