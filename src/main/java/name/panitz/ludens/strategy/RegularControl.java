package name.panitz.ludens.strategy;
import javax.swing.*;
import java.awt.event.*;

public class RegularControl<M> extends JPanel{

  RegularBoard<M> board;

  RegularControl(RegularBoard<M> b){   
    this.board=b;
    add(this.board);

    board.addMouseListener(new MouseAdapter(){
      @Override public void mousePressed(MouseEvent ev){
        byte c = (byte)(ev.getPoint().getX()/board.UNIT);
        byte r = (byte)(ev.getPoint().getY()/board.UNIT);
        whenMousePressed(c,r);
      }
    });
  }

  RegularControl(RegularGame<M> game){   
    this(new RegularBoard<M>(game));
  }

  public void whenMousePressed(byte c,byte r){
    if (board.getGame().ended()) return;
    if (board.getGame().getAtPosition(c,r)
        != board.getGame().getPlayerNone()) return;

    board.setGame(board.getGame().setAtPosition(c,r));
  }

}

