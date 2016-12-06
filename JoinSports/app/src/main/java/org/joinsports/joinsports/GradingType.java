package org.joinsports.joinsports;

/**
 * Created by Timo on 23.11.2016.
 */

public class GradingType {
    // Attributes
    private String type;
    private int points;

    // Constructor
    GradingType(String pType, int pPoints) {
        type = pType;
        points = pPoints;
    }

    // Functions

    // Get- & Set- Methods

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
