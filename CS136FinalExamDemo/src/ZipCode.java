import java.io.Serializable;
import com.google.gson.annotations.SerializedName;

public class ZipCode implements Serializable 
{
  @SerializedName("post code")
  private String postCode;
  private String country;
  
  @SerializedName("country abbreviation")
  private String countryabbreviation;
  private Place[] places;
  
  public String getPostCode() {
    return postCode;
  }
  
  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }
  
  public String getCountry() {
    return country;
  }
  
  public void setCountry(String country) {
    this.country = country;
  }
  
  public String getCountryAbbreviation() {
    return countryabbreviation;
  }
  
  public void setCountryAbbreviation(String countryAbbreviation) {
    this.countryabbreviation = countryAbbreviation;
  }
  
  public Place[] getPlaces() {
    return places;
  }
  
  public void setPlaces(Place[] places) {
    this.places = places;
  }
  
  public static class Place implements Serializable 
  {    
       
    @SerializedName("place name")
    private String placename;
    private String longitude;
    private String state;
    
    @SerializedName("state abbreviation")
    private String stateabbreviation;
    private String latitude;
    
    public String getPlaceName() {
      return placename;
    }
    
    public void setPlaceName(String placeName) {
      this.placename = placeName;
    }
    
    public String getLongitude() {
      return longitude;
    }
    
    public void setLongitude(String longitude) {
      this.longitude = longitude;
    }
    
    public String getState() {
      return state;
    }
    
    public void setState(String state) {
      this.state = state;
    }
    
    public String getStateAbbreviation() {
      return stateabbreviation;
    }
    
    public void setStateAbbreviation(String stateAbbreviation) {
      this.stateabbreviation = stateAbbreviation;
    }
    
    public String getLatitude() {
      return latitude;
    }
    
    public void setLatitude(String latitude) {
      this.latitude = latitude;
    }
  }
}
