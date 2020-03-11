package beximtex;
/**
 * <p>Title: BeximTex, Backup</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.sql.*;
import java.text.*;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.io.File;
import javax.swing.border.*;

public class frmBackup extends JInternalFrame {

  JLabel lblHead = new JLabel();
  JTable BackupTable1 = new JTable();

  boolean isBackup = false;
  boolean isRestore = false;
  String FileName;
  Date d;
  SimpleDateFormat sdf;
  DBU db = new DBU();

  ResultSet rs;
  String Query = new String();
  File theFile;

  ImageIcon imgIE = new ImageIcon("./Images/impExp.jpg");
  ImageIcon imgDB = new ImageIcon("./Images/impExp.png");
  ImageIcon imgDsk = new ImageIcon("./Images/disk.gif");
  ImageIcon imgMySQL = new ImageIcon("./Images/mySql.jpg");
  ImageIcon imgJava = new ImageIcon("./Images/javaLogo.gif");
  ImageIcon imgIco = new ImageIcon("./Images/popup.gif");
  ImageIcon imgImpExp = new ImageIcon("./Images/impExpL.png");

  JLabel lblDisk = new JLabel();
  JLabel lblIco = new JLabel();
  JLabel lblJava = new JLabel();
  JPanel pnlMain = new JPanel();
  TitledBorder titledBorder1;
  JTextField txtBrowseBk = new JTextField();
  JPanel pnlBackup = new JPanel();
  JLabel jLabel110 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JButton btnBackup = new JButton();
  JComboBox CboTableBk = new JComboBox();
  JButton btnBrowseBkup = new JButton();
  JLabel jLabel8 = new JLabel();
  JTextField txtBrowseRst = new JTextField();
  JLabel jLabel111 = new JLabel();
  JComboBox CboTableRst = new JComboBox();
  JButton btnRestore = new JButton();
  JButton btnBrowseRst = new JButton();
  JPanel pnlRestore = new JPanel();
  JLabel lblMySQL = new JLabel();
  public frmBackup() {
    try {
      jbInit();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception {

    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,Color.blue),"");
    lblHead.setIcon(imgIE);
    lblHead.setBounds(new Rectangle(147, 7, 546, 161));
    lblHead.setText("");

    getTables();

    lblIco.setText("");
    lblIco.setBounds(new Rectangle(13, 18, 128, 128));
    lblIco.setIcon(imgImpExp);

    lblDisk.setBounds(new Rectangle(569, 72, 73, 65));
    lblDisk.setIcon(imgDsk);

    lblJava.setText("");
    lblJava.setBounds(new Rectangle(642, 55, 65, 84));
    lblJava.setIcon(imgJava);
    pnlMain.setBackground(Color.white);
    pnlMain.setBorder(titledBorder1);
    pnlMain.setBounds(new Rectangle(8, 165, 687, 305));
    pnlMain.setLayout(null);
    txtBrowseBk.setFont(new Font("Tahoma", 1, 12));
    txtBrowseBk.setCaretColor(Color.blue);
    txtBrowseBk.setText("");
    txtBrowseBk.setBounds(new Rectangle(137, 68, 285, 20));
    pnlBackup.setLayout(null);
    pnlBackup.setBounds(new Rectangle(165, 154, 516, 145));
    pnlBackup.setOpaque(true);
    pnlBackup.setBackground(Color.white);
    pnlBackup.setBorder(BorderFactory.createEtchedBorder());
    jLabel110.setBounds(new Rectangle(18, 40, 86, 16));
    jLabel110.setText("Select Table");
    jLabel110.setFont(new java.awt.Font("Tahoma", 1, 12));
    jLabel7.setFont(new java.awt.Font("Monospaced", 1, 20));
    jLabel7.setText("Export");
    jLabel7.setBounds(new Rectangle(15, 2, 85, 39));
    btnBackup.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(!txtBrowseBk.getText().equals(""))
        {
          setCursor(new Cursor(Cursor.WAIT_CURSOR));
          System.out.println("Export in Progress..." + txtBrowseBk.getText());
          String path = new String(txtBrowseBk.getText());
          StringBuffer sbPath = new StringBuffer(path);
          int index = sbPath.indexOf("\\", 0);
          while (index != -1) {
            sbPath.insert(++index, "\\");
            index = sbPath.indexOf("\\", ++index);
          }
          path = sbPath.toString();
          System.out.println("Path is :" + path);
          String SQLString = new String("SELECT * INTO OUTFILE '" + path +
              "' FIELDS TERMINATED BY ',' LINES TERMINATED BY '\\n' FROM " +
                                        CboTableBk.getSelectedItem() + ";");

          try {
            db.stmt.executeUpdate(SQLString);
          }
          catch (SQLException sqle) {
            System.out.println("*** Error: EXPORT DATA!!!");
            System.out.println("*** Exception: " + sqle);
            JOptionPane.showMessageDialog(null,
                "Error Occured While Taking Backup !!!" +
                "\nError: " + sqle,
                "Information Required...",
                JOptionPane.ERROR_MESSAGE);
            return;
          }

          frmWork w = new frmWork("EXPORTING DATA");
          w.setSize(368, 140);
          w.setVisible(true);

          JOptionPane.showMessageDialog(null,
                                        "DATA OF TABLE " +
                                        CboTableBk.getSelectedItem() +
                                        " EXPORTED SUCESSFULLY!", "Information",
                                        1);
          isBackup = false;
          setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
      }
    });
    btnBackup.setBounds(new Rectangle(16, 103, 491, 25));
    btnBackup.setIcon(new ImageIcon("images/save16.gif"));
    btnBackup.setText("EXPORT DATA");
    btnBackup.setFont(new java.awt.Font("Tahoma", 1, 11));
    btnBackup.setMnemonic('B');
    btnBackup.setBorder(BorderFactory.createRaisedBevelBorder());
    CboTableBk.setBounds(new Rectangle(18, 68, 114, 20));
    CboTableBk.setMaximumRowCount(10);
    CboTableBk.setBackground(Color.white);
    btnBrowseBkup.setBorder(BorderFactory.createRaisedBevelBorder());
    btnBrowseBkup.setText("Browse");
    btnBrowseBkup.setIcon(new ImageIcon("images/open.gif"));
    btnBrowseBkup.setBounds(new Rectangle(427, 66, 79, 22));
    btnBrowseBkup.setFont(new java.awt.Font("Tahoma", 1, 11));
    btnBrowseBkup.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        isBackup = true;
        isRestore = false;
        GenerateFileName();
        openFile();
      }
    });

    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.getContentPane().setBackground(Color.white);
    this.getContentPane().setLayout(null);
    this.setTitle("IMPORT / EXPORT MANAGER");
    this.setMaximum(false);
    this.setFrameIcon(imgIco);
    this.setIconifiable(true);
    this.setClosable(true);

    this.setResizable(false);
    this.setSize(new Dimension(712, 511));
    jLabel8.setFont(new java.awt.Font("Monospaced", 1, 20));
    jLabel8.setText("Import");
    jLabel8.setBounds(new Rectangle(15, 2, 93, 39));
    txtBrowseRst.setFont(new Font("Tahoma", 1, 12));
    txtBrowseRst.setCaretColor(Color.blue);
    txtBrowseRst.setText("");
    txtBrowseRst.setBounds(new Rectangle(136, 67, 288, 20));
    jLabel111.setBounds(new Rectangle(18, 40, 86, 16));
    jLabel111.setText("Select Table");
    jLabel111.setFont(new java.awt.Font("Tahoma", 1, 12));
    CboTableRst.setBounds(new Rectangle(17, 67, 114, 20));
    CboTableRst.setBackground(Color.white);
    CboTableRst.setMaximumRowCount(10);
    btnRestore.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(!txtBrowseRst.getText().equals(""))
        {
          setCursor(new Cursor(Cursor.WAIT_CURSOR));
          System.out.println("Import in Progress..." + txtBrowseRst.getText());
          String path = new String(txtBrowseRst.getText());
          StringBuffer sbPath = new StringBuffer(path);
          int index = sbPath.indexOf("\\", 0);
          while (index != -1) {
            sbPath.insert(++index, "\\");
            index = sbPath.indexOf("\\", ++index);
          }
          path = sbPath.toString();
          System.out.println("Path is :" + path);
          String SQLString = new String("LOAD DATA INFILE '" + path +
                                        "' INTO TABLE " +
                                        CboTableRst.getSelectedItem() +
              " FIELDS TERMINATED BY ',' LINES TERMINATED BY '\\n';");

          try {
            db.stmt.executeUpdate(SQLString);
          }
          catch (SQLException sqle) {
            System.out.println("*** Error: IMPORT DATA!!!");
            System.out.println("*** Exception: " + sqle);
            JOptionPane.showMessageDialog(null,
                "Error Occured While Importing Data !!!" + "\nError: " + sqle,
                "Information Required...",
                JOptionPane.ERROR_MESSAGE);
            return;
          }

          frmWork w = new frmWork("IMPORTING DATA");
          w.setSize(368, 140);
          w.setVisible(true);

          JOptionPane.showMessageDialog(null,
                                        "DATA IMPORTED IN TABLE " +
                                        CboTableRst.getSelectedItem() + " !",
                                        "Information", 1);
          isRestore = false;
          setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
      }
    });
    btnRestore.setBounds(new Rectangle(16, 103, 490, 25));
    btnRestore.setIcon(new ImageIcon("images/save16.gif"));
    btnRestore.setText("IMPORT DATA");
    btnRestore.setFont(new java.awt.Font("Tahoma", 1, 11));
    btnRestore.setMnemonic('B');
    btnRestore.setBorder(BorderFactory.createRaisedBevelBorder());
    btnBrowseRst.setBorder(BorderFactory.createRaisedBevelBorder());
    btnBrowseRst.setText("Browse");
    btnBrowseRst.setIcon(new ImageIcon("images/open.gif"));
    btnBrowseRst.setBounds(new Rectangle(427, 65, 79, 22));
    btnBrowseRst.setFont(new java.awt.Font("Tahoma", 1, 11));
    btnBrowseRst.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        isRestore = true;
        isBackup = false;
        GenerateFileName();
        openFile();
      }
    });
    pnlRestore.setBorder(BorderFactory.createEtchedBorder());
    pnlRestore.setBackground(Color.white);
    pnlRestore.setOpaque(true);
    pnlRestore.setBounds(new Rectangle(165, 6, 516, 145));
    pnlRestore.setLayout(null);
    lblMySQL.setBounds(new Rectangle(0, 0, 161, 303));
    lblMySQL.setIcon(imgMySQL);
    this.getContentPane().add(lblDisk, null);
    this.getContentPane().add(lblJava, null);
    this.getContentPane().add(lblIco, null);
    pnlBackup.add(jLabel7, null);
    pnlBackup.add(jLabel110, null);
    pnlBackup.add(btnBackup, null);
    pnlBackup.add(CboTableBk, null);
    pnlBackup.add(txtBrowseBk, null);
    pnlBackup.add(btnBrowseBkup, null);
    this.getContentPane().add(pnlMain, null);
    pnlRestore.add(jLabel8, null);
    pnlRestore.add(jLabel111, null);
    pnlRestore.add(btnRestore, null);
    pnlRestore.add(btnBrowseRst, null);
    pnlRestore.add(CboTableRst, null);
    pnlRestore.add(txtBrowseRst, null);
    pnlMain.add(pnlBackup, null);
    pnlMain.add(lblMySQL, null);
    pnlMain.add(pnlRestore, null);
    this.getContentPane().add(lblHead, null);

  }

  void openFile() {
    if (isBackup) {
      System.out.println("EXPORT Browse...");
      JFileChooser chooser = new JFileChooser("C:/");
      ExampleFileFilter filter = new ExampleFileFilter();
      filter.addExtension("csv");
      filter.setDescription("Comma Delimited");
      chooser.setFileFilter(filter);
      int returnVal = chooser.showSaveDialog(null);

      if (returnVal == JFileChooser.APPROVE_OPTION)
      {
        theFile = chooser.getSelectedFile();
        if (theFile != null)
        {
            if (theFile.isDirectory())
            {
              JOptionPane.showMessageDialog(null, "You chose this directory: " + theFile.getPath());
            } else
            {
              JOptionPane.showMessageDialog(null, "You chose this file: " + theFile.getPath());
            }
            txtBrowseBk.setText(theFile.getPath()+".csv");
        }
      }
      else if (returnVal == JFileChooser.CANCEL_OPTION)
      {
        JOptionPane.showMessageDialog(null, "User cancelled operation. No file was chosen.");
      }
      else if (returnVal == JFileChooser.ERROR_OPTION) {
        JOptionPane.showMessageDialog(null, "An error occured. No file was chosen.");
      }
      else
      {
        JOptionPane.showMessageDialog(null, "Unknown operation occured.");
      }
    }

    else if (isRestore) {
      System.out.println("IMPORT Brwose...");
      JFileChooser chooser = new JFileChooser("C:/");
      ExampleFileFilter filter = new ExampleFileFilter();
      filter.addExtension("csv");
      filter.setDescription("Comma Delimited");
      chooser.setFileFilter(filter);
      int returnVal = chooser.showOpenDialog(null);
      if (returnVal == JFileChooser.APPROVE_OPTION)
      {
        theFile = chooser.getSelectedFile();
        if (theFile != null)
        {
            if (theFile.isDirectory())
            {
              JOptionPane.showMessageDialog(null, "You chose this directory: " + theFile.getPath());
            } else
            {
              JOptionPane.showMessageDialog(null, "You chose this file: " + theFile.getPath());
            }
            txtBrowseRst.setText(theFile.getPath());
        }
      }
      else if (returnVal == JFileChooser.CANCEL_OPTION)
      {
        JOptionPane.showMessageDialog(null, "User cancelled operation. No file was chosen.");
      }
      else if (returnVal == JFileChooser.ERROR_OPTION) {
        JOptionPane.showMessageDialog(null, "An error occured. No file was chosen.");
      }
      else
      {
        JOptionPane.showMessageDialog(null, "Unknown operation occured.");
      }
    }

  }

  void ExecuteQueryNow() {
    frmWork w = new frmWork("EXECUTING");
    w.setSize(368, 140);
    w.setVisible(true);

    try {db.stmt.executeUpdate(Query);}
    catch (SQLException sqle) {
      System.out.println("*** Error: Executing Command!");
      System.out.println("*** Exception: " + sqle);
      JOptionPane.showMessageDialog(null,"Error Occured While Exexuting Command!\nPlease Contact Your Developer"+"\nError Msg: "+sqle.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
      return;
    }
  }

  private void getTables() {

    Query = "Show Tables;";
    String ComboData = new String("");

    try {
      rs = db.stmt.executeQuery(Query);
      if (!rs.next()) {
        JOptionPane.showMessageDialog(null, "No Records Found !!!");
      }

      ResultSetMetaData rsmd = rs.getMetaData();

      do {
        for (int i = 1; i <= rsmd.getColumnCount(); ++i) {

          ComboData = new String("");
          ComboData = (rs.getString(i));

          CboTableBk.addItem(ComboData);
          CboTableRst.addItem(ComboData);
        }
      }
      while (rs.next());

    }
    catch (SQLException sqle) {
      System.out.println("\nSet Row data Error !\n" + sqle);
      JOptionPane.showMessageDialog(null, "Error in Querry !!!", "Error...",
                                    JOptionPane.ERROR_MESSAGE);
    }
  }

  private void GenerateFileName()
  {
    d = new Date();
    if(isBackup){FileName = new String("BK");}
    if(isRestore){FileName = new String("RS");}
    sdf = new SimpleDateFormat("y");
    FileName = FileName + sdf.format(d);
    sdf = new SimpleDateFormat("M");
    FileName = FileName + sdf.format(d);
    sdf = new SimpleDateFormat("d");
    FileName = FileName + sdf.format(d);
    FileName = FileName + "_" + CboTableBk.getSelectedItem() + ".csv";
    System.out.println("FileName: " + FileName);
  }
  void btnBackup_actionPerformed(ActionEvent e) {}
  void btnBrowseBkup_actionPerformed(ActionEvent e) {}
  void btnRestore_actionPerformed(ActionEvent e) {}
  void btnBrowseRst_actionPerformed(ActionEvent e) {}
}