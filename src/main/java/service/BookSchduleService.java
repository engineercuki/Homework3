package service;

import java.util.List;

import model.BookSchdule;

public interface BookSchduleService {

					//CREAT
					void addBooking(BookSchdule bookschdule);
	
	
					//READ
					List<BookSchdule> FindAllSchdule();
					BookSchdule FindMySchdule(String patientId);
					List<BookSchdule> FindMyAllSchdule(String patientId);
					
					//UPDATE
					boolean UpdateMySchdule(BookSchdule bookschdule);
	
					
					//DELETE
					boolean DeleteMySchdule(int id);
}
