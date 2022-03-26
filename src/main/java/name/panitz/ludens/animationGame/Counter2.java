package name.panitz.ludens.animationGame;
import javax.swing.*;
import java.awt.event.*;
import name.panitz.ludens.util.ShowInFrame;
public class Counter2 extends SimpleButton{
  public Counter2(){

    b.addActionListener(
    new ActionListener(){
      int i=0;
      public void actionPerformed(ActionEvent e){
        i=i+1;
        l.setText(""+i);    
      }
    });
  }

  public static void main(String [] args){
    ShowInFrame.show(new Counter2());}
}

