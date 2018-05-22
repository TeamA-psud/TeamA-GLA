package Models;

public class Place {
	private String name,adresse,placeId,type;
	private String opennow,transport,url;
	private float rating;
	private Distance distance;
	public Place(String name,String adresse,String placeId,String type,String opennow,float rating,Distance distance,String transport,String url){
		this.name=name;
		this.adresse=adresse;
		this.placeId=placeId;
		this.type=type;
		this.opennow=opennow;
		this.rating=rating;
		this.distance=distance;
                this.transport=transport;
                this.url=url;
	}
        public String getUrl(){
            return url;
        }
        public void setUrl(String url){
            this.url=url;
        }
        public String getTransport(){
            return transport;
        }
        public void setTransport(String transport){
            this.transport=transport;
        }
	public Distance getDistance() {
		return distance;
	}

	public void setDistance(Distance distance) {
		this.distance = distance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String isOpennow() {
		return opennow;
	}

	public void setOpennow(String opennow) {
		this.opennow = opennow;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

    @Override
    public String toString() {
        return "Place{" + "name=" + name + ", adresse=" + adresse + ", placeId=" + placeId + ", type=" + type + ", opennow=" + opennow + ", rating=" + rating + ", duration =" + distance.getDuration() + "distance ="+ distance.getDistance()+'}';
    }
	
        
}
