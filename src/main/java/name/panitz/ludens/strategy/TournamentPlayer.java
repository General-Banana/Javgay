package name.panitz.ludens.strategy;
import name.panitz.ki.FourKI;

public class TournamentPlayer {
  private String name;
  public void setName(String name){this.name = name;}
  public String getName(){return name;}

  private String description;
  public void setDescription(String description) {
    this.description = description;}
  public String getDescription(){return description;}

  private FourKI player;
  public void setPlayer(FourKI player){this.player = player;}
  public FourKI getPlayer() {return player;}

  private int points=0;
  public void setPoints(int points){this.points = points;}
  public int getPoints(){return points;}

  public TournamentPlayer() {}
  public TournamentPlayer(String name,String d,FourKI player) {
    this.name=name;
    this.description=d;
    this.player=player;
  }

  public void setPlayer(String playerClassName){
    try{
     player=(FourKI)Class.forName(playerClassName).newInstance();
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  public TournamentPlayer(String n,String d,String playerClass){
    this.name=n;
    this.description=d;
    setPlayer(playerClass);
  }

  void reset(){
    try{
      player=player.getClass().newInstance();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override public String toString() {return name+" "+points;}
}

