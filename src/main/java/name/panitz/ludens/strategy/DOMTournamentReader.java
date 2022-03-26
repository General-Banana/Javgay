package name.panitz.ludens.strategy;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.util.*;

public class DOMTournamentReader extends TournamentReader{
  static Element getDocumentElement(String fileName)
                                        throws Exception{
    return DocumentBuilderFactory	
            .newInstance()
            .newDocumentBuilder()
            .parse(new java.io.File(fileName))
            .getDocumentElement();
  }

  public List<TournamentPlayer> read(String fileName) 
                                                throws Exception{
   List<TournamentPlayer>result=new LinkedList<TournamentPlayer>();
   final Element el= getDocumentElement(fileName);

    for (int i=0;i<el.getChildNodes().getLength();i++){
      final Node n=el.getChildNodes().item(i);

      if (    n.getNodeType()==Node.ELEMENT_NODE

           && n.getNodeName().equals("player"))

        result.add(fromXML(n));
    }
    return result;
  }

  static public TournamentPlayer fromXML(Node el)throws Exception{
    String name=null;
    String desc=null;
    String pl=null;
    for (int i=0;i<el.getChildNodes().getLength();i++){
      Node n = el.getChildNodes().item(i);
      if (n.getNodeName().equals("author")){
        name=n.getFirstChild().getNodeValue();
      }else if (n.getNodeName().equals("description")){
        desc=n.getFirstChild().getNodeValue();
      }else if (n.getNodeName().equals("class")){
        pl=n.getFirstChild().getNodeValue();
      }
    }
    return new TournamentPlayer(name,desc,pl);
  }
}

