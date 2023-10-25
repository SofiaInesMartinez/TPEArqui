package tpe.tripms.dto;

import java.util.Objects;

public class DTOScooterStatusRequest {
	private String status;
	
	public DTOScooterStatusRequest() {
		super();
	}
	
	public DTOScooterStatusRequest(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DTOScooterStatusRequest other = (DTOScooterStatusRequest) obj;
		return Objects.equals(status, other.status);
	}
}
