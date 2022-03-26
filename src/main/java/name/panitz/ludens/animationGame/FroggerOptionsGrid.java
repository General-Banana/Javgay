package name.panitz.ludens.animationGame;
import java.awt.*;
import javax.swing.*;
class FroggerOptionsGrid extends FroggerOptions{
  FroggerOptionsGrid(JFrame frame,TrainFrogger frog){
    super(frame,frog);
  }
  @Override void setComponentsLayout(){
    p.setLayout(new GridLayout(3,2));
  }
}

