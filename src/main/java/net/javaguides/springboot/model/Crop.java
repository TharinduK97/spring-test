package net.javaguides.springboot.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "crops")
public class Crop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "crop_Name")
	private String cropName;

	@Column(name = "crop_Type")
	private String cropType;

	@Column(name = "start_Date")
	private String startDate;


	public Crop() {

	}

	public Crop( String cropName, String cropType, String startDate, List<Landslide> landslides) {
		super();
		this.cropName = cropName;
		this.cropType = cropType;
		this.startDate = startDate;

	}

	public long getCrop_id() {
		return id;
	}

	public void setCrop_id(long id) {
		this.id = id;
	}

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

	public String getCropType() {
		return cropType;
	}

	public void setCropType(String cropType) {
		this.cropType = cropType;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}




}
