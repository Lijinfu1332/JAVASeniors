  package UI;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JButton;

import src.Time;
import javax.swing.JTextPane;

public class MYUI extends JFrame {

	private Time time;  //  @jve:decl-index=0:
	private static final long serialVersionUID = 1L;

	public static JPanel jContentPane = null;

	private JLabel jLabel = null;

	private static JTextField jTextField = null;

	private JButton jButton = null;

	private JButton jButton2 = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JButton jButton3 = null;
	private JButton jButton4 = null;
	private JButton jButton5 = null;
	private JButton jButton6 = null;
	private JButton jButton7 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel6 = null;
	private JLabel jLabel7 = null;
	private JLabel jLabel8 = null;
	private static JTextField jTextField1 = null;
	private JLabel jLabel9 = null;
	private static JTextField jTextField2 = null;
	private JLabel jLabel10 = null;
	private JLabel jLabel11 = null;
	private JLabel jLabel12 = null;
	private JLabel jLabel13 = null;
	private static JTextPane jTextPane = null;
	private JLabel jLabel14 = null;
	private static JTextPane jTextPane1 = null;
	private static JTextPane jTextPane2 = null;
	private static JTextPane jTextPane3 = null;
	private static JTextPane jTextPane4 = null;
	private JButton jButton8 = null;
	private JButton jButton9 = null;
	private JLabel jLabel15 = null;
	private JLabel jLabel16 = null;
	private JLabel jLabel17 = null;
	/**
	 * This is the default constructor
	 */
	public MYUI() {
		
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(770, 587);
		this.setContentPane(getJContentPane());
		this.setTitle("西宝高速模拟系统");
		time=new Time();
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel17 = new JLabel();
			jLabel17.setBounds(new Rectangle(486, 20, 175, 44));
			jLabel17.setText("");
			jLabel16 = new JLabel();
			jLabel16.setBounds(new Rectangle(184, 62, 63, 18));
			jLabel16.setText("：沃尔沃");
			jLabel15 = new JLabel();
			jLabel15.setBounds(new Rectangle(87, 61, 60, 18));
			jLabel15.setText("：依维柯");
			jLabel14 = new JLabel();
			jLabel14.setBounds(new Rectangle(306, 379, 134, 27));
			jLabel14.setText("点击车显示状态");
			jLabel13 = new JLabel();
			jLabel13.setBounds(new Rectangle(642, 300, 80, 25));
			jLabel13.setText("西安的依维柯");
			jLabel12 = new JLabel();
			jLabel12.setBounds(new Rectangle(514, 300, 80, 25));
			jLabel12.setText("西安的沃尔沃");
			jLabel11 = new JLabel();
			jLabel11.setBounds(new Rectangle(159, 300, 80, 25));
			jLabel11.setText("宝鸡的依维柯");
			jLabel10 = new JLabel();
			jLabel10.setBounds(new Rectangle(27, 300, 80, 25));
			jLabel10.setText("宝鸡的沃尔沃");
			jLabel9 = new JLabel();
			jLabel9.setBounds(new Rectangle(299, 334, 90, 25));
			jLabel9.setText("西安站的乘客");
			jLabel8 = new JLabel();
			jLabel8.setBounds(new Rectangle(297, 300, 90, 25));
			jLabel8.setText("宝鸡站的乘客");
			jLabel7 = new JLabel();
			jLabel7.setBounds(new Rectangle(621, 188, 38, 18));
			jLabel7.setText("咸阳");
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(526, 188, 38, 18));
			jLabel6.setText("兴平");
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(445, 187, 38, 18));
			jLabel5.setText("武功");
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(195, 188, 59, 18));
			jLabel4.setText("蔡家坡");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(114, 188, 38, 18));
			jLabel3.setText("虢镇");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(22, 188, 38, 18));
			jLabel2.setText("宝鸡");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(711, 188, 38, 18));
			jLabel1.setText("西安");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(71, 23, 90, 27));
			jLabel.setText("现在时间");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getJTextField(), null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(getJButton3(), null);
			jContentPane.add(getJButton4(), null);
			jContentPane.add(getJButton5(), null);
			jContentPane.add(getJButton6(), null);
			jContentPane.add(getJButton7(), null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(jLabel4, null);
			jContentPane.add(jLabel5, null);
			jContentPane.add(jLabel6, null);
			jContentPane.add(jLabel7, null);
			jContentPane.add(jLabel8, null);
			jContentPane.add(getJTextField1(), null);
			jContentPane.add(jLabel9, null);
			jContentPane.add(getJTextField2(), null);
			jContentPane.add(jLabel10, null);
			jContentPane.add(jLabel11, null);
			jContentPane.add(jLabel12, null);
			jContentPane.add(jLabel13, null);
			jContentPane.add(getJTextPane(), null);
			jContentPane.add(jLabel14, null);
			jContentPane.add(getJTextPane1(), null);
			jContentPane.add(getJTextPane2(), null);
			jContentPane.add(getJTextPane3(), null);
			jContentPane.add(getJTextPane4(), null);
			jContentPane.add(getJButton8(), null);
			jContentPane.add(getJButton9(), null);
			jContentPane.add(jLabel15, null);
			jContentPane.add(jLabel16, null);
			jContentPane.add(jLabel17, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(160, 24, 85, 28));
		}
		return jTextField;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(375, 24, 95, 33));
			jButton.setText("开始");
			jButton.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {		
					time.start();
					jButton.setVisible(false);
					jLabel17.setText("2020年5月23日");
					//System.out.println("mouseClicked()"); // TODO Auto-generated Event stub mouseClicked()
				}
			});
		}
		return jButton;
	}

	public static JPanel getjpanel()
	{
		return jContentPane;
	}
	public static void setJTextField(int time) {
		// TODO Auto-generated method stub
		int hour=time/3600;
		int minute=time/60%60;
		//int second=time%60%60;
		jTextField.setText(String.valueOf(hour)+":"+String.valueOf(minute));//+":"+String.valueOf(second)
	}
	public Time gettime()
	{
		return time;
	}

	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(30, 168, 696, 10));
		}
		return jButton2;
	}

	/**
	 * This method initializes jButton3	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setBounds(new Rectangle(126, 168, 1, 17));
		}
		return jButton3;
	}

	/**
	 * This method initializes jButton4	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton4() {
		if (jButton4 == null) {
			jButton4 = new JButton();
			jButton4.setBounds(new Rectangle(210, 168, 1, 17));
		}
		return jButton4;
	}

	/**
	 * This method initializes jButton5	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton5() {
		if (jButton5 == null) {
			jButton5 = new JButton();
			jButton5.setBounds(new Rectangle(458, 168, 1, 17));
		}
		return jButton5;
	}

	/**
	 * This method initializes jButton6	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton6() {
		if (jButton6 == null) {
			jButton6 = new JButton();
			jButton6.setBounds(new Rectangle(542, 168, 1, 17));
		}
		return jButton6;
	}

	/**
	 * This method initializes jButton7	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton7() {
		if (jButton7 == null) {
			jButton7 = new JButton();
			jButton7.setBounds(new Rectangle(638, 168, 1, 17));
		}
		return jButton7;
	}

	/**
	 * This method initializes jTextField1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setBounds(new Rectangle(387, 300, 60, 25));
		}
		return jTextField1;
	}
	public static void set_jfied1(int num)//宝鸡车站乘客数量
	{
		jTextField1.setText(String.valueOf(num));
	}
	public static void set_jfied2(int num)//宝鸡车站乘客数量
	{
		jTextField2.setText(String.valueOf(num));
	}

	/**
	 * This method initializes jTextField2	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setBounds(new Rectangle(388, 335, 60, 25));
		}
		return jTextField2;
	}

	/**
	 * This method initializes jTextPane	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane() {
		if (jTextPane == null) {
			jTextPane = new JTextPane();
			jTextPane.setBounds(new Rectangle(304, 409, 136, 133));
		}
		return jTextPane;
	}
	public static void setjTextPane(String text)
	{
		jTextPane.setText(text);
	}
	/**
	 * This method initializes jTextPane1	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane1() {
		if (jTextPane1 == null) {
			jTextPane1 = new JTextPane();
			jTextPane1.setBounds(new Rectangle(27, 325, 80, 125));
		}
		return jTextPane1;
	}
	public static void set_jTextPane1(String wow)//宝鸡的沃尔沃
	{
		jTextPane1.setText(wow);
	}
	public static void set_jTextPane2(String yvk)//宝鸡的依维柯
	{
		jTextPane2.setText(yvk);
	}
	public static void set_jTextPane3(String wow)//西安的沃尔沃
	{
		jTextPane3.setText(wow);
	}
	public static void set_jTextPane4(String yvk)//宝鸡的依维柯
	{
		jTextPane4.setText(yvk);
	}
	/**
	 * This method initializes jTextPane2	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane2() {
		if (jTextPane2 == null) {
			jTextPane2 = new JTextPane();
			jTextPane2.setBounds(new Rectangle(159, 326, 80, 124));
		}
		return jTextPane2;
	}

	/**
	 * This method initializes jTextPane3	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane3() {
		if (jTextPane3 == null) {
			jTextPane3 = new JTextPane();
			jTextPane3.setBounds(new Rectangle(514, 325, 81, 124));
		}
		return jTextPane3;
	}

	/**
	 * This method initializes jTextPane4	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane4() {
		if (jTextPane4 == null) {
			jTextPane4 = new JTextPane();
			jTextPane4.setBounds(new Rectangle(642, 325, 80, 125));
		}
		return jTextPane4;
	}

	/**
	 * This method initializes jButton8	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton8() {
		if (jButton8 == null) {
			jButton8 = new JButton();
			jButton8.setBounds(new Rectangle(59, 66, 20, 10));
			jButton8.setBackground(Color.blue);
		}
		return jButton8;
	}

	/**
	 * This method initializes jButton9	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton9() {
		if (jButton9 == null) {
			jButton9 = new JButton();
			jButton9.setBounds(new Rectangle(152, 66, 20, 10));
		}
		return jButton9;
	}
}  //  @jve:decl-index=0:visual-constraint="2,-3"
