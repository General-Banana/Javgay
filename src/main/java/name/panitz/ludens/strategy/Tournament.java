package name.panitz.ludens.strategy;
import java.util.*;
import javax.swing.JFrame;
import name.panitz.ki.FourKI;

public class Tournament {

  static enum Result {Home,Guest,Draw}


  private List<TournamentPlayer> ps
     = new LinkedList<TournamentPlayer>();
  public List<TournamentPlayer> getPs(){return ps;}
  public void setPs(List<TournamentPlayer> ps){this.ps=ps;}

  void readPlayer(String fileName) throws Exception{
     ps=TournamentReader.getInstance().read(fileName);  
  }

  JFrame f = new JFrame();
  Result play(TournamentPlayer home,TournamentPlayer guest){

    home.reset();
    guest.reset();
    Vier game = new Vier();
    f.setVisible(true);

    while (!game.ended()){

      f.add(new RegularBoard<Byte>(game));
      f.pack();

      int n=home.getPlayer().nextMove();
      game=game.doMove((byte)n);
      guest.getPlayer().nextMove(n);

      if (game.wins()) return Result.Home;
      if (game.noMoreMove()) return Result.Draw;

      n=guest.getPlayer().nextMove();
      game=game.doMove((byte)n);
      f.add(new RegularBoard<Byte>(game));
      f.pack();
      home.getPlayer().nextMove(n);
      if (game.wins()) return Result.Guest;
      if (game.noMoreMove()) return Result.Draw;
    }
    return Result.Draw;
  }

  void play(){
    for (TournamentPlayer p1:ps){
      for (TournamentPlayer p2:ps){
        if (p1!=p2){
	  System.out.println(p1+" gegen "+p2);

          Result result=play(p1,p2);
          if (result==Result.Draw){
            p1.setPoints(p1.getPoints()+1);
            p2.setPoints(p2.getPoints()+1);
          }else if(result==Result.Home)
            p1.setPoints(p1.getPoints()+3);
          else p2.setPoints(p2.getPoints()+3);
          System.out.println(ps);
        }
      }
    }

    Collections.sort(ps, new Comparator<TournamentPlayer>(){
      public int compare(TournamentPlayer o1,TournamentPlayer o2){
        return o2.getPoints()-o1.getPoints();
      }	  
    });  
  }

  static public void main(String[] args) throws Exception{
    Tournament tor = new Tournament();
    tor.readPlayer("tournament.xml");
    System.out.println(tor.getPs());
    tor.play();
    System.out.println(tor.getPs());
  }
}

