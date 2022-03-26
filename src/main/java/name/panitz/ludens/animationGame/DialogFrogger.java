package name.panitz.ludens.animationGame;
import javax.swing.*;
import java.awt.event.*;
public class DialogFrogger extends MenuFrogger{
  JMenu gameMenu = new JMenu("Game"); 
  JDialog options=new FroggerOptions(this,frogger);
  DialogFrogger(){
    gameMenu.add(new AbstractAction("Preferences"){
      public void actionPerformed(ActionEvent e){
        options.pack();
        options.setVisible(true); 
      }
     });
    menuBar.add(gameMenu);
    pack();
  }
  public static void main(String [] args){new DialogFrogger();}
}

