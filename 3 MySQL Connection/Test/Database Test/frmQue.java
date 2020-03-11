//package beximtex;
/**
 * <p>Title: BeximTex, Queue Manager</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.TableColumn;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.Date;

public class frmQue extends JInternalFrame {
  String Head = null;
  JLabel lblHead = new JLabel();
  JPanel pnlTab = new JPanel();
  JScrollPane sp = new JScrollPane();
  Vector ColumHead = new Vector();
  Vector rows = new Vector();
  int TotalCol = 0;
  int Rows = 0;
  int Columns = 0;
  String Type[][];  String SelRow[][];
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;
  Border border1;

  JPanel pnlButtons = new JPanel();
  TitledBorder titledBorder3;
  JToggleButton btnDelete = new JToggleButton();
  JToggleButton btnClose = new JToggleButton();
  JToggleButton btnSearch = new JToggleButton();

  ButtonGroup bg = new ButtonGroup();
  JTable Table = new JTable();

  ImageIcon imgFirst = new ImageIcon("./Images/iconFirst.gif");
  ImageIcon imgFO = new ImageIcon("./Images/iconFirstOver.gif");
  ImageIcon imgLast = new ImageIcon("./Images/iconLast.gif");
  ImageIcon imgLO = new ImageIcon("./Images/iconLastOver.gif");
  ImageIcon imgNext = new ImageIcon("./Images/iconNext.gif");
  ImageIcon imgNO = new ImageIcon("./Images/iconNextOver.gif");
  ImageIcon imgPrev = new ImageIcon("./Images/iconPrevious.gif");
  ImageIcon imgPO = new ImageIcon("./Images/iconPreviousOver.gif");
  ImageIcon imgSearch = new ImageIcon("./Images/powerSearch.gif");
  ImageIcon imgIco = new ImageIcon("./Images/popup.gif");
  ImageIcon imgQ = new ImageIcon("./Images/question32.png");
  ImageIcon imgExc = new ImageIcon("./Images/exc.gif");

  DBU db = new DBU();
  ResultSet rs;
  ResultSet rsQue;

  boolean isAdd = false;

  String EmpCode = null;
  String TableName = null;
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
  Date d;
  String SQLString,TransactionID,Query;
  JLabel lblSearch = new JLabel();
  JTextField txtSearch = new JTextField();
  JLabel lblPicture = new JLabel();
  JToggleButton btnDeleteAll = new JToggleButton();
  JToggleButton btnDeleteC = new JToggleButton();
  JToggleButton btnDeleteS = new JToggleButton();
  JComboBox cboType = new JComboBox();

  int[] sz;

  public frmQue(String ec, String Label, String qry, String tbl) {
    EmpCode = ec;
    Head = Label;
    SQLString = qry;
    TableName = tbl;
    try {jbInit();}
    catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(null, "Error Occured !!!" + "\nError: " + e,
                                    "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  private void jbInit() throws Exception {

    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    border1 = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.blue,
                                              new Color(187, 218, 252),
                                              Color.black, Color.white);
    titledBorder3 = new TitledBorder("");
    this.getContentPane().setLayout(null);

    pnlTab.setBounds(new Rectangle(9, 41, 671, 293));
    pnlTab.setBorder(BorderFactory.createLineBorder(Color.black));
    pnlTab.setLayout(new BorderLayout());


    lblSearch.setText("Search");
    lblSearch.setBounds(new Rectangle(11, 72, 76, 24));
    lblSearch.setFont(new java.awt.Font("Tahoma", 1, 11));
    txtSearch.setText("");
    txtSearch.setBounds(new Rectangle(61, 73, 202, 23));
    txtSearch.setFont(new java.awt.Font("Tahoma", 1, 11));
    txtSearch.setDoubleBuffered(false);
    sp.getViewport().setBackground(Color.white);
    sp.setToolTipText("Request Queue");
    sp.getViewport();

    lblHead.setBackground(Color.white);
    this.getContentPane().setBackground(Color.white);

    lblHead.setText(Head);
    lblHead.setBounds(new Rectangle(9, 9, 671, 30));
    lblHead.setForeground(Color.black);
    lblHead.setFont(new java.awt.Font("Dialog", 1, 16));
    lblHead.setBorder(border1);
    lblHead.setOpaque(true);
    lblHead.setHorizontalAlignment(SwingConstants.CENTER);


    pnlButtons.setBackground(Color.white);
    pnlButtons.setBorder(titledBorder3);
    pnlButtons.setMaximumSize(new Dimension(32767, 32767));
    pnlButtons.setBounds(new Rectangle(9, 338, 671, 105));
    pnlButtons.setLayout(null);
    btnDelete.setBounds(new Rectangle(535, 6, 129, 28));
    btnDelete.setText("DELETE SELECTED");
    btnDelete.setFont(new java.awt.Font("Tahoma", 1, 11));
    btnDelete.setToolTipText("Deletes the selected record from the table above");
    btnDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int x[] = Table.getSelectedRows();
        if (x.length >= 1)
        {
          SelRow = new String[x.length][TotalCol];
          System.out.println("\nSELECTED ROW: ");
          for (int i = 0; i < x.length; i++)
          {
            for (int j = 0; j < TotalCol; j++)
            {
              SelRow[i][j] = Table.getValueAt(x[i], j).toString();
              System.out.print(SelRow[i][j]+" * ");
            }
          }
          TransactionID=(SelRow[0][0]);
          System.out.println("Table is "+TableName+" AND TransactionID "+TransactionID);
          int yn;
          Query = "DELETE FROM "+TableName+" WHERE TransactionID='"+TransactionID+"';";
          yn = JOptionPane.showConfirmDialog(null,
              "This will DELETE the Searched Transaction "+TransactionID+" from Table "+TableName+"\nAre you sure?", "Conformation...",
              JOptionPane.YES_NO_OPTION, 3, imgQ);
          System.out.println("\nRecord Found waiting for the user to take action...\n");

            if (yn == JOptionPane.YES_OPTION)
            {
              try
              {
                db.stmt.executeUpdate(Query);
                frmWork w = new frmWork("DELETING RECORD");
                w.setSize(368, 140);
                w.setVisible(true);

                JOptionPane.showMessageDialog(null, "Records Deleted...",
                                              "Information",
                                              1);
                Connect();
              }
              catch (SQLException sqle) {
                System.out.println("frmQue.DeleteSelected Error: Deleting Data!!!");
                System.out.println("*** Exception: " + sqle);
                JOptionPane.showMessageDialog(null,
                                              "frmQue.DeleteSelected Error !!!" +
                                              "\nError: " +
                                              sqle.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
              }

            }
            else {
              System.out.println("\nRecord not Deleted, Abord by the user...\n");
              Connect();
            }
        }
        else if (x.length < 1) {
          JOptionPane.showMessageDialog(null, "Please Select One Item!",
                                        "Information Required...",
                                        JOptionPane.ERROR_MESSAGE);
        }
      }
    });
    btnClose.setText("CLOSE");
    btnClose.setBounds(new Rectangle(535, 70, 129, 28));
    btnClose.setFont(new java.awt.Font("Tahoma", 1, 11));
    btnClose.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent x2) {
        dispose();
      }
    });

    btnSearch.setBounds(new Rectangle(399, 70, 129, 28));
    btnSearch.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (txtSearch.getText().equals("")) {
          JOptionPane.showMessageDialog(null, "Search What ?",
                                        "Information Required...",
                                        JOptionPane.INFORMATION_MESSAGE, imgExc);
          txtSearch.requestFocus();
        }
        else
        {
          try
          {
            Query = "SELECT * FROM "+TableName+" WHERE " + cboType.getSelectedItem().toString() + "='" + txtSearch.getText() + "';";
            rsQue = db.stmt.executeQuery(Query);
            frmWork w = new frmWork("SEARCHING");
            w.setSize(368, 140);
            w.setVisible(true);
            if (!rsQue.next()) {
              System.out.println("\nRecord for " + txtSearch.getText() + " not found!!!\n");
              JOptionPane.showMessageDialog(null, "Record not found!!!",
                                            "Search Result...",
                                            JOptionPane.ERROR_MESSAGE);
              txtSearch.requestFocus();
              Connect();
            }
            else {getTableData(Query);}
          }
          catch (SQLException sqle) {
            System.out.println("*** frmQue.SearchData Error:");
            System.out.println("*** Exception: " + sqle);
            JOptionPane.showMessageDialog(null,
                                          "frmQue.SearchData Error:" + "\nError: " + sqle.getMessage(),
                                          "Error", JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });
    btnSearch.setText("SEARCH");
    btnSearch.setFont(new java.awt.Font("Tahoma", 1, 11));

    lblPicture.setText("");
    lblPicture.setIcon(imgSearch);
    lblPicture.setBounds(new Rectangle(20, 13, 273, 42));
    btnDeleteAll.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int yn;
        Query = "DELETE FROM "+TableName+";";
        yn = JOptionPane.showConfirmDialog(null,
            "This will DELETE all records from Table "+TableName+"\nAre you sure?", "Conformation...",
            JOptionPane.YES_NO_OPTION, 3, imgQ);
        System.out.println("\nRecord Found waiting for the user to take action...\n");

          if (yn == JOptionPane.YES_OPTION)
          {
            try
            {
              db.stmt.executeUpdate(Query);
              frmWork w = new frmWork("DELETING RECORD");
              w.setSize(368, 140);
              w.setVisible(true);

              JOptionPane.showMessageDialog(null, "Records Deleted...",
                                            "Information",
                                            1);
              Connect();
            }
            catch (SQLException sqle) {
              System.out.println("frmQue.DeleteSearchData Error: Deleting Data!!!");
              System.out.println("*** Exception: " + sqle);
              JOptionPane.showMessageDialog(null,
                                            "frmQue.DeleteSearchData Error !!!" +
                                            "\nError: " +
                                            sqle.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

          }
          else {
            System.out.println("\nRecord not Deleted, Abord by the user...\n");
            Connect();
          }
      }
    });
    btnDeleteAll.setFont(new java.awt.Font("Tahoma", 1, 11));
    btnDeleteAll.setToolTipText("Deletes all records from the table");
    btnDeleteAll.setText("DELETE ALL");
    btnDeleteAll.setBounds(new Rectangle(535, 38, 129, 28));
    btnDeleteC.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int yn;
        if(TableName.equals("Jobs")){Query = "DELETE FROM Jobs WHERE Status='Cleared';";}
        if(TableName.equals("HW_POGR")){Query = "DELETE FROM HW_POGR WHERE Status='Cleared';";}
        else {Query = "DELETE FROM "+TableName+" WHERE JobStatus='Cleared';";}

        yn = JOptionPane.showConfirmDialog(null,
            "This will DELETE all CLEARED records from Table "+TableName+"\nAre you sure?", "Conformation...",
            JOptionPane.YES_NO_OPTION, 3, imgQ);
        System.out.println("\nRecord Found waiting for the user to take action...\n");

          if (yn == JOptionPane.YES_OPTION)
          {
            try
            {
              db.stmt.executeUpdate(Query);
              frmWork w = new frmWork("DELETING RECORD");
              w.setSize(368, 140);
              w.setVisible(true);

              JOptionPane.showMessageDialog(null, "Records Deleted...",
                                            "Information",
                                            1);
              Connect();
            }
            catch (SQLException sqle) {
              System.out.println("frmQue.DeleteAllClearRecords Error: Deleting Data!!!");
              System.out.println("*** Exception: " + sqle);
              JOptionPane.showMessageDialog(null,
                                            "frmQue.DeleteAllClearRecords Error !!!" +
                                            "\nError: " +
                                            sqle.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

          }
          else {
            System.out.println("\nRecord not Deleted, Abord by the user...\n");
            Connect();
          }
      }
    });
    btnDeleteC.setFont(new java.awt.Font("Tahoma", 1, 11));
    btnDeleteC.setToolTipText("Deletes the Records which are cleared [Job Status]");
    btnDeleteC.setText("DELETE CLEARED");
    btnDeleteC.setBounds(new Rectangle(399, 6, 129, 28));
    btnDeleteS.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int yn;
        Query = "DELETE FROM "+TableName+" WHERE "+cboType.getSelectedItem().toString()+"='"+txtSearch.getText()+"';";
        yn = JOptionPane.showConfirmDialog(null,
            "This will DELETE All the Searched Data from Table "+TableName+"\nAre you sure?", "Conformation...",
            JOptionPane.YES_NO_OPTION, 3, imgQ);
        System.out.println("\nRecord Found waiting for the user to take action...\n");

          if (yn == JOptionPane.YES_OPTION)
          {
            try
            {
              db.stmt.executeUpdate(Query);
              frmWork w = new frmWork("DELETING RECORD");
              w.setSize(368, 140);
              w.setVisible(true);

              JOptionPane.showMessageDialog(null, "Records Deleted...",
                                            "Information",
                                            1);
              Connect();
            }
            catch (SQLException sqle) {
              System.out.println("frmQue.DeleteAll Error: Deleting Data!!!");
              System.out.println("*** Exception: " + sqle);
              JOptionPane.showMessageDialog(null,
                                            "frmQue.DeleteAll Error !!!" +
                                            "\nError: " +
                                            sqle.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

          }
          else {
            System.out.println("\nRecord not Deleted, Abord by the user...\n");
            Connect();
          }
      }
    });
    btnDeleteS.setFont(new java.awt.Font("Tahoma", 1, 11));
    btnDeleteS.setToolTipText("Deletes the current Search Results");
    btnDeleteS.setText("DELETE SEARCH");
    btnDeleteS.setBounds(new Rectangle(399, 38, 129, 28));
    cboType.setBounds(new Rectangle(271, 73, 121, 23));
    cboType.setBackground(Color.white);

    pnlButtons.add(lblSearch, null);
    pnlButtons.add(lblPicture, null);
    pnlButtons.add(btnClose, null);
    pnlButtons.add(btnDeleteAll, null);
    pnlButtons.add(btnSearch, null);
    this.getContentPane().add(lblHead, null);
    this.getContentPane().add(pnlTab, null);
    pnlTab.add(sp, BorderLayout.CENTER);
    this.getContentPane().add(pnlButtons, null);
    pnlButtons.add(btnDeleteC, null);
    pnlButtons.add(btnDeleteS, null);
    pnlButtons.add(btnDelete, null);
    pnlButtons.add(txtSearch, null);
    pnlButtons.add(cboType, null);

    this.setTitle("QUEUE MANAGER");
    this.setSize(new Dimension(700, 480));
    this.setResizable(false);
    this.setClosable(true);
    this.setIconifiable(true);
    this.setMaximizable(false);
    this.setFrameIcon(imgIco);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    if(TableName.equals("Jobs")){addJobItems();}
    else if(TableName.equals("HW_POGR")){addPOItems();}else{addRequestItems();}
    Connect();
  }

  public void Connect() {
    try {rsQue = db.stmt.executeQuery(SQLString);getTableData(SQLString);}
    catch (SQLException sqle) {
      System.out.println("Error: Connecting!");
      System.out.println("*** Exception: " + sqle);
      JOptionPane.showMessageDialog(null,
                                    "Error Occured !!!" + "\nError: " + sqle.getMessage(),
                                    "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  void getTableData(String SQLString) {
    System.out.println("\nProcessing "+TableName);
    rows = GetRowData(SQLString);
    ColumHead = GetColData(SQLString);
    Table = new JTable(rows, ColumHead);
    setColWidth(SQLString, Table);
    sp.getViewport().add(Table);
    Table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    Table.setFont(new java.awt.Font("Tahoma", 0, 11));
    Table.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {
        int x[] = Table.getSelectedRows();
        if (x.length >= 1)
        {
          SelRow = new String[x.length][TotalCol];
          System.out.println("\nSELECTED ROW: ");
          for (int i = 0; i < x.length; i++)
          {
            for (int j = 0; j < TotalCol; j++)
            {
              SelRow[i][j] = Table.getValueAt(x[i], j).toString();
              System.out.print(SelRow[i][j]+" * ");
            }
          }
          TransactionID=(SelRow[0][0]);
          System.out.println("Table is "+TableName+" AND TransactionID "+TransactionID);
        }
        else if (x.length < 1) {
          JOptionPane.showMessageDialog(null, "Please Select One Item!",
                                        "Information Required...",
                                        JOptionPane.ERROR_MESSAGE);
        }
      }
    });
  }

  Vector GetRowData(String SQL) {
    SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
    DBU db = new DBU();
    ResultSet rs;
    Vector Row = new Vector();
    Vector currentRow;

    try
    {
      rs = db.stmt.executeQuery(SQL);
      if (!rs.next())
      {
        return null;
      }
      ResultSetMetaData rsmd = rs.getMetaData();
      TotalCol = rsmd.getColumnCount();

      do {
        currentRow = new Vector();

        for (int i = 1; i <= rsmd.getColumnCount(); ++i)
        {
          if(rsmd.getColumnType(i)==93) //Date
          currentRow.addElement(sdf.format(rs.getDate(i)));
          else
          currentRow.addElement(rs.getString(i));
        }
        Row.addElement(currentRow);
      }
      while (rs.next());
    }
    catch (SQLException sqle) {
      System.out.println("frmReqApp.GetRowData Error: " + sqle);
      JOptionPane.showMessageDialog(null,
                                    "frmReqApp.GetRowData Error !!!" +
                                    "\nError: " +
                                    sqle, "Error", JOptionPane.ERROR_MESSAGE);
    }
    return Row;
  }

  Vector GetColData(String SQL) {
    DBU db = new DBU();
    ResultSet rs;
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
      System.out.println("GetColData Error: Set Row data Error !");
      JOptionPane.showMessageDialog(null,
                                    "Error Occured !!!" + "\nError: " + sqle,
                                    "Error", JOptionPane.ERROR_MESSAGE);
    }
    return Col;
  }

  void setColWidth(String SQLString, JTable Table) {
    DBU db = new DBU();
    ResultSet rs;
    try {
      rs = db.stmt.executeQuery(SQLString);
      if (!rs.next()) {
        return;
      }
      ResultSetMetaData rsmd = rs.getMetaData();
      TotalCol = rsmd.getColumnCount();
      TableColumn column = null;

      if(TableName.equals("Email"))
      {
        sz = new int[14];
        sz[0]=115;sz[1]=50;sz[2]=60;sz[3]=150;sz[4]=150;sz[5]=150;sz[6]=70;sz[7]=50;sz[8]=100;sz[9]=50;sz[10]=50;sz[11]=100;sz[12]=50;sz[13]=70;
      }
      if(TableName.equals("Mobile"))
      {
        sz = new int[26];
        sz[0]=115;sz[1]=50;sz[2]=60;sz[3]=50;sz[4]=50;sz[5]=90;sz[6]=150;sz[7]=50;sz[8]=70;sz[9]=150;sz[10]=50;sz[11]=70;sz[12]=50;sz[13]=50;sz[14]=50;sz[15]=150;sz[16]=50;sz[17]=150;sz[18]=70;sz[19]=50;sz[20]=100;sz[21]=50;sz[22]=50;sz[23]=100;sz[24]=50;sz[25]=70;
      }
      if(TableName.equals("Hardware"))
      {
        sz = new int[13];
        sz[0]=115;sz[1]=50;sz[2]=60;sz[3]=150;sz[4]=150;sz[5]=150;sz[6]=70;sz[7]=100;sz[8]=50;sz[9]=50;sz[10]=100;sz[11]=50;sz[12]=70;
      }
      if(TableName.equals("Phone"))
      {
        sz = new int[13];
        sz[0]=115;sz[1]=50;sz[2]=60;sz[3]=100;sz[4]=150;sz[5]=50;sz[6]=100;sz[7]=50;sz[8]=50;sz[9]=100;sz[10]=50;sz[11]=100;sz[12]=70;
      }
      if(TableName.equals("Software"))
      {
        sz = new int[12];
        sz[0]=115;sz[1]=50;sz[2]=60;sz[3]=100;sz[4]=150;sz[5]=50;sz[6]=100;sz[7]=50;sz[8]=50;sz[9]=100;sz[10]=50;sz[11]=70;
      }
      if(TableName.equals("Jobs"))
      {
        sz = new int[8];
        sz[0]=105;sz[1]=60;sz[2]=100;sz[3]=50;sz[4]=50;sz[5]=100;sz[6]=100;sz[7]=150;
      }
      if(TableName.equals("HW_POGR"))
      {
        sz = new int[16];
        sz[0]=115;sz[1]=115;sz[2]=60;sz[3]=100;sz[4]=150;sz[5]=70;sz[6]=70;sz[7]=70;sz[8]=70;sz[9]=50;sz[10]=70;sz[11]=120;sz[12]=60;sz[13]=60;sz[14]=120;sz[15]=150;
      }

      for (int j = 0; j < TotalCol; ++j)
      {
        column = Table.getColumnModel().getColumn(j);
        column.setPreferredWidth(sz[j]);
      }
    }
    catch (SQLException sqle) {
      System.out.println("Set Col Width Error !"+sqle);
      JOptionPane.showMessageDialog(null,
                                    "Error Occured !!!" + "\nError: " + sqle,
                                    "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  private void addRequestItems()
  {
    cboType.addItem("TransactionID");
    cboType.addItem("EmpCode");
    cboType.addItem("Date");
    cboType.addItem("DeptApp");
    cboType.addItem("ISApp");
    cboType.addItem("JobStatus");
  }
  private void addJobItems()
  {
    cboType.addItem("TransactionID");
    cboType.addItem("EmpCode");
    cboType.addItem("Date");
    cboType.addItem("RequestFrom");
    cboType.addItem("Status");
  }
  private void addPOItems()
  {
    cboType.addItem("TransactionID");
    cboType.addItem("OID");
    cboType.addItem("Date");
    cboType.addItem("OfferNo");
  }
  void btnPrevious_actionPerformed(ActionEvent e) {}
  void btnNext_actionPerformed(ActionEvent e) {}
  void btnFirst_actionPerformed(ActionEvent e) {}
  void btnClose_actionPerformed(ActionEvent e) {}
  void btnPrev_actionPerformed(ActionEvent e) {}
  void btnSearch_actionPerformed(ActionEvent e) {}
  void btnDelete_actionPerformed(ActionEvent e) {}
  void btnDeleteAll_actionPerformed(ActionEvent e) {}
  void btnDeleteC_actionPerformed(ActionEvent e) {}
  void btnDeleteS_actionPerformed(ActionEvent e) {}
}