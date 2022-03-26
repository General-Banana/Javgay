package name.panitz.ludens.strategy;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;
import org.xml.sax.*;

public class TournamentSAX extends DefaultHandler{

  List<TournamentPlayer> result=new LinkedList<TournamentPlayer>();

  String currentText;
  String name=null;
  String desc=null;
  String pl=null;

  @Override
  public void startElement
   (String uri,String localName,String qName,Attributes attrs)
                                         throws SAXException {
    currentText="";
  }

  @Override
  public void endElement(String uri,String localN,String qName) 
                                           throws SAXException{

    if (qName.equals("author")) name=currentText;
    else if (qName.equals("description")) desc=currentText;
    else if (qName.equals("class")) pl=currentText;


    else if (qName.equals("player")){
      result.add(new TournamentPlayer(name,desc,pl));
      name=null;
      desc=null;
      pl=null;
    }
  }

  @Override
  public void characters(char[] ch,int start,int length) 
                                             throws SAXException{
    currentText=currentText+new String(ch,start,length);
  }
}

