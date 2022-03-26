package name.panitz.ludens.error.runtime;
import name.panitz.ludens.animationGame.Vertex;
public class Cast{
  public static String asString(Object o){
    return (String)o;
  }

  public static void main(String[] a){
    String s1 = asString("hello");

    String s2 = asString(new Vertex(17,4));
  }
}

