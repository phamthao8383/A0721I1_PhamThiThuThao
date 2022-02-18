package model;

public class Services {
private int serviceID;
private String serviceName;
private int area;
private double rentalCosts ;
private int max_number_people ;
private String criterion;
private String descriptions;
private double pool_are ;
private int number_floors ;

    public Services(int serviceID, String serviceName, int area, double rentalCosts, int max_number_people, String criterion, String descriptions, double pool_are, int number_floors) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.area = area;
        this.rentalCosts = rentalCosts;
        this.max_number_people = max_number_people;
        this.criterion = criterion;
        this.descriptions = descriptions;
        this.pool_are = pool_are;
        this.number_floors = number_floors;
    }

    public Services() {
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(double rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getMax_number_people() {
        return max_number_people;
    }

    public void setMax_number_people(int max_number_people) {
        this.max_number_people = max_number_people;
    }

    public String getCriterion() {
        return criterion;
    }

    public void setCriterion(String criterion) {
        this.criterion = criterion;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getPool_are() {
        return pool_are;
    }

    public void setPool_are(double pool_are) {
        this.pool_are = pool_are;
    }

    public int getNumber_floors() {
        return number_floors;
    }

    public void setNumber_floors(int number_floors) {
        this.number_floors = number_floors;
    }
}
