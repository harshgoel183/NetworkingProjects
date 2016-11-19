/****************************************************************/
/*                      DosAttacker	                            */
/*                                                              */
/****************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
/**
 * Summary description for DosAttacker
 *
 */
public class DosAttacker extends JFrame
{
	// Variables declaration
	private JPanel contentPane;
	//-----
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JTextField jTextField1;
	private JTextField jTextField2;
	private JButton jButton1;
	private JButton jButton2;
	private JPanel jPanel1;
	Socket sndFl;
	public String flSer1="";
	public int port=0;
	//-----
	// End of variables declaration


	public DosAttacker()
	{
		super();
		initializeComponent();
		//
		// TODO: Add any constructor code after initializeComponent call
		//

		this.setVisible(true);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always regenerated
	 * by the Windows Form Designer. Otherwise, retrieving design might not work properly.
	 * Tip: If you must revise this method, please backup this GUI file for JFrameBuilder
	 * to retrieve your design properly in future, before revising this method.
	 */
	private void initializeComponent()
	{
		contentPane = (JPanel)this.getContentPane();
		//-----
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jTextField1 = new JTextField();
		jTextField2 = new JTextField();
		
		jButton1 = new JButton();
		jButton2 = new JButton();
		jPanel1 = new JPanel();
		//-----

		//
		// contentPane
		//
		contentPane.setLayout(null);
		addComponent(contentPane, jPanel1, 8,9,190,247);
		//
		// jLabel1
		//
		jLabel1.setText("Server IP Address :");
		//
		// jLabel2
		//
		jLabel2.setText("Server Port Number : ");
		//
		// jTextField1
		//
		jTextField1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jTextField1_actionPerformed(e);
			}

		});
		//
		// jTextField2
		//
		jTextField2.setText("8000");
		jTextField2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jTextField2_actionPerformed(e);
			}

		});
		//
		// jButton1
		//
		jButton1.setText("Attack");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton1_actionPerformed(e);
			}

		});
		//
		// jButton2
		//
		jButton2.setText("Exit");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton2_actionPerformed(e);
			}

		});
		//
		// jPanel1
		//
		jPanel1.setLayout(null);
		jPanel1.setBorder(BorderFactory.createRaisedBevelBorder());
		addComponent(jPanel1, jLabel1, 15,15,120,26);
		addComponent(jPanel1, jLabel2, 18,89,148,23);
		addComponent(jPanel1, jTextField1, 60,49,100,22);
		addComponent(jPanel1, jTextField2, 62,121,100,22);
		addComponent(jPanel1, jButton1, 81,176,83,28);
		addComponent(jPanel1, jButton2, 82,209,83,28);
		//
		// DosAttacker
		//
		this.setTitle("DosAttacker");
		this.setLocation(new Point(161, 95));
		this.setSize(new Dimension(216, 300));
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setResizable(false);
	}

	/** Add Component Without a Layout Manager (Absolute Positioning) */
	private void addComponent(Container container,Component c,int x,int y,int width,int height)
	{
		c.setBounds(x,y,width,height);
		container.add(c);
	}

	//
	// TODO: Add any appropriate code in the following Event Handling Methods
	//
	private void jTextField1_actionPerformed(ActionEvent e)
	{
		System.out.println("\njTextField1_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

	}

	private void jTextField2_actionPerformed(ActionEvent e)
	{
		System.out.println("\njTextField2_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

	}

	private void jButton1_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton1_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
		try
		{
			flSer1=jTextField1.getText();
				port=Integer.parseInt(jTextField2.getText());
				sndFl=new Socket(flSer1,port);
				DataOutputStream dos=new DataOutputStream(sndFl.getOutputStream());
				dos.writeUTF("DOS");
			
		}
		catch (Exception as)
		{
			as.printStackTrace();
		}
				


	}

	private void jButton2_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton2_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
		System.exit(0);

	}

	//
	// TODO: Add any method code to meet your needs in the following area
	//






























 

//============================= Testing ================================//
//=                                                                    =//
//= The following main method is just for testing this class you built.=//
//= After testing,you may simply delete it.                            =//
//======================================================================//
	public static void main(String[] args)
	{
		/*JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch (Exception ex)
		{
			System.out.println("Failed loading L&F: ");
			System.out.println(ex);
		}*/
		new DosAttacker();
	}
//= End of Testing =


}
