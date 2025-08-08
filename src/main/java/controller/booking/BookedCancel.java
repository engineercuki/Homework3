package controller.booking;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.HomePage;
import controller.patient.Login;
import dao.impl.BookSchduleDaoImpl;
import model.BookSchdule;
import model.Patient;
import service.impl.BookSchduleServiceImpl;
import util.Tool;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.util.List;
import java.awt.Color;

public class BookedCancel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField deleteId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookedCancel frame = new BookedCancel();
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
	public BookedCancel() {
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
		
		JLabel gjun = new JLabel("");
		gjun.setIcon(new ImageIcon(Login.class.getResource("/image/gjun.jpg")));
		gjun.setBounds(0, 0, 1044, 146);
		panel.add(gjun);
		
		JLabel msgBar = new JLabel("預約紀錄");
		msgBar.setBackground(new Color(255, 255, 255));
		msgBar.setHorizontalAlignment(SwingConstants.CENTER);
		msgBar.setFont(new Font("標楷體", Font.PLAIN, 24));
		msgBar.setBounds(10, 166, 1044, 30);
		contentPane.add(msgBar);
		
		JLabel lblNewLabel_1 = new JLabel("查詢後再輸入要取消的序號：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(197, 534, 383, 47);
		contentPane.add(lblNewLabel_1);
		
		deleteId = new JTextField();
		deleteId.setFont(new Font("新細明體", Font.PLAIN, 24));
		deleteId.setHorizontalAlignment(SwingConstants.CENTER);
		deleteId.setBounds(590, 534, 110, 48);
		contentPane.add(deleteId);
		deleteId.setColumns(10);
		
		JTextArea bookedInfo = new JTextArea();
		bookedInfo.setFont(new Font("新細明體", Font.PLAIN, 24));
		bookedInfo.setBounds(10, 206, 1044, 309);
		contentPane.add(bookedInfo);		
		
		//******************功能區*********************
		
		BookSchduleServiceImpl bsi = new BookSchduleServiceImpl();

		Patient name=(Patient)Tool.readFile("member.txt");
		String show=name.getPatientName()+" 的預約資訊如下";
		msgBar.setText(show);
		
		BookSchduleDaoImpl bdi=new BookSchduleDaoImpl();
		Patient p=(Patient)Tool.readFile("member.txt");
		
		JButton submit = new JButton("確認取消");
		submit.setForeground(new Color(0, 0, 255));
		submit.addMouseListener(new MouseAdapter() {
			@Override
			 public void mouseClicked(MouseEvent e) {
		        try {
		        	int id = Integer.parseInt(deleteId.getText().trim());
		            bsi.DeleteMySchdule(id);
		            deleteId.setText("");
		            bookedInfo.setText("指定資料已刪除，請點選[查詢]重新確認！");
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "請輸入有效的預約序號！");
		        }
		    }
		});
		submit.setFont(new Font("新細明體", Font.PLAIN, 24));
		submit.setBounds(299, 623, 187, 47);
		contentPane.add(submit);
		
		JButton print = new JButton("列印預約紀錄");
		print.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					bookedInfo.print();
				} catch (Exception pe) {
					// TODO Auto-generated catch block
					pe.printStackTrace();
				}
			}
		});
		print.setFont(new Font("新細明體", Font.PLAIN, 24));
		print.setBounds(588, 623, 187, 47);
		contentPane.add(print);
		
		JButton excel = new JButton("匯出Excel");
		excel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		excel.setFont(new Font("新細明體", Font.PLAIN, 24));
		excel.setBounds(855, 623, 187, 47);
		contentPane.add(excel);
		
		JButton goback = new JButton("返回");
		goback.setForeground(new Color(255, 0, 0));
		goback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePage back=new HomePage();
				back.setVisible(true);
				dispose();
			}
		});
		goback.setFont(new Font("新細明體", Font.PLAIN, 24));
		goback.setBounds(20, 623, 187, 47);
		contentPane.add(goback);
		
		JButton mySchdule = new JButton("查詢");
		mySchdule.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				List<BookSchdule> resultList = new BookSchduleServiceImpl().FindMyAllSchdule(p.getPatientId());
		        bookedInfo.setText(Tool.bookSchduleList(resultList));
			}
		});
		mySchdule.setFont(new Font("新細明體", Font.PLAIN, 24));
		mySchdule.setBounds(20, 534, 187, 47);
		contentPane.add(mySchdule);

	}
}
