package name.panitz.ludens.animationGame;
import javax.swing.*;
import name.panitz.ludens.util.ShowInFrame;
public class Counter extends SimpleButton{

  public Counter(){
    b.addActionListener(new CountButtonListener(l));
  }

  public static void main(String [] args){
    ShowInFrame.show(new Counter());}
}

