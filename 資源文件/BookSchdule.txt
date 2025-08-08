package model;

import java.io.Serializable;

public class BookSchdule implements Serializable{
				private int id;
				private String patientName;
				private String patientId;
				private String bookDate;
				private String bookTime;
				private String department;
				private String doctorName;
				private String cancel;
				private String cancelTimeLog;
				
				public BookSchdule() {
								super();
				}
				
				public BookSchdule(String patientName,String patientId,String bookDate,String bookTime,String doctorName,String department) {
								super();
								this.patientName=patientName;
								this.patientId=patientId;
								this.bookDate=bookDate;
								this.bookTime=bookTime;
								this.doctorName=doctorName;
								this.department=department;								
					
				}
				
				public BookSchdule(String patientId,String bookDate,String bookTime) {
					super();
					this.patientId=patientId;
					this.bookDate=bookDate;
					this.bookTime=bookTime;					
		
				}

				public int getId() {
					return id;
				}

				public void setId(int id) {
					this.id = id;
				}

				public String getPatientName() {
					return patientName;
				}

				public void setPatientName(String patientName) {
					this.patientName = patientName;
				}

				public String getPatientId() {
					return patientId;
				}

				public void setPatientId(String patientId) {
					this.patientId = patientId;
				}

				public String getBookDate() {
					return bookDate;
				}

				public void setBookDate(String bookDate) {
					this.bookDate = bookDate;
				}

				public String getBookTime() {
					return bookTime;
				}

				public void setBookTime(String bookTime) {
					this.bookTime = bookTime;
				}

				public String getDepartment() {
					return department;
				}

				public void setDepartment(String department) {
					this.department = department;
				}

				public String getDoctorName() {
					return doctorName;
				}

				public void setDoctorName(String doctorName) {
					this.doctorName = doctorName;
				}

				public String getCancel() {
					return cancel;
				}

				public void setCancel(String cancel) {
					this.cancel = cancel;
				}

				public String getCancelTimeLog() {
					return cancelTimeLog;
				}

				public void setCancelTimeLog(String cancelTimeLog) {
					this.cancelTimeLog = cancelTimeLog;
				}
				
				
				
}
