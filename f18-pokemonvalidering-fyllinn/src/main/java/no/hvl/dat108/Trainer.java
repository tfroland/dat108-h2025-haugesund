package no.hvl.dat108;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Trainer {
	
	@Size(min=2, message="Name must contain at least 2 characters")
	@NotNull(message = "Name is mandatory")
	private String name;
	
	@Pattern(regexp = "^\\d{8}$", message="Phone number must be exactly 8 digits")
	@NotNull(message = "Phone number is mandatory")
	private String phone;
	
	@Min(value = 100, message = "Height in cm must be between 100 og 220")
	@Max(value = 220, message = "Height in cm must be between 100 og 220")
	private Integer heightcm;
	
	@Past(message = "Birth date can not be in the future")
	@NotNull(message = "Birth date is mandatory")
	private LocalDate bdate;
	
	@Override
	public String toString() {
		return "Trainer [name=" + name + ", phone=" + phone 
				+ ", heightcm=" + heightcm + ", bdate=" + bdate + "]";
	}
	
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public Integer getHeightcm() {
		return heightcm;
	}
	public LocalDate getBdate() {
		return bdate;
	}

	public void setNavn(String name) {
		this.name = name;
	}

	public void setMobil(String phone) {
		this.phone = phone;
	}

	public void setHeightcm(Integer heightcm) {
		this.heightcm = heightcm;
	}

	public void setBdate(LocalDate bdate) {
		this.bdate = bdate;
	}
	
	
}
