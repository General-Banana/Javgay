package name.panitz.ludens.strategy;
public class TestTournamentReader{
  public static void main(String [] args)throws Exception{
    TournamentReader reader=TournamentReader.getInstance();
    System.out.println(reader.read(args[0]));
  }
}

