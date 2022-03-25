package Spielobjekte;
public class Vertex{
	
	public double x;
	public double y;
	
	public Vertex(double xx, double yy){
		x=xx;
		y=yy;
	}

	public double länge(){
		return Math.sqrt(x*x+y*y);
	}

	public Vertex skalarMult(double s){
		return new Vertex(x*s,y*s);
	}

	public Vertex skalarMultMod(double s){
		x=s*x;
		y=s*y;
	}
}
