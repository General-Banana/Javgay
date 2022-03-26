package name.panitz.ludens.strategy;
public  class AlphaBetaGame<M> extends MinMaxGame<M>{

  int negaMax(Game<M> g,int tiefe, int alpha, int beta){

    if (tiefe==0||g.ended())
      return g.evalState(g.currentPlayer());

    for (M i:g.moves()) {
      final int wert
        = -negaMax(g.doMove(i),tiefe-1,-beta,-alpha);

      if (wert >= beta) return beta;

      if (wert > alpha) alpha = wert;
    } // end of for

    return alpha;
  }

  @Override public M bestMove(Game<M> g,int depth){
    int val = -Integer.MAX_VALUE;
    M result = null;
    for (M m:g.moves()) {
      final Game<M> s = g.doMove(m);
      final int eval
       = -negaMax(s,depth,-Integer.MAX_VALUE,-val);
      if (eval>val) {val=eval;result=m;}
      else if(result==null) result=m;
    }
    return result;
  }
}

