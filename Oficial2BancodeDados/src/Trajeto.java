import java.util.Date;

import javax.persistence.*;

@Entity
public class Trajeto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private long taxiId;
	private Date data;
	private Double longitude;
	private Double latitude;
	
	public Trajeto() {
		super();
	}

	public Trajeto(long id, Date data, Double logitute, Double latitude) {
		super();
		this.taxiId = id;
		this.data = data;
		this.longitude = logitute;
		this.latitude = latitude;
	}

	public long getTaxiId() {
		return taxiId;
	}

	public void setTaxiId(long taxiId) {
		this.taxiId = taxiId;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		return "Trajeto [id=" + taxiId + "logitute=" + longitude + ", latitude=" + latitude + "]";
	}
	
	
	
	
	
	
	
	
}
