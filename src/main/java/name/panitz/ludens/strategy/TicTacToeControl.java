package name.panitz.ludens.strategy;
import name.panitz.ludens.util.*;
import javax.swing.*;
class TicTacToeControl
         extends RegularControl<Pair<Byte,Byte>>{

  TicTacToeControl(TicTacToe ttt){super(ttt);}
  TicTacToeControl(){this(new TicTacToe());}

  public static void main(String[] args){
    ShowInFrame.show("TicTacToe",new TicTacToeControl());
  }
}

