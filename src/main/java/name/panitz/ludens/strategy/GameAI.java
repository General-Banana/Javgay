package name.panitz.ludens.strategy;
import name.panitz.ludens.util.Pair;
import java.util.List;
public interface GameAI<M>{

  Game<M> doBestMove(Game<M> g);

  M bestMove(Game<M> g);
}

