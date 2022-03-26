package name.panitz.ludens.strategy;
import java.util.*;
import name.panitz.ludens.util.Pair;

public class TicTacToe 
           extends AbstractRegularGame<Pair<Byte,Byte>>{

  TicTacToe(){super((byte)3,(byte)3);}

  public TicTacToe setAtPosition(byte column,byte row){
    return doMove(new Pair<Byte,Byte>(column,row));
  }

  public List<Pair<Byte,Byte>> moves(){

    List<Pair<Byte,Byte>> result
     = new LinkedList<Pair<Byte,Byte>>();

    for (byte c=0;c<columns;c++)
      for (byte r=0;r<rows;r++)

        if (b[c][r]==NONE) 
          result.add(new Pair<Byte,Byte>(c,r));

    return result;
  }

  @Override public TicTacToe clone(){
    return (TicTacToe)super.clone();
  }

  public TicTacToe doMove(Pair<Byte,Byte> m){
    TicTacToe result = clone();
    result.player=nextPlayer();
    result.b[m.fst][m.snd]=player;
    result.movesDone=(byte)(movesDone+1);
    return result;
  }

  public boolean noMoreMove(){
    return rows*columns==movesDone;
  }

  public boolean wins(byte p){
    return   checkRows(p)
           ||checkColumns(p)
           ||checkDiagonal1(p)
           ||checkDiagonal2(p);
  }

  private boolean checkRows(byte p){
    for (byte r=0;r<rows;r++){

      for (byte c=0;c<columns;c++){
        if (b[c][r]!=p) break;

        if (c==columns-1) return true;
      }
    }
    return false;
  }

  private boolean checkColumns(byte p){
    for (byte c=0;c<columns;c++){
      for (byte r=0;r<rows;r++){
        if (b[c][r]!=p) break;
        if (r==rows-1) return true;
      }
    }
    return false;
  }

  private boolean checkDiagonal1(byte p){
    for (byte r=0;r<rows;r++){
      if (b[r][r]!=p) break;
      if (r==rows-1) return true;
    }
    return false;
  }

  private boolean checkDiagonal2(byte p){
    for (byte r=0;r<rows;r++){
      if (b[r][rows-r-1]!=p) break;
      if (r==rows-1) return true;
    }
    return false;
  }

  public int evalState(byte p){
    if (wins())
      return 
       (lastPlayer()==p)?Integer.MAX_VALUE:-Integer.MAX_VALUE;
    return 0;
  }

}

