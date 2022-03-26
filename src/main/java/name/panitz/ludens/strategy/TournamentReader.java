package name.panitz.ludens.strategy;
import java.util.List;
public abstract class TournamentReader{

  public abstract List<TournamentPlayer> read(String fileName)
                                    throws Exception;

  public static String TOURNAMENT_READER_CLASS
    ="name.panitz.ludens.strategy.TournamentReader.class";

  private static String DEFAULT_READER_CLASS 
    ="name.panitz.ludens.strategy.DOMTournamentReader";

  private static TournamentReader instance;

  static TournamentReader getInstance(){
    if (instance==null){

      String readerClass
          = System.getProperty(TOURNAMENT_READER_CLASS);  
      if (readerClass==null) readerClass=DEFAULT_READER_CLASS;

      try{
        instance = (TournamentReader)
                      Class.forName(readerClass).newInstance();
      }catch(Exception e){
          e.printStackTrace(System.err);
	  instance = new DOMTournamentReader();
      }
    }

    return instance;
  }
}

