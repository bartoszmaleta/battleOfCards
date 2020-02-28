import controller.Game;
import exception.RandomizeDeckException;
import java.io.FileNotFoundException;

// Remember to change path of "Cards.xml"
// TODO:
//       - more graphics                                                COOL FEATURE
//       - healthCalculating loadingBar                                 COOL FEATURE
//       - clearScreen()                                                HARD IN INTELLIJ
//       - allignment                                                   COOL FEATURE
//       - experience depends on coins/cards You won                    MUST HAVE!!!!!!
//       - level dependency                                             FUTURE
//       - possible to buy sth for coins                                FUTURE
//       - coins deposit after draw                                     DONE
//       - better newLines()                                            HARD IN INTELLIJ
//       - menu during game                                             DONE
//       - attack() and bet() break into smaller methods                FUTURE
//       - calculateHealth() move to one method = "update"              FUTURE
//       - show name of Smurf on his card image                         MUST HAVE!!!!!!
//       - change some characters to emoji                              DONE (NOT IN INTELLIJ)
//       - add more colours                                             DONE
//       - high scores                                                  FUTURE
//       - emoji of the player                                          DONE
//       - enum for player specs                                        FUTURE
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
