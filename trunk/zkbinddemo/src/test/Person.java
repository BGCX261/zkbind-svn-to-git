/**
 * 
 */
package test;

import java.util.Calendar;
import java.util.Date;

import org.zkoss.bind.annotation.DependsOn;
import org.zkoss.bind.annotation.NotifyChange;

/**
 * A Person bean.
 * @author henrichen
 *
 */
public class Person {
	private String firstName;
	private String lastName;
	private Date birthday;
	private boolean gender;
	private String phone;
	private Address address;
	
	public Person(String fname, String lname) {
		firstName = fname;
		lastName = lname;
	}
	
	//fire property change to base.firstName
	@NotifyChange
	public void setFirstName(String n) {
		this.firstName = n;
	}
	public String getFirstName() {
		return this.firstName;
	}
	
	@NotifyChange
	public void setLastName(String n) {
		this.lastName = n;
	}
	public String getLastName() {
		return this.lastName;
	}
	
	@DependsOn({"firstName", "lastName"})
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	
	@NotifyChange
	public void setBirthday(Date d) {
		this.birthday = d;
	}
	public Date getBirthday() {
		return this.birthday;
	}
	
	@NotifyChange
	public void setGender(boolean male) {
		this.gender = male;
	}
	public boolean getGender() {
		return this.gender;
	}
	
	@NotifyChange
	public void setPhone(String p) {
		this.phone = p;
	}
	public String getPhone() {
		return this.phone;
	}
	
	@NotifyChange
	public void setAddress(Address addr) {
		address = addr;
	}
	public Address getAddress() {
		if (address == null) {
			address = new Address("","");
		}
		return this.address;
	}

	@DependsOn({"address.street", "address.zip"})
	public String getFullAddr() {
		return address == null ? null : (address.getStreet() + " " + address.getZip());
	}
	
	public static class Address {
		private String _zip;
		private String _street;
		public Address(String street, String zip) {
			_zip = zip;
			_street = street;
		}
		public String getZip() {
			return _zip;
		}
		public String getStreet() {
			return _street;
		}
		@NotifyChange
		public void setZip(String zip) {
			_zip = zip;
		}
		@NotifyChange
		public void setStreet(String street) {
			_street = street;
		}
	}
}
