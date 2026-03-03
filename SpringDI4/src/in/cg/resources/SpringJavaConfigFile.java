package in.cg.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.cg.beans.Address;
import in.cg.beans.Student;

@Configuration
public class SpringJavaConfigFile {
	
	@Bean
	public Address createAddressObj() {
		Address a=new Address();
		a.setHno(101);
		a.setCity("Jaunpur");
		a.setPincode(22001);
		
		return a;
	}
		
		@Bean()
		public Student createStudentObject() {
			Student s1=new Student();
			s1.setId(12224421);
			s1.setName("Rahul");
			s1.setEmail("rahul.gmail.com");
			//s1.setA(createAddressObj()); manual injection
			
			return s1;
		
	}

}