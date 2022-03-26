package name.panitz.ludens.animationGame;
import javax.swing.*;
import java.awt.event.*;
class FroggerOptions extends JDialog{

  TrainFrogger frogger;

  JButton cancelButton = new JButton("Cancel");
  JButton okButton = new JButton("OK");

  JLabel maxSpeedLabel = new JLabel("maximum speed");
  JLabel maxSpaceLabel = new JLabel("maximum space");
  JTextField maxSpeedValue = new JTextField(); 
  JTextField maxSpaceValue = new JTextField(); 

  JPanel p = new JPanel();

  FroggerOptions(JFrame frame,TrainFrogger frog){
    super(frame,"Options");
    this.frogger= frog;

    cancelButton.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent e){
          setVisible(false);
        }
    });

    okButton.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent e){
          frogger.maxSpeed=new Double(maxSpeedValue.getText());
          frogger.maxSpace=new Integer(maxSpaceValue.getText());
          frogger.reset();
          setVisible(false);
        }
    });

    setComponentsLayout(); 
    addTheComponents(); 
    add(p);
  }

  void setComponentsLayout(){}

  void addTheComponents(){
    p.add(maxSpeedLabel);p.add(maxSpeedValue);
    p.add(maxSpaceLabel);p.add(maxSpaceValue);
    p.add(cancelButton); p.add(okButton);
  }

  @Override public void setVisible(boolean v){
    if (v){
      maxSpaceValue.setText(""+frogger.maxSpace);
      maxSpeedValue.setText(""+frogger.maxSpeed);
    }
    super.setVisible(v);
  }
}

