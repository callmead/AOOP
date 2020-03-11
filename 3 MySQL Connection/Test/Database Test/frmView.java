//package beximtex;
/**
 * <p>Title: BeximTex, Data Viewer</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.awt.*;
import java.awt.print.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.util.*;
import java.text.*;
import java.sql.*;
import java.io.PrintStream;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

public class frmView extends JInternalFrame
{//Class
        JLabel lblHead = new JLabel();
        JScrollPane SP = new JScrollPane();

        Vector rowData = new Vector();
        Vector colData = new Vector();

        JTable Table;
        ResultsModel tableModel;

        String strCaption,strSQL,TableName;

        DBU db = new DBU();
        ResultSetMetaData rsmd;
        private boolean DEBUG = false;

        int TotalCol=0;

        int Rows=0;
        int Columns=0;

        JMenuBar mb = new JMenuBar();
        JMenu jMenuPrint = new JMenu();
        JMenuItem jMenuItemSetup = new JMenuItem();
        JMenuItem jMenuItemPrint = new JMenuItem();
        JMenuItem jMenuItemClose = new JMenuItem();

        PageFormat pf;
        int[] sz;

        ImageIcon imgIco = new ImageIcon("./Images/popup.gif");
        ImageIcon imgPrint = new ImageIcon("./Images/printIcon.gif");
        ImageIcon imgClose = new ImageIcon("./Images/close.gif");

       /**
  *  Default Constructor with 3 Parameters
  *
   */
        public frmView(String Caption,String SqlStr,String t)
        {//Cons
                strCaption = Caption;
                strSQL =SqlStr;TableName=t;
                try
                {jbInit();}
                catch(Exception e)
                {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null,"frmView.Error"+"\nError: "+e,"Error",JOptionPane.ERROR_MESSAGE);
                }
        }//Cons

        private void jbInit() throws Exception
        {//jbInit

                Border border1 = BorderFactory.createLineBorder(SystemColor.controlText,1);

                this.setTitle("DATA VIEW");
                this.setSize(new Dimension(700, 400));
                this.getContentPane().setLayout(new BorderLayout());
                this.getContentPane().setBackground(Color.white);
                this.setJMenuBar(mb);
                this.getContentPane().add(SP, BorderLayout.CENTER);
                this.getContentPane().add(lblHead, BorderLayout.NORTH);

                lblHead.setBorder(border1);
                lblHead.setFont(new java.awt.Font("SansSerif", 1, 18));
                lblHead.setHorizontalAlignment(SwingConstants.CENTER);
                lblHead.setText(strCaption);
                lblHead.setPreferredSize(new Dimension(10,50));

                tableModel = new ResultsModel();

                Table = new JTable(tableModel);
                Table.setAutoResizeMode(0);
                Table.setShowHorizontalLines(false);
                Table.setShowVerticalLines(false);
                showData();
                setColumnWidths();
                Table.setFont(new java.awt.Font("Tahoma", 0, 11));

                SP.getViewport().setBackground(Color.white);
                SP.setBorder(null);
                SP.getViewport().add(Table, null);

                jMenuPrint.setMnemonic('P');
                jMenuPrint.setText("Print");

                jMenuItemSetup.setMnemonic('S');
                jMenuItemSetup.setText("Printer Setup");
                jMenuItemSetup.setIcon(imgPrint);
                jMenuItemSetup.addActionListener(new java.awt.event.ActionListener()
                {
                        public void actionPerformed(ActionEvent e)
                        {
                                OnPageSetup();
                        }
                });

                jMenuItemPrint.setMnemonic('R');
                jMenuItemPrint.setText("Print");
                jMenuItemPrint.setIcon(imgPrint);
                jMenuItemPrint.addActionListener(new java.awt.event.ActionListener()
                {
                        public void actionPerformed(ActionEvent e)
                        {
                                OnPrint();
                        }
                });

                jMenuItemClose.setMnemonic('C');
                jMenuItemClose.setText("Close");
                jMenuItemClose.setIcon(imgClose);
                jMenuItemClose.addActionListener(new java.awt.event.ActionListener()
                {
                        public void actionPerformed(ActionEvent e)
                        {
                                dispose();
                        }
                });

                mb.add(jMenuPrint);

                jMenuPrint.add(jMenuItemSetup);
                jMenuPrint.add(jMenuItemPrint);
                jMenuPrint.addSeparator();
                jMenuPrint.add(jMenuItemClose);

                this.setIconifiable(true);
                this.setMaximizable(true);
                this.setClosable(true);
                this.setResizable(true);
                this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                this.setFrameIcon(imgIco);
        }//jbInit


  /**
   * Sets the Column Width of Table
   *
   */
        public void setColumnWidths() {//setColumnWidths
              ResultSet rs;
              try {
                rs = db.stmt.executeQuery(strSQL);
                if (!rs.next()) {
                  return;
                }

                ResultSetMetaData rsmd = rs.getMetaData();
                TotalCol = rsmd.getColumnCount();
                int s = 0;

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
                  sz[0]=115;sz[1]=75;sz[2]=115;sz[3]=70;sz[4]=70;sz[5]=100;sz[6]=100;sz[7]=150;
                }

                for (int j = 0; j < TotalCol; ++j)
                {
                  column = Table.getColumnModel().getColumn(j);
                  column.setPreferredWidth(sz[j]);
                }
              }
              catch (SQLException sqle) {
                System.out.println("frmView.setColumnWidths Error !"+sqle);
                JOptionPane.showMessageDialog(null, "frmView.setColumnWidths Error!" + "\nError: " + sqle, "Error", JOptionPane.ERROR_MESSAGE);
              }
            }//setColumnWidths


  /**
   * Display PageSetup Properties
   *
   */
        public void OnPageSetup()
        {

                Thread t = new Thread(new Runnable()
                {
                        public void run()
                        {
                                PrinterJob pj = PrinterJob.getPrinterJob();
                                if (pf==null) pf = pj.defaultPage();
                                pf = pj.pageDialog(pf);
                        }//End of run Method
                });
                t.start();
        }

  /**
   * Capture Current Screen and send it to the Printer
   *
   */
        public void OnPrint()
        {
                Thread t = new Thread(new Runnable()
                {
                        public void run()
                        {
                                PrinterJob pj = PrinterJob.getPrinterJob();
                                if (pf==null) pf = pj.defaultPage();

                                pj.setPrintable(new reportPrint(),pf);
                                if(pj.printDialog())
                                {
                                        try
                                        {
                                                pj.print();
                                        }
                                        catch(PrinterException pe)
                                        {
                                                JOptionPane.showMessageDialog(null,"Error Occured !!!"+"\nError: "+pe,"Error",JOptionPane.ERROR_MESSAGE);
                                                JOptionPane.showMessageDialog(null,
                                                "Sorry,Printer Not Ready !!!");

                                        }
                                }
                        }
                });
                t.start();
        }

  /**
   * Print Job
   *
   */
        class reportPrint implements Printable
        {
                public int print(Graphics g,PageFormat pfmt,int index)
                {
                        if (index!=0) return NO_SUCH_PAGE;

                        g.translate((int)pfmt.getImageableX(),
                        (int)pfmt.getImageableY());

                        Container c = getContentPane();
                        c.print(g);

                        return PAGE_EXISTS;

                }

        }

 /**
  * Show Data on Table
  *
  */
    public void showData()
    {
        boolean flag = false;
        Object obj = null;
        try
        {
            tableModel.setResultSet(db.stmt.executeQuery(strSQL));
        }
        catch(SQLException sqlexception)
        {
            String s = "Selection event Error\n" + sqlexception.getMessage();
            System.err.println(s);
        }
    }
}

