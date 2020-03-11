package beximtex;
/**
 * <p>Title: BeximTex, Software Request</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import java.text.*;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import java.rmi.*;

public class frmSoftware extends JInternalFrame
{//Class

	JPanel pnlTop = new JPanel();
	JPanel pnlMid = new JPanel();
	JPanel pnlButtons = new JPanel();

	TitledBorder titledBorder1;
	TitledBorder titledBorder2;
	TitledBorder titledBorder3;

	JLabel lblEmpCode = new JLabel();
	JLabel lblEID = new JLabel();
	JLabel lblName = new JLabel();
	JLabel lblDate = new JLabel();
	JLabel lblRT = new JLabel();
	JLabel lblDesc = new JLabel();
	JLabel lblRec = new JLabel();

	JTextField txtEmpCode = new JTextField();
	JTextField txtSID = new JTextField();
	JTextField txtName = new JTextField();
	JTextField txtDate = new JTextField();

	JTextArea txtDesc = new JTextArea();
	JScrollPane SPtxtDesc = new JScrollPane();

	JToggleButton btnSave = new JToggleButton();
	JToggleButton btnDelete = new JToggleButton();
	JToggleButton btnEdit = new JToggleButton();
	JToggleButton btnPrev = new JToggleButton();
	JToggleButton btnNext = new JToggleButton();
	JToggleButton btnNew = new JToggleButton();
	JToggleButton btnCancel = new JToggleButton();

	JRadioButton rdoNewReport = new JRadioButton();
	JRadioButton rdoRM = new JRadioButton();
	JRadioButton rdoTIM = new JRadioButton();
	JRadioButton rdoIFM = new JRadioButton();
	JRadioButton rdoOther = new JRadioButton();
	ButtonGroup bgRT = new ButtonGroup();

	//**************************************************************
	//RMI Declare Server Object
	SoftwareController sftcon;
	Software sft = new Software();
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

	String RequestType = null;
	String EmpCode = null;
	String userName = null;

	String CurrentDate = null;
	String TranID = null;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date d;

	int yn;
	boolean isAdd = false;
	boolean fieldsOK = false;
	JToggleButton btnClose = new JToggleButton();

	public frmSoftware(String ec, String un)
	{//Cons
		EmpCode = ec;
		userName = un;

		try {jbInit();}
		catch (Exception e) {System.exit(0);}
	}//Cons

	private void jbInit() throws Exception
	{//jbInit

		//**************************************************************
		//Connection: Connects with Server
		try
		{
			sftcon = (SoftwareController)Naming.lookup(new ReadHost().getHost() + "SoftwareController");
		}catch(Exception ec)
		{
			System.out.println("\n******************************\n       SERVER NOT READY       \n******************************\n");
			System.out.println("Error: "+ec.getMessage());
			JOptionPane.showMessageDialog(null, "SERVER NOT READY!" + "\nError: "+ec.getMessage(),
			"Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		System.out.println("\n******************************\n CLIENT READY [frmSoftware] \n******************************\n");
		//**************************************************************

		titledBorder1 = new TitledBorder("");
		titledBorder2 = new TitledBorder("");
		titledBorder3 = new TitledBorder("");

		pnlTop.setBackground(Color.white);
		pnlTop.setForeground(Color.white);
		pnlTop.setBorder(titledBorder1);
		pnlTop.setBounds(new Rectangle(8, 8, 550, 70));
		pnlTop.setLayout(null);

		pnlMid.setBackground(Color.white);
		pnlMid.setForeground(Color.white);
		pnlMid.setBorder(titledBorder2);
		pnlMid.setBounds(new Rectangle(8, 83, 550, 137));
		pnlMid.setLayout(null);

		pnlButtons.setBackground(Color.white);
		pnlButtons.setForeground(Color.white);
		pnlButtons.setBorder(titledBorder3);
		pnlButtons.setBounds(new Rectangle(8, 226, 550, 44));
		pnlButtons.setLayout(null);

		lblEmpCode.setBounds(new Rectangle(284, 36, 106, 24));
		lblEmpCode.setText("EMPLOYEE CODE");
		lblEmpCode.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblEmpCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEID.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblEID.setBounds(new Rectangle(9, 9, 131, 24));
		lblEID.setText("TRANSACTION #");
		lblName.setText("NAME");
		lblName.setBounds(new Rectangle(9, 36, 131, 24));
		lblName.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblDate.setBounds(new Rectangle(284, 9, 106, 24));
		lblDate.setText("DATE");
		lblDate.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRT.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblRT.setText("REQUEST TYPE");
		lblRT.setBounds(new Rectangle(10, 9, 241, 24));
		lblDesc.setBounds(new Rectangle(10, 39, 366, 24));
		lblDesc.setText("DESCRIPTION [OF THE REQUIREMENT]");
		lblDesc.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblRec.setBounds(new Rectangle(228, 10, 89, 24));
		lblRec.setText("");
		lblRec.setHorizontalAlignment(SwingConstants.LEFT);
		lblRec.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblRec.setBorder(null);

		txtEmpCode.setBounds(new Rectangle(398, 37, 140, 23));
		txtEmpCode.setText("");
		txtEmpCode.setEnabled(false);
		txtEmpCode.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtSID.setEnabled(false);
		txtSID.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtSID.setBounds(new Rectangle(119, 10, 140, 23));
		txtSID.setText("");
		txtName.setText("");
		txtName.setBounds(new Rectangle(119, 37, 140, 23));
		txtName.setEnabled(false);
		txtName.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtDate.setBounds(new Rectangle(398, 10, 140, 23));
		txtDate.setEnabled(false);
		txtDate.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtDate.setText("");
		txtDesc.setText("");
		txtDesc.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtDesc.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1)
			{
				if (ke1.getKeyCode() == KeyEvent.VK_TAB)
				{
					if (txtDesc.getText().equals("") || txtDesc.getText().equals("	"))
					{
						JOptionPane.showMessageDialog(null, "Please Provide Description!!!",
						"Missing Information",
						JOptionPane.ERROR_MESSAGE);
						txtDesc.requestFocus();
					}
					else
					{ btnSave.requestFocus();}
				}
			}

			public void KeyReleased(KeyEvent ke2) {}

			public void KeyTyped(KeyEvent ke3) {}
		});
		txtDesc.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{ txtDesc.selectAll(); }

			public void focusLost(FocusEvent f)
			{
				if (txtDesc.getText().equals("") || txtDesc.getText().equals("	"))
				{
					JOptionPane.showMessageDialog(null, "Please Provide Description!!!",
					"Missing Information",
					JOptionPane.ERROR_MESSAGE);
					txtDesc.requestFocus();
				}
			}
		});

		SPtxtDesc.setBounds(new Rectangle(9, 59, 529, 66));
		rdoNewReport.setBackground(Color.white);
		rdoNewReport.setForeground(Color.black);
		rdoTIM.setBackground(Color.white);
		rdoTIM.setForeground(Color.black);
		rdoOther.setBackground(Color.white);
		rdoOther.setForeground(Color.black);
		rdoIFM.setBackground(Color.white);
		rdoIFM.setForeground(Color.black);
		rdoRM.setBackground(Color.white);
		rdoRM.setForeground(Color.black);
		btnClose.setText("CLOSE");
		btnClose.setBounds(new Rectangle(451, 7, 91, 28));
		btnClose.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnClose.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent x2)
			{ dispose(); }
		});

		btnNew.setBounds(new Rectangle(6, 8, 91, 28));
		btnNew.setText("NEW");
		btnNew.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnNew.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				d = new Date();
				CurrentDate = null;
				TranID = new String("S");
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

				clearFields();
				txtSID.setText(TranID);
				txtEmpCode.setText(EmpCode);
				txtName.setText(userName);
				d = new Date();
				sdf = new SimpleDateFormat("yyyy-MM-dd");
				CurrentDate = sdf.format(d);
				txtDate.setText(CurrentDate);
				isAdd = true;
				SetInitialButtons(false);
				SetTextFields(true);
				lblRT.setText("REQUEST TYPE ");
				rdoNewReport.setSelected(true);
				lblRec.setText(" Add New Rec. ");
			}
		});

		btnSave.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnSave.setText("SAVE");
		btnSave.setBounds(new Rectangle(6, 8, 91, 28));
		btnSave.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				CheckRDOs();
				CheckFields();
				if (fieldsOK)
				{
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
							fieldsOK = false;
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
							fieldsOK = false;
						}
					}
					//SET FLAG...
					isAdd=false;
					lblRec.setText("");
				}
				else
				{ return; }
			}
		});

		btnEdit.setText("EDIT");
		btnEdit.setBounds(new Rectangle(102, 8, 91, 28));
		btnEdit.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnEdit.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				SetInitialButtons(false);
				SetTextFields(true);
				lblRT.setText("REQUEST TYPE ");
				rdoNewReport.setSelected(true);
				lblRec.setText(" Edit Record. ");
			}
		});

		btnDelete.setBounds(new Rectangle(355, 7, 91, 28));
		btnDelete.setText("Delete");
		btnDelete.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnDelete.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (txtSID.getText().equals(""))
				{ return;}
				DeleteData();
			}
		});

		btnCancel.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnCancel.setText("CANCEL");
		btnCancel.setBounds(new Rectangle(102, 8, 91, 28));
		btnCancel.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				SetInitialButtons(true);
				SetTextFields(false);
				isAdd = false;
				lblRec.setText("");
			}
		});


		btnPrev.setBounds(new Rectangle(205, 10, 22, 23));
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
					sft=sftcon.movePrevious();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmSoftware]: MOVE PREVIOUS Error");System.out.println("Error: "+re.getMessage());}
			}
		});

		btnNext.setText("");
		btnNext.setBounds(new Rectangle(320, 10, 22, 23));
		btnNext.setIcon(imgNext);
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
					sft=sftcon.moveNext();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmSoftware]: MOVE NEXT Error");System.out.println("Error: "+re.getMessage());}
			}
		});

		rdoNewReport.setText("NEW REPORT");
		rdoNewReport.setBounds(new Rectangle(96, 9, 99, 24));
		rdoNewReport.setFont(new java.awt.Font("Tahoma", 1, 11));
		rdoRM.setText("REPORT MODIFICATION");
		rdoRM.setBounds(new Rectangle(198, 9, 162, 24));
		rdoRM.setFont(new java.awt.Font("Tahoma", 1, 11));
		rdoTIM.setFont(new java.awt.Font("Tahoma", 1, 11));
		rdoTIM.setBounds(new Rectangle(360, 9, 53, 24));
		rdoTIM.setText("TIM");
		rdoOther.setFont(new java.awt.Font("Tahoma", 1, 11));
		rdoOther.setBounds(new Rectangle(476, 9, 67, 24));
		rdoOther.setText("OTHER");
		rdoIFM.setText("IFM");
		rdoIFM.setFont(new java.awt.Font("Tahoma", 1, 11));
		rdoIFM.setBounds(new Rectangle(418, 9, 49, 24));

		bgRT.add(rdoNewReport);
		bgRT.add(rdoRM);
		bgRT.add(rdoTIM);
		bgRT.add(rdoIFM);
		bgRT.add(rdoOther);

		pnlTop.add(txtSID, null);
		pnlTop.add(txtDate, null);
		pnlTop.add(txtEmpCode, null);
		pnlTop.add(lblEmpCode, null);
		pnlTop.add(lblDate, null);
		pnlTop.add(txtName, null);
		pnlTop.add(lblName, null);
		pnlTop.add(lblEID, null);
		this.getContentPane().add(pnlMid, null);

		pnlMid.add(lblRT, null);
		pnlMid.add(SPtxtDesc, null);
		pnlMid.add(lblDesc, null);
		pnlMid.add(rdoNewReport, null);
		pnlMid.add(rdoTIM, null);
		pnlMid.add(rdoOther, null);
		pnlMid.add(rdoIFM, null);
		pnlMid.add(rdoRM, null);
		this.getContentPane().add(pnlButtons, null);
		SPtxtDesc.getViewport().add(txtDesc, null);
		pnlMid.add(rdoTIM, null);

		pnlButtons.add(btnNew, null);
		pnlButtons.add(btnCancel, null);
		pnlButtons.add(btnEdit, null);
		pnlButtons.add(btnDelete, null);
		pnlButtons.add(btnNext, null);
		pnlButtons.add(lblRec, null);
		pnlButtons.add(btnPrev, null);
		pnlButtons.add(btnSave, null);
		pnlButtons.add(btnClose, null);
		this.getContentPane().add(pnlTop, null);

		this.setClosable(true);
		this.setIconifiable(true);
		this.setTitle("SOFTWARE REQUEST FORM");
		this.getContentPane().setLayout(null);
		this.setFrameIcon(imgIco);
		this.getContentPane().setBackground(Color.white);
		this.setSize(new Dimension(576, 309));

		SetTextFields(false);
		SetInitialButtons(true);
		getConnected();
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
			sftcon.Connect(EmpCode);
		}catch(RemoteException re){ System.out.println("Client [frmSoftware]: Open Error");System.out.println("Error: "+re.getMessage());}

		//DISPLAY DATA RMI
		try
		{
			sft=sftcon.moveNext();
			display();
		}catch(RemoteException re){ System.out.println("Client [frmSoftware]: Show Error");System.out.println("Error: "+re.getMessage());}
	}

	/**
	*	Display Data
	*
	*/

	public void display()
	{
		clearFields();

		txtSID.setText(sft.getTransactionID());
		if(!txtSID.getText().equals("")) txtName.setText(userName);
		txtEmpCode.setText(sft.getEmpCode());
		txtDate.setText(sft.getDate());
		lblRT.setText("REQUEST TYPE: " + sft.getRequestType());
		txtDesc.setText(sft.getDescription());

		//lblRec.setText(" REC # " + rsP.getRow());
	}

	/**
	*	Checking RDO's States
	*
	*/

	public void CheckRDOs()
	{
		if (rdoNewReport.isSelected()) { RequestType = "New Report";}
		if (rdoRM.isSelected()) { RequestType = "Report Modification";}
		if (rdoTIM.isSelected()) { RequestType = "TIM";}
		if (rdoIFM.isSelected()) { RequestType = "IFM";}
		if (rdoOther.isSelected()) { RequestType = "Other";}
	}

	/**
	*	Setting Text Fields
	*	@param boolean true or false value
	*
	*/

	void SetTextFields(boolean txtValue)
	{
		txtDesc.setEnabled(txtValue);
		rdoNewReport.setVisible(txtValue);
		rdoRM.setVisible(txtValue);
		rdoTIM.setVisible(txtValue);
		rdoIFM.setVisible(txtValue);
		rdoOther.setVisible(txtValue);
	}

	/**
	*	Setting Button States
	*	@param boolean true or false value
	*
	*/

	void SetInitialButtons(boolean bVal)
	{
		btnNew.setVisible(bVal);
		btnEdit.setVisible(bVal);
		btnSave.setVisible(!bVal);
		btnCancel.setVisible(!bVal);
		btnDelete.setEnabled(bVal);
		btnPrev.setEnabled(bVal);
		btnNext.setEnabled(bVal);
	}

	/**
	*	Field Checking
	*
	*	@return boolean true or false value
	*/

	public void CheckFields()
	{
		if (txtDesc.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null,
			"Please Provide Software Description!!!",
			"Missing Information",
			JOptionPane.ERROR_MESSAGE);
			txtDesc.requestFocus();
			fieldsOK = false; ;
		}
		else
		{ fieldsOK = true; }
	}

	/**
	*	Clears TextFields
	*
	*/

	public void clearFields()
	{
		txtSID.setText("");
		txtDate.setText("");
		txtName.setText("");
		txtEmpCode.setText("");
		txtDesc.setText("");
		lblRec.setText("");
		txtDesc.setText("");
	}

	/**
	*	Requests Server to Add New Record
	*
	*/

	public boolean save()
	{//Save
		boolean savesucc=false;

		//INITIALISE USER OBJECT...
		sft.setTransactionID(txtSID.getText());
		sft.setEmpCode(EmpCode);
		sft.setDate(txtDate.getText());
		sft.setRequestType(RequestType);
		sft.setDescription(txtDesc.getText());
		sft.setDeptApp("-");
		sft.setDeptComm("-");
		sft.setDeptAppBy("-");
		sft.setISApp("-");
		sft.setISComm("-");
		sft.setISAppBy("-");
		sft.setJobStatus("-");

		try
		{
			savesucc = sftcon.insertData(sft);
			StartWorking("ADDING NEW RECORD");
			JOptionPane.showMessageDialog(null, "Server: Record Added!", "Information", 1);
			lblRec.setText("");
			getConnected();

		}catch(RemoteException re)
		{
			System.out.println("Client [frmSoftware]: SAVE DATA Error");System.out.println("Error: "+re.getMessage());
			JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmSoftware]: "+re.getMessage(),
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
		sft.setDescription(txtDesc.getText());
		sft.setRequestType(RequestType);

		try
		{
			updatesucc = sftcon.updateEmpData(sft);
			StartWorking("UPDATING RECORD");
			JOptionPane.showMessageDialog(null, "Server: Record Updated!", "Information", 1);
			lblRec.setText("");
			getConnected();

		}catch(RemoteException re)
		{
			System.out.println("Client [frmSoftware]: UPDATE DATA Error");System.out.println("Error: "+re.getMessage());
			JOptionPane.showMessageDialog(null, "UPDATE DATA Error\nClient [frmSoftware]: "+re.getMessage(),
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
		String strQuery = "DELETE FROM Software WHERE TransactionID='" + txtSID.getText() + "';";

		yn = JOptionPane.showConfirmDialog(null, "Are you sure you want to DELETE this record ?", "Conformation...",
		JOptionPane.YES_NO_OPTION, 3, imgQ);

		if (yn == JOptionPane.YES_OPTION)
		{
			try
			{
				sftcon.DeleteData(strQuery);
				StartWorking("DELETING RECORD");
				JOptionPane.showMessageDialog(null, "Server: Record Deleted!", "Information", 1);
				clearFields();
				getConnected();

			}catch(RemoteException re)
			{
				System.out.println("Client [frmSoftware]: DELETE DATA Error");System.out.println("Error: "+re.getMessage());
				JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmSoftware]: "+re.getMessage(),
													"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else {}
	}//Delete Data

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

	//void btnClose_actionPerformed(ActionEvent e) {}

}//Class