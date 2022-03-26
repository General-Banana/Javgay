package name.panitz.ludens.strategy;
public abstract class AbstractRegularGame<M> 
        implements RegularGame<M>, Cloneable{

  final static byte NONE = 0;
  final static byte ONE = 1;
  final static byte TWO = 22;

  public byte getPlayerOne(){return ONE;}
  public byte getPlayerTwo(){return TWO;}
  public byte getPlayerNone(){return NONE;}

  byte player=ONE;

  public byte currentPlayer(){return player;}
  public byte otherPlayer(byte p){return (p==ONE)?TWO:ONE;}
  public byte nextPlayer(){return otherPlayer(player);}
  public byte lastPlayer(){return otherPlayer(player);}

  final byte rows;
  final byte columns;

  public int getRows(){return rows;}
  public int getColumns(){return columns;}

  byte[][] b;

  public AbstractRegularGame(byte c,byte r){
    columns=c;
    rows=r;
    b=new byte[columns][];  
    for (int i=0;i<columns;i++) b[i]=new byte[rows];
  }

  public byte getAtPosition(byte column,byte row){
    return b[column][row];
  }

  int movesDone  =  0;

  byte lastColumn = -1;
  byte lastRow    = -1;

  Boolean winsLast=null;
  public boolean wins(){
      if (winsLast==null)winsLast=wins(lastPlayer());
      return winsLast;
  }
  public boolean ended(){
    return noMoreMove()||wins();
  }

  @Override public AbstractRegularGame clone(){

    AbstractRegularGame result = null;

    try{
      result=(AbstractRegularGame)super.clone();

      result.b = b.clone();
      result.winsLast=null;

      for (int i = 0; i < result.b.length; i++)
        result.b[i] = result.b[i].clone();

    }catch (CloneNotSupportedException a){}

    return result;
  }

}

