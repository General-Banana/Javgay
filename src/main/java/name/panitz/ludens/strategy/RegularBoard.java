package name.panitz.ludens.strategy;
import javax.swing.*;
import java.awt.*;

public class RegularBoard<M> extends JPanel{

  private RegularGame<M> game;

  RegularBoard(RegularGame<M> g){game=g;}

  public void setGame(RegularGame<M> g){game=g;repaint();}
  public RegularGame<M> getGame(){return game;}

  public int UNIT=50;

  @Override public Dimension getPreferredSize(){
    return new Dimension(game.getColumns()*UNIT
                        ,game.getRows()*UNIT);
  }

  @Override public void paintComponent(Graphics g){
    super.paintComponent(g);
    for (byte c=0;c<game.getColumns();c++)
      for (byte r=0;r<game.getRows();r++)   
       if (game.getAtPosition(c,r)!=game.getPlayerNone()){
          g.setColor(selectColor(game.getAtPosition(c,r)));
          g.fillOval(c*UNIT,r*UNIT,UNIT,UNIT);
       }
  }

  Color selectColor(byte player){
    if (player==game.getPlayerOne()) return Color.YELLOW;
    if (player==game.getPlayerTwo()) return Color.BLUE;
    return Color.BLACK;
  }

}

