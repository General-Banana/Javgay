package name.panitz.ludens.animationGame;
public class FroggerBorder extends DialogFrogger{
  public FroggerBorder() {
    options=new FroggerOptionsBorder(this,frogger);
  }
  public static void main(String [] args){new FroggerBorder();}
}

