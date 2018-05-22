package Models;

public class GeoLocation {
	private double lat,lon;
	
	public GeoLocation(double lat,double lon){
		this.lat=lat;
		this.lon=lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	@Override
	public String toString() {
		return lat+","+lon;
	}
	
}
