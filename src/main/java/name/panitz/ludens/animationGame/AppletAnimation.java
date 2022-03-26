package name.panitz.ludens.animationGame;
public class AppletAnimation extends javax.swing.JApplet{
  @Override public void init(){
    new ControlledWindow(new TrainFrogger()).setResizable(false);
   }
}

