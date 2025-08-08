package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JLabel;

import model.BookSchdule;
import model.Patient;

public class Tool {
	
	//存物件-登入紀錄生命週期 -> Object為物件層級最高類型故使用Object宣告+filename
	public static void saveFile(Object object, String fileName) {
					try {
						FileOutputStream fos=new FileOutputStream(fileName);
						ObjectOutputStream oos=new ObjectOutputStream(fos);
						oos.writeObject(object);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	}
	
	
	//取物件-登入紀錄生命週期
	public static Object readFile(String fileName) {
		Object object=null;
		
		try {
			FileInputStream fis=new FileInputStream(fileName);
			ObjectInputStream ois=new ObjectInputStream(fis);
			object=ois.readObject();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
		
	}
	
	//預約紀錄查詢showInfo
	public static String bookSchduleList(List<BookSchdule> schduleList) {
	    if (schduleList == null || schduleList.isEmpty()) {
	        return "查無預約資料！";
	    }

	    StringBuilder sb = new StringBuilder();
	    for (BookSchdule schdule : schduleList) {
	        sb.append("序號：").append(schdule.getId()).append("\t")
	        .append("姓名：").append(schdule.getPatientName())
	          .append(" (").append(schdule.getPatientId()).append(")\t")
	          .append("預約日期：").append(schdule.getBookDate())
	          .append(" ").append(schdule.getBookTime()).append("\t")
	          .append(schdule.getDepartment()).append("門診\t")
	          .append(schdule.getDoctorName()).append(" 醫師\n");
	    }

	    return sb.toString();
	}
        
	//預約紀錄查詢showInfo
		public static String bookSchduleList1(List<BookSchdule> schduleList) {
		    if (schduleList == null || schduleList.isEmpty()) {
		        return "查無預約資料！";
		    }

		    StringBuilder sb = new StringBuilder();
		    for (BookSchdule schdule : schduleList) {
		        sb.append("序號：").append(schdule.getId()).append("\t")
		        .append("姓名：").append(schdule.getPatientName())
		          .append(" (").append(schdule.getPatientId()).append(")\t")
		          .append("預約日期：").append(schdule.getBookDate())
		          .append(" ").append(schdule.getBookTime()).append("\t")
		          .append(schdule.getDepartment()).append("門診\t")
		          .append(schdule.getDoctorName()).append(" 醫師\n");
		    }

		    return sb.toString();
		}
        /*
        return "姓名：" + schdule.getPatientName() + "(" + schdule.getPatientId() + ")\t"
             + "預約日期：" + schdule.getBookDate() + "  " + schdule.getBookTime() + "\t"
             + schdule.getDepartment()+ "門診"+"\t"+ schdule.getDoctorName() + " 醫師" +  "\n";
             */
   
		//個資查詢Info
		public static String formatPatientInfo(Patient p) {

		    return "姓名：" + p.getPatientName() + " (" + p.getPatientId() + ")\t"
		         + "生日：" + p.getBirthday().format(DateTimeFormatter.ofPattern("yyyy/M/d")) + "\t"
		         + "密碼：" + p.getPassword()+"\n";
		}
		
		public static void updateDateTime(JLabel label) {
	        LocalDateTime now = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/M/dd HH:mm:ss");
	        label.setText(now.format(formatter));
	    }



}
