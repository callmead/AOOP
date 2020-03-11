package beximtex;
/**
 * <p>Title: BeximTex, List</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Date;
import java.text.*;
import javax.swing.border.*;

import java.rmi.*;

public class frmList extends JDialog
{//Class

	//**************************************************************
	//RMI Declare Server Object
	CommonTableController ctccon;
	//**************************************************************

	String Head = null;
	String SQL = null;

	JLabel lblHead = new JLabel();
	JPanel pnlMain = new JPanel();

	JTable Table;
	JScrollPane sp = new JScrollPane();

	Vector ColHead = new Vector();
	Vector rows = new Vector();

	int TotalCol = 0;
	int Rows = 0;
	int Columns = 0;

	public String Type[][];
	String SelRow[][];

	JPanel pnlButtons = new JPanel();
	TitledBorder titledBorder1;
	TitledBorder titledBorder2;
	JButton btnClose = new JButton();
	JButton btnSelect = new JButton();
	Border border1;

	public frmList(String s, String q)
	{//Cons
		Head = s;
		SQL = q;
		try {jbInit();}
		catch(Exception e){System.exit(0);}
	}//Cons

	private void jbInit() throws Exception
	{//jbInit

		//**************************************************************
	    //getConnectedion: getConnecteds with Server
		try
		{
			ctccon = (CommonTableController)Naming.lookup(new ReadHost().getHost() + "CommonTableController");

		}catch(Exception ec)
		{
			System.out.println("\n******************************\n       SERVER NOT READY       \n******************************\n");
			System.out.println("Error: "+ec.getMessage());
			JOptionPane.showMessageDialog(null, "SERVER NOT READY!" + "\nError: "+ec.getMessage(),
			"Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		System.out.println("\n******************************\n CLIENT READY [frmList] \n******************************\n");
		//**************************************************************

		titledBorder1 = new TitledBorder("");
		titledBorder2 = new TitledBorder("");
		border1 = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.blue, new Color(187, 218, 252), Color.black, Color.white);
		this.setTitle("");
		this.setResizable(false);
		this.getContentPane().setLayout(null);
		this.setLocation(new Point(150, 100));
		this.setSize(new Dimension(600, 443));
		this.setModal(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		centerForm(this);

		pnlButtons.setLayout(null);
		pnlButtons.setBackground(Color.white);
		pnlButtons.setBorder(titledBorder2);
		pnlButtons.setBounds(new Rectangle(15, 357, 564, 50));

		btnClose.setBorder(BorderFactory.createRaisedBevelBorder());
		btnClose.setMnemonic('L');
		btnClose.setText("Close");
		btnClose.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnClose.setBounds(new Rectangle(289, 11, 238, 27));
		btnClose.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Type=null;
				dispose();
			}
		});

		btnSelect.setBounds(new Rectangle(32, 11, 238, 27));
		btnSelect.setBorder(BorderFactory.createRaisedBevelBorder());
		btnSelect.setMnemonic('S');
		btnSelect.setText("Select");
		btnSelect.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnSelect.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ btnSelect_actionPerformed(e); }
		});

		sp.getViewport().setBackground(Color.white);
		lblHead.setBackground(Color.white);
		this.getContentPane().add(lblHead, null);
		this.getContentPane().add(pnlMain, null);
		this.getContentPane().add(pnlButtons, null);
		this.getContentPane().setBackground(Color.white);

		lblHead.setBounds(new Rectangle(15, 10, 564, 30));
		lblHead.setForeground(Color.black);
		lblHead.setFont(new java.awt.Font("Dialog", 1, 16));
		lblHead.setBorder(border1);
		lblHead.setOpaque(true);
		lblHead.setHorizontalAlignment(SwingConstants.CENTER);

		pnlMain.setBounds(new Rectangle(15, 49, 564, 300));
		pnlMain.setBorder(BorderFactory.createLineBorder(Color.black));
		pnlMain.setLayout(new BorderLayout());
		pnlMain.add(sp, BorderLayout.CENTER);

		pnlButtons.add(btnSelect, null);
		pnlButtons.add(btnClose, null);

		getTableData(SQL);

	}//jbInit

	private boolean CheckData()
	{
		try
		{
			if (ctccon.isFound(SQL))
			{ return true; }
			else {return false;}

		}catch(RemoteException re)
		{System.out.println("Client [frmList]: CHECK DATA Error");System.out.println("Error: "+re.getMessage());return false;}
	}

	void getTableData(String SQL)
	{
		if(CheckData())
		{
			try
			{
				rows = ctccon.getRowData(SQL);
				ColHead = ctccon.getColumnData(SQL);
				TotalCol = ctccon.getColNo(SQL);

			}catch(RemoteException re)
			{
				System.out.println("Client [frmList]: GET TABLE DATA Error");System.out.println("Error: "+re.getMessage());
				JOptionPane.showMessageDialog(null, "GET TABLE DATA Error\nClient [frmList]: "+re.getMessage(),
													"Error", JOptionPane.ERROR_MESSAGE);
			}

		}
		else
		{
			lblHead.setText("NO RECORDS WERE FOUND!");
			return;
		}

		Table = new JTable(rows, ColHead);
		setColWidth(SQL, Table);
		sp.getViewport().add(Table);
		Table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		lblHead.setText(Head);
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
				}
				else if (x.length < 1)
				{}
			}
		});
	}

	void btnSelect_actionPerformed(ActionEvent e)
	{
		int x[] = Table.getSelectedRows();
		if (x.length >= 1)
		{
			Type = new String[x.length][TotalCol];

			for (int i = 0; i < x.length; i++)
			{
				for (int j = 0; j < TotalCol; j++)
				{
					Type[i][j] = Table.getValueAt(x[i], j).toString();
				}
			}
			dispose();
		}
		else if (x.length < 1)
		{
			JOptionPane.showMessageDialog(null, "Please Select One Item!", "Information Required...", JOptionPane.ERROR_MESSAGE);
		}

	}

	String[][] getType()
	{ return Type; }

	public void centerForm(JDialog f)
	{
		int x = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int y = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

		int cx = (x - f.getWidth()) / 2;
		int cy = (y - f.getHeight()) / 2;
		f.setLocation(cx, cy);
	}

	/**
	*	Sets Column Widths of Table
	*	@param String SQL, @param JTable Table
	*
	*/

	void setColWidth(String SQLString, JTable Table)
	{
		TableColumn column = null;
		for (int j = 0; j < TotalCol; ++j)
		{
			column = Table.getColumnModel().getColumn(j);
			column.setPreferredWidth(80);
		}
	}
/*
	void setColWidth(String SQLString)
	{
		DBU db = new DBU();
		ResultSet rs;
		try
		{
			rs = db.stmt.executeQuery(SQLString);
			if (!rs.next())
			{
				return;
			}

			ResultSetMetaData rsmd = rs.getMetaData();
			TotalCol = rsmd.getColumnCount();
			TableColumn column = null;
			int s = 0;

			for (int j = 0; j < TotalCol; ++j)
			{
				s=rsmd.getColumnDisplaySize(j+1);
				column = Table.getColumnModel().getColumn(j);
				column.setPreferredWidth(s+60);
			}
		}
		catch (SQLException sqle)
		{
			System.out.println("frmList.Set Col Width Error !"+sqle);
			JOptionPane.showMessageDialog(null,
			"frmList.SetColWidth Error" + "\nError: " + sqle,
			"Error", JOptionPane.ERROR_MESSAGE);
		}
	}
*/
}//Class