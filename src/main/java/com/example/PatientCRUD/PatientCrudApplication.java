package com.example.PatientCRUD;

import com.example.PatientCRUD.entity.PatientEntity;
import com.example.PatientCRUD.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatientCrudApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PatientCrudApplication.class, args);
	}

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public void run(String... args) throws Exception {
		PatientEntity patientEntity = new PatientEntity();
		patientEntity.setPatientNo(1223);
		patientEntity.setFirstName("Paschal");
		patientEntity.setLastName("Mbowe");
		patientEntity.setPhoneNo(07622412);
		patientEntity.setUgonjwa("UTI");
		patientRepository.save(patientEntity);

		PatientEntity patientEntity1 = new PatientEntity();
		patientEntity1.setPatientNo(1224);
		patientEntity1.setFirstName("Kennedy");
		patientEntity1.setLastName("Bayona");
		patientEntity1.setPhoneNo(07622412);
		patientEntity1.setUgonjwa("HIV");
		patientRepository.save(patientEntity1);
	}
}