class ResultsModel extends AbstractTableModel
{

    ResultsModel()
    {
        columnNames = new String[0];
    }

    public void setResultSet(ResultSet resultset)
    {
        if(resultset == null)
        {
            columnNames = new String[0];
            dataRows.clear();
            fireTableChanged(null);
            return;
        }
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-mm-dd");
        DecimalFormat decimalformat = new DecimalFormat("000000.00");
        try
        {
            ResultSetMetaData resultsetmetadata = resultset.getMetaData();
            int i = resultsetmetadata.getColumnCount();
            columnNames = new String[i];
            for(int j = 0; j < i; j++)
                columnNames[j] = resultsetmetadata.getColumnLabel(j + 1);

            dataRows = new Vector();
            String as[];
            for(; resultset.next(); dataRows.addElement(as))
            {
                as = new String[i];
                for(int k = 0; k < i; k++)
                {
                    if(resultsetmetadata.getColumnType(k + 1) == 93)
                    {
                        as[k] = simpledateformat.format(resultset.getDate(k + 1));
                        continue;
                    }
                    if(resultsetmetadata.getColumnType(k + 1) == -7)
                    {
                        if(resultset.getBoolean(k + 1))
                            as[k] = "Y";
                        else
                            as[k] = "N";
                        continue;
                    }
                    if(resultsetmetadata.getColumnTypeName(k + 1).equalsIgnoreCase("Integer"))
                    {
                        as[k] = resultset.getString(k + 1);
                        continue;
                    }
                    if(resultsetmetadata.getColumnType(k + 1) == 2)
                        as[k] = decimalformat.format(resultset.getDouble(k + 1));
                    else
                        as[k] = resultset.getString(k + 1);
                }

            }

            fireTableChanged(null);
        }
        catch(SQLException sqlexception)
        {
            System.err.println(sqlexception);
        }
    }

 /**
  * Returns Column Count
  *  @return int value
  */
    public int getColumnCount()
    {
        return columnNames.length;
    }

 /**
  * Returns Row Count
  *  @return int value
  */
    public int getRowCount()
    {
        if(dataRows == null)
            return 0;
        else
            return dataRows.size();
    }

 /**
  * Returns the value at i,j
  *  @param int value
  *  @return String Class Object
  */
    public Object getValueAt(int i, int j)
    {
        return ((String[])dataRows.elementAt(i))[j];
    }

 /**
  * Returns Column Name
  *  @param int value
  *  @return String Array
  */
    public String getColumnName(int i)
    {
        return columnNames[i] != null ? columnNames[i] : "No Name";
    }

    String columnNames[];
    Vector dataRows;
}