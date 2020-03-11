package beximtex;
/**
* <p>Title: BeximTex, User Manager</p>
* <p>Description: Support Software System</p>
* <p>Copyright: 2006-2010</p>
* <p>Company: ASKA</p>
* @author Adeel Ashraf Malik
* @version 1.0.0
*/

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.text.*;
import java.util.*;
import java.util.Date;

import java.rmi.*;

public class frmUsers extends JInternalFrame
{//Class

	Border border1;
	TitledBorder titledBorder1 = new TitledBorder(BorderFactory.createLineBorder(
	Color.gray, 1), "");
	TitledBorder titledBorder2 = new TitledBorder(BorderFactory.createLineBorder(
	Color.gray, 1), "User Search");

	JPanel pnlTop = new JPanel();
	JPanel pnlMid = new JPanel();

	JLabel lblEmpCode = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel lblUT = new JLabel();
	JLabel lblRem = new JLabel();

	JTextField txtEmpCode = new JTextField();
	JTextField txtPassword = new JTextField();
	JToggleButton btnLast = new JToggleButton();
	JToggleButton btnPrevious = new JToggleButton();
	JToggleButton btnNext = new JToggleButton();
	JToggleButton btnFirst = new JToggleButton();
	JButton btnDelete = new JButton();
	JButton btnClose = new JButton();
	JButton btnSave = new JButton();
	JButton btnCancel = new JButton();
	JButton btnEdit = new JButton();
	JButton btnNew = new JButton();
	JLabel lblRec = new JLabel();

	//**************************************************************
	//RMI Declare Server Object
	UserController usercon;
	User usr = new User();

	CommonTableController ctccon;
	//**************************************************************

	boolean isAdd = false;

	String searchType1 = new String();
	String searchType2 = new String();

	String SDate = null;
	SimpleDateFormat sdf = new SimpleDateFormat();
	Date d;
	String CurrentDate=null;

	JPanel pnlBottom = new JPanel();
	JComboBox cboSearch = new JComboBox();
	JButton btnGo = new JButton();
	JTextField txtSearch = new JTextField();
	JButton btnRefresh = new JButton();
	JLabel lblPicture = new JLabel();
	JComboBox cboType = new JComboBox();
	JScrollPane SPtxtRem = new JScrollPane();
	JTextArea txtRemarks = new JTextArea();
	JLabel lblPic = new JLabel();
	JTextField txtName = new JTextField();
	JLabel lblName = new JLabel();
	JLabel lblDesg = new JLabel();
	JLabel lblDept = new JLabel();
	JLabel lblExt = new JLabel();
	JTextField txtExt = new JTextField();
	JLabel lblDH = new JLabel();
	JTextField txtDH = new JTextField();
	JLabel lblEmpCode1 = new JLabel();
	JTextField txtHD = new JTextField();
	JLabel lblBU = new JLabel();
	JTextField txtAMT = new JTextField();
	JLabel lblAMT = new JLabel();
	JLabel lblDOJ = new JLabel();
	JTextField txtDOJ = new JTextField();
	JLabel lblDOP = new JLabel();
	JTextField txtDOP = new JTextField();
	JButton btnSelect = new JButton();

	ImageIcon imgFirst = new ImageIcon("./Images/iconFirst.gif");
	ImageIcon imgFO = new ImageIcon("./Images/iconFirstOver.gif");
	ImageIcon imgLast = new ImageIcon("./Images/iconLast.gif");
	ImageIcon imgLO = new ImageIcon("./Images/iconLastOver.gif");
	ImageIcon imgNext = new ImageIcon("./Images/iconNext.gif");
	ImageIcon imgNO = new ImageIcon("./Images/iconNextOver.gif");
	ImageIcon imgPrev = new ImageIcon("./Images/iconPrevious.gif");
	ImageIcon imgPO = new ImageIcon("./Images/iconPreviousOver.gif");
	ImageIcon imgSearch = new ImageIcon("./Images/powerSearch.gif");
	ImageIcon imgSrc = new ImageIcon("./Images/find.png");
	ImageIcon imgRef = new ImageIcon("./Images/db.gif");
	ImageIcon imgExc = new ImageIcon("./Images/exc.gif");
	ImageIcon imgIco = new ImageIcon("./Images/popup.gif");
	ImageIcon imgTab = new ImageIcon("./Images/table.gif");
	ImageIcon imgLog = new ImageIcon("./Images/loginL.png");
	ImageIcon imgQ = new ImageIcon("./Images/question32.png");

	JLabel lblIco = new JLabel();
	JButton btnDOJ = new JButton();
	JButton btnDOP = new JButton();
	JLabel lblEmail = new JLabel();
	JTextField txtEmail = new JTextField();
	JComboBox cboDesg = new JComboBox();
	JComboBox cboDept = new JComboBox();
	JComboBox cboBU = new JComboBox();

	public frmUsers()
	{//Cons
		try {jbInit();}
		catch (Exception e)	{System.exit(0);}
	}//Cons

