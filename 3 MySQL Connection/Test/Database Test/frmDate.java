//package beximtex;
/**
 * <p>Title: BeximTex, Date Selector</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.Date;
import java.math.*;

import java.text.DecimalFormat;

public class frmDate
    extends JDialog {

  JPanel pnlMain = new JPanel();

  TitledBorder titledBorder1;
  TitledBorder titledBorder2;

  JLabel lblY = new JLabel();
  int febVal = 0;

  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
  DecimalFormat df = new DecimalFormat();
  Date d;

  String passWord = null;
  String tmp = null;
  public String SelectedDate;

  JLabel lblTop = new JLabel();
  JComboBox cboYear = new JComboBox();
  JComboBox cboMonth = new JComboBox();
  JLabel lblMonth = new JLabel();
  JLabel lblDay = new JLabel();
  JComboBox cboDay = new JComboBox();
  JButton btnOK = new JButton();

  public frmDate(String t) {
    tmp = t;
    try {jbInit();pack();}
    catch (Exception ex) {
      ex.printStackTrace();
      JOptionPane.showMessageDialog(null,
                                    "Error Occured !!!" + "\nError: " + ex,
                                    "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  private void jbInit() throws Exception {
    this.setTitle("LOCKED");
    lblTop.setBounds(new Rectangle(6, 5, 167, 16));
    lblTop.setText("DATE SELECTOR");
    lblTop.setFont(new java.awt.Font("Tahoma", 1, 12));
    lblTop.setVerifyInputWhenFocusTarget(true);
    cboYear.setBounds(new Rectangle(7, 50, 61, 24));
    cboYear.setMaximumRowCount(10);
    cboYear.setBackground(Color.white);
    cboYear.setFont(new java.awt.Font("Tahoma", 1, 12));
    cboMonth.setBounds(new Rectangle(74, 50, 52, 24));
    cboMonth.setBackground(Color.white);
    cboMonth.setFont(new java.awt.Font("Tahoma", 1, 12));

    lblMonth.setFont(new java.awt.Font("Tahoma", 1, 12));
    cboMonth.setMaximumRowCount(10);
    lblMonth.setText("MONTH");
    lblMonth.setBounds(new Rectangle(74, 32, 52, 16));
    lblDay.setBounds(new Rectangle(131, 32, 52, 16));
    lblDay.setText("DAY");
    cboDay.setFont(new java.awt.Font("Tahoma", 1, 12));
    cboDay.setMaximumRowCount(10);
    cboDay.setBackground(Color.white);
    lblDay.setFont(new java.awt.Font("Tahoma", 1, 12));
    cboDay.setBounds(new Rectangle(131, 50, 52, 24));
    btnOK.setBounds(new Rectangle(7, 80, 174, 24));
    btnOK.setMnemonic('O');
    btnOK.setFont(new java.awt.Font("Tahoma", 1, 12));
    btnOK.setText("OK");
    btnOK.addActionListener(new frmDate_btnOK_actionAdapter(this));
    pnlMain.add(lblTop, null);
    pnlMain.add(cboYear, null);
    this.getContentPane().add(pnlMain, null);
    pnlMain.add(lblY, null);
    pnlMain.add(btnOK, null);
    pnlMain.add(lblDay, null);
    pnlMain.add(cboDay, null);
    pnlMain.add(cboMonth, null);
    pnlMain.add(lblMonth, null);//jbInit

    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");

    pnlMain.setBackground(Color.white);
    pnlMain.setBorder(titledBorder2);
    pnlMain.setBounds(new Rectangle(7, 7, 190, 114));
    pnlMain.setLayout(null);
    lblY.setBounds(new Rectangle(7, 32, 52, 16));
    lblY.setText("YEAR");
    lblY.setFont(new java.awt.Font("Tahoma", 1, 12));//End KeyListener

    addComboItems();
    cboYear.addItemListener(new ItemListener(){
      public void itemStateChanged(ItemEvent e){
        addDays();
      }
    });
    cboMonth.addItemListener(new ItemListener(){
      public void itemStateChanged(ItemEvent e){
        addDays();
      }
    });
    addDays();

    this.getContentPane().setBackground(Color.white);
    this.getContentPane().setLayout(null);
    this.setModal(true);
    this.setTitle(tmp);
    this.setResizable(false);
    this.setSize(new Dimension(212, 133));
    this.setDefaultCloseOperation(0);
    centerForm(this);

    d = new Date();
    sdf = new SimpleDateFormat("yyyy");
    cboYear.setSelectedItem(sdf.format(d));
    sdf = new SimpleDateFormat("M");
    cboMonth.setSelectedItem(sdf.format(d));
    sdf = new SimpleDateFormat("d");
    cboDay.setSelectedItem(sdf.format(d));
  }

  public void centerForm(JDialog f) {
    int x = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    int y = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    int cx = (x - f.getWidth()) / 2;
    int cy = (y - f.getHeight()) / 2;
    f.setLocation(cx, cy);
  }

  private void addComboItems()
  {
    df.applyPattern("00");
    for (int i=1990;i<=2020;i++)
    {
      cboYear.addItem(String.valueOf(i));
    }
    for (int i=1;i<=12;i++)
    {
      cboMonth.addItem(String.valueOf(df.format(i)));
    }
  }

  private void addDays()
  {
    cboDay.removeAllItems();
    df.applyPattern("00");
    String tmp = cboYear.getSelectedItem().toString();
    int y = Integer.parseInt(tmp);
    febVal=31;

    if(cboMonth.getSelectedItem().equals("01")){febVal=31;}
    if(cboMonth.getSelectedItem().equals("02"))
    {
      if(y % 4 !=0){febVal=28;}
      else if(y % 400 !=0){febVal=29;}
      else if(y % 100 !=0){febVal=28;}
      else{febVal=29;}
    }
    if(cboMonth.getSelectedItem().equals("03")){febVal=31;}
    if(cboMonth.getSelectedItem().equals("04")){febVal=30;}
    if(cboMonth.getSelectedItem().equals("05")){febVal=31;}
    if(cboMonth.getSelectedItem().equals("06")){febVal=30;}
    if(cboMonth.getSelectedItem().equals("07")){febVal=31;}
    if(cboMonth.getSelectedItem().equals("08")){febVal=31;}
    if(cboMonth.getSelectedItem().equals("09")){febVal=30;}
    if(cboMonth.getSelectedItem().equals("10")){febVal=31;}
    if(cboMonth.getSelectedItem().equals("11")){febVal=30;}
    if(cboMonth.getSelectedItem().equals("12")){febVal=31;}
    for (int i=1;i<=febVal;i++)
    {
      cboDay.addItem(String.valueOf(df.format(i)));
    }
  }

  String createDate()
  {
    String SelectedDate = (String)cboYear.getSelectedItem()+"-"+
        (String)cboMonth.getSelectedItem()+"-"+
        (String)cboDay.getSelectedItem();
    return SelectedDate;
  }

  void btnOK_actionPerformed(ActionEvent e) {
    createDate();
    dispose();
  }
}

class frmDate_btnOK_actionAdapter implements java.awt.event.ActionListener {
  frmDate adaptee;

  frmDate_btnOK_actionAdapter(frmDate adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnOK_actionPerformed(e);
  }
}