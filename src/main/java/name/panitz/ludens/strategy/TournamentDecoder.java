package name.panitz.ludens.strategy;
import java.beans.*;
import java.io.*;
public class TournamentDecoder{
  static public void main(String[] args) throws Exception{
    XMLDecoder e=new XMLDecoder(new FileInputStream(args[0]));
    Tournament tor = (Tournament)e.readObject();
    e.close();
    System.out.println(tor.getPs());
    tor.play();
    System.out.println(tor.getPs());
  }
}

