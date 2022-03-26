package name.panitz.ludens.rmi.game;
import name.panitz.ludens.util.ShowInFrame;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.rmi.registry.*;
import java.util.Map;
import static java.awt.event.KeyEvent.*;

public class RMIGameClient extends JPanel {

  final String name;
  RMIGame game=null;
  State s=null;

  RMIGameClient(String host,String n){
    this.name=n;
    setFocusable(true);
    try {
      Registry registry = LocateRegistry.getRegistry(host);
      game = (RMIGame) registry.lookup("rmigame");
      s = game.getState();
    } catch (Exception e) {e.printStackTrace();}

    setPreferredSize
      (new Dimension((int)s.size.x,(int)s.size.y));

    addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        try{game.createPlayer(name);}catch(Exception e1){}
      }
    });

    addKeyListener(new KeyAdapter(){
      public void keyReleased(KeyEvent e){
        try{
          switch (e.getKeyCode()){
           case VK_LEFT:  game.turnLeft(name); break; 
           case VK_RIGHT: game.turnRight(name);break; 
           case VK_UP:    game.move(name);     break; 
           case VK_DOWN:  game.shoot(name);    break; 
          }
        }catch(Exception e1){System.out.println(e);}
      }
    });

    Timer t = new Timer(100,new ActionListener(){
      public void actionPerformed(ActionEvent e){
        try{s=game.getState();
        }catch(Exception e2){e2.printStackTrace();}
        repaint();  
      }
    });
    t.start();
  }

  public void paintComponent(Graphics g){
    super.paintComponent(g);
    try{
      g.setColor(Color.BLACK);
      for (Shot shot:s.shots)shot.paintMe(g);

      for (Map.Entry<String,Player> sp:s.players.entrySet()){

        if (sp.getKey().equals(name))g.setColor(Color.BLUE);
        else g.setColor(Color.YELLOW);
        sp.getValue().paintMe(g);
      }
    }catch (Exception e){}
  }

  public static void main(String[] args) {
    ShowInFrame.show(new RMIGameClient(args[0],args[1]));
  }
}

