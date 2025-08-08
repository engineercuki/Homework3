package controller.patient;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Patient;
import service.impl.PatientServiceImpl;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.Period;
import java.time.YearMonth;
import java.util.Calendar;

public class Rigister extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField pid;
	private JTextField password;
	private JTextField phone;
    private JComboBox<String> bdYear;
    private JComboBox<String> bdMonth;
    private JComboBox<String> bdDay;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rigister frame = new Rigister();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Rigister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 1080, 760);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 10, 1044, 146);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel gjun = new JLabel("");
		gjun.setIcon(new ImageIcon(Login.class.getResource("/image/gjun.jpg")));
		gjun.setBounds(0, 0, 1044, 146);
		panel.add(gjun);
		
		name = new JTextField();
		name.setHorizontalAlignment(SwingConstants.LEFT);
		name.setFont(new Font("新細明體", Font.PLAIN, 24));
		name.setBounds(296, 203, 188, 35);
		contentPane.add(name);
		name.setColumns(10);
		
		pid = new JTextField();
		pid.setHorizontalAlignment(SwingConstants.LEFT);
		pid.setFont(new Font("新細明體", Font.PLAIN, 24));
		pid.setColumns(10);
		pid.setBounds(296, 292, 188, 35);
		contentPane.add(pid);
		
		password = new JTextField();
		password.setHorizontalAlignment(SwingConstants.LEFT);
		password.setFont(new Font("新細明體", Font.PLAIN, 24));
		password.setColumns(10);
		password.setBounds(296, 392, 188, 35);
		contentPane.add(password);
		
		phone = new JTextField();
		phone.setHorizontalAlignment(SwingConstants.LEFT);
		phone.setFont(new Font("新細明體", Font.PLAIN, 24));
		phone.setColumns(10);
		phone.setBounds(296, 481, 188, 35);
		contentPane.add(phone);
		
		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("標楷體", Font.PLAIN, 24));
		lblNewLabel.setBounds(151, 203, 135, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("身分證字號(帳號)");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("標楷體", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(92, 292, 194, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("密碼");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("標楷體", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(151, 392, 135, 35);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("電話");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("標楷體", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(151, 481, 135, 35);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("生日");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("標楷體", Font.PLAIN, 24));
		lblNewLabel_4.setBounds(478, 292, 135, 35);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("年齡");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_1.setFont(new Font("標楷體", Font.PLAIN, 24));
		lblNewLabel_4_1.setBounds(478, 392, 135, 35);
		contentPane.add(lblNewLabel_4_1);

		JLabel lblNewLabel_4_2 = new JLabel("年");
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_2.setFont(new Font("標楷體", Font.PLAIN, 24));
		lblNewLabel_4_2.setBounds(713, 292, 24, 35);
		contentPane.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("月");
		lblNewLabel_4_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_2_1.setFont(new Font("標楷體", Font.PLAIN, 24));
		lblNewLabel_4_2_1.setBounds(830, 293, 24, 35);
		contentPane.add(lblNewLabel_4_2_1);
		
		JLabel lblNewLabel_4_2_2 = new JLabel("日");
		lblNewLabel_4_2_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_2_2.setFont(new Font("標楷體", Font.PLAIN, 24));
		lblNewLabel_4_2_2.setBounds(948, 292, 24, 35);
		contentPane.add(lblNewLabel_4_2_2);		
		
		JLabel lblNewLabel_3_1 = new JLabel("性別");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1.setFont(new Font("標楷體", Font.PLAIN, 24));
		lblNewLabel_3_1.setBounds(478, 481, 135, 35);
		contentPane.add(lblNewLabel_3_1);		
		
		JLabel rigisterMsg = new JLabel("");
		rigisterMsg.setFont(new Font("新細明體", Font.PLAIN, 24));
		rigisterMsg.setForeground(new Color(255, 0, 0));
		rigisterMsg.setHorizontalAlignment(SwingConstants.CENTER);
		rigisterMsg.setBounds(471, 543, 501, 66);
		contentPane.add(rigisterMsg);
				
		//*********************功能區********************

		JComboBox<String> bdYear = new JComboBox<>();
		bdYear.setFont(new Font("新細明體", Font.PLAIN, 24));
		bdYear.setBounds(623, 292, 87, 32);
		// 初始化年份（今年往前100年）
		bdYear.addItem(""); // 空白選項加在最前面
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 0; i < 100; i++) {
        	bdYear.addItem(String.valueOf(currentYear - i));
        }
		contentPane.add(bdYear);
		
		JComboBox<String> bdMonth = new JComboBox<>();
		bdMonth.setFont(new Font("新細明體", Font.PLAIN, 24));
		bdMonth.setBounds(744, 292, 87, 32);
		// 初始化月份（1~12）
		bdMonth.addItem(""); // 空白選項加在最前面
        for (int i = 1; i <= 12; i++) {
        	bdMonth.addItem(String.valueOf(i));
        }
		contentPane.add(bdMonth);
		
		JComboBox<String> bdDay = new JComboBox<>();
		bdDay.setFont(new Font("新細明體", Font.PLAIN, 24));
		bdDay.setBounds(864, 292, 87, 32);
		contentPane.add(bdDay);	
		// 更新日期選項的方法
		Runnable updateDays = () -> {
		    bdDay.removeAllItems(); // 清空舊的選項
			bdDay.addItem(""); // 空白選項加在最前面
		    String yearStr = (String) bdYear.getSelectedItem();
		    String monthStr = (String) bdMonth.getSelectedItem();
            if (yearStr != null && monthStr != null && !yearStr.isEmpty() && !monthStr.isEmpty()) {
                try {
                    int year = Integer.parseInt(yearStr);
                    int month = Integer.parseInt(monthStr);
                    int daysInMonth = YearMonth.of(year, month).lengthOfMonth();
                    for (int i = 1; i <= daysInMonth; i++) {
                        bdDay.addItem(String.valueOf(i));
                    }
                } catch (NumberFormatException ex) {
                    ex.printStackTrace(); // 防止非數字選項造成錯誤
                }
            }
        };
		// 加入事件監聽
        bdYear.addActionListener(e -> updateDays.run());
        bdMonth.addActionListener(e -> updateDays.run());
        // 預設選擇第一個選項並更新日期
        bdYear.setSelectedIndex(0);
        bdMonth.setSelectedIndex(0);
        updateDays.run();
 
		JLabel Age = new JLabel("");
		Age.setHorizontalAlignment(SwingConstants.LEFT);
		Age.setFont(new Font("標楷體", Font.PLAIN, 24));
		// 計算年齡的方法
		Runnable updateAge = () -> {
			 String yearStr = (String) bdYear.getSelectedItem();
			    String monthStr = (String) bdMonth.getSelectedItem();
			    String dayStr = (String) bdDay.getSelectedItem();
			    if (yearStr != null && monthStr != null && dayStr != null &&
			            !yearStr.isEmpty() && !monthStr.isEmpty() && !dayStr.isEmpty()){
			    	int year = Integer.parseInt(yearStr);
		            int month = Integer.parseInt(monthStr);
		            int day = Integer.parseInt(dayStr);

		            LocalDate birthDate = LocalDate.of(year, month, day);
		            LocalDate today = LocalDate.now();
		            Period age = Period.between(birthDate, today);
		            Age.setText(String.valueOf(age.getYears()));
		    } else {
		        Age.setText(""); // 防止無效日期
		    }
		};
		// 加入事件監聽
		bdYear.addActionListener(e -> {
		    updateDays.run();
		    updateAge.run();
		});
		bdMonth.addActionListener(e -> {
		    updateDays.run();
		    updateAge.run();
		});
		bdDay.addActionListener(e -> updateAge.run());
		// 預設選擇第一個選項並更新日期與年齡
		bdYear.setSelectedIndex(0);
		bdMonth.setSelectedIndex(0);
		updateDays.run();
		updateAge.run();
		Age.setBounds(623, 392, 135, 35);
		contentPane.add(Age);
		
		String[] options = {"","男", "女"};
		JComboBox<String> sex = new JComboBox<>(options);
		sex.setFont(new Font("新細明體", Font.PLAIN, 24));
		sex.setBounds(623, 481, 87, 32);
		contentPane.add(sex);
		
		JButton submit = new JButton("註冊");
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name=name.getText();
				String Pid=pid.getText();
				String Password=password.getText();
				String Sex=(String)sex.getSelectedItem();
				String Phone=phone.getText();
				
				//檢查欄位是否為空值
				if (name.getText() != null && pid.getText() !=null && password.getText() !=null && phone.getText() != null && 
						(String) sex.getSelectedItem() != null && !((String) sex.getSelectedItem()).isEmpty() &&
						(String) bdYear.getSelectedItem() != null && !((String) bdYear.getSelectedItem()).isEmpty() &&
						(String) bdMonth.getSelectedItem() != null && !((String) bdMonth.getSelectedItem()).isEmpty() &&
						(String) bdDay.getSelectedItem() != null && !((String) bdDay.getSelectedItem()).isEmpty()) {

							String Birthday=(String)bdYear.getSelectedItem()+"/"+bdMonth.getSelectedItem()+"/"+bdDay.getSelectedItem();
							Patient p=new Patient(Name,Pid,Sex,Birthday,Phone,Password);
				
							boolean result=new PatientServiceImpl().addCheck(p);

							if (result) {
								rigisterMsg.setText("註冊成功！");
								name.setText("");
								pid.setText("");
								password.setText("");
								phone.setText("");
								sex.setSelectedItem("");
								bdYear.setSelectedItem("");
								bdMonth.setSelectedItem("");
								bdDay.setSelectedItem("");
			        
							} else {
								rigisterMsg.setText("帳號已存在，請返回[登入]");
							}}
				else {
						rigisterMsg.setText("欄位不可空白!");
				}}
		});
		submit.setForeground(new Color(0, 0, 255));
		submit.setFont(new Font("新細明體", Font.PLAIN, 24));
		submit.setBounds(629, 619, 191, 42);
		contentPane.add(submit);
		
		JButton back = new JButton("返回登入");
		back.setForeground(new Color(255, 0, 0));
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login=new Login();
				login.setVisible(true);
				dispose();
			}
		});
		back.setFont(new Font("新細明體", Font.PLAIN, 24));
		back.setBounds(92, 619, 191, 42);
		contentPane.add(back);
	
	}
}
