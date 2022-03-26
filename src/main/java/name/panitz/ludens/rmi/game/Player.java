package name.panitz.ludens.rmi.game;
import name.panitz.ludens.animationGame.Vertex;
public class Player extends Geo {

  double angle = 0;

  Player(Vertex pos){super(20,20,pos);}

  void turnRight(){
    angle=angle-0.1;
    if (angle<0) angle=angle+2*Math.PI;
  }
  void turnLeft(){
    angle=angle+0.1;
    if (angle>2*Math.PI) angle=angle-2*Math.PI;
  }

  static Vertex getOnCircle(double angle, double w){
    return new Vertex(Math.sin(angle)*w
                     ,Math.cos(angle)*w);
  }

  void move(){
    pos.addMod(getOnCircle(angle,1));
  }

  Vertex getCenter(){
    return new Vertex(pos.x+width/2,pos.y+height/2);
  }

  Vertex getHead(){
    return getCenter().add(getOnCircle(angle,width/2));
  }

  void paintMe(java.awt.Graphics g){
    final java.awt.Polygon poly = new java.awt.Polygon(); 
    final Vertex head=getHead(); 

    poly.addPoint((int)head.x,(int)head.y);

    final Vertex base1
     = getCenter().add(getOnCircle(angle+2*Math.PI/3,width/2)); 
    final Vertex base2
     = getCenter().add(getOnCircle(angle+4*Math.PI/3,width/2)); 

    poly.addPoint((int)base1.x,(int)base1.y);
    poly.addPoint((int)base2.x,(int)base2.y);

    g.fillPolygon(poly);
    g.setColor(java.awt.Color.BLACK);
    g.fillRect((int)head.x,(int)head.y,2,2);
  }
}

