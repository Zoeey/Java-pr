package matchmaker;

import model.GameConstants;
import model.GameSession;
import model.Player;
import model.SingleGameSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates {@link GameSession} for single player
 *
 * @author Alpi
 */
public class SinglePlayerMatchMaker implements MatchMaker {
  @NotNull
  private final Logger log = LogManager.getLogger(SinglePlayerMatchMaker.class);
  @NotNull
  private final ArrayList<SingleGameSession> activeGameSessions = new ArrayList<>();

  /**
   * Creates new GameSession for single player
   *
   * @param player single player
   */
  @Override
  public void joinGame(@NotNull Player player) {
    SingleGameSession newSGameSession = new SingleGameSession(player);
    activeGameSessions.add(newSGameSession);
    if (log.isInfoEnabled()) {
      log.info(player.name() + " joined " + newSGameSession);
    }
    //GameSession newGameSession = createNewGame();
    //activeGameSessions.add(newGameSession);
    //newGameSession.join(player);
  }

  @NotNull
  public List<GameSession> getActiveGameSessions() {
    return new ArrayList<>(activeGameSessions);
  }

  /**
   * TODO HOMEWORK 1. Implement new game creation. Instantiate GameSession state
   * Log every game instance creation
   *
   * @return new GameSession
   */
  @NotNull
  private GameSession createNewGame() {

    throw new NotImplementedException();//Implement it!
  }
}
