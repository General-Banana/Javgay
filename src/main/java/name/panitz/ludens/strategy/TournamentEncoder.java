package name.panitz.ludens.strategy;
import java.beans.*;
import java.io.*;
public class TournamentEncoder{
  static public void main(String[] args) throws Exception{
    Tournament tor = new Tournament();
    tor.readPlayer(args[0]);
    XMLEncoder e=new XMLEncoder(new FileOutputStream(args[1]));
    e.writeObject(tor);
    e.close();
  }
}

