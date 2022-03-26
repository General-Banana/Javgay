package name.panitz.ludens.strategy;
import javax.swing.*;
import name.panitz.ludens.util.Pair;

class AlphaBetaTicTacToeControl 
                     extends MinMaxTicTacToeControl{
  AlphaBetaTicTacToeControl(TicTacToe g){
    super(g);
    ai = new AlphaBetaGame<Pair<Byte,Byte>>();
  }
  AlphaBetaTicTacToeControl(){this(new TicTacToe());}

  public static void main(String[] args){
    JFrame f=new JFrame("TicTacToe");
    f.add(new AlphaBetaTicTacToeControl());
    f.pack();f.setVisible(true);
  }
}

