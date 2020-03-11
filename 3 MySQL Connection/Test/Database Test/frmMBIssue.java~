package beximtex;
/**
 * <p>Title: BeximTex, Mobile & Sim Issue</p>
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

public class frmMBIssue extends JInternalFrame
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
	JTextField txtDate = new JTextField();
	JLabel lblTID = new JLabel();
	JLabel lblIssue = new JLabel();
	JTextField txtEmpCode = new JTextField();
	JLabel lblDate = new JLabel();
	JLabel lblIT = new JLabel();
	JTextField txtSID = new JTextField();
	JLabel lblSID = new JLabel();
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
	MBissueController mbiscon;
	MBissue mbis = new MBissue();

	CommonTableController ctccon;
	//**************************************************************

	ImageIcon imgFirst = new ImageIcon("./Images/iconFirst.gif");
	ImageIcon imgFO = new ImageIcon("./Images/iconFirstOver.gif");
	ImageIcon imgLast = new ImageIcon("./Images/iconLast.gif");
	ImageIcon imgLO = new ImageIcon("./Images/iconLastOver.gif");
	ImageIcon imgNext = new ImageIcon("./Images/iconNext.gif");
	ImageIcon imgNO = new ImageIcon("./Images/iconNextOver.gif");
	ImageIcon imgPrev = new ImageIcon("./Images/iconPrevious.gif");
	ImageIcon imgHead = new ImageIcon("./Images/touch.gif");
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
	Date d;

	String SQL = null;

	Vector ColHead = new Vector();
	Vector rows = new Vector();

	int TotalCol = 0;
	int Rows = 0;
	int Columns = 0;

	JLabel lblSO = new JLabel();
	JTextField txtIssue = new JTextField();
	JTextField txtRD = new JTextField();
	JLabel lblRD = new JLabel();
	JLabel lblSName = new JLabel();
	JLabel lblPH = new JLabel();
	JComboBox cboIT = new JComboBox();
	JComboBox cboSO = new JComboBox();
	JTextField txtSName = new JTextField();
	JTextField txtPhone = new JTextField();
	JLabel lblDate1 = new JLabel();
	JTextField txtCCC = new JTextField();
	JToggleButton btnSet = new JToggleButton();
	JToggleButton btnSim = new JToggleButton();
	JToggleButton btnDT = new JToggleButton();
	JToggleButton btnEmp = new JToggleButton();
	JToggleButton btnDT1 = new JToggleButton();
	JLabel lblHead = new JLabel();

	public frmMBIssue(String ec)
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
			mbiscon = (MBissueController)Naming.lookup(new ReadHost().getHost() + "MBissueController");
			ctccon = (CommonTableController)Naming.lookup(new ReadHost().getHost() + "CommonTableController");

		}catch(Exception ec)
		{
			System.out.println("\n******************************\n       SERVER NOT READY       \n******************************\n");
			System.out.println("Error: "+ec.getMessage());
			JOptionPane.showMessageDialog(null, "SERVER NOT READY!" + "\nError: "+ec.getMessage(),
			"Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		System.out.println("\n******************************\n CLIENT READY [frmMBissue] \n******************************\n");
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

		this.setTitle("MOBILE ISSUE");
		this.getContentPane().setLayout(null);
		this.setForeground(Color.white);
		this.setFrameIcon(imgIco);
		this.getContentPane().setBackground(Color.white);
		this.setClosable(true);
		this.setIconifiable(true);
		this.setMaximizable(false);
		this.setSize(new Dimension(596, 470));

		TP.setBackground(Color.lightGray);
		TP.setFont(new java.awt.Font("Monospaced", 1, 12));
		TP.setForeground(Color.white);
		TP.setBounds(new Rectangle(7, 42, 572, 285));

		pnlReg.setBackground(Color.white);
		pnlReg.setForeground(Color.white);
		pnlReg.setBorder(titledBorder2);
		pnlReg.setMinimumSize(new Dimension(1, 1));
		pnlReg.setOpaque(true);
		pnlReg.setPreferredSize(new Dimension(1, 1));
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
		txtTID.setBounds(new Rectangle(112, 9, 140, 23));
		txtTID.setEnabled(false);
		txtTID.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtTID.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtTID.selectAll();}
			public void focusLost(FocusEvent f) {}
		});


		txtDate.setBounds(new Rectangle(289, 9, 78, 23));
		txtDate.setEnabled(false);
		txtDate.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtDate.setText("");

		lblIssue.setBounds(new Rectangle(278, 37, 106, 24));
		lblIssue.setText("ISSUE TO");
		lblIssue.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblIssue.setHorizontalAlignment(SwingConstants.RIGHT);

		lblDate.setBounds(new Rectangle(244, 8, 41, 24));
		lblDate.setText("DATE");
		lblDate.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);


		lblIT.setText("ISSUE TYPE");
		lblIT.setBounds(new Rectangle(10, 37, 106, 24));
		lblIT.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblIT.setToolTipText("");

		txtSID.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtSID.setBounds(new Rectangle(399, 67, 113, 23));
		txtSID.setText("");
		txtSID.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtSID.selectAll();}
			public void focusLost(FocusEvent f)	{}
		});

		txtSID.setEnabled(false);
		lblSID.setToolTipText("");
		lblSID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSID.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblSID.setBounds(new Rectangle(278, 66, 106, 24));
		lblSID.setText("SET");
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
				resetStock();
				setButton(false);
				setFields(true);
				btnDT1.setEnabled(false);
				cboIT.requestFocus();
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
				sdf = new SimpleDateFormat("yyyy-MM-dd");
				CurrentDate = sdf.format(d);
				txtDate.setText(CurrentDate);
				txtRD.setText(CurrentDate);
				d = new Date();
				CurrentDate = null;
				sdf = new SimpleDateFormat("y");
				TranID = sdf.format(d);
				sdf = new SimpleDateFormat("M");
				TranID = TranID + sdf.format(d);
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
					mbis=mbiscon.moveLast();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmMBissue]: MOVE LAST Error");System.out.println("Error: "+re.getMessage());}
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
			{ getConnected();}
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
					mbis=mbiscon.movePrevious();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmMBissue]: MOVE PREVIOUS Error");System.out.println("Error: "+re.getMessage());}
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
					mbis=mbiscon.moveNext();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmMBissue]: MOVE NEXT Error");System.out.println("Error: "+re.getMessage());}
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
					mbis=mbiscon.moveFirst();
					display();
				}catch(RemoteException re){ System.out.println("Client [frmMBissue]: MOVE FIRST Error");System.out.println("Error: "+re.getMessage());}
			}
		});
		btnFirst.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{ btnFirst.setIcon(imgFO); }
			public void mouseExited(MouseEvent f)
			{  btnFirst.setIcon(imgFirst);}
		});
		pnlTab.setBounds(new Rectangle(6, 8, 554, 243));
		pnlTab.setLayout(null);
		pnlTab.setBackground(Color.white);
		pnlTab.setBorder(titledBorder9);
		sp.getViewport().setBackground(Color.white);
		sp.setToolTipText("ISSUE DETAILS");
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

		lblSO.setToolTipText("");
		lblSO.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblSO.setBounds(new Rectangle(10, 66, 106, 24));
		lblSO.setText("SET OWNER");

		txtIssue.setBounds(new Rectangle(399, 38, 113, 23));
		txtIssue.setEnabled(false);
		txtIssue.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtIssue.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{ txtIssue.selectAll(); }
			public void focusLost(FocusEvent f) {}
		});

		txtRD.setEnabled(false);
		txtRD.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtRD.setText("");
		txtRD.setBounds(new Rectangle(112, 124, 115, 23));
		txtRD.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{ txtRD.selectAll(); }
			public void focusLost(FocusEvent f) {}
		});
		txtRD.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke1) {}
			public void keyTyped(KeyEvent ke1)
			{
				if(txtRD.getText().length()>=10){ke1.consume();}
				if((ke1.getKeyChar()>=48 && ke1.getKeyChar()<=57 ) || (ke1.getKeyChar()==45) || (ke1.getKeyChar()==8)) {} //45- 8BackSpace
				else ke1.consume();
			}
		});

		lblRD.setHorizontalAlignment(SwingConstants.LEFT);
		lblRD.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblRD.setText("RETURN DATE");
		lblRD.setBounds(new Rectangle(10, 124, 99, 24));
		lblSName.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblSName.setBounds(new Rectangle(10, 94, 75, 24));
		lblSName.setText("SET NAME");
		txtSName.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblPH.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPH.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblPH.setText("PHONE NO.");
		lblPH.setBounds(new Rectangle(304, 94, 80, 24));
		cboIT.setBackground(Color.white);
		cboIT.setMaximumRowCount(4);
		cboIT.setToolTipText("");
		cboIT.setBounds(new Rectangle(112, 38, 140, 23));
		cboIT.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				if(cboIT.getSelectedItem().equals("Sim Only"))
				{txtSID.setText("-");txtSName.setText("-");btnSet.setEnabled(false);txtPhone.setText("");}
				else if (cboIT.getSelectedItem().equals("Set Only"))
				{txtPhone.setText("-");btnSim.setEnabled(false);btnSet.setEnabled(true);txtSID.setText("");txtSName.setText("");}
				else if (cboIT.getSelectedItem().equals("Both"))
				{btnSim.setEnabled(true);btnSet.setEnabled(true);txtSID.setText("");txtSName.setText("");txtPhone.setText("");}
			}
		});

		cboSO.setBounds(new Rectangle(112, 67, 140, 23));
		cboSO.setBackground(Color.white);
		cboSO.setFont(new java.awt.Font("Tahoma", 1, 11));
		cboSO.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				if(cboSO.getSelectedItem().equals("Own"))
				{txtSID.setText("-");txtSName.setText("-");btnSet.setEnabled(false);txtSID.setEnabled(false);}
				else if (cboIT.getSelectedItem().equals("Company"))
				{txtSID.setEnabled(true);btnSet.setEnabled(true);}
			}
		});

		txtSName.setEnabled(false);
		txtSName.setBounds(new Rectangle(112, 95, 140, 23));
		txtSName.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtSName.selectAll();}
			public void focusLost(FocusEvent f) {}
		});
		txtPhone.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtPhone.selectAll();}
			public void focusLost(FocusEvent f) {}
		});
		txtPhone.setEnabled(false);
		txtPhone.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtPhone.setBounds(new Rectangle(399, 95, 113, 23));
		lblDate1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate1.setFont(new java.awt.Font("Tahoma", 1, 11));
		lblDate1.setText("CCC");
		lblDate1.setBounds(new Rectangle(392, 8, 30, 24));
		txtCCC.setEnabled(true);
		txtCCC.setFont(new java.awt.Font("Tahoma", 1, 11));
		txtCCC.setBounds(new Rectangle(426, 9, 113, 23));
		txtCCC.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent f)
			{txtCCC.selectAll();}
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

		btnSet.setToolTipText("Show Available Sets");
		btnSet.setText("");
		btnSet.setIcon(imgTab);
		btnSet.setBounds(new Rectangle(517, 67, 22, 23));
		btnSet.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ btnSet_actionPerformed(e); }
		});
		btnSim.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ btnSim_actionPerformed(e); }
		});
		btnSim.setBounds(new Rectangle(517, 95, 22, 23));
		btnSim.setIcon(imgTab);
		btnSim.setText("");
		btnSim.setToolTipText("Show Available Sims");
		btnDT.setToolTipText("DATE SELECTOR");
		btnDT.setText("");
		btnDT.setIcon(imgTab);
		btnDT.setBounds(new Rectangle(230, 124, 22, 23));
		btnDT.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ btnDT_actionPerformed(e);	}
		});
		btnEmp.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ btnEmp_actionPerformed(e); }
		});
		btnEmp.setBounds(new Rectangle(517, 38, 22, 23));
		btnEmp.setIcon(imgTab);
		btnEmp.setText("");
		btnEmp.setToolTipText("Show Employee List");
		btnDT1.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ btnDT1_actionPerformed(e); }
		});
		btnDT1.setBounds(new Rectangle(370, 9, 22, 23));
		btnDT1.setIcon(imgTab);
		btnDT1.setText("");
		btnDT1.setToolTipText("DATE SELECTOR");
		lblHead.setBounds(new Rectangle(0, 0, 534, 60));
		lblHead.setIcon(imgHead);
		pnlFields.add(txtEmpCode, null);
		pnlFields.add(lblTID, null);
		pnlFields.add(lblIT, null);
		pnlFields.add(txtSID, null);
		pnlFields.add(txtRemarks, null);
		pnlFields.add(lblSO, null);
		pnlFields.add(txtIssue, null);
		pnlFields.add(lblSName, null);
		pnlFields.add(lblRD, null);
		pnlFields.add(lblPH, null);
		pnlFields.add(lblRem, null);
		pnlFields.add(lblIssue, null);
		pnlFields.add(lblSID, null);
		pnlFields.add(txtPhone, null);
		pnlFields.add(cboIT, null);
		pnlFields.add(cboSO, null);
		pnlFields.add(txtSName, null);
		pnlFields.add(txtRD, null);
		pnlFields.add(txtTID, null);
		pnlFields.add(lblDate, null);
		pnlFields.add(txtDate, null);
		pnlFields.add(lblDate1, null);
		pnlFields.add(txtCCC, null);
		pnlFields.add(btnSet, null);
		pnlFields.add(btnSim, null);
		pnlFields.add(btnDT, null);
		pnlFields.add(btnEmp, null);
		pnlFields.add(btnDT1, null);

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
		TP.add(pnlReg, "ISSUE");
		sp.add(Table, null);
		TP.add(pnlDV, "VIEW DATA");
		this.getContentPane().add(TP, null);
		this.getContentPane().add(pnlSearch, null);
		pnlSearch.add(btnGo, null);
		pnlSearch.add(lblPicture, null);
		pnlSearch.add(txtSearch, null);
		pnlSearch.add(cboSearch, null);

		cboSearch.addItem("SetName");
		cboSearch.addItem("Brand");
		cboSearch.addItem("Model");
		cboSearch.addItem("Quality");
		cboSearch.addItem("Warranty");

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
			mbiscon.Connect();
		}catch(RemoteException re){ System.out.println("Client [frmMTBbill]: Open Error");System.out.println("Error: "+re.getMessage());}

		//DISPLAY DATA RMI
		try
		{
			mbis = mbiscon.moveNext();
			display();
		}catch(RemoteException re){ System.out.println("Client [frmMTBbill]: Show Error");System.out.println("Error: "+re.getMessage());}

		SQL="SELECT * FROM MB_Issue ORDER BY TransactionID;";
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
		btnEmp.setEnabled(!btnValue);
		btnDT.setEnabled(!btnValue);
		btnSet.setEnabled(!btnValue);
		btnSim.setEnabled(!btnValue);
		btnDT1.setEnabled(!btnValue);
	}

	/**
	*	Sets Fields States
	*
	*/

	public void setFields(boolean txtValue)
	{
		txtCCC.setEnabled(txtValue);
		cboIT.setEnabled(txtValue);
		cboSO.setEnabled(txtValue);
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
		txtDate.setText("");
		txtIssue.setText("");
		txtSID.setText("");
		txtSName.setText("");
		txtPhone.setText("");
		txtRD.setText("");
		txtCCC.setText("");
		txtRemarks.setText("");
	}

	/**
	*	Display Data
	*
	*/

	public void display()
	{
		txtTID.setText(mbis.getTransactionID());
		txtDate.setText(mbis.getDate());
		cboIT.setSelectedItem(mbis.getIssueType());
		txtIssue.setText(mbis.getIssueTo());
		cboSO.setSelectedItem(mbis.getSetOwner());
		txtSID.setText(mbis.getSetID());
		txtSName.setText(mbis.getSetName());
		txtPhone.setText(mbis.getPhoneNo());
		txtRD.setText(mbis.getReturnDate());
		txtCCC.setText(mbis.getCCC());
		//EmPCode
		txtRemarks.setText(mbis.getRemarks());


	}

	/**
	*	Checks the Fields
	*
	*	@return boolean true or false value
	*/

	public boolean checkFields()
	{
		if (txtCCC.getText().equals("")){JOptionPane.showMessageDialog(null,"Please provide Cost Center Code!","Missing Information",JOptionPane.ERROR_MESSAGE);txtCCC.requestFocus();return false;}
		if (txtIssue.getText().equals("")){JOptionPane.showMessageDialog(null,"Please select an Employee to whom you want to Issue!","Missing Information",JOptionPane.ERROR_MESSAGE);txtIssue.requestFocus();return false;}
		if (txtSID.getText().equals("")){JOptionPane.showMessageDialog(null,"Please select a Set!","Missing Information",JOptionPane.ERROR_MESSAGE);txtSID.requestFocus();return false;}
		if (txtPhone.getText().equals("")){JOptionPane.showMessageDialog(null,"Please select a Sim!","Missing Information",JOptionPane.ERROR_MESSAGE);txtPhone.requestFocus();return false;}
		if (txtRD.getText().equals("")){JOptionPane.showMessageDialog(null,"Please select Return Date!","Missing Information",JOptionPane.ERROR_MESSAGE);txtRD.requestFocus();return false;}
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
		mbis.setTransactionID(txtTID.getText());
		mbis.setDate(txtDate.getText());
		mbis.setIssueType(cboIT.getSelectedItem()+"");
		mbis.setIssueTo(txtIssue.getText());
		mbis.setSetOwner(cboSO.getSelectedItem()+"");
		mbis.setSetID(txtSID.getText());
		mbis.setSetName(txtSName.getText());
		mbis.setPhoneNo(txtPhone.getText());
		mbis.setReturnDate(txtRD.getText());
		mbis.setCCC(txtCCC.getText());
		mbis.setEmpCode(EmpCode);
		mbis.setRemarks(txtRemarks.getText());

		try
		{
			savesucc = mbiscon.insertData(mbis);
			StartWorking("ADDING NEW RECORD");
			IssueStock();
			JOptionPane.showMessageDialog(null, "Server: Record Added!", "Information", 1);
			getConnected();

		}catch(RemoteException re)
		{
			System.out.println("Client [frmMBissue]: SAVE DATA Error");System.out.println("Error: "+re.getMessage());
			JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmMBissue]: "+re.getMessage(),
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
		mbis.setTransactionID(txtTID.getText());
		mbis.setDate(txtDate.getText());
		mbis.setIssueType(cboIT.getSelectedItem()+"");
		mbis.setIssueTo(txtIssue.getText());
		mbis.setSetOwner(cboSO.getSelectedItem()+"");
		mbis.setSetID(txtSID.getText());
		mbis.setSetName(txtSName.getText());
		mbis.setPhoneNo(txtPhone.getText());
		mbis.setReturnDate(txtRD.getText());
		mbis.setCCC(txtCCC.getText());
		mbis.setEmpCode(EmpCode);
		mbis.setRemarks(txtRemarks.getText());

		try
		{
			updatesucc = mbiscon.updateData(mbis);
			StartWorking("UPDATING RECORD");
			IssueStock();
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
		String strQuery = "DELETE FROM MB_Issue WHERE TransactionID='" + txtTID.getText() + "';";

		int yn;
		yn = JOptionPane.showConfirmDialog(null, "Are you sure you want to DELETE this record ?", "Conformation...",
		JOptionPane.YES_NO_OPTION, 3, imgQ);

		if (yn == JOptionPane.YES_OPTION)
		{
			try
			{
				mbiscon.DeleteData(strQuery);
				StartWorking("DELETING RECORD");
				resetStock();
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
					txtTID.setText(SelRow[0][0]);txtDate.setText(SelRow[0][1]);cboIT.setSelectedItem(SelRow[0][2]);txtIssue.setText(SelRow[0][3]);cboSO.setSelectedItem(SelRow[0][4]);txtSID.setText(SelRow[0][5]);txtSName.setText(SelRow[0][6]);txtPhone.setText(SelRow[0][7]);txtRD.setText(SelRow[0][8]);txtCCC.setText(SelRow[0][9]);txtRemarks.setText(SelRow[0][11]);
				}
				else if (x.length < 1)
				{ JOptionPane.showMessageDialog(null, "Please Select One Item!", "Information Required...", JOptionPane.ERROR_MESSAGE);	}
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
		sz[0]=100;sz[1]=60;sz[2]=70;sz[3]=50;sz[4]=70;sz[5]=100;sz[6]=100;sz[7]=70;
		sz[8]=60;sz[9]=100;sz[10]=50;sz[11]=200;
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
			JOptionPane.showMessageDialog(null, "Search What ?", "Information Required...", JOptionPane.INFORMATION_MESSAGE, imgExc);
			txtSearch.requestFocus();
		}
		else
		{
			SQLString = "SELECT * FROM MB_Issue WHERE " + cboSearch.getSelectedItem().toString() + "='" + txtSearch.getText() + "';";
			try
			{
				if (mbiscon.isFound(SQLString))
				{
					mbis = mbiscon.SearchData(SQLString);
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

	public void resetStock()
	{
		String MobilePhone = "UPDATE MB_P_Stock SET Issued='No' WHERE SetID='"+txtSID.getText()+"';";
		String SimCard = "UPDATE MB_S_Stock SET Issued='No' WHERE PhoneNo='"+txtPhone.getText()+"';";

		try
		{
			mbiscon.RunUpdate(MobilePhone);
			mbiscon.RunUpdate(SimCard);

		}catch(RemoteException re)
		{
			System.out.println("Client [frmMBbill]: RESET STOCK Error");System.out.println("Error: "+re.getMessage());
			JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmMBbill]: "+re.getMessage(),
												"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void IssueStock()
	{
		String MobilePhone = "UPDATE MB_P_Stock SET Issued='Yes' WHERE SetID='"+txtSID.getText()+"';";
		String SimCard = "UPDATE MB_S_Stock SET Issued='Yes' WHERE PhoneNo='"+txtPhone.getText()+"';";

		try
		{
			mbiscon.RunUpdate(MobilePhone);
			mbiscon.RunUpdate(SimCard);

		}catch(RemoteException re)
		{
			System.out.println("Client [frmMBbill]: ISSUE STOCK Error");System.out.println("Error: "+re.getMessage());
			JOptionPane.showMessageDialog(null, "SAVE DATA Error\nClient [frmMBbill]: "+re.getMessage(),
												"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	*	Adding Combo Items
	*
	*/

	void getComboItems()
	{
		cboIT.addItem("Sim Only");
		cboIT.addItem("Set Only");
		cboIT.addItem("Both");

		cboSO.addItem("Company");
		cboSO.addItem("Own");
	}

	void btnEmp_actionPerformed(ActionEvent e)
	{
		frmList lst = new frmList("EMPLOYEE INFORMATION",
		"SELECT EmpCode, Name, Designation, Department, Ext FROM Employees ORDER BY Department,Name;");
		lst.setVisible(true);

		String t[][] = lst.getType();
		if(t!=null)
		{
			txtIssue.setText(t[0][0]);
		}
	}

	void btnSet_actionPerformed(ActionEvent e)
	{
		frmList lst = new frmList("AVAILABLE MOBILE PHONES",
		"SELECT SetID,Date,SetName,Brand,Model,Quality,Warranty FROM MB_P_Stock WHERE Issued='No' ORDER BY SetName;");
		lst.setVisible(true);

		String t[][] = lst.getType();
		if(t!=null)
		{
			txtSID.setText(t[0][0]);
			txtSName.setText(t[0][3]);
		}
	}

	void btnSim_actionPerformed(ActionEvent e)
	{
		frmList lst = new frmList("AVAILABLE SIMS",
		"SELECT PhoneNo,Date,CType,CProvider,CallType,Quality FROM MB_S_Stock WHERE Issued='No' ORDER BY PhoneNo;");
		lst.setVisible(true);

		String t[][] = lst.getType();
		if(t!=null)
		{
			txtPhone.setText(t[0][0]);
		}
	}

	void btnDT_actionPerformed(ActionEvent e)
	{
		frmDate fd = new frmDate("Select Return Date");
		fd.setSize(new Dimension(212, 163));
		fd.setVisible(true);
		String SDate = fd.createDate();
		txtRD.setText(SDate);
	}

	void btnDT1_actionPerformed(ActionEvent e)
	{
		frmDate fd = new frmDate("Select Date");
		fd.setSize(new Dimension(212, 163));
		fd.setVisible(true);
		String SDate = fd.createDate();
		txtDate.setText(SDate);
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