package name.panitz.ludens.rmi.game;
import name.panitz.ludens.animationGame.Vertex;
import java.util.*;

import javax.swing.Timer;
import java.awt.event.*;
import java.awt.Dimension;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class RMIGameImpl implements RMIGame {

  private State state = new State();
  public State getState(){return state;}

  RMIGameImpl(){
    Timer t = new Timer(30,new ActionListener(){
      public void actionPerformed(ActionEvent e){
        doOnTick();
      }
    });
    t.start();
  }

  void doAction(ActionListener al){
    Timer t = new Timer(0,al);
    t.setRepeats(false);
    t.start();
  }

  public void createPlayer(final String name){
    doAction(new ActionListener(){
      public void actionPerformed(ActionEvent a){
       state.players.put
        (name
        ,new Player
               (new Vertex((int)(Math.random()*state.size.x)
                          ,(int)(Math.random()*state.size.y))));
      }
    });
  }

  public void move(final String name){
    Player d=state.players.get(name);
    if (d!=null) d.move();
  }

  public void turnRight(String name){
    Player d=state.players.get(name);
    if (d!=null) d.turnRight();
  }
  public void turnLeft(String name){
    Player d=state.players.get(name);
    if (d!=null) d.turnLeft();
  }

  public void shoot(final String name){
    doAction(new ActionListener(){
      public void actionPerformed(ActionEvent a){
        Player d=state.players.get(name);
        if (d!=null){
          final Shot s
            =new Shot(d.getHead(),Player.getOnCircle(d.angle,6));
          state.shots.add(s);
        }
      }
    });
  }

  void doOnTick(){

    for (Iterator<Shot> it=state.shots.iterator();it.hasNext();){
      Shot s = it.next();

      s.move();

      List<String> removeP = new LinkedList<String>();

      for (Map.Entry<String,Player> p:state.players.entrySet())
        if (p.getValue().touches(s)) removeP.add(p.getKey());

      for (String p:removeP) state.players.remove(p);

      if (s.velocity<=0) it.remove();
    }
  }
}

