package pl.akademiakodu.AK_Spring_Exercise_BuildingManagerTOTO.models;

public class UserInput {

    private String width;
    private String length;
    private String floors;
    private String undergroundFloors;

    public UserInput() {
    }

    public UserInput(String width, String length, String floors, String undergroundFloors) {

        this.width = width;
        this.length = length;
        this.floors = floors;
        this.undergroundFloors = undergroundFloors;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getFloors() {
        return floors;
    }

    public void setFloors(String floors) {
        this.floors = floors;
    }

    public String getUndergroundFloors() {
        return undergroundFloors;
    }

    public void setUndergroundFloors(String undergroundFloors) {
        this.undergroundFloors = undergroundFloors;
    }
}
