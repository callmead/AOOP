package beximtex;
/**
 * <p>Title: BeximTex, Hardware Request</p>
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

public class frmHardware extends JInternalFrame
{//Class

	JPanel pnlTop = new JPanel();
	JPanel pnlMid = new JPanel();
	JPanel pnlButtons = new JPanel();

	TitledBorder titledBorder1;
	TitledBorder titledBorder2;
	TitledBorder titledBorder3;

	JLabel lblEmpCode = new JLabel();
	JLabel lblHID = new JLabel();
	JLabel lblName = new JLabel();
	JLabel lblDate = new JLabel();
	JLabel lblDesc = new JLabel();
	JLabel lblNeed = new JLabel();
	JLabel lblSpec = new JLabel();
	JLabel lblRec = new JLabel();

	JTextField txtEmpCode = new JTextField();
	JTextField txtHID = new JTextField();
	JTextField txtName = new JTextField();
	JTextField txtDate = new JTextField();

	JScrollPane SPtxtDesc = new JScrollPane();
	JScrollPane SPtxtNeed = new JScrollPane();
	JScrollPane SPtxtSpec = new JScrollPane();

	JToggleButton btnDelete = new JToggleButton();
	JToggleButton btnEdit = new JToggleButton();
	JToggleButton btnNext = new JToggleButton();
	JToggleButton btnPrev = new JToggleButton();
	JToggleButton btnNew = new JToggleButton();
	JToggleButton btnSave = new JToggleButton();
	JToggleButton btnCancel = new JToggleButton();

	//**************************************************************
	//RMI Declare Server Object
	HardwareController hdwcon;
	Hardware hdw = new Hardware();
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

	JTextArea txtDesc = new JTextArea();
	JTextArea txtNeed = new JTextArea();
	JTextArea txtSpec = new JTextArea();

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

	public frmHardware(String ec, String un)
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
			hdwcon = (HardwareController)Naming.lookup(new ReadHost().getHost() + "HardwareController");
		}catch(Exception ec)
		{
			System.out.println("\n******************************\n       SERVER NOT READY       \n******************************\n");
			System.out.println("Error: "+ec.getMessage());
			JOptionPane.showMessageDialog(null, "SERVER NOT READY!" + "\nError: "+ec.getMessage(),
			"Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		System.out.println("\n******************************\n CLIENT READY [frmHardware] \n******************************\n");
		//**************************************************************

		titledBorder1 = new TitledBorder("");
		titledBorder2 = new TitledBorder("");
		titledBorder3 = new TitledBorder("");
		txtSpec.setText("");

		pnlTop.setBackground(Color.white);
		pnlTop.setForeground(Color.white);
		pnlTop.setBorder(titledBorder1);
		pnlTop.setBounds(new Rectangle(7, 8, 551, 73));
		pnlTop.setLayout(null);

		pnlMid.setBackground(Color.white);
		pnlMid.setForeground(Color.white);
		pnlMid.setBorder(titledBorder2);
		pnlMid.setDebugGraphicsOptions(0);
		pnlMid.setBounds(new Rectangle(7, 86, 551, 238));
		pnlMid.setLayout(null);

		pnlButtons.setBackground(Color.white);
		pnlButtons.setForeground(Color.white);
		pnlButtons.setBorder(titledBorder3);
		pnlButtons.setBounds(new Rectangle(7, 330, 551, 45));
		pnlButtons.setLayout(null);

		lblEmpCode.setBounds(new Rectangle(285, 37, 106, 24));
		lblEmpCode.setText("EMPLOYEE CODE");
		lblEmpCode.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblEmpCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHID.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblHID.setBounds(new Rectangle(10, 10, 131, 24));
		lblHID.setText("TRANSACTION #");
		lblName.setText("NAME");
		lblName.setBounds(new Rectangle(10, 37, 131, 24));
		lblName.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblDate.setBounds(new Rectangle(285, 10, 106, 24));
		lblDate.setText("DATE");
		lblDate.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDesc.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblDesc.setText("NAME / DESCRIPTION [OF THE HARDWARE REQURIED]");
		lblDesc.setBounds(new Rectangle(12, 6, 519, 24));
		lblNeed.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblNeed.setText("NEED / JUSTIFICATION [JOBS TO BE DONE]");
		lblNeed.setBounds(new Rectangle(11, 80, 519, 24));
		lblSpec.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblSpec.setRequestFocusEnabled(true);
		lblSpec.setText("SPECIFICATION [LEAVE BLANK IF THERE IS NO SPECIFICATION]");
		lblSpec.setBounds(new Rectangle(11, 153, 519, 24));

		txtEmpCode.setBounds(new Rectangle(399, 38, 140, 23));
		txtEmpCode.setText("");
		txtEmpCode.setEnabled(false);
		txtEmpCode.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtHID.setEnabled(false);
		txtHID.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtHID.setBounds(new Rectangle(120, 11, 140, 23));
		txtHID.setText("");
		txtName.setText("");
		txtName.setBounds(new Rectangle(120, 38, 140, 23));
		txtName.setEnabled(false);
		txtName.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtDate.setBounds(new Rectangle(399, 11, 140, 23));
		txtDate.setEnabled(false);
		txtDate.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtDate.setText("");

		txtDesc.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtDesc.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1)
			{
				if (ke1.getKeyCode() == KeyEvent.VK_TAB)
				{
					//txtDesc.setText("-");
					txtNeed.requestFocus();
				}
			}

			public void KeyReleased(KeyEvent ke2) {}
			public void KeyTyped(KeyEvent ke3) {}
		});
		txtDesc.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{ txtDesc.selectAll(); }
			public void focusLost(FocusEvent f) {}
		});

		txtNeed.setText("");
		txtNeed.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtNeed.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1)
			{
				if (ke1.getKeyCode() == KeyEvent.VK_TAB)
				{
					//txtNeed.setText("-");
					txtSpec.requestFocus();
				}
			}
			public void KeyReleased(KeyEvent ke2) {}
			public void KeyTyped(KeyEvent ke3) {}
		});
		txtNeed.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{ txtNeed.selectAll(); }
			public void focusLost(FocusEvent f) {}
		});

		txtSpec.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtSpec.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1)
			{
				if (ke1.getKeyCode() == KeyEvent.VK_TAB)
				{
					if(txtSpec.getText().equals("")){txtSpec.setText("-");}
					btnSave.requestFocus();
				}
			}
			public void KeyReleased(KeyEvent ke2) {}
			public void KeyTyped(KeyEvent ke3) {}
		});
		txtSpec.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{ txtSpec.selectAll(); }
			public void focusLost(FocusEvent f)
			{
				if (txtSpec.getText().equals(""))
				{ txtSpec.setText("-"); }
			}
		});

		SPtxtDesc.setBounds(new Rectangle(11, 29, 527, 49));
		SPtxtNeed.setBounds(new Rectangle(10, 103, 527, 49));
		SPtxtSpec.setBounds(new Rectangle(10, 176, 527, 49));

		btnNew.setBounds(new Rectangle(7, 9, 91, 28));
		btnNew.setText("NEW");
		btnNew.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnNew.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				d = new Date();
				CurrentDate = null;
				TranID = new String("H");
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
				txtHID.setText(TranID);
				txtEmpCode.setText(EmpCode);
				txtName.setText(userName);

				d = new Date();
				sdf = new SimpleDateFormat("yyyy-MM-dd");
				CurrentDate = sdf.format(d);
				txtDate.setText(CurrentDate);

				isAdd = true;
				SetInitialButtons(false);
				SetTextFields(true);
				txtDesc.requestFocus();
				lblRec.setText(" Add New Rec. ");
			}
		});

		btnSave.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnSave.setText("SAVE");
		btnSave.setBounds(new Rectangle(7, 9, 91, 28));
		btnSave.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				CheckFields();
				if (txtSpec.getText().equals(""))
				{ txtSpec.setText("-");	}

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
				else { return; }
			}
		});

		btnDelete.setBounds(new Rectangle(356, 8, 91, 28));
		btnDelete.setText("Delete");
		btnDelete.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnDelete.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (txtHID.getText().equals("")) { return; }
				DeleteData();
			}
		});

		btnEdit.setText("EDIT");
		btnEdit.setBounds(new Rectangle(103, 9, 91, 28));
		btnEdit.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnEdit.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				SetInitialButtons(false);
				SetTextFields(true);
				txtDesc.requestFocus();
				lblRec.setText(" Edit Record. ");
			}
		});

		lblRec.setBounds(new Rectangle(230, 11, 88, 24));
		lblRec.setText("");
		lblRec.setHorizontalAlignment(SwingConstants.LEFT);
		lblRec.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblRec.setBorder(null);

		btnCancel.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnCancel.setText("CANCEL");
		btnCancel.setBounds(new Rectangle(103, 9, 91, 28));
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


		btnNext.setText("");
		btnNext.setBounds(new Rectangle(321, 11, 22, 23));
		btnNext.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnNext.setIcon(imgNext);
		btnNext.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{ btnNext.setIcon(imgNO);}
			public void mouseExited(MouseEvent f)
			{ btnNext.setIcon(imgNext); }
		});
		btnNext.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					hdw=hdwcon.moveNext();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmHardware]: MOVE NEXT Error");System.out.println("Error: "+re.getMessage());}
			}
		});

		btnPrev.setBounds(new Rectangle(206, 11, 22, 23));
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
					hdw=hdwcon.movePrevious();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmHardware]: MOVE PREVIOUS Error");System.out.println("Error: "+re.getMessage());}
			}
		});

		this.setForeground(Color.white);
		btnClose.setText("CLOSE");
		btnClose.setBounds(new Rectangle(451, 8, 91, 28));
		btnClose.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnClose.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent x2)
			{ dispose(); }
		});
		pnlTop.add(txtDate, null);
		pnlTop.add(lblHID, null);
		pnlTop.add(txtHID, null);
		pnlTop.add(txtName, null);
		pnlTop.add(lblName, null);
		pnlTop.add(lblEmpCode, null);
		pnlTop.add(lblDate, null);
		pnlTop.add(txtEmpCode, null);
		this.getContentPane().add(pnlMid, null);

		pnlMid.add(SPtxtDesc, null);
		pnlMid.add(lblDesc, null);
		pnlMid.add(SPtxtNeed, null);
		pnlMid.add(lblNeed, null);
		pnlMid.add(lblSpec, null);
		pnlMid.add(SPtxtSpec, null);
		this.getContentPane().add(pnlButtons, null);
		SPtxtSpec.getViewport().add(txtSpec, null);
		SPtxtNeed.getViewport().add(txtNeed, null);
		SPtxtDesc.getViewport().add(txtDesc, null);

		pnlButtons.add(btnNew, null);
		pnlButtons.add(btnEdit, null);
		pnlButtons.add(btnPrev, null);
		pnlButtons.add(lblRec, null);
		pnlButtons.add(btnNext, null);
		pnlButtons.add(btnDelete, null);
		pnlButtons.add(btnSave, null);
		pnlButtons.add(btnCancel, null);
		pnlButtons.add(btnClose, null);
		this.getContentPane().add(pnlTop, null);

		this.setClosable(true);
		this.setIconifiable(true);
		this.setMaximizable(false);
		this.setTitle("HARDWARE REQUEST FORM");
		this.getContentPane().setLayout(null);
		this.setSize(new Dimension(576, 415));
		this.setFrameIcon(imgIco);
		this.getContentPane().setBackground(Color.white);

		SetTextFields(false);
		SetInitialButtons(true);
		getConnected();
	}

	/**
	*	Setting Text Fields
	*	@param boolean true or false value
	*
	*/

	void SetTextFields(boolean txtValue)
	{
		txtDesc.setEnabled(txtValue);
		txtNeed.setEnabled(txtValue);
		txtSpec.setEnabled(txtValue);
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
		if (txtDesc.getText().equals("") || txtDesc.getText().equals("	"))
		{
			JOptionPane.showMessageDialog(null,
			"Please Provide Hardware Description!!!",
			"Missing Information",
			JOptionPane.ERROR_MESSAGE);
			txtDesc.requestFocus();
			fieldsOK = false;
		}

		else if (txtNeed.getText().equals("") || txtNeed.getText().equals("	"))
		{
			JOptionPane.showMessageDialog(null,
			"Please Provide Why is the Hardware Required!!!",
			"Missing Information",
			JOptionPane.ERROR_MESSAGE);
			txtNeed.requestFocus();
			fieldsOK = false;
		}
		else {fieldsOK = true;}
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
			hdwcon.Connect(EmpCode);
		}catch(RemoteException re){ System.out.println("Client [frmHardware]: Open Error");System.out.println("Error: "+re.getMessage());}

		//DISPLAY DATA RMI
		try
		{
			hdw=hdwcon.moveNext();
			display();
		}catch(RemoteException re){ System.out.println("Client [frmHardware]: Show Error");System.out.println("Error: "+re.getMessage());}
	}

	/**
	*	Display Data
	*
	*/

	public void display()
	{
		clearFields();

		txtHID.setText(hdw.getTransactionID());
		if(!txtHID.getText().equals("")) txtName.setText(userName);
		txtEmpCode.setText(hdw.getEmpCode());
		txtDate.setText(hdw.getDate());
		txtDesc.setText(hdw.getDescription());
		txtNeed.setText(hdw.getNeed());
		txtSpec.setText(hdw.getSpec());

		//lblRec.setText(" REC # " + rsP.getRow());
	}//Display

	/**
	*	Clears TextFields
	*
	*/

	public void clearFields()
	{
		txtHID.setText("");
		txtDate.setText("");
		txtName.setText("");
		txtEmpCode.setText("");
		txtDesc.setText("");
		txtNeed.setText("");
		txtSpec.setText("");

		txtDesc.setText("");
		txtNeed.setText("");
		txtSpec.setText("");
	}

	/**
	*	Requests Server to Add New Record
	*
	*/

	public boolean save()
	{//Save
		boolean savesucc=false;

		//INITIALISE USER OBJECT...
		hdw.setTransactionID(txtHID.getText());
		hdw.setEmpCode(EmpCode);
		hdw.setDate(txtDate.getText());
		hdw.setDescription(txtDesc.getText());
		hdw.setNeed(txtNeed.getText());
		hdw.setSpec(txtSpec.getText());
		hdw.setDeptApp("-");
		hdw.setDeptComm("-");
		hdw.setDeptAppBy("-");
		hdw.setISApp("-");
		hdw.setISComm("-");
		hdw.setISAppBy("-");
		hdw.setJobStatus("-");

		try
		{
			savesucc = hdwcon.insertData(hdw);
			StartWorking("ADDING NEW RECORD");
			JOptionPane.showMessageDialog(null, "Server: Record Added!", "Information", 1);
			lblRec.setText("");
			getConnected();

		}catch(RemoteException re)
		{
			System.out.println("Client [frmHardware]: SAVE DATA Error");System.out.println("Error: "+re.getMessage());
			JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmHardware]: "+re.getMessage(),
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
		hdw.setDescription(txtDesc.getText());
		hdw.setNeed(txtNeed.getText());
		hdw.setSpec(txtSpec.getText());

		try
		{
			updatesucc = hdwcon.updateEmpData(hdw);
			StartWorking("UPDATING RECORD");
			JOptionPane.showMessageDialog(null, "Server: Record Updated!", "Information", 1);
			lblRec.setText("");
			getConnected();

		}catch(RemoteException re)
		{
			System.out.println("Client [frmHardware]: UPDATE DATA Error");System.out.println("Error: "+re.getMessage());
			JOptionPane.showMessageDialog(null, "UPDATE DATA Error\nClient [frmHardware]: "+re.getMessage(),
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
		String strQuery = "DELETE FROM Hardware WHERE TransactionID='" + txtHID.getText() +"';";

		yn = JOptionPane.showConfirmDialog(null, "Are you sure you want to DELETE this record ?", "Conformation...",
		JOptionPane.YES_NO_OPTION, 3, imgQ);

		if (yn == JOptionPane.YES_OPTION)
		{
			try
			{
				hdwcon.DeleteData(strQuery);
				StartWorking("DELETING RECORD");
				JOptionPane.showMessageDialog(null, "Server: Record Deleted!", "Information", 1);
				clearFields();
				getConnected();

			}catch(RemoteException re)
			{
				System.out.println("Client [frmHardware]: DELETE DATA Error");System.out.println("Error: "+re.getMessage());
				JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmHardware]: "+re.getMessage(),
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