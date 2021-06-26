package sg.edu.iss.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sg.edu.iss.demo.domain.Student;
import sg.edu.iss.demo.repo.StudentRepository;

@SpringBootApplication
public class DemoApplication {
	
	@Autowired
	StudentRepository srepo;//To create this instance of interface of student repository for doing the dependency injection.
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean//To test my data repository
	CommandLineRunner runner() {
		return args -> {
			
			Student s1 = new Student("Hou Lu", "Sweet", null, 5000.00, 4.50);
			Student s2 = new Student("Zerita", "Nice", null, 5000.00, 4.50);
			Student s3 = new Student("Austin", "Nice", null, 5000.00, 4.50);
			Student s4 = new Student("Benjo", "ExamSmart", null, 5000.00, 5.00);
			
			//after that which are above, now ready to put it to database
			srepo.save(s1);
			srepo.save(s2);
			srepo.save(s3);
			srepo.save(s4);
			
			//after saving, now I want to read back from database, so I want to use the repository class again.
			java.util.List<Student> list = srepo.findAll();
			for (Student student: list) {
				System.out.println("Record from DB" + student.toString());
							
			}
			
		};
	}

}
