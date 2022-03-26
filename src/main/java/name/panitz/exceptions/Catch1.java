package name.panitz.exceptions;
public class Catch1 {
  public static int fakultät(int n) throws Exception{
    if (n==0) return 1;
    if (n<0) throw new Exception();
    return n*fakultät(n-1);
  }

  public static void main(String [] args){
    try {
      System.out.println(fakultät(5));
      System.out.println(fakultät(-3));
      System.out.println(fakultät(4));
    }catch (Exception e){
      System.out.println("Ausnahme aufgetreten: "+e);
    }
  }
}

