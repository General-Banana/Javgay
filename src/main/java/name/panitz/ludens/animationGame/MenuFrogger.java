package name.panitz.ludens.animationGame;
import javax.swing.*;
import java.awt.event.*;

public class MenuFrogger extends ControlledWindow{

  TrainFrogger frogger;

  JMenuBar menuBar = new JMenuBar(); 
  JMenu fileMenu = new JMenu("File");

  MenuFrogger(){this(new TrainFrogger());}

  MenuFrogger(TrainFrogger tf){
    super(tf);
    frogger=tf;

    menuBar.add(fileMenu);
    this.setJMenuBar(menuBar);

    JMenuItem pauseItem=new JMenuItem("Pause");
    fileMenu.add(pauseItem);

    pauseItem.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        p.t.stop();
      }
    });

    fileMenu.add(new JMenuItem(new AbstractAction("Start"){
      public void actionPerformed(ActionEvent e){
        p.t.start();
      }
    }));

    fileMenu.add(new AbstractAction("Quit"){
      public void actionPerformed(ActionEvent e){
        System.exit(0); 
      }
     });

    pack();
  }

  public static void main(String [] args){new MenuFrogger();}
}

