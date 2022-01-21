package services;

import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerService implements ICustomerService{

    private String jdbcURL = "jdbc:mysql://localhost:3306/resort_management";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456789";
    private static final String INSERT_CUSTOMERS_SQL = "INSERT INTO customers" + "  (customerID, customerName,birthDay,gender,IdCardPeople,phoneNumber,email,address,type_customerID" + ") VALUES " +
            " (?, ?, ?,?,?,?,?,?,?);";
    private static final String SELECT_CUSTOMERS_BY_ID = "select * from customers where customerID =?";
    private static final String SELECT_ALL_CUSTOMERS = "select *from customers;";
    private static final String DELETE_CUSTOMERS_SQL = "delete from customers where customerID= ?;";
    private static final String UPDATE_CUSTOMERS_SQL = "update customers set customerName = ?,birthDay = ?,gender = ?,IdCardPeople = ?,phoneNumber = ?,email= ?,address = ?,type_customerID = ?,where customerID = ?";

    public CustomerService() {
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
    public void insertCustomer(Customer customer) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMERS_SQL)) {
            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.setDate(2, (java.sql.Date) customer.getBirthDay());
            preparedStatement.setInt(3, customer.getGender());
            preparedStatement.setString(4, customer.getIdCardPeople());
            preparedStatement.setString(5, customer.getPhoneNumber());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getAddress());
            preparedStatement.setInt(8, customer.getType_customerID());

            // System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // printSQLException(e);
        }

    }

    @Override
    public Customer selectCustomer(int customerID) {
        Customer customer = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMERS_BY_ID);) {
            preparedStatement.setInt(1, customerID);
            // System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
              //  int customerID = rs.getInt("customerID");
                String customerName = rs.getString("customerName");
                Date birthDay = rs.getDate("birthDay");
                byte gender=rs.getByte("gender");
                String idCardPeople = rs.getString("idCardPeople");
                String phoneNumber = rs.getString("phoneNumber");
                String email=rs.getString("email");
                String address=rs.getString("address");
                int type_customerID=rs.getInt("type_customerID");
                customer =new Customer(customerID, customerName, birthDay, gender, idCardPeople, phoneNumber,email,address,type_customerID);
            }
        } catch (SQLException e) {
            // printSQLException(e);
        }
        return customer;
    }


    @Override
    public List<Customer> selectAllCustomer() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Customer> customers = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int customerID = rs.getInt("customerID");
                String customerName = rs.getString("customerName");
                Date birthDay = rs.getDate("birthDay");
                byte gender=rs.getByte("gender");
                String idCardPeople = rs.getString("idCardPeople");
                String phoneNumber = rs.getString("phoneNumber");
                String email=rs.getString("email");
                String address=rs.getString("address");
                int type_customerID=rs.getInt("type_customerID");
                customers.add(new Customer(customerID, customerName, birthDay, gender, idCardPeople, phoneNumber,email,address,type_customerID));
            }
        } catch (SQLException e) {
            //  printSQLException(e);
        }
        return customers;
    }



    @Override
    public boolean deleteCustomer(int customerID) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMERS_SQL);) {
            statement.setInt(1, customerID);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMERS_SQL)) {
            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.setDate(2, (java.sql.Date) customer.getBirthDay());
            preparedStatement.setInt(3, customer.getGender());
            preparedStatement.setString(4, customer.getIdCardPeople());
            preparedStatement.setString(5, customer.getPhoneNumber());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getAddress());
            preparedStatement.setInt(8, customer.getType_customerID());

            // System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // printSQLException(e);
        }
        return rowUpdated;
    }


}
