package org.joinsports.joinsports.entity;

/**
 * Created by Timo on 23.11.2016.
 */

public class Location {
    // Attributes
    private String townOrVillage;
    private int postcode;
    private String locationName;
    private int longitude;          // for Google Maps --> must be calculated by a service
    private int lattitude;

    // Constructor
    Location(String pTownOrVillage, int pPostcode, String pLocationName) {
        townOrVillage = pTownOrVillage;
        postcode = pPostcode;
        locationName = pLocationName;

        calculateMapPosition();
    }

    // Functions

    void calculateMapPosition() {
        // calculation

        // set the calculated lon/lat variables
        longitude = 0;
        lattitude = 0;
    }

    // Get- & Set - Methods
    public String getTownOrVillage() {
        return townOrVillage;
    }

    public void setTownOrVillage(String townOrVillage) {
        this.townOrVillage = townOrVillage;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getLattitude() {
        return lattitude;
    }

    public void setLattitude(int lattitude) {
        this.lattitude = lattitude;
    }

}
