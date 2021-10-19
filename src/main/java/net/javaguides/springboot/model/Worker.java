package net.javaguides.springboot.model;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "workers")
public class Worker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "first_Name")
	private String firstName;

	@Column(name = "fast_Name")
	private String lastName;

	@Column(name = "telephone")
	private String telePhone;


	@Column(name = "occupation")
	private String occupation;

	public Worker() {

	}

	public Worker(String firstName, String lastName, String telePhone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.telePhone = telePhone;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String gettelePhone() {
		return telePhone;
	}
	public void settelePhone(String telePhone) {
		this.telePhone = telePhone;
	}
	public String getOccupation() {return occupation;}
	public void setOccupation(String occupation) {this.occupation = occupation;}

}
