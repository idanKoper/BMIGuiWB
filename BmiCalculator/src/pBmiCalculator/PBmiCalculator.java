package pBmiCalculator;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Panel;

public class PBmiCalculator extends JFrame {

	JLabel pTitle;
//	JPanel pGender = new JPanel();
//	JPanel pHeight = new JPanel();
//	JPanel pBody = new JPanel();
//	JPanel pWeight = new JPanel();
//	JPanel pAge = new JPanel(); 
//	JPanel pExe = new JPanel();
	//ResultPanel result = new ResultPanel();
	ButtonGroup buttonGroup1;
	ButtonGroup buttonGroup3;
	JRadioButton female;
	JRadioButton male;
	JLabel heightL;
	JLabel lGen;
	JLabel JExe;
	JLabel LAge;
	JLabel lWeight1;
	JLabel hl;
	JSlider slider;
	JRadioButton small;
	JRadioButton  medium;
	JRadioButton  large;
	
	
	JRadioButton Inactive;
	JRadioButton Moderately;
	JRadioButton Extremely;
	JLabel background;
	JButton clearB;
	ImageIcon icon;
	JLabel calculate;
	JLabel EERLab;
	String bmi;
	JButton calculateB;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JTextField age;
	JTextField weight;
	private JLabel label_1;
	private final JLabel lblNewLabel_1 = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PBmiCalculator frame = new PBmiCalculator();
					frame.setVisible(true);
					ModelWbBMI model = new ModelWbBMI();
					ControlWbBMI control = new ControlWbBMI(frame,model);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PBmiCalculator() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("./BMIicon.png"));
		setResizable(false);
		setTitle("BMI Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		pTitle = new JLabel("BMI Calculator");
		pTitle.setForeground(new Color(255, 255, 255));
		pTitle.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 31));
		pTitle.setHorizontalAlignment(SwingConstants.CENTER);
		pTitle.setBounds(83, 13, 632, 62);
		contentPane.add(pTitle);

		heightL = new JLabel("Height:");
		heightL.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 18));
		heightL.setBounds(35, 219, 93, 38);
		contentPane.add(heightL);

		 lWeight1 = new JLabel("Weight:");
		lWeight1.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 18));
		lWeight1.setBounds(35, 146, 93, 38);
		contentPane.add(lWeight1);

		LAge = new JLabel("Age:");
		LAge.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 18));
		LAge.setBounds(35, 95, 53, 38);
		contentPane.add(LAge);

		male = new JRadioButton("Male");
		male.setOpaque(false);
		male.setBounds(160, 339, 63, 25);
		contentPane.add(male);

		female = new JRadioButton("Female");
		female.setOpaque(false);
		female.setBounds(227, 339, 71, 25);
		contentPane.add(female);

		slider = new JSlider();
		slider.setOpaque(false);
		slider.setMinimum(60);
		slider.setMinorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setValue(60);
		slider.setMajorTickSpacing(20);
		slider.setMaximum(230);
		slider.setBounds(111, 219, 606, 51);
		contentPane.add(slider);

		JLabel label = new JLabel("60");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 23));
		label.setBounds(729, 218, 71, 38);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				label.setText(Integer.toString(slider.getValue()));
			}
		});

		contentPane.add(label);

		calculate = new JLabel("");
		calculate.setForeground(new Color(255, 255, 255));
		calculate.setBounds(278, 476, 339, 38);
		contentPane.add(calculate);

		clearB = new JButton("Clear The Scren");
		clearB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearLabels();
				buttonGroup1.clearSelection();
				buttonGroup3.clearSelection();
				weight.setText("");
				age.setText("");
				slider.setValue(60);
				lGen.setForeground(Color.BLACK);
				JExe.setForeground(Color.BLACK);
				LAge.setForeground(Color.BLACK);
				lWeight1.setForeground(Color.BLACK);
			}
		});
		clearB.setBounds(416, 527, 137, 25);
		contentPane.add(clearB);

		EERLab = new JLabel("");
		EERLab.setForeground(new Color(255, 255, 255));
		EERLab.setBounds(278, 442, 339, 38);
		contentPane.add(EERLab);

		JLabel lblKg = new JLabel("Kg");
		lblKg.setForeground(new Color(255, 255, 255));
		lblKg.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 18));
		lblKg.setBounds(186, 146, 93, 38);
		contentPane.add(lblKg);

		JLabel lblYears = new JLabel("Years");
		lblYears.setForeground(new Color(255, 255, 255));
		lblYears.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 18));
		lblYears.setBounds(186, 95, 53, 38);
		contentPane.add(lblYears);

		JExe = new JLabel("Activity level:");
		JExe.setForeground(new Color(255, 255, 255));
		JExe.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 18));
		JExe.setBounds(456, 296, 145, 38);
		contentPane.add(JExe);

		Inactive = new JRadioButton("Inactive");
		Inactive.setForeground(new Color(255, 255, 255));
		Inactive.setOpaque(false);
		Inactive.setBounds(466, 339, 127, 25);
		contentPane.add(Inactive);
		
		buttonGroup1 = new ButtonGroup();
		buttonGroup1.add(male);
		buttonGroup1.add(female);

		Moderately = new JRadioButton("Moderately Active");
		Moderately.setForeground(new Color(255, 255, 255));
		Moderately.setOpaque(false);
		Moderately.setBounds(466, 369, 127, 25);
		contentPane.add(Moderately);

		Extremely = new JRadioButton("Extremely Active");
		Extremely.setForeground(new Color(255, 255, 255));
		Extremely.setOpaque(false);
		Extremely.setBounds(466, 399, 127, 25);
		contentPane.add(Extremely);
		
		
		buttonGroup3 = new ButtonGroup();
		buttonGroup3.add(Inactive);
		buttonGroup3.add(Moderately);
		buttonGroup3.add(Extremely);

		calculateB = new JButton("Calculate");
		calculateB.setBounds(227, 527, 139, 25);
		contentPane.add(calculateB);
		
		age = new JTextField();
		age.setBounds(115, 105, 53, 22);
		contentPane.add(age);
		age.setColumns(10);
		
		weight = new JTextField();
		weight.setBounds(115, 156, 53, 22);
		contentPane.add(weight);
		weight.setColumns(10);
		
		lGen = new JLabel("Gender:");
		lGen.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 18));
		lGen.setBounds(160, 299, 87, 31);
		contentPane.add(lGen);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("./Famale.jpg"));
		lblNewLabel.setBounds(227, 373, 31, 74);
		contentPane.add(lblNewLabel);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("./Male.jpg"));
		label_1.setBounds(160, 373, 31, 74);
		contentPane.add(label_1);
		lblNewLabel_1.setIcon(new ImageIcon("./Shape-Silver-Abstract.jpg"));
		lblNewLabel_1.setBounds(-456, -35, 1323, 614);
		contentPane.add(lblNewLabel_1);
		

	}
	public String getGender() {
		String gender="";
		if(male.isSelected())
			gender= male.getText();
		else if(female.isSelected())
			gender= female.getText();
		return gender;
	}
	//height
	public double getHeightBMI() {
			double height = (double)this.slider.getValue();
			return height;
	}
	//weight
	public double getWeight() {
		String temp = this.weight.getText().replaceAll("\\s+",""); 
		try {
			if(temp.isEmpty()) {
				return 0.0;
			}
			else {
				double weightB = Double.valueOf(temp);
				return weightB;
			}
		}
		catch(IllegalArgumentException e) {}
		return 0.0;
	}
	//age
	public double getAge() {
		String temp = this.age.getText().replaceAll("\\s+",""); 
		try {
			if(temp.isEmpty()) {
				return 0.0;
			}
			else {
				double dAge = Double.valueOf(temp);
				return dAge;
			}		}
		catch(IllegalArgumentException e) {}
		return 0.0;
	}
	//result panel
