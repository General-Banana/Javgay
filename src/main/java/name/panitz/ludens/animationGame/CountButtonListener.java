package name.panitz.ludens.animationGame;
import java.awt.event.*;
import javax.swing.*;
public class CountButtonListener implements ActionListener{
  JLabel l;
  int i = 0;
  CountButtonListener(JLabel l){this.l=l;}

   public void actionPerformed(ActionEvent e){
    i=i+1;
    l.setText(""+i);    
  }
}

