package tpe.scooterMS.DTO;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class TariffRequestDTO {
	@NotNull(message = "normal shouldn't be null")
	@PositiveOrZero(message = "normal should be positive or zero")
	private float normal;
	@NotNull(message = "extra shouldn't be null")
	@PositiveOrZero(message = "extra should be positive or zero")
	private float extra;
	@NotNull(message = "startDate shouldn't be null")
	private Date startDate;
	
	public TariffRequestDTO() {
		super();
	}
	
	public TariffRequestDTO(float normal, float extra, Date startDate) {
		super();
		this.normal = normal;
		this.extra = extra;
		this.startDate = startDate;
	}


	public float getNormal() {
		return normal;
	}


	public void setNormal(float normal) {
		this.normal = normal;
	}


	public float getExtra() {
		return extra;
	}


	public void setExtra(float extra) {
		this.extra = extra;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
}
