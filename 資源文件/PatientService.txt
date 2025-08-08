package service;

import model.Patient;

public interface PatientService {
	
				//CREATE
				boolean addCheck(Patient patient); //判斷帳號是否重複
	
				//READ
				Patient login(String patientId,String password);
				Patient findPatientInfo(String patientId);

	
				//UPDATE
				public boolean update(String patientId,String password);

	
				//DELETE

}
