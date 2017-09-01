/**
 * Klasse für das Stromnetz. 
 * Lässt sich durch andere Attribute je nach Bedarf erweitern.
 * 
 * @author Daniel Zart
 */
public class Stromnetz {

	private String power;
	private String ref;
	private String id;
	private String latitude;
	private String longitude;
	
	public Stromnetz()
	{}
	
	public String getID()
	{
		return id;
	}
	
	public void setID(String id)
	{
		this.id = id;
	}
	
	public String getPower()
	{
		return power;
	}
	
	public void setPower(String power)
	{
		this.power = power;
	}
	
	public String getRef()
	{
		return ref;
	}
	
	public void setRef(String ref)
	{
		this.ref = ref;
	}
	
	public String getLat()
	{
		return latitude;
	}
	
	public void setLat(String latitude)
	{
		this.latitude = latitude;
	}
	
	public String getLong()
	{
		return longitude;
	}
	
	public void setLong(String longitude)
	{
		this.longitude = longitude;
	}
	
	@Override
	public String toString() {
	    return "(ID: "  + this.id + ") " + "(Power: " + this.power + ") (Ref: "+ this.ref + ") (Latitude: " + this.latitude + ")" + "(Longitude: " + this.longitude + ") \n";
	  }
}