	private void jbInit() throws Exception
	{//Cons

		//**************************************************************
	    //Connection: Connects with Server
		try
		{
			//suppcon = (SupplierController)Naming.lookup("rmi://ServerAddress:1099/SupplierController");
			usercon = (UserController)Naming.lookup(new ReadHost().getHost() + "UserController");
			ctccon = (CommonTableController)Naming.lookup(new ReadHost().getHost() + "CommonTableController");

		}catch(Exception ec)
		{
			System.out.println("\n******************************\n       SERVER NOT READY       \n******************************\n");
			System.out.println("Error: "+ec.getMessage());
			JOptionPane.showMessageDialog(null, "SERVER NOT READY!" + "\nError: "+ec.getMessage(),
			"Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		System.out.println("\n******************************\n CLIENT READY [frmUsers] \n******************************\n");
		//**************************************************************

		lblRec.setBackground(Color.white);
		pnlTop.setForeground(Color.white);
		pnlMid.setForeground(Color.white);
		pnlBottom.setForeground(Color.white);
		lblIco.setBounds(new Rectangle(9, 297, 128, 128));
		lblIco.setIcon(imgLog);
		btnDOJ.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ btnDOJ_actionPerformed(e); }
		});

		btnDOJ.setBounds(new Rectangle(520, 106, 22, 23));
		btnDOJ.setIcon(imgTab);
		btnDOJ.setMnemonic('O');
		btnDOJ.setBorder(BorderFactory.createRaisedBevelBorder());
		btnDOJ.setToolTipText("Select a Particular Date");
		btnDOP.setToolTipText("Select a Particular Date");
		btnDOP.setBorder(BorderFactory.createRaisedBevelBorder());
		btnDOP.setMnemonic('O');
		btnDOP.setIcon(imgTab);
		btnDOP.setBounds(new Rectangle(520, 131, 22, 23));
		btnDOP.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ btnDOP_actionPerformed(e); }
		});

		lblEmail.setBounds(new Rectangle(285, 153, 106, 24));
		lblEmail.setText("EMAIL");
		lblEmail.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		txtEmail.setBounds(new Rectangle(403, 156, 115, 20));
		txtEmail.setText("");
		txtEmail.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtEmail.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{ txtEmail.selectAll(); }
			public void focusLost(FocusEvent f) {}
		});

		txtEmail.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1) {}
			public void keyTyped(KeyEvent ke1)
			{
				if ( (ke1.getKeyChar() >= 65 && ke1.getKeyChar() <= 90) ||
				(ke1.getKeyChar() >= 48 && ke1.getKeyChar() <= 57) ||
				(ke1.getKeyChar() >= 97 && ke1.getKeyChar() <= 122) ||
				(ke1.getKeyChar() == '@') || (ke1.getKeyChar() == 46) ||
				(ke1.getKeyChar() == 45) || (ke1.getKeyChar() == 109) ||
				(ke1.getKeyChar() == 8) || (ke1.getKeyChar() == 95)) {}
				else { ke1.consume(); }
			}
		});

		txtDOJ.setEnabled(false);
		txtDOP.setEnabled(false);
		cboDesg.setBackground(Color.white);
		cboDesg.setBounds(new Rectangle(115, 33, 143, 20));
		cboDesg.setMaximumRowCount(4);
		cboDept.setMaximumRowCount(4);
		cboDept.setBounds(new Rectangle(115, 57, 143, 20));
		cboDept.setBackground(Color.white);
		cboBU.setBackground(Color.white);
		cboBU.setBounds(new Rectangle(115, 132, 143, 20));
		cboBU.setMaximumRowCount(4);
		pnlBottom.add(txtSearch, null);
		pnlBottom.add(lblPicture, null);
		pnlBottom.add(btnGo, null);
		pnlBottom.add(cboSearch, null);
		this.getContentPane().add(lblIco, null);
		this.getContentPane().add(lblPic, null);
		pnlTop.add(lblName, null);
		pnlTop.add(txtName, null);
		pnlTop.add(lblDesg, null);
		pnlTop.add(lblDept, null);
		pnlTop.add(lblDH, null);
		pnlTop.add(txtDH, null);
		pnlTop.add(lblEmpCode1, null);
		pnlTop.add(txtHD, null);
		pnlTop.add(lblBU, null);
		pnlTop.add(cboType, null);
		pnlTop.add(lblUT, null);
		pnlTop.add(lblRem, null);
		pnlTop.add(SPtxtRem, null);
		pnlTop.add(btnSelect, null);
		pnlTop.add(jLabel3, null);
		pnlTop.add(txtPassword, null);
		pnlTop.add(txtExt, null);
		pnlTop.add(lblExt, null);
		pnlTop.add(lblAMT, null);
		pnlTop.add(txtAMT, null);
		pnlTop.add(txtDOJ, null);
		pnlTop.add(lblDOJ, null);
		pnlTop.add(lblDOP, null);
		pnlTop.add(txtDOP, null);
		pnlTop.add(txtEmpCode, null);
		pnlTop.add(lblEmpCode, null);
		pnlTop.add(btnDOJ, null);
		SPtxtRem.getViewport().add(txtRemarks, null);
		this.getContentPane().add(pnlMid, null);
		titledBorder2 = new TitledBorder(BorderFactory.createLineBorder(Color.gray,
		1), "");
		this.getContentPane().setLayout(null);
		this.getContentPane().setBackground(Color.white);

		pnlTop.setBackground(Color.white);
		pnlTop.setFont(new java.awt.Font("Tahoma", 1, 14));
		pnlTop.setBorder(titledBorder1);
		pnlTop.setOpaque(true);
		pnlTop.setBounds(new Rectangle(213, 5, 548, 244));
		pnlTop.setLayout(null);
		pnlMid.setLayout(null);

		btnLast.setToolTipText("Last");
		btnLast.setIcon(imgLast);
		btnLast.setText("");
		btnLast.setBounds(new Rectangle(377, 11, 22, 23));
		btnLast.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{ btnLast.setIcon(imgLO); }
			public void mouseExited(MouseEvent f)
			{ btnLast.setIcon(imgLast); }
		});
		btnLast.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					usr=usercon.moveLast();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmUsers]: MOVE LAST Error");System.out.println("Error: "+re.getMessage());}
			}
		});

		btnPrevious.setToolTipText("Previous");
		btnPrevious.setIcon(imgPrev);
		btnPrevious.setText("");
		btnPrevious.setBounds(new Rectangle(175, 11, 22, 23));
		btnPrevious.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{ btnPrevious.setIcon(imgPO); }
			public void mouseExited(MouseEvent f)
			{ btnPrevious.setIcon(imgPrev); }
		});
		btnPrevious.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					usr=usercon.movePrevious();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmUsers]: MOVE PREVIOUS Error");System.out.println("Error: "+re.getMessage());}
			}
		});

		btnNext.setToolTipText("Next");
		btnNext.setIcon(imgNext);
		btnNext.setText("");
		btnNext.setBounds(new Rectangle(354, 11, 22, 23));
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
					usr=usercon.moveNext();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmUsers]: MOVE NEXT Error");System.out.println("Error: "+re.getMessage());}
			}
		});

		btnFirst.setToolTipText("First");
		btnFirst.setIcon(imgFirst);
		btnFirst.setText("");
		btnFirst.setBounds(new Rectangle(151, 11, 22, 23));
		btnFirst.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{ btnFirst.setIcon(imgFO); }
			public void mouseExited(MouseEvent f)
			{ btnFirst.setIcon(imgFirst); }
		});
		btnFirst.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					usr=usercon.moveFirst();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmUsers]: MOVE FIRST Error");System.out.println("Error: "+re.getMessage());}
			}
		});

		btnDelete.setBorder(BorderFactory.createRaisedBevelBorder());
		btnDelete.setMnemonic('D');
		btnDelete.setText("DELETE");
		btnDelete.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnDelete.setIcon(new ImageIcon("images/Delete16.gif"));
		btnDelete.setBounds(new Rectangle(353, 38, 91, 28));
		btnDelete.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(txtEmpCode.getText().equals(""))
				{ return;}
				DeleteData();
			}
		});

		btnClose.setBorder(BorderFactory.createRaisedBevelBorder());
		btnClose.setMnemonic('L');
		btnClose.setText("CLOSE");
		btnClose.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnClose.setIcon(new ImageIcon("images/close.gif"));
		btnClose.setBounds(new Rectangle(447, 38, 91, 28));
		btnClose.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ dispose(); }
		});

		btnSave.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				saveData();
				lblRec.setText("");
			}
		});

		btnSave.setBorder(BorderFactory.createRaisedBevelBorder());
		btnSave.setMnemonic('S');
		btnSave.setText("SAVE");
		btnSave.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnSave.setIcon(new ImageIcon("images/Save16.gif"));
		btnSave.setBounds(new Rectangle(10, 38, 91, 28));
		btnCancel.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setButtons(true);
				setFields(false);
				//REFRESH...
				getConnected();
				isAdd = false;
				lblRec.setText("");
			}
		});

		btnCancel.setBorder(BorderFactory.createRaisedBevelBorder());
		btnCancel.setBounds(new Rectangle(105, 38, 91, 28));
		btnCancel.setText("CANCEL");
		btnCancel.setIcon(new ImageIcon("images/Cancel.gif"));
		btnCancel.setMnemonic('C');
		btnCancel.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnEdit.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setButtons(false);
				setFields(true);
				txtName.requestFocus();
				txtEmpCode.setEnabled(false);
				lblRec.setText(" Edit Record... ");
			}
		});

		btnEdit.setBorder(BorderFactory.createRaisedBevelBorder());
		btnEdit.setBounds(new Rectangle(105, 38, 91, 28));
		btnEdit.setText("EDIT");
		btnEdit.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnEdit.setIcon(new ImageIcon("images/EditMnu.gif"));
		btnEdit.setMnemonic('E');

		btnNew.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				isAdd = true;
				setButtons(false);
				setFields(true);
				clearFields();

				d = new Date();
				sdf = new SimpleDateFormat("yyyy-MM-dd");
				CurrentDate = sdf.format(d);
				txtDOJ.setText(CurrentDate);
				txtDOP.setText(CurrentDate);
				txtAMT.setText("0");
				txtName.requestFocus();
				txtDH.setText("-");
				txtHD.setText("-");
				txtEmail.setText("@beximtex.com");
				cboType.setSelectedItem("Operator");
				lblRec.setText(" Add New Record... ");
			}
		});

		btnNew.setBorder(BorderFactory.createRaisedBevelBorder());
		btnNew.setBounds(new Rectangle(10, 38, 91, 28));
		btnNew.setText("NEW");
		btnNew.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnNew.setIcon(new ImageIcon("images/FileMnu.gif"));
		btnNew.setMnemonic('N');

		lblRec.setBounds(new Rectangle(200, 12, 150, 21));
		lblRec.setOpaque(true);
		lblRec.setText("");
		lblRec.setFont(new Font("Tahoma", 1, 12));
		pnlBottom.setBackground(Color.white);
		pnlBottom.setBorder(titledBorder2);
		pnlBottom.setBounds(new Rectangle(213, 336, 548, 87));
		pnlBottom.setLayout(null);
		cboSearch.setBounds(new Rectangle(343, 52, 101, 24));
		cboSearch.setMaximumRowCount(4);
		cboSearch.setBackground(Color.white);
		cboSearch.addItem("EmpCode");
		cboSearch.addItem("Name");
		cboSearch.addItem("Designation");
		cboSearch.addItem("Department");
		cboSearch.addItem("Ext");
		cboSearch.addItem("DeptHead");
		cboSearch.addItem("BU");
		cboSearch.addItem("AppMBamt");
		cboSearch.addItem("DOJ");
		cboSearch.addItem("DOP");
		cboSearch.addItem("UserType");

		btnGo.setBounds(new Rectangle(448, 49, 91, 28));
		btnGo.setText("  FIND     ");
		btnGo.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnGo.setIcon(imgSrc);
		btnGo.setBorder(BorderFactory.createRaisedBevelBorder());
		btnGo.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				searchType1 = txtSearch.getText();
				Object obj = new Object();
				obj = cboSearch.getSelectedItem();
				searchType2 = obj.toString();
				getSearchData();
			}
		});

		txtSearch.setFont(new Font("Tahoma", 1, 12));
		txtSearch.setCaretColor(Color.blue);
		txtSearch.setText("");
		txtSearch.setBounds(new Rectangle(8, 52, 330, 24));
		txtSearch.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtSearch.selectAll();}
			public void focusLost(FocusEvent f)	{}
		});

		txtRemarks.setFont(new Font("Tahoma", 1, 12));
		txtRemarks.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtRemarks.selectAll();}
			public void focusLost(FocusEvent f)	{}
		});
		txtRemarks.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1)
			{
				if (ke1.getKeyCode() == KeyEvent.VK_TAB)
				{btnSave.requestFocus();}
			}
			public void KeyReleased(KeyEvent ke1) {}
			public void KeyTyped(KeyEvent ke1) {}
		});

		pnlMid.setBackground(Color.white);

		btnRefresh.setToolTipText("Refresh Database");
		btnRefresh.setBorder(BorderFactory.createRaisedBevelBorder());
		btnRefresh.setMnemonic('B');
		btnRefresh.setText("REFRESH DB");
		btnRefresh.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnRefresh.setIcon(imgRef);
		btnRefresh.setBounds(new Rectangle(200, 38, 149, 28));
		btnRefresh.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{btnRefresh_actionPerformed(e);}
		});

		cboType.setMaximumRowCount(4);
		cboType.setBounds(new Rectangle(115, 156, 143, 20));
		cboType.setBackground(Color.white);
		cboType.addItem("Admin");
		cboType.addItem("IS Manager");
		cboType.addItem("Manager");
		cboType.addItem("Hardware Eng.");
		cboType.addItem("Hardware Inv. Eng.");
		cboType.addItem("Mobile Inv. Staff");
		cboType.addItem("Communication Eng");
		cboType.addItem("Software Staff");
		cboType.addItem("Operator");

		SPtxtRem.getViewport().setBackground(Color.white);
		SPtxtRem.setBounds(new Rectangle(115, 181, 425, 51));
		lblPicture.setText("");
		lblPicture.setBounds(new Rectangle(6, 7, 273, 42));
		lblPicture.setIcon(imgSearch);
		lblPic.setText("");
		lblPic.setBounds(new Rectangle(0, 0, 210, 444));
		lblPic.setIcon(new ImageIcon("./Images/pid.jpg"));
		txtName.setFont(new Font("Tahoma", 1, 12));
		txtName.setCaretColor(Color.blue);
		txtName.setBounds(new Rectangle(115, 8, 143, 20));
		txtName.setText("");
		txtName.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtName.selectAll();}
			public void focusLost(FocusEvent f)	{}
		});

		lblName.setBounds(new Rectangle(10, 10, 87, 16));
		lblName.setText("NAME");
		lblName.setFont(new java.awt.Font("Tahoma", 1, 12));

		lblDesg.setBounds(new Rectangle(10, 34, 93, 16));
		lblDesg.setText("DESIGNATION");
		lblDesg.setFont(new java.awt.Font("Tahoma", 1, 12));
		lblDept.setBounds(new Rectangle(10, 59, 87, 16));
		lblDept.setText("DEPARTMENT");
		lblDept.setFont(new java.awt.Font("Tahoma", 1, 12));

		lblExt.setBounds(new Rectangle(304, 59, 87, 16));
		lblExt.setText("EXT #");
		lblExt.setFont(new java.awt.Font("Tahoma", 1, 12));
		lblExt.setHorizontalAlignment(SwingConstants.RIGHT);
		txtExt.setFont(new Font("Tahoma", 1, 12));
		txtExt.setCaretColor(Color.blue);
		txtExt.setBounds(new Rectangle(403, 57, 115, 20));
		txtExt.setText("");
		txtExt.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtExt.selectAll();}
			public void focusLost(FocusEvent f)	{}
		});

		txtExt.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1){}
			public void keyTyped(KeyEvent ke1)
			{
				if(txtExt.getText().length()>=5){ke1.consume();}
				if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==8)) {}
				else ke1.consume();
			}
		});

		lblDH.setBounds(new Rectangle(10, 83, 87, 16));
		lblDH.setText("DEPT. HEAD");
		lblDH.setFont(new java.awt.Font("Tahoma", 1, 12));
		txtDH.setFont(new Font("Tahoma", 1, 12));
		txtDH.setCaretColor(Color.blue);
		txtDH.setBounds(new Rectangle(115, 82, 143, 20));
		txtDH.setText("");
		txtDH.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtDH.selectAll();}
			public void focusLost(FocusEvent f) {}
		});

		lblEmpCode1.setBounds(new Rectangle(10, 108, 87, 16));
		lblEmpCode1.setText("HEAD DESG.");
		lblEmpCode1.setFont(new java.awt.Font("Tahoma", 1, 12));
		txtHD.setFont(new Font("Tahoma", 1, 12));
		txtHD.setCaretColor(Color.blue);
		txtHD.setBounds(new Rectangle(115, 107, 143, 20));
		txtHD.setText("");
		txtHD.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtHD.selectAll();}
			public void focusLost(FocusEvent f)	{}
		});

		lblBU.setBounds(new Rectangle(10, 132, 111, 16));
		lblBU.setText("BUSSINESS UNIT");
		lblBU.setFont(new java.awt.Font("Tahoma", 1, 12));

		txtAMT.setFont(new Font("Tahoma", 1, 12));
		txtAMT.setCaretColor(Color.blue);
		txtAMT.setBounds(new Rectangle(403, 82, 115, 20));
		txtAMT.setText("");
		txtAMT.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtAMT.selectAll();}
			public void focusLost(FocusEvent f){}
		});

		txtAMT.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1) {}
			public void keyTyped(KeyEvent ke1)
			{
				if(txtAMT.getText().length()>=5){ke1.consume();}
				if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==8) || (ke1.getKeyChar()==46)) {}
				else ke1.consume();
			}
		});

		lblAMT.setBounds(new Rectangle(304, 83, 87, 16));
		lblAMT.setText("APP. MB. TK");
		lblAMT.setFont(new java.awt.Font("Tahoma", 1, 12));
		lblAMT.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDOJ.setFont(new java.awt.Font("Tahoma", 1, 12));
		lblDOJ.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDOJ.setText("JOINING DATE");
		lblDOJ.setBounds(new Rectangle(304, 108, 87, 16));
		txtDOJ.setText("");
		txtDOJ.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtDOJ.selectAll();}
			public void focusLost(FocusEvent f){}
		});

		txtDOJ.setBounds(new Rectangle(403, 107, 115, 20));
		txtDOJ.setCaretColor(Color.blue);
		txtDOJ.setFont(new Font("Tahoma", 1, 12));
		txtDOJ.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1){}
			public void keyTyped(KeyEvent ke1)
			{
				if(txtDOJ.getText().length()>=10){ke1.consume();}
				if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==45) || (ke1.getKeyChar()==8)) {}//45- 8BackSpace
				else ke1.consume();
			}
		});

		lblDOP.setFont(new java.awt.Font("Tahoma", 1, 12));
		lblDOP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDOP.setText("PROMOTION DATE");
		lblDOP.setBounds(new Rectangle(276, 132, 115, 16));

		txtDOP.setText("");
		txtDOP.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtDOP.selectAll();}
			public void focusLost(FocusEvent f){}
		});

		txtDOP.setBounds(new Rectangle(403, 132, 115, 20));
		txtDOP.setCaretColor(Color.blue);
		txtDOP.setFont(new Font("Tahoma", 1, 12));
		txtDOP.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1){}
			public void keyTyped(KeyEvent ke1)
			{
				if(txtDOP.getText().length()>=10){ke1.consume();}
				if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==45) || (ke1.getKeyChar()==8)) {}
				else ke1.consume();
			}
		});

		lblEmpCode.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
		btnSelect.setToolTipText("Select a Particular User Record");
		btnSelect.setBorder(BorderFactory.createRaisedBevelBorder());
		btnSelect.setMnemonic('O');
		btnSelect.setIcon(imgTab);
		btnSelect.setBounds(new Rectangle(261, 7, 22, 23));
		btnSelect.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ btnSelect_actionPerformed(e); }
		});

		this.getContentPane().add(pnlTop, null);
		pnlMid.add(btnNew, null);
		pnlMid.add(btnSave, null);
		pnlMid.add(btnClose, null);
		pnlMid.add(btnCancel, null);
		pnlMid.add(btnEdit, null);
		pnlMid.add(btnDelete, null);
		pnlMid.add(btnRefresh, null);
		pnlMid.add(lblRec, null);
		pnlMid.add(btnPrevious, null);
		pnlMid.add(btnFirst, null);
		pnlMid.add(btnLast, null);
		pnlMid.add(btnNext, null);
		this.getContentPane().add(pnlBottom, null);
		pnlTop.add(btnDOP, null);
		pnlTop.add(lblEmail, null);
		pnlTop.add(txtEmail, null);
		pnlTop.add(cboDesg, null);
		pnlTop.add(cboDept, null);
		pnlTop.add(cboBU, null);

		lblEmpCode.setFont(new java.awt.Font("Tahoma", 1, 12));
		lblEmpCode.setText("EMP. CODE");
		lblEmpCode.setBounds(new Rectangle(286, 10, 105, 16));
		jLabel3.setBounds(new Rectangle(277, 34, 114, 16));
		jLabel3.setText("Password");
		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
		lblUT.setBounds(new Rectangle(10, 157, 87, 16));
		lblUT.setText("USER TYPE");
		lblUT.setFont(new java.awt.Font("Tahoma", 1, 12));
		lblRem.setBounds(new Rectangle(10, 181, 87, 16));
		lblRem.setText("REMARKS");
		lblRem.setFont(new java.awt.Font("Tahoma", 1, 12));

		txtEmpCode.setText("");
		txtEmpCode.setBounds(new Rectangle(403, 8, 115, 20));
		txtEmpCode.setCaretColor(Color.blue);
		txtEmpCode.setFont(new Font("Tahoma", 1, 12));
		txtEmpCode.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtEmpCode.selectAll();}
			public void focusLost(FocusEvent f)
			{
				String a = txtEmpCode.getText();
				txtEmpCode.setText(a.toUpperCase());
			}
		});
		txtEmpCode.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1){}
			public void keyTyped(KeyEvent ke1)
			{
				if(txtEmpCode.getText().length()>=6){ke1.consume();}
				if((ke1.getKeyChar()==32)){ke1.consume();}//32Space
			}
		});

		txtPassword.setBounds(new Rectangle(403, 33, 115, 20));
		txtPassword.setText("");
		txtPassword.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtPassword.selectAll();}
			public void focusLost(FocusEvent f){}
		});
		txtPassword.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1){}
			public void keyTyped(KeyEvent ke1)
			{
				if(txtPassword.getText().length()>=10){ke1.consume();}
				if((ke1.getKeyChar()==32)){ke1.consume();}//32Space
			}
		});

		txtPassword.setCaretColor(Color.blue);
		txtPassword.setFont(new Font("Tahoma", 1, 12));

		pnlMid.setBorder(titledBorder1);
		pnlMid.setBounds(new Rectangle(213, 254, 548, 77));

		this.setTitle("USER MANAGER");
		this.setFrameIcon(imgIco);
		this.setResizable(false);
		this.setIconifiable(true);
		this.setClosable(true);
		this.setResizable(false);
		this.setFrameIcon(new ImageIcon("./Images/Login.png"));
		this.setSize(new Dimension(780, 462));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		setButtons(true);
		setFields(false);

		getComboData("SELECT * FROM Desg ORDER BY Designation;",cboDesg);
		getComboData("SELECT * FROM Dept ORDER BY Department;",cboDept);
		getComboData("SELECT * FROM BU ORDER BY BU;",cboBU);

		//REFRESH...
		getConnected();

	}//Cons

	/**
	*	Connects Table
	*
	*/

	public void getConnected()
	{
		//CONNECT TABLE
		try
		{
			usercon.Connect();
		}catch(RemoteException re){ System.out.println("Client [frmUsers]: Open Error");System.out.println("Error: "+re.getMessage());}

		//DISPLAY DATA RMI
		try
		{
			usr=usercon.moveNext();
			display();
		}catch(RemoteException re){ System.out.println("Client [frmUsers]: Show Error");System.out.println("Error: "+re.getMessage());}
	}

	/**
	*	Display Data
	*
	*/

	public void display()
	{
		clearFields();
		txtEmpCode.setText(usr.getEmpCode());
		txtPassword.setText(usr.getPass());
		txtName.setText(usr.getName());
		cboDesg.setSelectedItem(usr.getDesignation());
		cboDept.setSelectedItem(usr.getDepartment());
		txtExt.setText(usr.getExt());
		txtDH.setText(usr.getDeptHead());
		txtHD.setText(usr.getHeadDesg());
		txtDOJ.setText(usr.getDOJ());
		txtDOP.setText(usr.getDOP());
		cboBU.setSelectedItem(usr.getBU());
		txtAMT.setText(usr.getAppMBamt());
		cboType.setSelectedItem(usr.getUserType());
		txtEmail.setText(usr.getEmail());
		txtRemarks.setText(usr.getRemarks());
	}

	/**
	*	Clear Text From Fields
	*
	*/

	public void clearFields()
	{
		txtEmpCode.setText("");
		txtPassword.setText("");
		txtName.setText("");
		txtExt.setText("");
		txtDH.setText("");
		txtHD.setText("");
		txtAMT.setText("");
		txtDOJ.setText("");
		txtDOP.setText("");
		txtEmail.setText("");
		txtRemarks.setText("");
	}

	/**
	*	Sets Button States
	*
	*/

	public void setButtons(boolean btnValue)
	{
		btnNew.setVisible(btnValue);
		btnEdit.setVisible(btnValue);
		btnSave.setVisible(!btnValue);
		btnCancel.setVisible(!btnValue);
		btnDelete.setEnabled(btnValue);
		btnClose.setEnabled(btnValue);
		btnFirst.setEnabled(btnValue);
		btnPrevious.setEnabled(btnValue);
		btnNext.setEnabled(btnValue);
		btnLast.setEnabled(btnValue);
		btnSelect.setEnabled(btnValue);
		btnRefresh.setEnabled(btnValue);
		btnGo.setEnabled(btnValue);
		btnDOJ.setEnabled(!btnValue);
		btnDOP.setEnabled(!btnValue);
		txtEmpCode.requestFocus();
	}

	/**
	*	Sets Fields States
	*
	*/

	public void setFields(boolean txtValue)
	{
		txtName.setEnabled(txtValue);
		txtEmpCode.setEnabled(txtValue);
		cboDesg.setEnabled(txtValue);
		txtPassword.setEnabled(txtValue);
		cboDept.setEnabled(txtValue);
		txtExt.setEnabled(txtValue);
		txtDH.setEnabled(txtValue);
		txtAMT.setEnabled(txtValue);
		txtHD.setEnabled(txtValue);
		cboBU.setEnabled(txtValue);
		cboType.setEnabled(txtValue);
		txtEmail.setEnabled(txtValue);
		txtRemarks.setEnabled(txtValue);
	}

	/**
	*	Sets Green Signal for Save or Update
	*
	*/

	public void saveData()
	{
		if (isAdd==true)
		{
			if (save()==false)
			{
				JOptionPane.showMessageDialog(null,	"UNABLE TO INSERT NEW RECORD !!!\nPlease try with valid Data ...",
													"Error", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				//BUTTON STATE...
				setButtons(true);
				//FIELD STATE...
				setFields(false);
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
				setButtons(true);
				//FIELD STATE...
				setFields(false);
			}
		}

		//SET FLAG...
		isAdd=false;

	}//saveData

	/**
	*	Requests Server to Add New Record
	*
	*/

	public boolean save()
	{//Save
		boolean savesucc=false;

		//INITIALISE USER OBJECT...
		usr.setEmpCode(txtEmpCode.getText());
		usr.setPass(txtPassword.getText());
		usr.setName(txtName.getText());
		usr.setDesignation(cboDesg.getSelectedItem()+"");
		usr.setDepartment(cboDept.getSelectedItem()+"");
		usr.setExt(txtExt.getText());
		usr.setDeptHead(txtDH.getText());
		usr.setHeadDesg(txtHD.getText());
		usr.setDOJ(txtDOJ.getText());
		usr.setDOP(txtDOP.getText());
		usr.setBU(cboBU.getSelectedItem()+"");
		usr.setAppMBamt(txtAMT.getText());
		usr.setUserType(cboType.getSelectedItem()+"");
		usr.setEmail(txtEmail.getText());
		usr.setRemarks(txtRemarks.getText());


		try
		{
			savesucc = usercon.insertData(usr);
			StartWorking("ADDING NEW RECORD");
			JOptionPane.showMessageDialog(null, "Server: Record Added!", "Information", 1);
			getConnected();

		}catch(RemoteException re)
		{
			System.out.println("Client [frmUsers]: SAVE DATA Error");System.out.println("Error: "+re.getMessage());
			JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmUsers]: "+re.getMessage(),
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
		usr.setEmpCode(txtEmpCode.getText());
		usr.setPass(txtPassword.getText());
		usr.setName(txtName.getText());
		usr.setDesignation(cboDesg.getSelectedItem()+"");
		usr.setDepartment(cboDept.getSelectedItem()+"");
		usr.setExt(txtExt.getText());
		usr.setDeptHead(txtDH.getText());
		usr.setHeadDesg(txtHD.getText());
		usr.setDOJ(txtDOJ.getText());
		usr.setDOP(txtDOP.getText());
		usr.setBU(cboBU.getSelectedItem()+"");
		usr.setAppMBamt(txtAMT.getText());
		usr.setUserType(cboType.getSelectedItem()+"");
		usr.setEmail(txtEmail.getText());
		usr.setRemarks(txtRemarks.getText());

		try
		{
			updatesucc = usercon.updateData(usr);
			StartWorking("UPDATING RECORD");
			JOptionPane.showMessageDialog(null, "Server: Record Updated!", "Information", 1);
			getConnected();

		}catch(RemoteException re)
		{
			System.out.println("Client [frmUsers]: UPDATE DATA Error");System.out.println("Error: "+re.getMessage());
			JOptionPane.showMessageDialog(null, "UPDATE DATA Error\nClient [frmUsers]: "+re.getMessage(),
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
		String strQuery = "DELETE FROM Employees WHERE EmpCode='" + txtEmpCode.getText() +"';";

		int yn;
		yn = JOptionPane.showConfirmDialog(null, "Are you sure you want to DELETE this record ?", "Conformation...",
		JOptionPane.YES_NO_OPTION, 3, imgQ);

		if (yn == JOptionPane.YES_OPTION)
		{
			try
			{
				usercon.DeleteData(strQuery);
				StartWorking("DELETING RECORD");
				JOptionPane.showMessageDialog(null, "Server: Record Deleted!", "Information", 1);
				clearFields();
				getConnected();

			}catch(RemoteException re)
			{
				System.out.println("Client [frmUsers]: DELETE DATA Error");System.out.println("Error: "+re.getMessage());
				JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmUsers]: "+re.getMessage(),
													"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else {}
	}//Delete Data

	/**
	*	Query Server for Particular Data
	*
	*/

	public void getSearchData()
	{//getSearchData
		if (txtSearch.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Search What ?",
												"Information Required...",
			JOptionPane.INFORMATION_MESSAGE, imgExc);
			txtSearch.requestFocus();
		}
		else
		{
			String srchStr = "SELECT * FROM Employees WHERE " + searchType2 + " LIKE '" + searchType1 + "%';";

			try
			{
				if (usercon.isFound(srchStr))
				{
					usr = usercon.SearchData(srchStr);
					StartWorking("LOADING");
					display();
				}
				else
				{
					System.out.println("Record Not Found!");
					JOptionPane.showMessageDialog(null, "Record Not Found!", "Information", JOptionPane.INFORMATION_MESSAGE, imgExc);
				}

			}catch(RemoteException re)
			{System.out.println("Client [frmUsers]: SEARCH DATA Error");System.out.println("Error: "+re.getMessage());}
		}
	}//getSearchData

	void btnRefresh_actionPerformed(ActionEvent e)
	{
		//REFRESH...
		getConnected();
	}

	void btnSelect_actionPerformed(ActionEvent e)
	{

		String Querry=null;
		if(txtSearch.getText().equals(""))
		{
			Querry="SELECT * FROM Employees ORDER BY Department,Name;";
		}
		else{Querry="SELECT * FROM Employees WHERE "+searchType2+"='" + searchType1 + "';";}

		frmList lst = new frmList("EMPLOYEE INFORMATION",Querry);
		lst.setVisible(true);

		String t[][] = lst.getType();
		if(t!=null)
		{
			txtEmpCode.setText(t[0][0]);
			txtPassword.setText(t[0][1]);
			txtName.setText(t[0][2]);
			cboDesg.setSelectedItem(t[0][3]);
			cboDept.setSelectedItem(t[0][4]);
			txtExt.setText(t[0][5]);
			txtDH.setText(t[0][6]);
			txtHD.setText(t[0][7]);
			txtDOJ.setText(t[0][8]);
			txtDOP.setText(t[0][9]);
			cboBU.setSelectedItem(t[0][10]);
			txtAMT.setText(t[0][11]);
			cboType.setSelectedItem(t[0][12]);
			txtEmail.setText(t[0][13]);
			txtRemarks.setText(t[0][14]);
		}
	}

	/**
	*	Query Server Specific Column and Sets Combo Data
	*  @param String strQuery, JComboBox cbo
	*
	*/

	private void getComboData(String Query, JComboBox cbo)
	{
		String ComboData = new String("");
		String strQuery = Query;
		Vector tmp = new Vector();

		try
		{
			tmp = ctccon.getComboData(strQuery,1);

			for (int i = 0;i<tmp.size();i++)
			{
				ComboData = new String("");
				ComboData = tmp.elementAt(i).toString();
				cbo.addItem(ComboData);
			}

		}catch(RemoteException re)
		{
			System.out.println("Client [frmUsers]: GET COMBO DATA Error");System.out.println("Error: "+re.getMessage());
			JOptionPane.showMessageDialog(null,	"GET COMBO DATA Error\nClient [frmUsers]: "+re.getMessage(),
			"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	void btnDOJ_actionPerformed(ActionEvent e)
	{
		frmDate fd = new frmDate("Select Joining Date");
		fd.setSize(new Dimension(212, 163));
		fd.setVisible(true);
		String SDate = fd.createDate();
		txtDOJ.setText(SDate);
	}
	void btnDOP_actionPerformed(ActionEvent e)
	{
		frmDate fd = new frmDate("Select Promotion Date");
		fd.setSize(new Dimension(212, 163));
		fd.setVisible(true);
		String SDate = fd.createDate();
		txtDOP.setText(SDate);
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