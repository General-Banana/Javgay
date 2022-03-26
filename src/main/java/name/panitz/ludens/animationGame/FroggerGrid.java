package name.panitz.ludens.animationGame;
public class FroggerGrid extends DialogFrogger{
  public FroggerGrid() {
    options=new FroggerOptionsGrid(this,frogger);
  }
  public static void main(String [] args){new FroggerGrid();}
}

