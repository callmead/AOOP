package beximtex;
/**
 * <p>Title: BeximTex, Jobs</p>
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
import java.text.*;
import java.util.*;
import java.util.Date;

import java.rmi.*;

public class frmJobs extends JInternalFrame
{//Class

	String Head = null;
	String SQL = null;

	JLabel lblHead = new JLabel();
	JPanel pnlTab = new JPanel();

	JScrollPane sp = new JScrollPane();

	Vector ColHead = new Vector();
	Vector rows = new Vector();

	int TotalCol = 0;
	int Rows = 0;
	int Columns = 0;

	String Type[][];
	String SelRow[][];

	JPanel pnlFields = new JPanel();
	TitledBorder titledBorder1;
	TitledBorder titledBorder2;
	Border border1;
	JTextField txtFrom = new JTextField();
	JTextField txtDate = new JTextField();
	JLabel lblFrom = new JLabel();
	JLabel lblDate = new JLabel();
	JTextField txtTID = new JTextField();
	JLabel lblEID = new JLabel();
	JLabel lblDept1 = new JLabel();
	JTextField txtReqID = new JTextField();

	JLabel lblReqID = new JLabel();
	JPanel pnlButtons = new JPanel();
	TitledBorder titledBorder3;
	JToggleButton btnDelete = new JToggleButton();
	JToggleButton btnClose = new JToggleButton();
	JLabel lblRec = new JLabel();
	JToggleButton btnSave = new JToggleButton();
	JToggleButton btnCancel = new JToggleButton();
	JToggleButton btnEdit = new JToggleButton();
	JToggleButton btnNext = new JToggleButton();
	JToggleButton btnPrev = new JToggleButton();
	JToggleButton btnSelect = new JToggleButton();
	JLabel lblJS = new JLabel();

	JRadioButton rdoSFR = new JRadioButton();
	JRadioButton rdoClear = new JRadioButton();
	JRadioButton rdoHold = new JRadioButton();
	JRadioButton rdoUP = new JRadioButton();
	ButtonGroup bg = new ButtonGroup();
	JTextField txtSID = new JTextField();
	JTable Table = new JTable();

	//**************************************************************
	//RMI Declare Server Object
	JobsController jobbcon;
	Jobs jobb = new Jobs();

	CommonTableController ctccon;
	//**************************************************************

	ImageIcon imgFirst = new ImageIcon("./Images/iconFirst.gif");
	ImageIcon imgFO = new ImageIcon("./Images/iconFirstOver.gif");
	ImageIcon imgLast = new ImageIcon("./Images/iconLast.gif");
	ImageIcon imgLO = new ImageIcon("./Images/iconLastOver.gif");
	ImageIcon imgNext = new ImageIcon("./Images/iconNext.gif");
	ImageIcon imgNO = new ImageIcon("./Images/iconNextOver.gif");
	ImageIcon imgPrev = new ImageIcon("./Images/iconPrevious.gif");
	ImageIcon imgPO = new ImageIcon("./Images/iconPreviousOver.gif");
	ImageIcon imgIco = new ImageIcon("./Images/popup.gif");
	ImageIcon imgQ = new ImageIcon("./Images/question32.png");

	int yn;
	boolean isAdd = false;

	String EmpCode = null;
	String TableName = null;
	String tmpStatus = null;
	String CurrentDate = null;
	String TranID = null;
	String JobStatus = null;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date d;
	JTextField txtRemarks = new JTextField();
	int[] sz;

	public frmJobs(String ec, String Label, String query, String tbl)
	{//Cons

		EmpCode = ec;
		Head = Label;
		SQL = query;
		TableName = tbl;

		try {jbInit();}
		catch (Exception e) {System.exit(0);}
	}//Cons

	private void jbInit() throws Exception
	{//jbInit

		//**************************************************************
		//Connection: Connects with Server
		try
		{
			jobbcon = (JobsController)Naming.lookup(new ReadHost().getHost() + "JobsController");
			ctccon = (CommonTableController)Naming.lookup(new ReadHost().getHost() + "CommonTableController");
		}catch(Exception ec)
		{
			System.out.println("\n******************************\n       SERVER NOT READY       \n******************************\n");
			System.out.println("Error: "+ec.getMessage());
			JOptionPane.showMessageDialog(null, "SERVER NOT READY!" + "\nError: "+ec.getMessage(),
			"Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		System.out.println("\n******************************\n CLIENT READY [frmJobs] \n******************************\n");
		//**************************************************************

		titledBorder1 = new TitledBorder("");
		titledBorder2 = new TitledBorder("");
		border1 = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.blue, new Color(187, 218, 252), Color.black, Color.white);
		titledBorder3 = new TitledBorder("");
		this.getContentPane().setLayout(null);

		pnlTab.setBounds(new Rectangle(9, 44, 671, 200));
		pnlTab.setBorder(BorderFactory.createLineBorder(Color.black));
		pnlTab.setLayout(new BorderLayout());

		pnlFields.setLayout(null);
		pnlFields.setBackground(Color.white);
		pnlFields.setBorder(titledBorder2);
		pnlFields.setBounds(new Rectangle(9, 251, 671, 131));

		pnlTab.add(sp, BorderLayout.CENTER);
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

		txtFrom.setText("");
		txtFrom.setBounds(new Rectangle(301, 12, 169, 23));
		txtFrom.setEnabled(false);
		txtFrom.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtDate.setBounds(new Rectangle(523, 12, 140, 23));
		txtDate.setEnabled(false);
		txtDate.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtDate.setText("");
		lblFrom.setText("FROM");
		lblFrom.setBounds(new Rectangle(259, 11, 42, 24));
		lblFrom.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblDate.setBounds(new Rectangle(474, 11, 41, 24));
		lblDate.setText("DATE");
		lblDate.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTID.setEnabled(false);
		txtTID.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtTID.setBounds(new Rectangle(105, 41, 140, 23));
		txtTID.setText("");
		lblEID.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblEID.setBounds(new Rectangle(10, 40, 100, 24));
		lblEID.setText("TRANSACTION #");

		lblDept1.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblDept1.setText("REMARKS");
		lblDept1.setBounds(new Rectangle(10, 97, 106, 24));
		txtReqID.setText("");
		txtReqID.setBounds(new Rectangle(105, 12, 140, 23));
		txtReqID.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtReqID.setEnabled(false);
		lblReqID.setText("Request ID");
		lblReqID.setBounds(new Rectangle(10, 11, 76, 24));
		lblReqID.setFont(new java.awt.Font("Tahoma", 1, 11));
		pnlButtons.setBackground(Color.white);
		pnlButtons.setBorder(titledBorder3);
		pnlButtons.setMaximumSize(new Dimension(32767, 32767));
		pnlButtons.setBounds(new Rectangle(9, 388, 671, 50));
		pnlButtons.setLayout(null);
		btnDelete.setBounds(new Rectangle(411, 10, 91, 28));
		btnDelete.setText("DELETE");
		btnDelete.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnDelete.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (txtTID.getText().equals(""))
				{ return; }
				btnDelete_actionPerformed(e);
			}
		});
		btnClose.setText("CLOSE");
		btnClose.setBounds(new Rectangle(508, 10, 91, 28));
		btnClose.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnClose.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent x2)
			{ dispose(); }
		});
		lblRec.setBounds(new Rectangle(284, 13, 89, 24));
		lblRec.setText("");
		lblRec.setHorizontalAlignment(SwingConstants.LEFT);
		lblRec.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblRec.setBorder(null);
		btnSave.setText("SAVE");
		btnSave.setBounds(new Rectangle(62, 11, 91, 28));
		btnSave.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnSave.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (txtRemarks.getText().equals(""))
				{ txtRemarks.setText("-"); }

				if (isAdd)
				{
					if (save()==false)
					{
						JOptionPane.showMessageDialog(null,	"UNABLE TO INSERT NEW RECORD !!!\nPlease try with valid Data ...",
															"Error", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						//BUTTON STATE...
						SetInitialButtons(true);
						//FIELD STATE...
						SetTextFields(false);
					}
				}
				else
				{
					if (editData()==false)
					{
						JOptionPane.showMessageDialog(null,	"UNABLE TO UPDATE RECORD !!!\nPlease try with valid Data ...",
															"Error", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						//BUTTON STATE...
						SetInitialButtons(true);
						//FIELD STATE...
						SetTextFields(false);
					}
				}
				//SET FLAG...
				isAdd=false;
				lblRec.setText("");
			}
		});
		btnCancel.setText("CANCEL");
		btnCancel.setBounds(new Rectangle(158, 11, 91, 28));
		btnCancel.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnCancel.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				SetInitialButtons(true);
				SetTextFields(false);
				getConnected();
				isAdd = false;
				lblRec.setText("");
			}
		});
		btnEdit.setText("EDIT");
		btnEdit.setBounds(new Rectangle(158, 11, 91, 28));
		btnEdit.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnEdit.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				SetInitialButtons(false);
				SetTextFields(true);
				rdoUP.requestFocus();
				lblJS.setText("JOB STATUS ");
				lblRec.setText(" Edit Record. ");
			}
		});
		btnNext.setText("");
		btnNext.setIcon(imgNext);
		btnNext.setBounds(new Rectangle(376, 13, 22, 23));
		btnNext.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnNext.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{ btnNext.setIcon(imgNO); }

			public void mouseExited(MouseEvent f)
			{ btnNext.setIcon(imgNext); }
		});
		btnNext.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					jobb=jobbcon.moveNext();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmJobs]: MOVE NEXT Error");System.out.println("Error: "+re.getMessage());}
			}
		});

		btnPrev.setBounds(new Rectangle(261, 13, 22, 23));
		btnPrev.setText("");
		btnPrev.setIcon(imgPrev);
		btnPrev.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnPrev.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{ btnPrev.setIcon(imgPO); }
			public void mouseExited(MouseEvent f)
			{ btnPrev.setIcon(imgPrev); }
		});
		btnPrev.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					jobb=jobbcon.moveNext();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmJobs]: MOVE NEXT Error");System.out.println("Error: "+re.getMessage());}
			}
		});
		btnSelect.setBounds(new Rectangle(62, 11, 91, 28));
		btnSelect.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				btnSelect_actionPerformed(e);
			}
		});
		btnSelect.setText("SELECT");
		btnSelect.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblJS.setBounds(new Rectangle(10, 69, 237, 24));
		lblJS.setText("JOB STATUS");
		lblJS.setFont(new java.awt.Font("Tahoma", 1, 11));
		rdoSFR.setBackground(Color.white);
		rdoSFR.setForeground(Color.black);
		rdoSFR.setFont(new java.awt.Font("Tahoma", 1, 11));
		rdoSFR.setBounds(new Rectangle(310, 69, 127, 24));
		rdoSFR.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				rdoSFR_actionPerformed(e);
			}
		});
		rdoSFR.setText("SENT FOR REPAIR");
		rdoClear.setBackground(Color.white);
		rdoClear.setForeground(Color.black);
		rdoClear.setFont(new java.awt.Font("Tahoma", 1, 11));
		rdoClear.setBounds(new Rectangle(433, 69, 83, 24));
		rdoClear.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				rdoClear_actionPerformed(e);
			}
		});
		rdoClear.setText("CLEARED");
		rdoHold.setBackground(Color.white);
		rdoHold.setForeground(Color.black);
		rdoHold.setText("HOLD");
		rdoHold.setBounds(new Rectangle(237, 69, 64, 24));
		rdoHold.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				rdoHold_actionPerformed(e);
			}
		});
		rdoHold.setFont(new java.awt.Font("Tahoma", 1, 11));
		rdoUP.setBackground(Color.white);
		rdoUP.setForeground(Color.black);
		rdoUP.setText("UNDER PROGRESS");
		rdoUP.setBounds(new Rectangle(101, 69, 133, 24));
		rdoUP.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				rdoUP_actionPerformed(e);
			}
		});
		rdoUP.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtSID.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtSID.setEnabled(false);
		txtSID.setText("");
		txtSID.setBounds(new Rectangle(523, 70, 140, 23));

		txtRemarks.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtRemarks.setBounds(new Rectangle(105, 98, 557, 23));
		txtRemarks.setText("");
		bg.add(rdoClear);
		bg.add(rdoHold);
		bg.add(rdoSFR);
		bg.add(rdoUP);
		pnlFields.add(txtReqID, null);
		pnlFields.add(lblReqID, null);
		pnlFields.add(lblEID, null);
		pnlFields.add(txtTID, null);
		pnlFields.add(txtDate, null);
		pnlFields.add(lblDate, null);
		pnlFields.add(txtFrom, null);
		pnlFields.add(lblFrom, null);
		pnlFields.add(lblDept1, null);
		pnlFields.add(lblJS, null);
		pnlFields.add(rdoUP, null);
		pnlFields.add(rdoHold, null);
		pnlFields.add(rdoSFR, null);
		pnlFields.add(rdoClear, null);
		pnlFields.add(txtSID, null);
		pnlFields.add(txtRemarks, null);
		this.getContentPane().add(pnlButtons, null);
		pnlButtons.add(btnClose, null);
		pnlButtons.add(btnDelete, null);
		pnlButtons.add(btnNext, null);
		pnlButtons.add(lblRec, null);
		pnlButtons.add(btnPrev, null);
		pnlButtons.add(btnEdit, null);
		pnlButtons.add(btnSelect, null);
		pnlButtons.add(btnSave, null);
		pnlButtons.add(btnCancel, null);
		this.getContentPane().add(pnlTab, null);
		this.getContentPane().add(lblHead, null);
		this.getContentPane().add(pnlFields, null);

		SetTextFields(false);
		SetInitialButtons(true);
		txtSID.setVisible(false);

		this.setTitle("JOB QUEUE");
		this.setSize(new Dimension(700, 480));
		this.setResizable(false);
		this.setClosable(true);
		this.setIconifiable(true);
		this.setMaximizable(false);
		this.setFrameIcon(imgIco);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getConnected();

	}//jbInit

	/**
	*	Setting Text Fields
	*	@param boolean true or false value
	*
	*/

	void SetTextFields(boolean txtValue)
	{
		txtRemarks.setEnabled(txtValue);
		rdoUP.setVisible(txtValue);
		rdoHold.setVisible(txtValue);
		rdoSFR.setVisible(txtValue);
		rdoClear.setVisible(txtValue);
	}

	/**
	*	Setting Button States
	*	@param boolean true or false value
	*
	*/

	void SetInitialButtons(boolean bVal)
	{
		btnSelect.setVisible(bVal);
		btnEdit.setVisible(bVal);
		btnSave.setVisible(!bVal);
		btnCancel.setVisible(!bVal);
		btnDelete.setEnabled(bVal);
		btnClose.setEnabled(bVal);
		btnPrev.setEnabled(bVal);
		btnNext.setEnabled(bVal);
	}

	/**
	*	Connects Table
	*
	*/

	public void getConnected()
	{
		//CONNECT TABLE
		try
		{
			jobbcon.Connect(EmpCode);
		}catch(RemoteException re){ System.out.println("Client [frmJobs]: Open Error");System.out.println("Error: "+re.getMessage());}

		//DISPLAY DATA RMI
		try
		{
			jobb=jobbcon.moveNext();
			display();
		}catch(RemoteException re){ System.out.println("Client [frmJobs]: Show Error");System.out.println("Error: "+re.getMessage());}

		getTableData(SQL);
	}

	/**
	*	Display Data
	*
	*/

	public void display()
	{
		clearFields();

		txtTID.setText(jobb.getTransactionID());
		txtDate.setText(jobb.getDate());
		txtReqID.setText(jobb.getRequestID());
		txtFrom.setText(jobb.getReqFrom());
		tmpStatus =	jobb.getStatus();
		lblJS.setText("JOB STATUS          " + tmpStatus);
		txtSID.setText(jobb.getSID());
		txtRemarks.setText(jobb.getRemarks());

		//lblRec.setText(" REC # " + rsP.getRow());
	}//Display

	/**
	*	Clears TextFields
	*
	*/

	public void clearFields()
	{
		txtTID.setText("");
		txtReqID.setText("");
		txtDate.setText("");
		txtFrom.setText("");
		lblRec.setText("");
		txtRemarks.setText("");
	}

	/**
	*	Requests Server to Add New Record
	*
	*/

	public boolean save()
	{//Save
		boolean savesucc=false;

		//INITIALISE USER OBJECT...
		jobb.setTransactionID(txtTID.getText());
		jobb.setDate(txtDate.getText());
		jobb.setRequestID(txtReqID.getText());
		jobb.setReqFrom(txtFrom.getText());
		jobb.setEmpCode(EmpCode);
		jobb.setStatus(JobStatus);
		jobb.setSID(txtSID.getText());
		jobb.setRemarks(txtRemarks.getText());

		try
		{
			savesucc = jobbcon.insertData(jobb);
			StartWorking("ADDING NEW RECORD");
			JOptionPane.showMessageDialog(null, "Server: Record Added!", "Information", 1);
			lblRec.setText("");
			UpdateRequestData();
			getConnected();

		}catch(RemoteException re)
		{
			System.out.println("Client [frmJobs]: SAVE DATA Error");System.out.println("Error: "+re.getMessage());
			JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmJobs]: "+re.getMessage(),
			"Error", JOptionPane.ERROR_MESSAGE);
			return savesucc;
		}

		return savesucc;
	}//Save

	/**
	*	Requests Server to Update a Specific Record
	*
	*/

	public boolean editData()
	{//Edit Data
		boolean updatesucc=false;

		//INITIALISE USER OBJECT...
		jobb.setStatus(JobStatus);
		jobb.setRemarks(txtRemarks.getText());

		try
		{
			updatesucc = jobbcon.updateData(jobb);
			StartWorking("UPDATING RECORD");
			JOptionPane.showMessageDialog(null, "Server: Record Updated!", "Information", 1);
			lblRec.setText("");
			UpdateRequestData();
			getConnected();

		}catch(RemoteException re)
		{
			System.out.println("Client [frmJobs]: UPDATE DATA Error");System.out.println("Error: "+re.getMessage());
			JOptionPane.showMessageDialog(null, "UPDATE DATA Error\nClient [frmJobs]: "+re.getMessage(),
												"Error", JOptionPane.ERROR_MESSAGE);
			return updatesucc;
		}

		return updatesucc;
	}//Edit Data

	/**
	*	Requests Server to Delete a Specific Record
	*
	*/

	public void DeleteData()
	{//Delete Data
		String strQuery = "DELETE FROM Jobs WHERE TransactionID='" + txtTID.getText() + "';";

		yn = JOptionPane.showConfirmDialog(null, "Are you sure you want to DELETE this record ?", "Conformation...",
		JOptionPane.YES_NO_OPTION, 3, imgQ);

		if (yn == JOptionPane.YES_OPTION)
		{
			try
			{
				jobbcon.DeleteData(strQuery);
				StartWorking("DELETING RECORD");
				JOptionPane.showMessageDialog(null, "Server: Record Deleted!", "Information", 1);
				clearFields();
				UpdateRequestData();
				getConnected();

			}catch(RemoteException re)
			{
				System.out.println("Client [frmJobs]: DELETE DATA Error");System.out.println("Error: "+re.getMessage());
				JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmJobs]: "+re.getMessage(),
													"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else {}
	}//Delete Data

	/**
	*	Requests Server to Update Request Data
	*
	*/

	public void UpdateRequestData()
	{//Delete Data

		String strQuery = "UPDATE " + TableName + " SET " + "JobStatus='" + JobStatus + "' WHERE TransactionID='" + txtReqID.getText() + "';";

		try
		{
			jobbcon.UpdateReqTable(strQuery);

		}catch(RemoteException re)
		{
			System.out.println("Client [frmJobs]: DELETE DATA Error");System.out.println("Error: "+re.getMessage());
			JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmJobs]: "+re.getMessage(),
												"Error", JOptionPane.ERROR_MESSAGE);
		}

	}//Delete Data

	/**
	*	Gets Table Data
	*	@param String SQL
	*
	*/

	void getTableData(String SQLString)
	{
		System.out.println("\nProcessing "+TableName);
		try
		{
			rows = ctccon.getRowData(SQLString);
			ColHead = ctccon.getColumnData(SQLString);
			TotalCol = ctccon.getColNo(SQLString);

		}catch(RemoteException re)
		{
			System.out.println("Client [frmJobs]: GET TABLE DATA Error");System.out.println("Error: "+re.getMessage());
			JOptionPane.showMessageDialog(null, "GET TABLE DATA Error\nClient [frmJobs]: "+re.getMessage(),
												"Error", JOptionPane.ERROR_MESSAGE);
		}

		Table = new JTable(rows, ColHead);

		setColWidth(Table);
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

					for (int i = 0; i < x.length; i++)
					{
						for (int j = 0; j < TotalCol; j++)
						{
							SelRow[i][j] = Table.getValueAt(x[i], j).toString();
						}
					}

					System.out.println("SELECTED ROW: "+SelRow[0][0]+" * "+SelRow[0][1]+" * "+SelRow[0][2]+" * "+SelRow[0][3]+" * "+SelRow[0][4]+" * "+SelRow[0][5]);
				}
				else if (x.length < 1)
				{
					JOptionPane.showMessageDialog(null, "Please Select One Item!", "Information Required...", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	*	Sets Column Widths of Table
	*	@param String SQL, @param JTable Table
	*
	*/

	void setColWidth(JTable Table)
	{
		TableColumn column = null;
		if(TableName.equals("Email"))
		{
			sz = new int[9];
			sz[0]=115;sz[1]=50;sz[2]=60;sz[3]=150;sz[4]=150;sz[5]=150;sz[6]=70;sz[7]=150;sz[8]=150;

			for (int j = 0; j <= 8; ++j)
			{
				column = Table.getColumnModel().getColumn(j);
				column.setPreferredWidth(sz[j]);
			}
		}
		if(TableName.equals("Mobile"))
		{
			sz = new int[8];
			sz[0]=115;sz[1]=50;sz[2]=60;sz[3]=70;sz[4]=50;sz[5]=50;sz[6]=150;sz[7]=150;

			for (int j = 0; j <=7 ; ++j)
			{
				column = Table.getColumnModel().getColumn(j);
				column.setPreferredWidth(sz[j]);
			}
		}
		if(TableName.equals("Hardware"))
		{
			sz = new int[7];
			sz[0]=115;sz[1]=50;sz[2]=60;sz[3]=150;sz[4]=150;sz[5]=150;sz[6]=150;
		}
		if(TableName.equals("Phone"))
		{
			sz = new int[6];
			sz[0]=115;sz[1]=50;sz[2]=60;sz[3]=100;sz[4]=150;sz[5]=150;
		}
		if(TableName.equals("Software"))
		{
			sz = new int[7];
			sz[0]=115;sz[1]=50;sz[2]=60;sz[3]=100;sz[4]=150;sz[5]=150;sz[6]=150;
		}

		for (int j = 0; j < TotalCol; ++j)
		{
			column = Table.getColumnModel().getColumn(j);
			column.setPreferredWidth(sz[j]);
		}
	}

	void btnDelete_actionPerformed(ActionEvent e)
	{
		if (txtTID.getText().equals(""))
		{ return; }
		DeleteData();
	}

	void rdoSFR_actionPerformed(ActionEvent e)
	{
		txtSID.setVisible(true);
		JobStatus = "Sent For Repair";
		frmList lst = new frmList("PLEASE SELECT A SUPPLIER",
		"SELECT * FROM Suppliers ORDER BY SID;");
		lst.setVisible(true);
		String t[][] = lst.getType();
		txtSID.setText(t[0][0]);
	}

	void rdoClear_actionPerformed(ActionEvent e)
	{
		txtSID.setText("-");
		txtSID.setVisible(false);
		JobStatus = "Cleared";
	}

	void rdoHold_actionPerformed(ActionEvent e)
	{
		txtSID.setText("-");
		txtSID.setVisible(false);
		JobStatus = "Hold";
	}

	void rdoUP_actionPerformed(ActionEvent e)
	{
		txtSID.setText("-");
		txtSID.setVisible(false);
		JobStatus = "Under Progress";
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

			clearFields();
			txtReqID.setText(Type[0][0]);
			txtFrom.setText(Type[0][1]);
			rdoUP.setSelected(true);
			JobStatus = "Under Progress";
			d = new Date();
			CurrentDate = null;
			TranID = new String("J");
			sdf = new SimpleDateFormat("y");
			TranID = TranID + sdf.format(d);
			sdf = new SimpleDateFormat("M");
			TranID = TranID + sdf.format(d);
			sdf = new SimpleDateFormat("d");
			TranID = TranID + sdf.format(d);
			TranID = TranID + EmpCode;
			sdf = new SimpleDateFormat("Hms");
			TranID = TranID + sdf.format(d);
			System.out.println("Transaction ID: " + TranID);

			txtTID.setText(TranID);

			d = new Date();
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			CurrentDate = sdf.format(d);
			txtDate.setText(CurrentDate);

			isAdd = true;
			SetInitialButtons(false);
			SetTextFields(true);
			rdoUP.requestFocus();
			lblJS.setText("JOB STATUS ");
		}
		else if (x.length < 1)
		{
			JOptionPane.showMessageDialog(null, "Please select a request first!",
			"Information Required...",
			JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	*	Progress Bar
	*
	*/

	private void StartWorking(String t)
	{
		frmWork w = new frmWork(t);
		w.setSize(368, 140);
		w.setVisible(true);
	}

}//Class