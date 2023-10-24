package tpe.scooterMS.model;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Scooter implements Serializable {
	
	@Id
	private long id;
	@Column(nullable = true)
	private Date lastMaintenanceDate;
	@Column(nullable= true)
	private float kilometers;
	@Column(nullable = false)
	private String status;
	
	public Scooter(long id, Date lastMaintenanceDate, float kilometers) {
		super();
		this.id = id;
		this.lastMaintenanceDate = lastMaintenanceDate;
		this.kilometers = kilometers;
		this.status = "available";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public float getKms() {
		return kilometers;
	}

	public void setKms(float kilometers) {
		this.kilometers = kilometers;
	}

	public Date getLastMaintenanceDate() {
		return lastMaintenanceDate;
	}

	public void setLastMaintenanceDate(Date lastMaintenanceDate) {
		this.lastMaintenanceDate = lastMaintenanceDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
}
