package name.panitz.ludens.strategy;
import javax.swing.*;
import name.panitz.ludens.util.Pair;

class MinMaxTicTacToeControl extends TicTacToeControl{

  GameAI<Pair<Byte,Byte>> ai
    = new MinMaxGame<Pair<Byte,Byte>>();

  MinMaxTicTacToeControl(TicTacToe g){super(g);}

  MinMaxTicTacToeControl(){this(new TicTacToe());}

  @Override public void whenMousePressed(byte c,byte r){
    if (board.getGame().ended()) return;
    board.setGame(
     (TicTacToe)ai.doBestMove(board.getGame())
    );
  }

  public static void main(String[] args){
    JFrame f=new JFrame("TicTacToe");
    f.add(new MinMaxTicTacToeControl());
    f.pack();f.setVisible(true);
  }
}

