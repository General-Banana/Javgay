package name.panitz.ludens.strategy;
import javax.swing.*;

class VierControl extends RegularControl<Byte>{
  VierControl(Vier v){super(v);}
  VierControl(){this(new Vier());}

  public static void main(String[] args){
    JFrame f=new JFrame("Vier Gewinnt");
    f.add(new RegularControl<Byte>(new Vier()));
    f.pack();
    f.setVisible(true);
  }
}

