package name.panitz.ludens.animationGame;
import name.panitz.ludens.util.*;

class RemoveAnimation1 extends AnimationPanel{
  @Override void reactWhenTouching(GameObject g1,GameObject g2){
    if (g1.isLargerThan(g2)) gos.remove(g2); else gos.remove(g1);          
  }

  public static void main(String [] args){
    MovablePanel p = new RemoveAnimation1();
    p.gos.add(new MovableImage("hexe.png",0,0,1,1));
    p.gos.add(new MovableImage("biene.png",200,200,-1,-1));
    ShowInFrame.show(p); 
  }
}

