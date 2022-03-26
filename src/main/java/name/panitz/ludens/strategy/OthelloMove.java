package name.panitz.ludens.strategy;
import java.util.List;
import name.panitz.ludens.util.Pair;
class OthelloMove{
  Pair<Byte,Byte> mv;
  List<Pair<Byte,Byte>> turn;
  OthelloMove(Pair<Byte,Byte> mv,List<Pair<Byte,Byte>> tu){
    this.mv=mv;
    this.turn=tu;
  }
}

