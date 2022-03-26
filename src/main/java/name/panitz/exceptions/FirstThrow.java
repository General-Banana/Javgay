package name.panitz.exceptions;
public class FirstThrow {
  public static int fakultät(int n){
    if (n==0) return 1;
    if (n<0) throw new RuntimeException();
    return n*fakultät(n-1);
  }
  public static void main(String [] args){
    System.out.println(fakultät(5));
    System.out.println(fakultät(-3));
    System.out.println(fakultät(4));
  }
}

