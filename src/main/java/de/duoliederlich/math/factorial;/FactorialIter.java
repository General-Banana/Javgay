package de.duoliederlich.math.factorial;
public class FactorialIter{
  public static int fac(int n){
    int result=1;
    for (int i=1;i<=n;i++) result=result*i;
    return result;
  }
}

