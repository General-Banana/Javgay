package name.panitz.ludens.strategy;
import java.util.List;
public interface Game<M>{

  List<M> moves();

  Game<M> doMove(M m);

  byte currentPlayer();
  byte otherPlayer(byte player);

  boolean noMoreMove();
  boolean ended();

  boolean wins(byte player);

  int evalState(byte player);

}

