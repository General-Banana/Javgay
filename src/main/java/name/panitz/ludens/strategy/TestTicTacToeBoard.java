package name.panitz.ludens.strategy;
import name.panitz.ludens.util.*;
import javax.swing.*;
class TestTicTacToeBoard {
  public static void main(String[] args){
    TicTacToe ttt=new TicTacToe();

    ttt=ttt.doMove(new Pair<Byte,Byte>((byte)1,(byte)1));
    ttt=ttt.doMove(new Pair<Byte,Byte>((byte)0,(byte)0));
    ttt=ttt.doMove(new Pair<Byte,Byte>((byte)2,(byte)0));

    RegularBoard<Pair<Byte,Byte>> board
      = new RegularBoard<Pair<Byte,Byte>>(ttt);

    ShowInFrame.show("Tic Tac Toe",board); 
  }
}

