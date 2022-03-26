package name.panitz.ludens.strategy;
import javax.swing.*;
import java.awt.event.*;
class AlphaBetaVierControl extends VierControl{
  GameAI<Byte> ai = new AlphaBetaGame<Byte>(){
    @Override int getDepth(){
      final Vier v=(Vier)board.getGame();
      if (v.movesDone<12) return 10;
      if (v.movesDone<22) return 12;
      return 14;
    }
  };

  AlphaBetaVierControl(Vier g){super(g);}
  AlphaBetaVierControl(){this(new Vier());}

  @Override public void whenMousePressed(byte c,byte r){
    if (board.getGame().ended()) return;
    if (board.getGame().currentPlayer()
                     ==board.getGame().getPlayerTwo()){
      super.whenMousePressed(c,r);
    }else board.setGame((Vier)ai.doBestMove(board.getGame()));
  }

  public static void main(String[] args){
    JFrame f=new JFrame("Vier");
    f.add(new AlphaBetaVierControl());
    f.pack();f.setVisible(true);
  }
}

