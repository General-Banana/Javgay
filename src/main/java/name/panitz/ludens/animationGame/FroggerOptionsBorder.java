package name.panitz.ludens.animationGame;
import java.awt.*;
import javax.swing.*;
class FroggerOptionsBorder extends FroggerOptions{
  FroggerOptionsBorder(JFrame frame,TrainFrogger frog){
    super(frame,frog);
  }

  @Override void setComponentsLayout(){
    p.setLayout(new BorderLayout());
  }

  @Override void addTheComponents() {
    JPanel pSpeed=new JPanel();
    pSpeed.add(maxSpeedLabel);
    pSpeed.add(maxSpeedValue);
    JPanel pSpace=new JPanel();
    pSpace.add(maxSpaceLabel);
    pSpace.add(maxSpaceValue);
    JPanel buttons=new JPanel();
    buttons.add(cancelButton);
    buttons.add(okButton);

    p.add(pSpeed,BorderLayout.NORTH);
    p.add(buttons,BorderLayout.SOUTH);
    p.add(pSpace,BorderLayout.CENTER);
  }
}