//	public ResultPanel getResult()
//	{
//		return result;
//	}
	//activity
	public String getActivity() {
		String act="";
		if(Inactive.isSelected())
			act = "Inactive";
		else if(Moderately.isSelected())
			act ="Moderately Active";
		else if(Extremely.isSelected())
			act ="Extremely Active";
		return act;
	}

	public void missInput() {
		if(getGender().equals("")) lGen.setForeground(Color.RED);
		if(getActivity().equals("")) JExe.setForeground(Color.RED);
		if(getAge()==0.0) LAge.setForeground(Color.RED);
		if(getWeight()==0.0) lWeight1.setForeground(Color.RED);

	}
	public void noMiss() {
		if(!getGender().equals(""))lGen.setForeground(Color.BLACK);
		if(!getActivity().equals("")) 	JExe.setForeground(Color.BLACK);
		if(!(getAge()==0.0)) 	LAge.setForeground(Color.BLACK);
		if(!(getWeight()==0.0))lWeight1.setForeground(Color.BLACK);
	}
	
	void addCalculationListener(ActionListener listenerforCalc) {
		calculateB.addActionListener(listenerforCalc);
	}
	/**
	 * changes the BMI results labels according to the user input 
	 * @param newBMI
	 * @param EER
	 * @param status
	 */
	public void setLabels(String newBMI, String EER, String status) {

		if(newBMI.equals("0.00") || EER.equals("0.00") || status.equals("")) {
			JOptionPane.showMessageDialog(this, "Some input is invalid! Follow the red titels to see what is wrong.");
			calculate.setText("");
			EERLab.setText("");
		}
		else {
			calculate.setText("Your BMI: " + newBMI + " You are "+status+"!");
			EERLab.setText("Estimated energy requirements " +EER+".");
		}
	}
	/**
	 * clear labels
	 */
	public void clearLabels() {
		calculate.setText("");
		EERLab.setText("");
	}
}
