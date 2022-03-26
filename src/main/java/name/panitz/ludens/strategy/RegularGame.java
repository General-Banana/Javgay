package name.panitz.ludens.strategy;
public interface RegularGame<M> extends Game<M>{

  int getRows();
  int getColumns();

  byte getPlayerOne();
  byte getPlayerTwo();
  byte getPlayerNone();

  byte getAtPosition(byte column,byte row);

  RegularGame<M> setAtPosition(byte column,byte row);

}

