package services;

import model.Customer;

import java.util.List;

public interface IServices {
    void insertServices(Services services) ;
    List<Services> selectAllServices();
}
