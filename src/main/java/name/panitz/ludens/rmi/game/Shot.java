package name.panitz.ludens.rmi.game;
import name.panitz.ludens.animationGame.Vertex;
public class Shot extends Geo {
  Vertex deltaPos;
  int velocity=100;

  void move(){
    if (velocity>0)pos.addMod(deltaPos);
    velocity=velocity-1;
  }

  Shot(Vertex pos,Vertex deltaPos){
    super(2,2,pos);
    this.deltaPos=deltaPos;
  }

  void paintMe(java.awt.Graphics g){
    g.fillRect((int)pos.x,(int)pos.y,(int)width,(int)height);
  }
}

