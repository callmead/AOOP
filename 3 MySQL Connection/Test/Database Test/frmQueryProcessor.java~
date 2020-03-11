package beximtex;
/**
 * <p>Title: BeximTex, Query Processor</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class frmQueryProcessor extends JInternalFrame {
  JPanel pnlTop = new JPanel();
  JScrollPane SPtxtQuery = new JScrollPane();
  JPanel pnlBotton = new JPanel();
  JToggleButton btnProcess = new JToggleButton();
  JToggleButton btnClear = new JToggleButton();
  JToggleButton btnSample = new JToggleButton();
  JScrollPane SPTbl = new JScrollPane();
  JTable Table = new JTable();
  JLabel lblJava = new JLabel();
  JTextArea txtQuery = new JTextArea();

  String SQLString = null;
  Vector ColumHead = new Vector();
  Vector rows = new Vector();
  Vector Rows1 = new Vector();
  Vector Col1 = new Vector();
  String Error = null;

  int TotalCol = 0;
  int Rows = 0;
  int Columns = 0;

  DBU db = new DBU();
  ResultSet rs;
  String Query = new String();
  JToggleButton btnShowTab = new JToggleButton();
  JToggleButton btnShowEmp = new JToggleButton();
  JToggleButton btnClose = new JToggleButton();

  ImageIcon imgIco = new ImageIcon("./Images/popup.gif");
  ImageIcon imgMySQL = new ImageIcon("./Images/mySql.jpg");
  ImageIcon imgJava = new ImageIcon("./Images/javaLogo.gif");
  ImageIcon imgD = new ImageIcon("./Images/mant1L.png");

  JLabel lblMySQL = new JLabel();
  JLabel jLabel8 = new JLabel();
  JLabel lblIco = new JLabel();
  JToggleButton btnDesc = new JToggleButton();

  public frmQueryProcessor() {
    try {jbInit();}
    catch (Exception e) {e.printStackTrace();}
  }

  public static void main(String[] args) {
    frmQueryProcessor qp = new frmQueryProcessor();
    qp.setVisible(true);
  }

  private void jbInit() throws Exception {

    pnlTop.setBackground(Color.white);
    pnlTop.setBorder(BorderFactory.createEtchedBorder());
    pnlTop.setBounds(new Rectangle(7, 8, 736, 135));
    pnlTop.setLayout(null);

    pnlBotton.setLayout(null);
    pnlBotton.setBounds(new Rectangle(14, 15, 630, 158));
    pnlBotton.setBorder(BorderFactory.createEtchedBorder());
    pnlBotton.setBounds(new Rectangle(8, 150, 736, 306));
    pnlBotton.setBackground(Color.white);

    lblJava.setText("");
    lblJava.setBounds(new Rectangle(104, 43, 65, 84));
    lblJava.setIcon(imgJava);

    btnProcess.setText("PROCESS");
    btnProcess.setFont(new java.awt.Font("Tahoma", 1, 11));
    btnProcess.setBounds(new Rectangle(498, 23, 110, 23));
    btnProcess.addActionListener(new frmQueryProcessor_btnProcess_actionAdapter(this));
    btnClear.setBounds(new Rectangle(498, 74, 110, 23));
    btnClear.addActionListener(new frmQueryProcessor_btnClear_actionAdapter(this));
    btnClear.setText("CLEAR");
    btnClear.setFont(new java.awt.Font("Tahoma", 1, 11));
    btnSample.setBounds(new Rectangle(498, 99, 110, 23));
    btnSample.addActionListener(new frmQueryProcessor_btnSample_actionAdapter(this));
    btnSample.setText("SAMPLE");
    btnSample.setFont(new java.awt.Font("Tahoma", 1, 11));

    txtQuery.setText("SELECT * FROM Employees;");
    txtQuery.setFont(new java.awt.Font("Tahoma", 1, 11));
    txtQuery.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent ke1) {
        if (ke1.getKeyCode() == KeyEvent.VK_TAB) {
          btnProcess.requestFocus();
        }
        System.out.print("  " + ke1.getKeyCode());
      }
      public void KeyReleased(KeyEvent ke2) {}
      public void KeyTyped(KeyEvent ke3) {}
    });

    SPtxtQuery.getViewport().setBackground(Color.white);
    SPtxtQuery.setBounds(new Rectangle(165, 45, 329, 81));

    SPTbl.getViewport().setBackground(Color.white);
    SPTbl.setBounds(new Rectangle(162, 1, 572, 303));

    btnShowTab.setText("TABLES");
    btnShowTab.setFont(new java.awt.Font("Tahoma", 1, 11));
    btnShowTab.setBounds(new Rectangle(498, 49, 110, 23));
    btnShowTab.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent x2) {
        SQLString = "SHOW TABLES;";
        frmWork w = new frmWork("RETRIEVING INFORMATION");
        w.setSize(368, 140);
        w.setVisible(true);
        Rows1 = GetRowData(SQLString);
        Col1 = GetColData(SQLString);
        Table = new JTable(Rows1, Col1);
        Table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        setColWidth(SQLString);
        SPTbl.getViewport().add(Table, null);
      }
    });

    btnShowEmp.setText("EMPLOYEES");
    btnShowEmp.setFont(new java.awt.Font("Tahoma", 1, 11));
    btnShowEmp.setBounds(new Rectangle(612, 74, 110, 23));
    btnShowEmp.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent x2) {
        SQLString = "SELECT * FROM Employees ORDER BY EmpCode;";
        frmWork w = new frmWork("RETRIEVING INFORMATION");
        w.setSize(368, 140);
        w.setVisible(true);
        Rows1 = GetRowData(SQLString);
        Col1 = GetColData(SQLString);
        Table = new JTable(Rows1, Col1);
        Table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        setColWidth(SQLString);
        SPTbl.getViewport().add(Table, null);
      }
    });

    btnClose.setText("CLOSE");
    btnClose.setFont(new java.awt.Font("Tahoma", 1, 11));
    btnClose.setBounds(new Rectangle(612, 99, 110, 23));
    btnClose.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent x2) {
        dispose();
      }
    });

    lblMySQL.setText("");
    lblMySQL.setBounds(new Rectangle(0, 0, 161, 303));
    lblMySQL.setIcon(imgMySQL);
    jLabel8.setFont(new java.awt.Font("Monospaced", 1, 20));
    jLabel8.setText("Type SQL Query");
    jLabel8.setBounds(new Rectangle(164, 1, 271, 39));
    lblIco.setBounds(new Rectangle(4, 3, 128, 128));
    lblIco.setIcon(imgD);
    btnDesc.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent x2) {
        if (txtQuery.getText().equals("") || txtQuery.getText().equals(" ")) {
          JOptionPane.showMessageDialog(null, "Please type a valid Table Name!",
                                        "Missing Information",
                                        JOptionPane.ERROR_MESSAGE);
          txtQuery.requestFocus();
        }
        else {
          SQLString = "DESC " + txtQuery.getText() + ";";
          frmWork w = new frmWork("RETRIEVING INFORMATION");
          w.setSize(368, 140);
          w.setVisible(true);
          Rows1 = GetRowData(SQLString);
          Col1 = GetColData(SQLString);
          Table = new JTable(Rows1, Col1);
          Table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
          setColWidth(SQLString);
          SPTbl.getViewport().add(Table, null);
        }
      }
    });
    btnDesc.setBounds(new Rectangle(612, 49, 110, 23));
    btnDesc.setFont(new java.awt.Font("Tahoma", 1, 11));
    btnDesc.setToolTipText("Describe Table");
    btnDesc.setText("DESCRIBE");
    pnlBotton.add(lblMySQL, null);
    pnlBotton.add(SPTbl, null);
    this.getContentPane().add(pnlTop, null);
    pnlTop.add(btnClose, null);
    pnlTop.add(btnSample, null);
    pnlTop.add(btnClear, null);
    pnlTop.add(btnShowEmp, null);
    pnlTop.add(SPtxtQuery, null);
    pnlTop.add(jLabel8, null);
    pnlTop.add(lblJava, null);
    pnlTop.add(lblIco, null);
    pnlTop.add(btnDesc, null);
    pnlTop.add(btnShowTab, null);
    pnlTop.add(btnProcess, null);
    SPtxtQuery.getViewport().add(txtQuery, null);
    this.getContentPane().add(pnlBotton, null);
    this.getContentPane().setBackground(Color.white);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setFrameIcon(imgIco);
    this.setIconifiable(true);
    this.setClosable(true);
    this.setTitle("QUERY PROCESSOR");
    this.setResizable(false);
    this.getContentPane().setLayout(null);
    this.setSize(new Dimension(760, 492));
  }

  void btnProcess_actionPerformed(ActionEvent e) {
    if (txtQuery.getText().equals("") || txtQuery.getText().equals(" ")) {
      JOptionPane.showMessageDialog(null, "Please type a valid Query! \nLike:\nSELECT * FROM HW_Stock WHERE Item='HDD';",
                                    "Missing Information",
                                    JOptionPane.ERROR_MESSAGE);
      txtQuery.requestFocus();
    }
    else {
      SQLString = txtQuery.getText();
      if(!SQLString.endsWith(";"))
      {
        SQLString = SQLString + ";";
        txtQuery.setText(SQLString);
      }
      SQLString = txtQuery.getText();
      processQuery();
    }
  }

  void processQuery() {
    if(!SQLString.startsWith("SELECT"))
    {
         JOptionPane.showMessageDialog(null,"Please Type a Valid Query!\nYou have SELECT Grant on Tables Only...","Access Denied",JOptionPane.ERROR_MESSAGE);
        System.out.println("Not a Valid Query!");return;
    }
    else
    {
            frmWork w = new frmWork("RETRIEVING INFORMATION");
            w.setSize(368, 140);
            w.setVisible(true);
            Rows1 = GetRowData(SQLString);
            Col1 = GetColData(SQLString);
            Table = new JTable(Rows1, Col1);
            Table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            setColWidth(SQLString);
           SPTbl.getViewport().add(Table, null);
    }
  }

  void btnClear_actionPerformed(ActionEvent e) {
    txtQuery.setText("");
    txtQuery.requestFocus();
  }

  void btnSample_actionPerformed(ActionEvent e) {
    txtQuery.setText("SELECT * FROM Employees WHERE Designation='Manager';");
  }

  Vector GetRowData(String SQL) {
    Vector Row = new Vector();
    Vector currentRow;

    try {
      rs = db.stmt.executeQuery(SQL);
      if (!rs.next()) {
        JOptionPane.showMessageDialog(null, "No Records Found !!!");
        return null;
      }

      ResultSetMetaData rsmd = rs.getMetaData();
      TotalCol = rsmd.getColumnCount();

      do {
        currentRow = new Vector();

        for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
          currentRow.addElement(rs.getString(i));
        }
        Row.addElement(currentRow);
      }
      while (rs.next());
    }
    catch (SQLException sqle) {
      System.out.println("\nSet Row data Error !\n" + sqle);
      JOptionPane.showMessageDialog(null, "Error in Querry !!!", "Error...",
                                    JOptionPane.ERROR_MESSAGE);
      txtQuery.selectAll();
      txtQuery.requestFocus();
    }
    return Row;
  }

  Vector GetColData(String SQL) {
    Vector Col = new Vector();

    try {
      rs = db.stmt.executeQuery(SQL);
      if (!rs.next()) {
        return null;
      }

      ResultSetMetaData rsmd = rs.getMetaData();
      TotalCol = rsmd.getColumnCount();

      for (int j = 1; j <= TotalCol; ++j) {
        Col.addElement(rsmd.getColumnName(j));
      }
    }
    catch (SQLException sqle) {
      System.out.println("\nSet Row data Error !\n" + sqle);
    }

    return Col;
  }

  void setColWidth(String SQL) {
    TotalCol = 0;
    try {
      rs = db.stmt.executeQuery(SQL);
      if (!rs.next()) {
        return;
      }

      ResultSetMetaData rsmd = rs.getMetaData();
      TotalCol = rsmd.getColumnCount();
      for (int j = 0; j < TotalCol; ++j) {
        Table.getColumnModel().getColumn(j).setPreferredWidth(100);
      }
    }
    catch (SQLException sqle) {
      System.out.println("\nSet Col Width Error !\n" + sqle);
    }
  }
}

class frmQueryProcessor_btnProcess_actionAdapter
    implements java.awt.event.ActionListener {
    frmQueryProcessor adaptee;
    frmQueryProcessor_btnProcess_actionAdapter(frmQueryProcessor adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btnProcess_actionPerformed(e);
  }
}

class frmQueryProcessor_btnClear_actionAdapter
    implements java.awt.event.ActionListener {
    frmQueryProcessor adaptee;
    frmQueryProcessor_btnClear_actionAdapter(frmQueryProcessor adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btnClear_actionPerformed(e);
  }
}

class frmQueryProcessor_btnSample_actionAdapter
    implements java.awt.event.ActionListener {
    frmQueryProcessor adaptee;
    frmQueryProcessor_btnSample_actionAdapter(frmQueryProcessor adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btnSample_actionPerformed(e);
  }
}
