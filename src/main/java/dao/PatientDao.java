package dao;

import model.Patient;

public interface PatientDao {
	
			//CREATE
			void add(Patient patient);
			
	
			//READ
			Patient Select(String patientId,String password);
			Patient selectByPatientId(String patientId);
	
			//UPDATE
			Patient update(String patientId,String password);
			void update(Patient patient);
	
			//DELETE


}
