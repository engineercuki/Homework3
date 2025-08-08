package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Patient implements Serializable{
	
					private int id;
					private String patientName;
					private String patientId;
					private String sex;
					private LocalDate birthday;
					private int age;
					private String phone; 
					private String password;
					private LocalDate today=LocalDate.now();
					
					public Patient() {
								super();
					}
					
					public Patient(String patientName,String patientId,String sex,String birthday,String phone,String password) {
								super();
								this.patientName=patientName;
								this.patientId=patientId;
								this.phone=phone;
								this.sex=sex;
								this.birthday=LocalDate.parse(birthday,DateTimeFormatter.ofPattern("yyyy/M/d")); //將字串轉LocalDate
								this.password=password;
								this.age=Period.between(this.birthday, today).getYears();	
					}
					
					public Patient(String patientId,String password) {
						super();
						this.patientId=patientId;
						this.password=password;
			}

					public Patient(String patientId,String name,String phome) {
						super();
						this.patientId=patientId;
						this.phone=phone;
						this.patientName=name;
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

					public String getSex() {
						return sex;
					}

					public void setSex(String sex) {
						this.sex = sex;
					}

					public LocalDate getBirthday() {
						return birthday;
					}

					public void setBirthday(LocalDate birthday) {
						this.birthday = birthday;
					}

					public int getAge() {
						return age;
					}

					public void setAge(int age) {
						this.age = age;
					}

					public String getPhone() {
						return phone;
					}

					public void setPhone(String phone) {
						this.phone = phone;
					}

					public String getPassword() {
						return password;
					}

					public void setPassword(String password) {
						this.password = password;
					}

					public LocalDate getToday() {
						return today;
					}

					public void setToday(LocalDate today) {
						this.today = today;
					}

						
					
					

}
