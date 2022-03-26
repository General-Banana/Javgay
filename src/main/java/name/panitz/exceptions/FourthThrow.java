package name.panitz.exceptions;
public class FourthThrow {
  public static int fakultät(int n) throws Exception{
    if (n==0) return 1;
    if (n<0) 
     throw 
      new Exception("negative Zahl für Fakultätsberechnung");
    return n*fakultät(n-1);
  }

  public static void main(String [] args) throws Exception{
    System.out.println(fakultät(5));
    System.out.println(fakultät(-3));
    System.out.println(fakultät(4));
  }
}

