import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Main extends JFrame {
  DefaultTableModel model = new DefaultTableModel(new Object[][] {
      { "some", "text" }, { "any", "text" }, { "even", "more" },
      { "text", "strings" }, { "and", "other" }, { "text", "values" } },
      new Object[] { "Column 1", "Column 2" });

  public Main() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JTable table = new JTable(model);
    getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
    pack();
  }

  public static void main(String arg[]) {
    new Main().setVisible(true);
  }
}