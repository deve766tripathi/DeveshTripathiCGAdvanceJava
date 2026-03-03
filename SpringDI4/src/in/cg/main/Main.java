package in.cg.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.cg.beans.Student;
import in.cg.resources.SpringJavaConfigFile;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(SpringJavaConfigFile.class);
				
		
	   //Student s1=(Student) context.getBean(Student.class);
	   
	   Student s1=(Student) context.getBean("createStudentObject",Student.class);
//	   Student s2=(Student) context.getBean("Stdobj2",Student.class);
	  //Student s1=(Student) context.getBean("Stdid");
	  //Student s2=(Student) context.getBean("Stdobj2");
		s1.display();
		//s2.display();
	
	}

}

