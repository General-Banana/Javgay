package name.panitz.ludens.strategy;
public class ConnectFourPlayer implements name.panitz.ki.FourKI{

  private Vier v = new Vier();

  AlphaBetaGame<Byte> ai = new AlphaBetaGame<Byte>(){
     @Override int getDepth(){
      if (v.movesDone<6) return 8;
      if (v.movesDone<8) return 9;
      if (v.movesDone<10) return 10;
      if (v.movesDone<14) return 11;
      if (v.movesDone<16) return 12;
      if (v.movesDone<18) return 14;
      return 30;
    }
  };

  public int nextMove(){
    byte result= ai.bestMove(v);
    v=v.doMove(result);
    return result;
  }

  public void nextMove(int i){v=v.doMove((byte)i);}
}

