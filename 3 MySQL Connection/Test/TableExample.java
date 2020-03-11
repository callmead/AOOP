//Java 25th Feb 2004 Table Example with data

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TableExample extends JDialog
{//Class

	JLabel lblHead = new JLabel();
	JPanel pnl = new JPanel();
	JButton btnClose = new JButton();
	JTable table;//JTable(rows,columns)
	JScrollPane sp = new JScrollPane(); //Scroll for Table Required.

	String [] columnHead =
		{"ID Number","Name     ","Phone     "};
	String [][] rowData =
		{
			{"NCC0001","Adeel","011094474"},
			{"NCC0002","Ashraf","8612032"},
			{"NCC0003","Junaid","1251121"},
			{"NCC0004","Ahmed","2154545"},
			{"NCC0005","Manna","2454545"},
			{"NCC0006","Mehdi","5454545"},
			{"NCC0007","Kamrul","2545452"},
			{"NCC0008","Jewel","5454545"},
			{"NCC0009","Shakil","8612032"},
			{"NCC0010","Faisal","1234545"}
		};

	public TableExample(String s) //String s for lable of lblHead
	{//Constructor
		this.setTitle("Table Example");
		this.setBounds(200,100,400,400);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		this.getContentPane().setLayout(null);
		this.getContentPane().add(pnl);
		this.getContentPane().add(lblHead);
		this.getContentPane().add(btnClose);
		//----------------------

		//Properties of Label...
		lblHead.setText(s);
		lblHead.setBounds(25,25,350,25);
		lblHead.setOpaque(true);
		lblHead.setForeground(Color.white);
		lblHead.setBackground(Color.red);
		lblHead.setBorder(BorderFactory.createRaisedBevelBorder());
		lblHead.setHorizontalAlignment(SwingConstants.CENTER);
		lblHead.setFont(new Font("Tahoma",1,12));
		//----------------------

		//Properties of Panel...
		pnl.setBounds(25,60,350,250);
		pnl.setBorder(BorderFactory.createLineBorder(Color.black));
		//pnl.add(table,BorderLayout.CENTER);//When not using ScrollPane
		pnl.setLayout(new BorderLayout());
		pnl.add(sp,BorderLayout.CENTER);

		//----------------------

		//Initialize Table Object...
		table = new JTable(rowData,columnHead);
		//--------------------------

		//Properties of ScrollPane...
		sp.getViewport().add(table);
		//---------------------------

		//Properties of Table...
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setColumnSelectionAllowed(true);
		//----------------------

		//Properties of Button...
		btnClose.setText("Close");
		btnClose.setMnemonic('l');
		btnClose.setBorder(BorderFactory.createRaisedBevelBorder());
		btnClose.setBounds(275,330,100,25);
		btnClose.setFont(new Font("Tahoma",1,12));
		btnClose.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//System.exit(0);
				dispose();
			}
		});
		//-----------------------

	}//Constructor

	public static void main(String a[])
	{//Main
		TableExample frm = new TableExample("Sorted list of all Students"); //String s
		frm.setVisible(true);
	}//Main
}//Class