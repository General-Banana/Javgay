package name.panitz.ludens.strategy;
import java.util.List;
import java.io.File;

public class SAXTournamentReader extends TournamentReader{
  public List<TournamentPlayer> read(String fileName) 
                                          throws Exception{
    TournamentSAX handler=new TournamentSAX();
    SAX.parse(fileName,handler);
    return handler.result;
  }
}

