package name.panitz.ludens.strategy;
import java.util.*;
class Vier extends AbstractRegularGame<Byte>{

  Vier(){super((byte)7,(byte)6);}

  public Vier setAtPosition(byte column,byte row){
    return doMove(column);
  }

  final static byte[] possibleMoves = {3,2,4,1,5,0,6};

  final static byte[] startMoves = {3,2,1,0};

  public List<Byte> moves(){
    final List<Byte> result = new LinkedList<Byte>();
    byte[] pms
      =(movesDone==0|| (movesDone==1&&lastColumn==3))
       ?startMoves:possibleMoves;

    for (byte c:pms) if (b[c][rows-1]==NONE) result.add(c); 

    return result;
  }

  public Vier doMove(Byte c){
    Vier result = (Vier)this.clone();
    for (byte r = 0;r<rows;r++){
      if (result.b[c][r]==NONE){
        result.b[c][r]=player;
	result.player = nextPlayer();
	result.lastColumn=c;
	result.lastRow=r;
	result.movesDone=movesDone+1;
        break;
      }
    }
    return result;
  }

  public boolean noMoreMove(){
    return movesDone==rows*columns;
  }

  public boolean wins(byte p){
    if (movesDone<7)  return false; 
    if (b[lastColumn][lastRow]!=p) return false;
    return   vertical(p)||horizontal(p)
           ||diagonal1(p)||diagonal2(p);
  }

  private boolean vertical(byte p){
    byte inRow = 1;
    for (int cr=lastRow-1;cr>=0&&b[lastColumn][cr]==p;cr--)
      inRow++;
    return inRow>=4;
  }

  private boolean horizontal(byte p){
    byte inRow = 1;
    for (int cc=lastColumn-1;cc>=0&&b[cc][lastRow]==p;cc--)
      inRow++;
    for (int cc=lastColumn+1
                       ;cc<columns&&b[cc][lastRow]==p;cc++)
      inRow++;
    return inRow>=4;
  }

  private boolean diagonal1(byte p){
    byte inRow = 1;
    byte cc=(byte)(lastColumn-1);
    byte cr=(byte)(lastRow-1);
    while (cc>=0&&cr>=0&&b[cc][cr]==p){
      inRow++;cc--;cr--;
    }
    cc=(byte)(lastColumn+1);
    cr=(byte)(lastRow+1);
    while (cc<columns&&cr<rows&&b[cc][cr]==p){
      inRow++;cc++;cr++;
    }
    return  inRow>=4;
  }

  private boolean diagonal2(byte p){
    byte inRow = 1;
    byte cc=(byte)(lastColumn-1);
    byte cr=(byte)(lastRow+1);
    while (cc>=0&&cr<rows&&b[cc][cr]==p){
      inRow++;cc--;cr++;
    }
    cc=(byte)(lastColumn+1);
    cr=(byte)(lastRow-1);
    while (cc<columns&&cr>=0&&b[cc][cr]==p){
      inRow++;cc++;cr--;
    }
    return inRow>=4;
  }

  public int evalState(byte player){
    return 
      wins()
        ?((lastPlayer()==player)
            ?Integer.MAX_VALUE:-Integer.MAX_VALUE)
        :state(player)-10*state(otherPlayer(player)); 
  }

  int ps(byte player,int rV){
    return (rV==3*player)?100:((rV==2*player)?10:0);
  }

  int state(byte p){
    int  result=0;
    for  (int c=0;c<columns-3;c++){
     for  (int r =0;r<rows-3;r++){
      result =  result 
       +ps(p,b[c] [r]+b[c]  [r+1]+b[c]  [r+2]+b[c]  [r+3])  
       +ps(p,b[c] [r]+b[c+1][r+1]+b[c+2][r+2]+b[c+3][r+3])  
       +ps(p,b[c] [r]+b[c+1][r]  +b[c+2][r]  +b[c+3][r]);

      final int c2 = columns-1-c;
      if (c2>3) result = result
       +ps(p,b[c2][r]+b[c2] [r+1]+b[c2] [r+2]+b[c2] [r+3]);

      final int s = rows-1-r;
      result=result
       +ps(p,b[c][s]+b[c+1][s]  +b[c+2][s]  +b[c+3][s])
       +ps(p,b[c][s]+b[c+1][s-1]+b[c+2][s-2]+b[c+3][s-3]);
     }
    }
    return result;
  }

}

