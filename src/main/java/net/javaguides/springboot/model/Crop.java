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

	@OneToMany (mappedBy = "crop",fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	private List<Landslide> landslides;

	public Crop() {

	}

	public Crop(long id, String cropName, String cropType, String startDate, List<Landslide> landslides) {
		this.id = id;
		this.cropName = cropName;
		this.cropType = cropType;
		this.startDate = startDate;
		this.landslides = landslides;
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

	public List<Landslide> getLandslides() {
		return landslides;
	}

	public void setLandslides(List landslides) {
		this.landslides = landslides;
	}


}
