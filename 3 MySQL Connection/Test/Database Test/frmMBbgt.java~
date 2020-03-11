package beximtex;
/**
 * <p>Title: BeximTex, Mobile Budget</p>
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

public class frmMBbgt extends JInternalFrame
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
	JLabel lblTID = new JLabel();
	JLabel lblPhoneNo = new JLabel();
	JTextField txtEmpCode = new JTextField();
	JLabel lblBU = new JLabel();
	JTextField txtCCC = new JTextField();
	JLabel lblCCC = new JLabel();
	JTextField txtES = new JTextField();
	JLabel lblES = new JLabel();
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
	MB_BgtController mbbgtcon;
	MB_Bgt mbbgt = new MB_Bgt();

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
	ImageIcon imgTab = new ImageIcon("./Images/table.gif");
	ImageIcon imgSrc = new ImageIcon("./Images/find.png");
	ImageIcon imgRef = new ImageIcon("./Images/db.gif");
	ImageIcon imgHead = new ImageIcon("./Images/touch.gif");
	ImageIcon imgSearch = new ImageIcon("./Images/powerSearch.gif");
	ImageIcon imgExc = new ImageIcon("./Images/exc.gif");
	ImageIcon imgQ = new ImageIcon("./Images/question32.png");

	int yn;
	boolean isAdd = false;
	boolean checkMBNo=false;
	boolean isNo=false;

	String Type[][];
	String SelRow[][];

	String EmpCode = null;
	String TableName = null;

	String CurrentDate = null;
	String TranID = null;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	DecimalFormat df = new DecimalFormat();
	double t=0;
	Date d;

	String SQL = null;
	String SQL1 = null;

	Vector ColHead = new Vector();
	Vector rows = new Vector();

	int TotalCol = 0;
	int Rows = 0;
	int Columns = 0;

	JTextField txtME = new JTextField();
	JLabel lblME = new JLabel();
	JTextField txtPhoneNo = new JTextField();
	JLabel lblMB = new JLabel();
	JLabel lblAB = new JLabel();
	JLabel lblYear = new JLabel();
	JComboBox cboYear = new JComboBox();
	JComboBox cboBU = new JComboBox();
	JTextField txtMB = new JTextField();
	JTextField txtAB = new JTextField();
	JToggleButton btnSim = new JToggleButton();
	JLabel lblHead = new JLabel();

	public frmMBbgt(String ec)
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
			mbbgtcon = (MB_BgtController)Naming.lookup(new ReadHost().getHost() + "MB_BgtController");
			ctccon = (CommonTableController)Naming.lookup(new ReadHost().getHost() + "CommonTableController");

		}catch(Exception ec)
		{
			System.out.println("\n******************************\n       SERVER NOT READY       \n******************************\n");
			System.out.println("Error: "+ec.getMessage());
			JOptionPane.showMessageDialog(null, "SERVER NOT READY!" + "\nError: "+ec.getMessage(),
			"Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		System.out.println("\n******************************\n CLIENT READY [frmMBbgt] \n******************************\n");
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

		this.setTitle("MOBILE PHONE BUDGET");
		this.getContentPane().setLayout(null);
		this.setForeground(Color.white);
		this.setFrameIcon(imgIco);
		this.getContentPane().setBackground(Color.white);
		this.setClosable(true);
		this.setIconifiable(true);
		this.setMaximizable(false);
		this.setSize(new Dimension(596, 472));

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
			public void focusLost(FocusEvent f){}
		});

		lblPhoneNo.setBounds(new Rectangle(278, 37, 106, 24));
		lblPhoneNo.setText("PHONE NO.");
		lblPhoneNo.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblPhoneNo.setHorizontalAlignment(SwingConstants.RIGHT);

		lblBU.setBounds(new Rectangle(252, 8, 41, 24));
		lblBU.setText("BU");
		lblBU.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblBU.setHorizontalAlignment(SwingConstants.RIGHT);

		txtCCC.setText("");
		txtCCC.setBounds(new Rectangle(121, 38, 140, 23));
		txtCCC.setEnabled(true);
		txtCCC.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtCCC.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtCCC.selectAll();}
			public void focusLost(FocusEvent f)	{}
		});

		lblCCC.setText("COST CENTER CODE");
		lblCCC.setBounds(new Rectangle(10, 37, 106, 24));
		lblCCC.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblCCC.setToolTipText("");

		txtES.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtES.setBounds(new Rectangle(399, 67, 140, 23));
		txtES.setText("");
		txtES.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtES.selectAll();}
			public void focusLost(FocusEvent f)
			{
				df.applyPattern("#######.##");
				try
				{
					t = Double.parseDouble(txtES.getText());
				}catch(Exception ex){}
				txtES.setText(df.format(t));
			}
		});
		txtES.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1)
			{
				df.applyPattern("#######.##");
				try
				{
					t = Double.parseDouble(txtES.getText());
				}catch(Exception ex){}
				txtES.setText(df.format(t));
			}
			public void keyTyped(KeyEvent ke1)
			{
				if(txtES.getText().length()>=8){ke1.consume();}
				if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==8) || (ke1.getKeyChar()==46)) {}
				else ke1.consume();
			}
		});

		txtES.setEnabled(true);
		lblES.setToolTipText("");
		lblES.setHorizontalAlignment(SwingConstants.RIGHT);
		lblES.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblES.setBounds(new Rectangle(278, 66, 106, 24));
		lblES.setText("EXP. CEILING");
		txtRemarks.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtRemarks.setBounds(new Rectangle(121, 124, 418, 23));
		txtRemarks.setText("");
		txtRemarks.setEnabled(true);
		txtRemarks.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtRemarks.selectAll();}
			public void focusLost(FocusEvent f){}
		});

		lblRem.setToolTipText("");
		lblRem.setHorizontalAlignment(SwingConstants.LEFT);
		lblRem.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblRem.setBounds(new Rectangle(10, 123, 106, 24));
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
				{ return;}
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
					checkMBNo=false;
					isNo=false;
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
				checkMBNo = false;
				isNo = false;
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
				txtCCC.requestFocus();
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
				checkMBNo = true;
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
				sdf = new SimpleDateFormat("d");
				TranID = TranID + sdf.format(d);
				sdf = new SimpleDateFormat("Hms");
				TranID = TranID + sdf.format(d);
				txtTID.setText("B"+TranID);
				System.out.println("Transaction ID: " + txtTID.getText());
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
					mbbgt=mbbgtcon.moveLast();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmMBbgt]: MOVE LAST Error");System.out.println("Error: "+re.getMessage());}
			}
		});
		btnLast.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{ btnLast.setIcon(imgLO);}
			public void mouseExited(MouseEvent f)
			{ btnLast.setIcon(imgLast);}
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
					mbbgt=mbbgtcon.movePrevious();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmMBbgt]: MOVE PREVIOUS Error");System.out.println("Error: "+re.getMessage());}
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
					mbbgt=mbbgtcon.moveNext();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmMBbgt]: MOVE NEXT Error");System.out.println("Error: "+re.getMessage());}
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
					mbbgt=mbbgtcon.moveFirst();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmMBbgt]: MOVE FIRST Error");System.out.println("Error: "+re.getMessage());}
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
		pnlSearch.setBounds(new Rectangle(7, 335, 572, 98));
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
			public void focusLost(FocusEvent f)	{}
		});

		txtME.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtME.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtME.selectAll();}
			public void focusLost(FocusEvent f)
			{
				df.applyPattern("#######.##");
				try
				{
					t = Double.parseDouble(txtME.getText());
				}catch(Exception ex){}
				txtME.setText(df.format(t));
			}
		});
		txtME.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1){}
			public void keyTyped(KeyEvent ke1)
			{
				if(txtME.getText().length()>=8){ke1.consume();}
				if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==8) || (ke1.getKeyChar()==46)) {}
				else ke1.consume();
			}
		});

		lblME.setToolTipText("");
		lblME.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblME.setBounds(new Rectangle(10, 66, 106, 24));
		lblME.setText("MONTHLY EXP.");
		txtME.setBounds(new Rectangle(121, 67, 140, 23));

		txtPhoneNo.setBounds(new Rectangle(399, 38, 117, 23));
		txtPhoneNo.setEnabled(false);
		txtPhoneNo.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtPhoneNo.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{ txtPhoneNo.selectAll(); }
			public void focusLost(FocusEvent f) {}
		});
		txtPhoneNo.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1){}
			public void keyTyped(KeyEvent ke1)
			{
				if(txtPhoneNo.getText().length()>=10){ke1.consume();}
				if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==8)) {}
				else ke1.consume();
			}
		});

		lblMB.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblMB.setBounds(new Rectangle(10, 94, 101, 24));
		lblMB.setText("MONTHLY BUDGET");
		lblAB.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAB.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblAB.setText("ANNUAL BUDGET");
		lblAB.setBounds(new Rectangle(272, 94, 112, 24));
		lblYear.setHorizontalAlignment(SwingConstants.RIGHT);
		lblYear.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblYear.setText("YEAR");
		lblYear.setBounds(new Rectangle(429, 8, 41, 24));
		cboYear.setBounds(new Rectangle(478, 9, 61, 24));
		cboYear.setMaximumRowCount(10);
		cboYear.setBackground(Color.white);
		cboYear.setFont(new java.awt.Font("Tahoma", 1, 12));
		d = new Date();
		sdf = new SimpleDateFormat("yyyy");
		cboYear.setSelectedItem(sdf.format(d));
		cboYear.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				txtCCC.setText("C"+cboBU.getSelectedItem()+cboYear.getSelectedItem());
				if (checkMBNo && isNo) CalculateMonthlyExp();
			}
		});

		cboBU.setBackground(Color.white);
		cboBU.setMaximumRowCount(4);
		cboBU.setBackground(Color.white);
		cboBU.setToolTipText("");
		cboBU.setBounds(new Rectangle(309, 9, 112, 23));
		txtMB.setBounds(new Rectangle(121, 95, 140, 23));
		txtMB.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtMB.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtMB.selectAll();}
			public void focusLost(FocusEvent f)
			{if(txtMB.getText().equals("")){txtMB.setText("0");txtAB.setText("0");}}
		});
		txtMB.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1){}
			public void keyTyped(KeyEvent ke1)
			{
				if(txtMB.getText().length()>=6){ke1.consume();}
				if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==8) || (ke1.getKeyChar()==46)) {}
				else ke1.consume();
			}
			public void keyReleased(KeyEvent ke1)
			{
				if(!txtMB.getText().equals(""))
				{
					double x = Double.parseDouble(txtMB.getText());
					x = x * 12;txtAB.setText("" + x);
				}
				else{txtAB.setText("0");}
			}
		});

		txtAB.setEnabled(false);
		txtAB.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtAB.setBounds(new Rectangle(399, 95, 140, 23));
		txtAB.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtAB.selectAll();}
			public void focusLost(FocusEvent f){}
		});
		txtAB.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1){}
			public void keyTyped(KeyEvent ke1)
			{
				if(txtAB.getText().length()>=10){ke1.consume();}
				if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==8) || (ke1.getKeyChar()==46)) {}
				else ke1.consume();
			}
		});

		btnSim.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ btnSim_actionPerformed(e); }
		});
		btnSim.setBounds(new Rectangle(517, 38, 22, 23));
		btnSim.setIcon(imgTab);
		btnSim.setText("");
		btnSim.setToolTipText("Show Available Sims");
		lblHead.setBounds(new Rectangle(0, 0, 534, 60));
		lblHead.setIcon(imgHead);
		pnlFields.add(txtEmpCode, null);
		pnlFields.add(lblTID, null);
		pnlFields.add(lblCCC, null);
		pnlFields.add(txtES, null);
		pnlFields.add(txtRemarks, null);
		pnlFields.add(lblME, null);
		pnlFields.add(txtPhoneNo, null);
		pnlFields.add(lblMB, null);
		pnlFields.add(txtTID, null);
		pnlFields.add(txtCCC, null);
		pnlFields.add(txtME, null);
		pnlFields.add(lblAB, null);
		pnlFields.add(lblRem, null);
		pnlFields.add(lblPhoneNo, null);
		pnlFields.add(lblES, null);
		pnlFields.add(cboYear, null);
		pnlFields.add(lblYear, null);
		pnlFields.add(cboBU, null);
		pnlFields.add(lblBU, null);
		pnlFields.add(txtMB, null);
		pnlFields.add(txtAB, null);
		pnlFields.add(btnSim, null);

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
		this.getContentPane().add(TP, null);
		this.getContentPane().add(pnlSearch, null);
		pnlSearch.add(btnGo, null);
		pnlSearch.add(lblPicture, null);
		pnlSearch.add(txtSearch, null);
		pnlSearch.add(cboSearch, null);

		this.getContentPane().add(pnlSearch, null);
		this.getContentPane().add(TP, null);
		this.getContentPane().add(pnlSearch, null);

		this.getContentPane().add(lblHead, null);

		getComboItems();
		getComboData("SELECT * FROM BU ORDER BY BU;",cboBU);
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
			mbbgtcon.Connect();
		}catch(RemoteException re){ System.out.println("Client [frmMBbgt]: Open Error");System.out.println("Error: "+re.getMessage());}

		//DISPLAY DATA RMI
		try
		{
			mbbgt = mbbgtcon.moveNext();
			display();
		}catch(RemoteException re){ System.out.println("Client [frmMBbgt]: Show Error");System.out.println("Error: "+re.getMessage());}

		SQL="SELECT * FROM MB_Budget ORDER BY Year,PhoneNo;";
		getTableData(SQL);
	}

	/**
	*	Sets Button States
	*	@param boolean true or false
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
		btnSim.setEnabled(!btnValue);
	}

	/**
	*	Sets Fields States
	*	@param boolean true or false
	*
	*/

	public void setFields(boolean txtValue)
	{
		cboBU.setEnabled(txtValue);
		cboYear.setEnabled(txtValue);
		txtCCC.setEnabled(txtValue);
		//txtPhoneNo.setEnabled(txtValue);
		txtME.setEnabled(txtValue);
		txtES.setEnabled(txtValue);
		txtMB.setEnabled(txtValue);
		//txtAB.setEnabled(txtValue);
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
		txtPhoneNo.setText("");
		txtME.setText("");
		txtES.setText("");
		txtMB.setText("");
		txtAB.setText("");
		txtRemarks.setText("");
	}

	/**
	*	Display Data
	*
	*/

	public void display()
	{
		txtTID.setText(mbbgt.getTransactionID());
		cboBU.setSelectedItem(mbbgt.getBU());
		cboYear.setSelectedItem(mbbgt.getYear());
		txtCCC.setText(mbbgt.getCCC());
		txtPhoneNo.setText(mbbgt.getPhoneNo());
		txtME.setText(mbbgt.getMonthlyExp());
		txtES.setText(mbbgt.getExpCeiling());
		txtMB.setText(mbbgt.getMonthlyBgt());
		txtAB.setText(mbbgt.getAnnualBgt());
		//EmpCode (10)
		txtRemarks.setText(mbbgt.getRemarks());
	}

	/**
	*	Checks the Fields
	*
	*	@return boolean true or false value
	*/

	public boolean checkFields()
	{
		if (txtCCC.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide a Cost Center Code!","Missing Information",JOptionPane.ERROR_MESSAGE);txtCCC.requestFocus();return false;}
		if (txtPhoneNo.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide a PhoneNo!","Missing Information",JOptionPane.ERROR_MESSAGE);txtPhoneNo.requestFocus();return false;}
		if (txtME.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide Monthly Expense!","Missing Information",JOptionPane.ERROR_MESSAGE);txtME.requestFocus();return false;}
		if (txtES.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide Expense Ceiling!","Missing Information",JOptionPane.ERROR_MESSAGE);txtES.requestFocus();return false;}
		if (txtMB.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide Monthly Budget!","Missing Information",JOptionPane.ERROR_MESSAGE);txtMB.requestFocus();return false;}
		if (txtAB.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide Annual Budget!","Missing Information",JOptionPane.ERROR_MESSAGE);txtAB.requestFocus();return false;}
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
		mbbgt.setTransactionID(txtTID.getText());
		mbbgt.setBU(cboBU.getSelectedItem()+"");
		mbbgt.setYear(cboYear.getSelectedItem()+"");
		mbbgt.setCCC(txtCCC.getText());
		mbbgt.setPhoneNo(txtPhoneNo.getText());
		mbbgt.setMonthlyExp(txtME.getText());
		mbbgt.setExpCeiling(txtES.getText());
		mbbgt.setMonthlyBgt(txtMB.getText());
		mbbgt.setAnnualBgt(txtAB.getText());
		mbbgt.setEmpCode(EmpCode);
		mbbgt.setRemarks(txtRemarks.getText());

		try
		{
			savesucc = mbbgtcon.insertData(mbbgt);
			StartWorking("ADDING NEW RECORD");
			JOptionPane.showMessageDialog(null, "Server: Record Added!", "Information", 1);
			getConnected();

		}catch(RemoteException re)
		{
			System.out.println("Client [frmMBbgt]: SAVE DATA Error");System.out.println("Error: "+re.getMessage());
			JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmMBbgt]: "+re.getMessage(),
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
		mbbgt.setTransactionID(txtTID.getText());
		mbbgt.setBU(cboBU.getSelectedItem()+"");
		mbbgt.setYear(cboYear.getSelectedItem()+"");
		mbbgt.setCCC(txtCCC.getText());
		mbbgt.setPhoneNo(txtPhoneNo.getText());
		mbbgt.setMonthlyExp(txtME.getText());
		mbbgt.setExpCeiling(txtES.getText());
		mbbgt.setMonthlyBgt(txtMB.getText());
		mbbgt.setAnnualBgt(txtAB.getText());
		mbbgt.setEmpCode(EmpCode);
		mbbgt.setRemarks(txtRemarks.getText());

		try
		{
			updatesucc = mbbgtcon.updateData(mbbgt);
			StartWorking("UPDATING RECORD");
			JOptionPane.showMessageDialog(null, "Server: Record Updated!", "Information", 1);
			getConnected();

		}catch(RemoteException re)
		{
			System.out.println("Client [frmMBbgt]: UPDATE DATA Error");System.out.println("Error: "+re.getMessage());
			JOptionPane.showMessageDialog(null, "UPDATE DATA Error\nClient [frmMBbgt]: "+re.getMessage(),
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
		String strQuery = "DELETE FROM MB_Budget WHERE TransactionID='" + txtTID.getText() + "';";

		int yn;
		yn = JOptionPane.showConfirmDialog(null, "Are you sure you want to DELETE this record ?", "Conformation...",
		JOptionPane.YES_NO_OPTION, 3, imgQ);

		if (yn == JOptionPane.YES_OPTION)
		{
			try
			{
				mbbgtcon.DeleteData(strQuery);
				StartWorking("DELETING RECORD");
				JOptionPane.showMessageDialog(null, "Server: Record Deleted!", "Information", 1);
				clearFields();
				getConnected();

			}catch(RemoteException re)
			{
				System.out.println("Client [frmMBbgt]: DELETE DATA Error");System.out.println("Error: "+re.getMessage());
				JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmMBbgt]: "+re.getMessage(),
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
			System.out.println("Client [frmMBbgt]: GET TABLE DATA Error");System.out.println("Error: "+re.getMessage());
			JOptionPane.showMessageDialog(null, "GET TABLE DATA Error\nClient [frmMBbgt]: "+re.getMessage(),
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
					txtTID.setText(SelRow[0][0]);cboBU.setSelectedItem(SelRow[0][1]);cboYear.setSelectedItem(SelRow[0][2]);txtCCC.setText(SelRow[0][3]);txtPhoneNo.setText(SelRow[0][4]);txtME.setText(SelRow[0][5]);txtES.setText(SelRow[0][6]);txtMB.setText(SelRow[0][7]);txtAB.setText(SelRow[0][8]);txtRemarks.setText(SelRow[0][9]);
				}
				else if (x.length < 1)
				{
					JOptionPane.showMessageDialog(null, "Please Select One Item!",
					"Information Required...",
					JOptionPane.ERROR_MESSAGE);
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
		int[] sz = new int[11];
		sz[0]=100;sz[1]=100;sz[2]=50;sz[3]=100;sz[4]=70;sz[5]=70;sz[6]=70;sz[7]=70;
		sz[8]=70;sz[9]=50;sz[10]=200;
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
			JOptionPane.showMessageDialog(null, "Search What ?",
			"Information Required...",
			JOptionPane.INFORMATION_MESSAGE, imgExc);
			txtSearch.requestFocus();
		}
		else
		{
			SQLString = "SELECT * FROM MB_Budget WHERE " + cboSearch.getSelectedItem().toString() + "='" + txtSearch.getText() + "';";

			try
			{
				if (mbbgtcon.isFound(SQLString))
				{
					mbbgt = mbbgtcon.SearchData(SQLString);
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
			{System.out.println("Client [frmMBbgt]: SEARCH DATA Error");System.out.println("Error: "+re.getMessage());}
		}
	}

	/**
	*	Adding Combo Items
	*
	*/

	void getComboItems()
	{
		for (int i=1990;i<=2020;i++)
		{
			cboYear.addItem(String.valueOf(i));
		}

		cboSearch.addItem("BU");
		cboSearch.addItem("Year");
		cboSearch.addItem("CCC");
		cboSearch.addItem("PhoneNo");
	}

	void btnSim_actionPerformed(ActionEvent e)
	{
		frmList lst = new frmList("PHONE NUMBERS",
		"SELECT MB_Issue.PhoneNo,Employees.Name,Employees.Department,Employees.AppMBamt AS 'Ceiling',Employees.BU FROM MB_Issue,Employees WHERE MB_Issue.IssueTo=Employees.EmpCode AND Employees.AppMBamt<>0 ORDER BY Employees.Department,Employees.Name;");
		lst.setVisible(true);
		String t[][] = lst.getType();
		if(t!=null)
		{
			txtPhoneNo.setText(t[0][0]);txtES.setText(t[0][3]);cboBU.setSelectedItem(t[0][4]);
			isNo=true;
			if (checkMBNo && isNo) CalculateMonthlyExp();
			txtMB.requestFocus();
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
			System.out.println("Client [frmMBbgt]: GET COMBO DATA Error");System.out.println("Error: "+re.getMessage());
			JOptionPane.showMessageDialog(null,	"GET COMBO DATA Error\nClient [frmMBbgt]: "+re.getMessage(),
			"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	*	Checks that the record already exists or not
	*
	*/

	private boolean CheckData()
	{
		String srchStr = "SELECT * FROM MB_Budget WHERE Year='"+cboYear.getSelectedItem()+"' AND PhoneNo='"+txtPhoneNo.getText()+"';";

		try
		{
			if (mbbgtcon.isFound(srchStr)) { return true; }
			else {return false;}

		}catch(RemoteException re)
		{System.out.println("Client [frmMBbgt]: CHECK DATA Error");System.out.println("Error: "+re.getMessage());return false;}
	}

	/**
	*	Calculates Monthly Expense
	*
	*/

	private void CalculateMonthlyExp()
	{
		String y = "" + cboYear.getSelectedItem();
		String strQuery = "SELECT SUM(Amount) from MB_Bill WHERE MobileNo='" + txtPhoneNo.getText() + "' AND YEAR='" + y + "';";
		String z = new String();

		int rAmount=0;

		try
		{
			if (mbbgtcon.isFound(strQuery))
			{
				z = ctccon.getDataItem(strQuery);
				System.out.println("Monthly Exp is"+ z +".");

				if((!z.equals("")) || (z!=null))
				{
					try
					{
						rAmount = Integer.parseInt(z);
					}catch(NumberFormatException ex){System.out.println("Exception OCCURED"+ex);}

					System.out.println("Total Amount [Year "+y+"]: "+rAmount);rAmount=rAmount/12;
					System.out.println("Average Amount [Year "+y+"]: "+rAmount);
					txtME.setText(""+rAmount);
				}
				else{System.out.println("No History Found for PhoneNo:"+txtPhoneNo.getText()+" in Year "+y);txtME.setText("0");txtME.requestFocus();}
			}
			else {System.out.println("No History Found for PhoneNo:"+txtPhoneNo);}

		}catch(RemoteException re)
		{System.out.println("Client [frmMBbgt]: CALCULATE MONTHLY EXPENSE Error");System.out.println("Error: "+re.getMessage());}
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