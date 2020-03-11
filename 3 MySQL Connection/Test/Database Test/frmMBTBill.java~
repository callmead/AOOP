package beximtex;
/**
 * <p>Title: BeximTex, Mobile Section T&T Bills</p>
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
import java.text.*;
import java.util.*;
import java.util.Date;

import java.rmi.*;

public class frmMBTBill extends JInternalFrame
{//Class

	JTabbedPane TP = new JTabbedPane();
	JPanel pnlReg = new JPanel();
	JPanel pnlDV = new JPanel();
	TitledBorder titledBorder1;
	TitledBorder titledBorder2;
	TitledBorder titledBorder3;
	JPanel pnlFields = new JPanel();
	TitledBorder titledBorder4;
	TitledBorder titledBorder5;
	JTextField txtTID = new JTextField();
	JTextField txtTelNo = new JTextField();
	JLabel lblTID = new JLabel();
	JLabel lblCCC = new JLabel();
	JTextField txtEmpCode = new JTextField();
	JLabel lblTelNo = new JLabel();
	JTextField txtAMT = new JTextField();
	JLabel lblAMT = new JLabel();
	JTextField txtRemarks = new JTextField();
	JLabel lblRem = new JLabel();
	JPanel pnlButtons = new JPanel();
	TitledBorder titledBorder6;
	TitledBorder titledBorder7;
	JButton btnDelete = new JButton();
	JButton btnClose = new JButton();
	JLabel lblRec = new JLabel();
	JButton btnSave = new JButton();
	JButton btnCancel = new JButton();
	JButton btnEdit = new JButton();
	JButton btnNew = new JButton();
	JToggleButton btnLast = new JToggleButton();
	JButton btnRefresh = new JButton();
	JToggleButton btnPrevious = new JToggleButton();
	JToggleButton btnNext = new JToggleButton();
	JToggleButton btnFirst = new JToggleButton();
	TitledBorder titledBorder8;
	JPanel pnlTab = new JPanel();
	TitledBorder titledBorder9;
	TitledBorder titledBorder10;
	JScrollPane sp = new JScrollPane();
	JTable Table = new JTable();
	JPanel pnlFieldsRE = new JPanel();
	TitledBorder titledBorder11;
	TitledBorder titledBorder12;
	JPanel pnlSearch = new JPanel();
	TitledBorder titledBorder13;
	TitledBorder titledBorder14;
	JButton btnGo = new JButton();
	JLabel lblPicture = new JLabel();
	JComboBox cboSearch = new JComboBox();
	JTextField txtSearch = new JTextField();

	//**************************************************************
	//RMI Declare Server Object
	MBTbillController mbtbcon;
	MBTbill mbtb = new MBTbill();

	CommonTableController ctccon;
	//**************************************************************

	ImageIcon imgFirst = new ImageIcon("./Images/iconFirst.gif");
	ImageIcon imgFO = new ImageIcon("./Images/iconFirstOver.gif");
	ImageIcon imgLast = new ImageIcon("./Images/iconLast.gif");
	ImageIcon imgHead = new ImageIcon("./Images/touch.gif");
	ImageIcon imgLO = new ImageIcon("./Images/iconLastOver.gif");
	ImageIcon imgNext = new ImageIcon("./Images/iconNext.gif");
	ImageIcon imgNO = new ImageIcon("./Images/iconNextOver.gif");
	ImageIcon imgPrev = new ImageIcon("./Images/iconPrevious.gif");
	ImageIcon imgPO = new ImageIcon("./Images/iconPreviousOver.gif");
	ImageIcon imgIco = new ImageIcon("./Images/popup.gif");
	ImageIcon imgTab = new ImageIcon("./Images/table.gif");
	ImageIcon imgSrc = new ImageIcon("./Images/find.png");
	ImageIcon imgRef = new ImageIcon("./Images/db.gif");
	ImageIcon imgSearch = new ImageIcon("./Images/powerSearch.gif");
	ImageIcon imgExc = new ImageIcon("./Images/exc.gif");
	ImageIcon imgQ = new ImageIcon("./Images/question32.png");

	int yn;
	boolean isAdd = false;
	String Type[][];
	String SelRow[][];

	String EmpCode = null;
	String TableName = null;

	String CurrentDate = null;
	String TranID = null;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	DecimalFormat df = new DecimalFormat();
	Date d;

	String SQL = null;
	String SQL1 = null;

	Vector ColHead = new Vector();
	Vector rows = new Vector();

	int TotalCol = 0;
	int Rows = 0;
	int Columns = 0;

	JTextField txtTN = new JTextField();
	JLabel lblTN = new JLabel();
	JTextField txtCCC = new JTextField();
	JTextField txtUser = new JTextField();
	JComboBox cboArea = new JComboBox();
	JLabel lblUser = new JLabel();
	JLabel lblUN = new JLabel();
	JLabel lblArea = new JLabel();
	JComboBox cboYear = new JComboBox();
	JLabel lblYM = new JLabel();
	JComboBox cboMonth = new JComboBox();
	JTextField txtUN = new JTextField();
	JLabel lblHead = new JLabel();

	public frmMBTBill(String ec)
	{//Cons
		EmpCode = ec;
		try {jbInit();}
		catch(Exception e){System.exit(0);}
	}//Cons

	private void jbInit() throws Exception
	{//jbInit

		//**************************************************************
	    //getConnectedion: getConnecteds with Server
		try
		{
			mbtbcon = (MBTbillController)Naming.lookup(new ReadHost().getHost() + "MBTbillController");
			ctccon = (CommonTableController)Naming.lookup(new ReadHost().getHost() + "CommonTableController");

		}catch(Exception ec)
		{
			System.out.println("\n******************************\n       SERVER NOT READY       \n******************************\n");
			System.out.println("Error: "+ec.getMessage());
			JOptionPane.showMessageDialog(null, "SERVER NOT READY!" + "\nError: "+ec.getMessage(),
			"Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		System.out.println("\n******************************\n CLIENT READY [frmMBTbill] \n******************************\n");
		//**************************************************************

		titledBorder1 = new TitledBorder("");
		titledBorder2 = new TitledBorder("");
		titledBorder3 = new TitledBorder("");
		titledBorder4 = new TitledBorder("");
		titledBorder5 = new TitledBorder("");
		titledBorder6 = new TitledBorder("");
		titledBorder7 = new TitledBorder("");
		titledBorder8 = new TitledBorder("");
		titledBorder9 = new TitledBorder("");
		titledBorder10 = new TitledBorder("");
		titledBorder11 = new TitledBorder("");
		titledBorder12 = new TitledBorder("");
		titledBorder13 = new TitledBorder("");
		titledBorder14 = new TitledBorder("");

		this.setTitle("T&T BILLING");
		this.getContentPane().setLayout(null);
		this.setForeground(Color.white);
		this.setFrameIcon(imgIco);
		this.getContentPane().setBackground(Color.white);
		this.setClosable(true);
		this.setIconifiable(true);
		this.setMaximizable(false);
		this.setSize(new Dimension(596, 473));

		TP.setBackground(Color.lightGray);
		TP.setFont(new java.awt.Font("Monospaced", 1, 12));
		TP.setForeground(Color.white);
		TP.setBounds(new Rectangle(7, 42, 572, 285));

		pnlReg.setBackground(Color.white);
		pnlReg.setForeground(Color.white);
		pnlReg.setBorder(titledBorder2);
		pnlReg.setLayout(null);
		pnlDV.setBackground(Color.white);
		pnlDV.setBorder(titledBorder3);
		pnlDV.setLayout(null);
		pnlFields.setBackground(Color.white);
		pnlFields.setBorder(titledBorder5);
		pnlFields.setBounds(new Rectangle(8, 9, 550, 160));
		pnlFields.setLayout(null);

		lblTID.setText("TRANSACTION ID");
		lblTID.setBounds(new Rectangle(10, 8, 102, 24));
		lblTID.setFont(new java.awt.Font("Tahoma", 1, 11));

		txtTID.setText("");
		txtTID.setBounds(new Rectangle(121, 9, 140, 23));
		txtTID.setEnabled(false);
		txtTID.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtTID.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtTID.selectAll();}
			public void focusLost(FocusEvent f) {}
		});


		txtTelNo.setBounds(new Rectangle(399, 38, 140, 23));
		txtTelNo.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtTelNo.setText("");
		txtTelNo.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtTelNo.selectAll();}
			public void focusLost(FocusEvent f) {}
		});
		txtTelNo.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1) {}
			public void keyTyped(KeyEvent ke1)
			{
				if(txtTelNo.getText().length()>=8){ke1.consume();}
				if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==8) || (ke1.getKeyChar()==44)) {}
				else ke1.consume();
			}
		});

		lblCCC.setBounds(new Rectangle(268, 8, 115, 24));
		lblCCC.setText("COST CENTER CODE");
		lblCCC.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblCCC.setHorizontalAlignment(SwingConstants.RIGHT);

		lblTelNo.setBounds(new Rectangle(288, 37, 96, 24));
		lblTelNo.setText("TELEPHONE NO.");
		lblTelNo.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblTelNo.setRequestFocusEnabled(true);
		lblTelNo.setHorizontalAlignment(SwingConstants.RIGHT);

		txtAMT.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtAMT.setBounds(new Rectangle(399, 95, 140, 23));
		txtAMT.setText("");
		txtAMT.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtAMT.selectAll();}
			public void focusLost(FocusEvent f) {}
		});
		txtAMT.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1) {}
			public void keyTyped(KeyEvent ke1)
			{
				if(txtAMT.getText().length()>=8){ke1.consume();}
				if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==8) || (ke1.getKeyChar()==46)) {}
				else ke1.consume();
			}
		});

		txtAMT.setEnabled(true);
		lblAMT.setToolTipText("");
		lblAMT.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAMT.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblAMT.setBounds(new Rectangle(278, 95, 106, 24));
		lblAMT.setText("AMOUNT");
		txtRemarks.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtRemarks.setBounds(new Rectangle(399, 124, 140, 23));
		txtRemarks.setText("");
		txtRemarks.setEnabled(true);
		txtRemarks.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtRemarks.selectAll();}
			public void focusLost(FocusEvent f) {}
		});
		txtRemarks.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1) {}
			public void keyTyped(KeyEvent ke1)
			{
				if(txtRemarks.getText().length()>=50){ke1.consume();}
			}
		});

		lblRem.setToolTipText("");
		lblRem.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRem.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblRem.setBounds(new Rectangle(278, 123, 106, 24));
		lblRem.setText("REMARKS");
		pnlButtons.setBackground(Color.white);
		pnlButtons.setBorder(titledBorder7);
		pnlButtons.setMaximumSize(new Dimension(32767, 32767));
		pnlButtons.setBounds(new Rectangle(8, 175, 550, 74));
		pnlButtons.setLayout(null);
		btnDelete.setBorder(BorderFactory.createRaisedBevelBorder());
		btnDelete.setMnemonic('D');
		btnDelete.setText("DELETE");
		btnDelete.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnDelete.setIcon(new ImageIcon("images/Delete16.gif"));
		btnDelete.setBounds(new Rectangle(352, 36, 91, 28));
		btnDelete.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(txtTID.getText().equals(""))
				{ return; }
				DeleteData();
			}
		});
		btnClose.setBorder(BorderFactory.createRaisedBevelBorder());
		btnClose.setMnemonic('L');
		btnClose.setText("CLOSE");
		btnClose.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnClose.setIcon(new ImageIcon("./Images/close.gif"));
		btnClose.setBounds(new Rectangle(446, 36, 91, 28));
		btnClose.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ dispose(); }
		});
		lblRec.setBackground(Color.white);
		lblRec.setBounds(new Rectangle(199, 10, 150, 21));
		lblRec.setOpaque(true);
		lblRec.setText("");
		lblRec.setFont(new Font("Tahoma", 1, 12));

		btnSave.setBorder(BorderFactory.createRaisedBevelBorder());
		btnSave.setMnemonic('S');
		btnSave.setText("SAVE");
		btnSave.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnSave.setIcon(new ImageIcon("images/Save16.gif"));
		btnSave.setBounds(new Rectangle(10, 36, 91, 28));
		btnSave.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(checkFields()==true)
				{
					if (isAdd)
					{
						if(CheckData()==false)
						{
							if (save()==false)
							{
								JOptionPane.showMessageDialog(null,	"UNABLE TO INSERT NEW RECORD !!!\nPlease try with valid Data ...",
																	"Error", JOptionPane.ERROR_MESSAGE);
							}
							else
							{
								setButton(true);
								setFields(false);
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,	"Record already Exists!",
																"Error", JOptionPane.ERROR_MESSAGE);
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
							setButton(true);
							setFields(false);
						}
					}
					//SET FLAG...
					isAdd=false;
					lblRec.setText("");
				}
			}
		});


		btnCancel.setBorder(BorderFactory.createRaisedBevelBorder());
		btnCancel.setBounds(new Rectangle(104, 36, 91, 28));
		btnCancel.setText("CANCEL");
		btnCancel.setMnemonic('C');
		btnCancel.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnCancel.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setButton(true);
				setFields(false);
				getConnected();
				isAdd = false;
				lblRec.setText("");
			}
		});

		btnEdit.setBorder(BorderFactory.createRaisedBevelBorder());
		btnEdit.setBounds(new Rectangle(104, 36, 91, 28));
		btnEdit.setText("EDIT");
		btnEdit.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnEdit.setMnemonic('E');
		btnEdit.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setButton(false);
				setFields(true);
				cboYear.requestFocus();
				lblRec.setText(" Edit Record... ");
			}
		});

		btnNew.setBorder(BorderFactory.createRaisedBevelBorder());
		btnNew.setBounds(new Rectangle(10, 36, 91, 28));
		btnNew.setText("NEW");
		btnNew.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnNew.setMnemonic('N');
		btnNew.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
			isAdd = true;
			setButton(false);
			setFields(true);
			clearFields();
			txtEmpCode.setText(EmpCode);
			d = new Date();
			CurrentDate = null;
			sdf = new SimpleDateFormat("y");
			TranID = sdf.format(d);
			sdf = new SimpleDateFormat("yyyy");
			cboYear.setSelectedItem(sdf.format(d));
			sdf = new SimpleDateFormat("M");
			TranID = TranID + sdf.format(d);
			cboMonth.setSelectedItem(sdf.format(d));
			sdf = new SimpleDateFormat("d");
			TranID = TranID + sdf.format(d);
			sdf = new SimpleDateFormat("Hms");
			TranID = TranID + sdf.format(d);
			txtTID.setText("MB"+TranID);
			System.out.println("Transaction ID: " + txtTID.getText());

			txtCCC.requestFocus();
			lblRec.setText(" Add New Record... ");
		}
		});

		btnLast.setToolTipText("Last");
		btnLast.setText("");
		btnLast.setIcon(imgLast);
		btnLast.setBounds(new Rectangle(376, 9, 22, 23));
		btnLast.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					mbtb=mbtbcon.moveLast();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmMBTbill]: MOVE LAST Error");System.out.println("Error: "+re.getMessage());}
			}
		});
		btnLast.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
		 	{ btnLast.setIcon(imgLO); }
			public void mouseExited(MouseEvent f)
			{ btnLast.setIcon(imgLast); }
		});
		btnRefresh.setToolTipText("Refresh Database");
		btnRefresh.setBorder(BorderFactory.createRaisedBevelBorder());
		btnRefresh.setMnemonic('B');
		btnRefresh.setIcon(imgRef);
		btnRefresh.setText("REFRESH DB");
		btnRefresh.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnRefresh.setBounds(new Rectangle(199, 36, 149, 28));
		btnRefresh.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ getConnected(); }
		});
		btnPrevious.setToolTipText("Previous");
		btnPrevious.setText("");
		btnPrevious.setIcon(imgPrev);
		btnPrevious.setBounds(new Rectangle(174, 9, 22, 23));
		btnPrevious.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					mbtb=mbtbcon.movePrevious();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmMBTbill]: MOVE PREVIOUS Error");System.out.println("Error: "+re.getMessage());}
			}
		});
		btnPrevious.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{ btnPrevious.setIcon(imgPO); }

			public void mouseExited(MouseEvent f)
			{ btnPrevious.setIcon(imgPrev); }
		});
		btnNext.setToolTipText("Next");
		btnNext.setText("");
		btnNext.setIcon(imgNext);
		btnNext.setBounds(new Rectangle(353, 9, 22, 23));
		btnNext.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					mbtb=mbtbcon.moveNext();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmMBTbill]: MOVE NEXT Error");System.out.println("Error: "+re.getMessage());}
			}
		});
		btnNext.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{ btnNext.setIcon(imgNO); }

			public void mouseExited(MouseEvent f)
			{ btnNext.setIcon(imgNext); }
		});
		btnFirst.setToolTipText("First");
		btnFirst.setText("");
		btnFirst.setIcon(imgFirst);
		btnFirst.setBounds(new Rectangle(150, 9, 22, 23));
		btnFirst.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					mbtb=mbtbcon.moveFirst();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmMBTbill]: MOVE FIRST Error");System.out.println("Error: "+re.getMessage());}
			}
		});
		btnFirst.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{ btnFirst.setIcon(imgFO); }

			public void mouseExited(MouseEvent f)
			{ btnFirst.setIcon(imgFirst); }
		});
		pnlTab.setBounds(new Rectangle(6, 8, 554, 243));
		pnlTab.setLayout(null);
		pnlTab.setBackground(Color.white);
		pnlTab.setBorder(titledBorder9);
		sp.getViewport().setBackground(Color.white);
		sp.setToolTipText("Orders Queue");
		sp.setBounds(new Rectangle(6, 6, 540, 229));
		pnlFieldsRE.setBackground(Color.white);
		pnlFieldsRE.setBorder(titledBorder12);
		pnlFieldsRE.setBounds(new Rectangle(6, 158, 554, 60));
		pnlFieldsRE.setLayout(null);
		pnlSearch.setBackground(Color.white);
		pnlSearch.setBorder(titledBorder14);
		pnlSearch.setBounds(new Rectangle(7, 334, 572, 98));
		pnlSearch.setLayout(null);

		btnGo.setBounds(new Rectangle(459, 60, 91, 28));
		btnGo.setText("  FIND     ");
		btnGo.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ btnGo_actionPerformed(e); }
		});
		btnGo.setIcon(imgSrc);
		btnGo.setFont(new java.awt.Font("Tahoma", 1, 11));
		btnGo.setBorder(BorderFactory.createRaisedBevelBorder());
		lblPicture.setText("");
		lblPicture.setIcon(imgSearch);
		lblPicture.setBounds(new Rectangle(17, 15, 273, 42));
		cboSearch.setBounds(new Rectangle(354, 63, 101, 24));
		cboSearch.setMaximumRowCount(4);
		cboSearch.setBackground(Color.white);
		txtSearch.setFont(new Font("Tahoma", 1, 12));
		txtSearch.setCaretColor(Color.blue);
		txtSearch.setText("");
		txtSearch.setBounds(new Rectangle(19, 63, 330, 24));
		txtSearch.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtSearch.selectAll();}
			public void focusLost(FocusEvent f) {}
		});

		txtTN.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtTN.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtTN.selectAll();}
			public void focusLost(FocusEvent f) {}
		});
		txtTN.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1) {}
			public void keyTyped(KeyEvent ke1)
			{
				if(txtTN.getText().length()>=15){ke1.consume();}
			}
		});

		lblTN.setToolTipText("");
		lblTN.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblTN.setBounds(new Rectangle(10, 66, 106, 24));
		lblTN.setText("TELPHONE NAME");
		txtTN.setBounds(new Rectangle(121, 67, 140, 23));

		txtCCC.setBounds(new Rectangle(398, 9, 140, 23));
		txtCCC.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtCCC.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{ txtCCC.selectAll();}

			public void focusLost(FocusEvent f) {}
		});
		txtCCC.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1) {}
			public void keyTyped(KeyEvent ke1)
			{
				if(txtCCC.getText().length()>=10){ke1.consume();}
			}
		});

		txtUser.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtUser.setText("");
		txtUser.setBounds(new Rectangle(399, 67, 140, 23));
		txtUser.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{ txtUser.selectAll(); }
			public void focusLost(FocusEvent f) {}
		});
		txtUser.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1) {}
			public void keyTyped(KeyEvent ke1)
			{
				if(txtUser.getText().length()>=15){ke1.consume();}
			}
		});

		cboArea.setBackground(Color.white);
		cboArea.setMaximumRowCount(3);
		cboArea.setToolTipText("");
		cboArea.setBounds(new Rectangle(121, 124, 140, 23));
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUser.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblUser.setText("USER NAME");
		lblUser.setBounds(new Rectangle(309, 67, 75, 24));
		lblUN.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblUN.setRequestFocusEnabled(true);
		lblUN.setBounds(new Rectangle(10, 94, 75, 24));
		lblUN.setText("UNIT");
		lblArea.setHorizontalAlignment(SwingConstants.LEFT);
		lblArea.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblArea.setText("AREA");
		lblArea.setBounds(new Rectangle(10, 123, 65, 24));
		cboYear.setBounds(new Rectangle(121, 37, 61, 24));
		cboYear.setMaximumRowCount(10);
		cboYear.setBackground(Color.white);
		cboYear.setFont(new java.awt.Font("Tahoma", 1, 12));
		cboYear.setSelectedItem("2005");
		lblYM.setToolTipText("");
		lblYM.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblYM.setBounds(new Rectangle(10, 37, 106, 24));
		lblYM.setText("YEAR & MONTH");
		cboMonth.setBounds(new Rectangle(209, 37, 52, 24));
		cboMonth.setFont(new java.awt.Font("Tahoma", 1, 12));
		cboMonth.setMaximumRowCount(10);
		cboMonth.setBackground(Color.white);
		txtUN.setBounds(new Rectangle(121, 95, 140, 23));
		txtUN.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtUN.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtUN.selectAll();}
			public void focusLost(FocusEvent f) {}
		});
		txtUN.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1) {}
			public void keyTyped(KeyEvent ke1)
			{
				if(txtUN.getText().length()>=15){ke1.consume();}
			}
		});

		lblHead.setBounds(new Rectangle(0, 0, 534, 60));
		lblHead.setIcon(imgHead);
		pnlFields.add(txtEmpCode, null);
		pnlFields.add(lblTID, null);
		pnlFields.add(txtAMT, null);
		pnlFields.add(txtRemarks, null);
		pnlFields.add(lblTN, null);
		pnlFields.add(txtTelNo, null);
		pnlFields.add(lblUN, null);
		pnlFields.add(txtTID, null);
		pnlFields.add(txtTN, null);
		pnlFields.add(lblRem, null);
		pnlFields.add(lblTelNo, null);
		pnlFields.add(lblAMT, null);
		pnlFields.add(cboYear, null);
		pnlFields.add(lblYM, null);
		pnlFields.add(cboMonth, null);
		pnlFields.add(txtUN, null);
		pnlFields.add(cboArea, null);
		pnlFields.add(lblArea, null);
		pnlFields.add(txtUser, null);
		pnlFields.add(lblUser, null);
		pnlFields.add(txtCCC, null);
		pnlFields.add(lblCCC, null);

		pnlButtons.add(btnEdit, null);
		pnlButtons.add(btnNew, null);
		pnlButtons.add(btnRefresh, null);
		pnlButtons.add(btnSave, null);
		pnlButtons.add(btnDelete, null);
		pnlButtons.add(lblRec, null);
		pnlButtons.add(btnClose, null);
		pnlButtons.add(btnCancel, null);
		pnlButtons.add(btnPrevious, null);
		pnlButtons.add(btnLast, null);
		pnlButtons.add(btnNext, null);
		pnlButtons.add(btnFirst, null);
		pnlReg.add(pnlFields, null);
		pnlReg.add(pnlButtons, null);

		pnlDV.add(pnlTab, null);
		pnlTab.add(sp, null);
		pnlDV.add(pnlFieldsRE, null);
		TP.add(pnlReg, "REGISTER");
		sp.add(Table, null);
		TP.add(pnlDV, "VIEW DATA");
		pnlSearch.add(btnGo, null);
		pnlSearch.add(lblPicture, null);
		pnlSearch.add(txtSearch, null);
		pnlSearch.add(cboSearch, null);

		this.getContentPane().add(TP, null);
		this.getContentPane().add(pnlSearch, null);
		this.getContentPane().add(lblHead, null);

		getComboItems();
		setButton(true);
		setFields(false);
		getConnected();

	}//jbInit

	/**
	*	getConnecteds Table
	*
	*/

	public void getConnected()
	{
		//CONNECT TABLE
		try
		{
			mbtbcon.Connect();
		}catch(RemoteException re){ System.out.println("Client [frmMTBbill]: Open Error");System.out.println("Error: "+re.getMessage());}

		//DISPLAY DATA RMI
		try
		{
			mbtb = mbtbcon.moveNext();
			display();
		}catch(RemoteException re){ System.out.println("Client [frmMTBbill]: Show Error");System.out.println("Error: "+re.getMessage());}

		SQL="SELECT * FROM MB_TBill ORDER BY TransactionID;";
		getTableData(SQL);
	}

	/**
	*	Sets Button States
	*
	*/

	public void setButton(boolean btnValue)
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
		btnRefresh.setEnabled(btnValue);
		btnGo.setEnabled(btnValue);
	}

	/**
	*	Sets Fields States
	*
	*/

	public void setFields(boolean txtValue)
	{
		txtCCC.setEnabled(txtValue);
		txtTelNo.setEnabled(txtValue);
		cboYear.setEnabled(txtValue);
		cboMonth.setEnabled(txtValue);
		txtUser.setEnabled(txtValue);
		txtTN.setEnabled(txtValue);
		txtAMT.setEnabled(txtValue);
		txtUN.setEnabled(txtValue);
		cboArea.setEnabled(txtValue);
		txtRemarks.setEnabled(txtValue);

		cboSearch.setEnabled(!txtValue);
		txtSearch.setEnabled(!txtValue);
	}

	/**
	*	Clear Text From Fields
	*
	*/

	public void clearFields()
	{
		txtTID.setText("");
		txtCCC.setText("");
		txtUser.setText("");
		txtTN.setText("");
		txtTelNo.setText("");
		txtAMT.setText("");
		txtUN.setText("");
		txtRemarks.setText("");
	}

	/**
	*	Display Data
	*
	*/

	public void display()
	{
		txtTID.setText(mbtb.getTransactionID());
		cboYear.setSelectedItem(mbtb.getYear());
		cboMonth.setSelectedItem(mbtb.getMonth());
		txtCCC.setText(mbtb.getCCC());
		txtUser.setText(mbtb.getUserName());
		txtTN.setText(mbtb.getTelName());
		txtTelNo.setText(mbtb.getTelNo());
		txtAMT.setText(mbtb.getAmount());
		txtUN.setText(mbtb.getUnit());
		cboArea.setSelectedItem(mbtb.getArea());
		//EmpCode
		txtRemarks.setText(mbtb.getRemarks());
	}

	/**
	*	Checks the Fields
	*
	*	@return boolean true or false value
	*/

	public boolean checkFields()
	{
		if (txtCCC.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide a Cost Center Code!","Missing Information",JOptionPane.ERROR_MESSAGE);txtCCC.requestFocus();return false;}
		if (txtUser.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide a User Name!","Missing Information",JOptionPane.ERROR_MESSAGE);txtUser.requestFocus();return false;}
		if (txtTN.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide a Telephone Name!","Missing Information",JOptionPane.ERROR_MESSAGE);txtTN.requestFocus();return false;}
		if (txtTelNo.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide a Telephone Number!","Missing Information",JOptionPane.ERROR_MESSAGE);txtTelNo.requestFocus();return false;}
		if (txtAMT.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide Amount!","Missing Information",JOptionPane.ERROR_MESSAGE);txtAMT.requestFocus();return false;}
		if (txtUN.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide a Unit!","Missing Information",JOptionPane.ERROR_MESSAGE);txtUN.requestFocus();return false;}
		if (txtRemarks.getText().equals("")){txtRemarks.setText("-");}
		return true;
	}

	/**
	*	Requests Server to Add New Record
	*
	*	@return boolean true or false value
	*/

	public boolean save()
	{//Save
		boolean savesucc=false;

		//INITIALISE USER OBJECT...
		mbtb.setTransactionID(txtTID.getText());
		mbtb.setYear(cboYear.getSelectedItem()+"");
		mbtb.setMonth(cboMonth.getSelectedItem()+"");
		mbtb.setCCC(txtCCC.getText());
		mbtb.setUserName(txtUser.getText());
		mbtb.setTelName(txtTN.getText());
		mbtb.setTelNo(txtTelNo.getText());
		mbtb.setAmount(txtAMT.getText());
		mbtb.setUnit(txtUN.getText());
		mbtb.setArea(cboArea.getSelectedItem()+"");
		mbtb.setEmpCode(EmpCode);
		mbtb.setRemarks(txtRemarks.getText());

		try
		{
			savesucc = mbtbcon.insertData(mbtb);
			StartWorking("ADDING NEW RECORD");
			JOptionPane.showMessageDialog(null, "Server: Record Added!", "Information", 1);
			getConnected();

		}catch(RemoteException re)
		{
			System.out.println("Client [frmMTBbill]: SAVE DATA Error");System.out.println("Error: "+re.getMessage());
			JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmMTBbill]: "+re.getMessage(),
			"Error", JOptionPane.ERROR_MESSAGE);
			return savesucc;
		}

		return savesucc;
	}//Save

	/**
	*	Requests Server to Update a Specific Record
	*
	*	@return boolean true or false value
	*/

	public boolean editData()
	{//Edit Data
		boolean updatesucc=false;

		//INITIALISE USER OBJECT...
		mbtb.setTransactionID(txtTID.getText());
		mbtb.setYear(cboYear.getSelectedItem()+"");
		mbtb.setMonth(cboMonth.getSelectedItem()+"");
		mbtb.setCCC(txtCCC.getText());
		mbtb.setUserName(txtUser.getText());
		mbtb.setTelName(txtTN.getText());
		mbtb.setTelNo(txtTelNo.getText());
		mbtb.setAmount(txtAMT.getText());
		mbtb.setUnit(txtUN.getText());
		mbtb.setArea(cboArea.getSelectedItem()+"");
		mbtb.setEmpCode(EmpCode);
		mbtb.setRemarks(txtRemarks.getText());

		try
		{
			updatesucc = mbtbcon.updateData(mbtb);
			StartWorking("UPDATING RECORD");
			JOptionPane.showMessageDialog(null, "Server: Record Updated!", "Information", 1);
			getConnected();

		}catch(RemoteException re)
		{
			System.out.println("Client [frmMTBbill]: UPDATE DATA Error");System.out.println("Error: "+re.getMessage());
			JOptionPane.showMessageDialog(null, "UPDATE DATA Error\nClient [frmMTBbill]: "+re.getMessage(),
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
		String strQuery = "DELETE FROM MB_TBill WHERE TransactionID='" + txtTID.getText() + "';";

		int yn;
		yn = JOptionPane.showConfirmDialog(null, "Are you sure you want to DELETE this record ?", "Conformation...",
		JOptionPane.YES_NO_OPTION, 3, imgQ);

		if (yn == JOptionPane.YES_OPTION)
		{
			try
			{
				mbtbcon.DeleteData(strQuery);
				StartWorking("DELETING RECORD");
				JOptionPane.showMessageDialog(null, "Server: Record Deleted!", "Information", 1);
				clearFields();
				getConnected();

			}catch(RemoteException re)
			{
				System.out.println("Client [frmMBbill]: DELETE DATA Error");System.out.println("Error: "+re.getMessage());
				JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmMBbill]: "+re.getMessage(),
													"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else {}
	}//Delete Data

	/**
	*	Gets Table Data
	*	@param String SQL
	*
	*/

	void getTableData(String SQLString)
	{
		try
		{
			rows = ctccon.getRowData(SQLString);
			ColHead = ctccon.getColumnData(SQLString);
			TotalCol = ctccon.getColNo(SQLString);

		}catch(RemoteException re)
		{
			System.out.println("Client [frmMBbill]: GET TABLE DATA Error");System.out.println("Error: "+re.getMessage());
			JOptionPane.showMessageDialog(null, "GET TABLE DATA Error\nClient [frmMBbill]: "+re.getMessage(),
												"Error", JOptionPane.ERROR_MESSAGE);
		}

		Table = new JTable(rows, ColHead);
		setColWidth(SQL, Table);
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
					txtTID.setText(SelRow[0][0]);cboYear.setSelectedItem(SelRow[0][1]);cboMonth.setSelectedItem(SelRow[0][2]);txtCCC.setText(SelRow[0][3]);txtUser.setText(SelRow[0][4]);txtTN.setText(SelRow[0][5]);txtTelNo.setText(SelRow[0][6]);txtAMT.setText(SelRow[0][7]);txtUN.setText(SelRow[0][8]);cboArea.setSelectedItem(SelRow[0][9]);txtRemarks.setText(SelRow[0][11]);
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

	void setColWidth(String SQLString, JTable Table)
	{
		TableColumn column = null;
		int[] sz = new int[12];
		sz[0]=100;sz[1]=70;sz[2]=50;sz[3]=100;sz[4]=120;sz[5]=120;sz[6]=70;sz[7]=70;
		sz[8]=120;sz[9]=70;sz[10]=50;sz[11]=200;
		for (int j = 0; j < TotalCol; ++j)
		{
			column = Table.getColumnModel().getColumn(j);
			column.setPreferredWidth(sz[j]);
		}
	}

	/**
	*	Searching
	*
	*/

	void btnGo_actionPerformed(ActionEvent e)
	{
		String SQLString=null;
		if (txtSearch.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Search What ?", "Information Required...",
			JOptionPane.INFORMATION_MESSAGE, imgExc);
			txtSearch.requestFocus();
		}
		else
		{
			SQLString = "SELECT * FROM MB_TBill WHERE " + cboSearch.getSelectedItem().toString() + "='" + txtSearch.getText() + "';";
			try
			{
				if (mbtbcon.isFound(SQLString))
				{
					mbtb = mbtbcon.SearchData(SQLString);
					StartWorking("LOADING");
					getTableData(SQLString);
					display();
				}
				else
				{
					System.out.println("Record Not Found!");
					JOptionPane.showMessageDialog(null, "Record Not Found!", "Information", JOptionPane.INFORMATION_MESSAGE, imgExc);
					getConnected();
				}

			}catch(RemoteException re)
			{System.out.println("Client [frmMBbill]: SEARCH DATA Error");System.out.println("Error: "+re.getMessage());}
		}
	}

	/**
	*	Adding Combo Items
	*
	*/

	void getComboItems()
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

		cboArea.addItem("South");
		cboArea.addItem("North");

		cboSearch.addItem("CCC");
		cboSearch.addItem("UserName");
		cboSearch.addItem("TelName");
		cboSearch.addItem("Unit");
		cboSearch.addItem("Area");
	}

	/**
	*	Checks that the record already exists or not
	*
	*/

	private boolean CheckData()
	{
		String srchStr = "SELECT * FROM MB_TBill WHERE Year='"+cboYear.getSelectedItem()+"' AND Month='"+cboMonth.getSelectedItem()+"' AND TelNo='"+txtTelNo.getText()+"';";

		try
		{
			if (mbtbcon.isFound(srchStr)) { return true; }
			else {return false;}

		}catch(RemoteException re)
		{System.out.println("Client [frmMBbill]: CHECK DATA Error");System.out.println("Error: "+re.getMessage());return false;}
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