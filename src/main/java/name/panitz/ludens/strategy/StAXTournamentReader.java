package name.panitz.ludens.strategy;
import javax.xml.stream.*;
import javax.xml.stream.events.*;
import java.io.*;
import java.util.*;

class StAXTournamentReader extends TournamentReader{
  public static XMLEventReader createEventReader(String fileName)
                                                throws Exception{
    return 
      XMLInputFactory
       .newInstance()
       .createXMLEventReader
            (new FileInputStream(fileName),"utf8");
  }

  public List<TournamentPlayer> read(String fileName) 
                                               throws Exception{
    XMLEventReader reader = createEventReader(fileName);
    String currentText=null;
    String name=null;
    String desc=null;
    String pl=null;
    List<TournamentPlayer> result 
     = new LinkedList<TournamentPlayer>();

    while (reader.hasNext()){
      XMLEvent n = reader.nextEvent();

      if (n.isStartElement()){
        currentText="";        
      }else if ( n.isCharacters()){
        currentText=currentText+n.asCharacters().getData();
      }else if ( n.isEndElement()){
        final EndElement ee = n.asEndElement();
        final String en = ee.getName().getLocalPart();
        if(en.equals("author")) name=currentText;
        else if(en.equals("description")) desc=currentText;
        else if(en.equals("class")) pl=currentText;
        else if (en.equals("player")){
          result.add(new TournamentPlayer(name,desc,pl));
          name=null;
          desc=null;
          pl=null;
        }	
      }
    }
    return result;
  }
}

