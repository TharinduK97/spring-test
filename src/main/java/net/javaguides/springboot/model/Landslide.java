package net.javaguides.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "landslides")
public class Landslide {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "size")
	private String size;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "crop_id", nullable = false)
	private Crop crop;


	public Landslide() {

	}

	public Landslide(String size, Crop crop_id) {
		super();
		this.size = size;
		this.crop = crop_id;

	}
	public long getId() {

		return id;
	}
	public void setId(long id) {

		this.id = id;
	}
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Crop getCrop() {
		return crop;
	}

	public void setCrop(Crop crop) {
		this.crop = crop;
	}

}
