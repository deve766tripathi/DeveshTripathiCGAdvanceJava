package in.cg.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Student {
	private int id;
	private String name;
	private String email;
	@Autowired
	private Address a;
	public void setA(Address a) {
		this.a = a;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void display() {
		System.out.println("id "+id);
		System.out.println("name "+name);
		System.out.println("email "+email);
		System.out.println("Address "+a);
		
	}
}
