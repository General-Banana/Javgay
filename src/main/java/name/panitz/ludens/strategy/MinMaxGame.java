package name.panitz.ludens.strategy;

public class MinMaxGame<M> implements GameAI<M>{

  int getDepth(){return 12;}
  int evalNextState(Game<M> g,byte player,int depth){
    return minmax(g,player,depth);
  }

  int minmax(Game<M> g,byte player,int depth){

    if (depth==0 || g.ended())
      return g.evalState(player);

    final boolean isMax=g.currentPlayer()==player;

    int resultVal
      = isMax?-Integer.MAX_VALUE:Integer.MAX_VALUE;

    for (M m:g.moves()){

      final Game<M> child= g.doMove(m);

      final int nextVal=minmax(child,player,depth-1);

      if (  ( isMax && nextVal>=resultVal)
          ||(!isMax && nextVal<=resultVal)){
        resultVal=nextVal;
      }
    }

    return resultVal;
  }

  public Game<M> doBestMove(Game<M> g){
    return g.doMove(bestMove(g));
  }

public M bestMove(Game<M> g){return bestMove(g,getDepth());}

  public M bestMove(Game<M> g,int depth){
    final byte player = g.currentPlayer();
    int val = Integer.MIN_VALUE;
    M result=null;
    for (M m:g.moves()) {
      final Game<M> s = g.doMove(m);
      final int eval = evalNextState(s,player,depth-1);  
      if (eval>val) {val=eval;result=m;}
    }
    return result;
  }

}

