package Models;

public class Distance {
	private GeoLocation startLocation,endLocation;
	private String distance,duration;
	public Distance(String distance,String duration){
		this.distance=distance;
		this.duration=duration;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Distance(GeoLocation startLocation,GeoLocation endLocation){
		this.startLocation=startLocation;
		this.endLocation=endLocation;
	}

	public GeoLocation getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(GeoLocation startLocation) {
		this.startLocation = startLocation;
	}

	public GeoLocation getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(GeoLocation endLocation) {
		this.endLocation = endLocation;
	}
	
        @Override
	public String toString(){
            return getDistance()+"--"+getDuration();
        }
}
