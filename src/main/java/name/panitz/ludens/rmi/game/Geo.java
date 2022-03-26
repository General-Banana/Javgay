package name.panitz.ludens.rmi.game;
import name.panitz.ludens.animationGame.*;
public class Geo extends GeometricObject {
  public Geo(double w,double h,Vertex pos){
    super(w,h,pos);
  }
  public boolean isLeftOf(Geo that){
    return this.pos.x+this.width<that.pos.x;
  }
  public boolean isAbove(Geo that){
    return this.pos.y+this.height<that.pos.y;
  }
  public boolean touches(Geo that){
    if (this.isLeftOf(that)) return false;
    if (that.isLeftOf(this)) return false;
    if (this.isAbove(that))  return false;
    if (that.isAbove(this))  return false;
    return true;
  }
}

