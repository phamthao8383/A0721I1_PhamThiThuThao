package services;

import model.Customer;

import java.util.List;

public interface ICustomerService {
    void insertCustomer(Customer customer) ;
    Customer selectCustomer(int customerID);
    List<Customer> selectAllCustomer();
    boolean deleteCustomer(int customerID);
    boolean updateCustomer(Customer customer) ;
}
