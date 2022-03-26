package name.panitz.ludens.rmi.game;
import name.panitz.ludens.animationGame.Vertex;
import java.util.*;

public class State implements java.io.Serializable{

  Vertex size= new Vertex(800,600);

  List<Shot> shots;

  Map<String,Player> players;

  State(Map<String,Player> players,List<Shot> shots){
    this.players=players;
    this.shots=shots;
  }

  State(){
    this(new HashMap<String,Player>(),new LinkedList<Shot>());
  }
}

