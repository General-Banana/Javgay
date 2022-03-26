package name.panitz.rmi.date;
import name.panitz.ludens.util.ShowInFrame;
import javax.swing.*;
import java.awt.event.*;

import java.rmi.registry.*;

public class DateClient extends JPanel {
  JButton getButton = new JButton("get new time from server");
  JLabel l    = new JLabel();
  DateClient(String host){
    add(getButton);
    add(l);
    try {
      Registry registry = LocateRegistry.getRegistry(host);
      final GetDate stub = (GetDate) registry.lookup("date");
      l.setText(""+stub.getDate());

      getButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
          try {
            l.setText(""+stub.getDate());
          }catch (Exception e1){}
        }
      });
    }catch (Exception e) {}
  }

  public static void main(String[] args) {
    ShowInFrame.show(new DateClient(args[0]));
  }
}

