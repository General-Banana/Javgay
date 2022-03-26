package name.panitz.ludens.animationGame;
import javax.swing.*;

public class FroggerOptions2 extends FroggerOptions {
  public FroggerOptions2(JFrame frame, TrainFrogger frog) {
    super(frame, frog);
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

    p.add(pSpeed);
    p.add(pSpace);
    p.add(buttons);
  }
}

