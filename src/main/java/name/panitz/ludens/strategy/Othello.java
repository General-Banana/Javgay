package name.panitz.ludens.strategy;
import java.util.*;
import name.panitz.ludens.util.Pair;

class Othello extends AbstractRegularGame<OthelloMove>{

  Othello(){
    super((byte)8,(byte)8);
    b[3][3]=getPlayerOne();
    b[4][4]=getPlayerOne();
    b[3][4]=getPlayerTwo();
    b[4][3]=getPlayerTwo();
    movesDone=4;
  }

  public boolean noMoreMove(){return movesDone==64;}

  public boolean wins(byte player){
    return noMoreMove()&&evalState(player)>32;}

  public boolean ended(){ return noMoreMove();}

  public int evalState(byte player){
    int result=0;
    for (byte trs=0;trs<columns;trs++)
     for (byte pos=0;pos<rows;pos++)
       if(b[trs][pos]==player) result=result+1;;
    return result;
  }

  List<Pair<Byte,Byte>> toTurn(Pair<Byte,Byte> m){
    final List<Pair<Byte,Byte>> result
      = new LinkedList<Pair<Byte,Byte>>();

    return result;
  }

  public Othello doMove(Pair<Byte,Byte> m){
    if (b[m.fst][m.snd]==NONE){
      final List<Pair<Byte,Byte>> turn = toTurn(m);
      if (!turn.isEmpty()) 
        return doMove(new OthelloMove(m,turn));
    }
    return this;
  }

  public Othello doMove(OthelloMove om){
    final Pair<Byte,Byte> m = om.mv;
    final Othello result= (Othello)clone();
    result.player=nextPlayer();
    if (om instanceof NoMove) return result;

    result.b[m.fst][m.snd]=player;
    for (Pair<Byte,Byte>t:om.turn)
      result.b[t.fst][t.snd]=player;

    result.movesDone=this.movesDone+1;
    return result;
  }

  public Othello setAtPosition(byte column,byte row){
    return doMove(new Pair<Byte,Byte>(column,row));
  }

  public List<OthelloMove> moves(){
    final List<OthelloMove> result
      = new LinkedList<OthelloMove>();
    for (byte trs=0;trs<columns;trs++)
      for (byte pos=0;pos<rows;pos++){
        final Pair<Byte,Byte> m
          = new Pair<Byte,Byte>(trs,pos);
        if (b[trs][pos]==NONE){
          final List<Pair<Byte,Byte>> turn = toTurn(m);
          if (!turn.isEmpty()) 
            result.add(new OthelloMove(m,turn));
        }
      }
    if (result.isEmpty()) result.add(new NoMove());
    return result;
  }
}

