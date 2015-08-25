package org.zkoss.mvvm.examples.modularized;

import org.zkoss.bind.annotation.Command;

public class ModularizedVM {

	Person person1;
	Person person2;
	
	public ModularizedVM(){
		person1 = new Person("Foo","Bar");
		person2 = new Person("Xyz","Abc");
	}

	public Person getPerson1() {
		return person1;
	}

	public void setPerson1(Person person1) {
		this.person1 = person1;
	}

	public Person getPerson2() {
		return person2;
	}

	public void setPerson2(Person person2) {
		this.person2 = person2;
	}

	public static class Person {
		String firstName;
		String lastName;
		
		
		public Person(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		
	}
}
