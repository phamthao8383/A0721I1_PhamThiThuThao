package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Services implements IServices{

    private String jdbcURL = "jdbc:mysql://localhost:3306/resort_management";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456789";
    private static final String INSERT_SERVICES_SQL = "INSERT INTO services" + "  (serviceID, serviceName,area,rentalCosts,max_number_people,criterion,descriptions,pool_area,number_floors" + ") VALUES " +
            " (?, ?);";
   // private static final String SELECT_CUSTOMERS_BY_ID = "select * from customers where customerID =?";
    private static final String SELECT_ALL_SERVICES = "select *from S;";
   // private static final String DELETE_CUSTOMERS_SQL = "delete from customers where customerID= ?;";
   // private static final String UPDATE_CUSTOMERS_SQL = "update customers set customerName = ?,birthDay = ?,gender = ?,IdCardPeople = ?,phoneNumber = ?,email= ?,address = ?,type_customerID = ?,where customerID = ?";

    public Services() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }


    @Override
    public void insertServices(Services services) {

    }

    @Override
    public List<Services> selectAllServices() {
        return null;
    }
}
