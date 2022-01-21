package controller;

import model.Customer;
import services.CustomerService;
import services.ICustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    private ICustomerService iCustomerService = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                response.sendRedirect("customer/create.jsp");
                break;
            }
            case "edit": {
                editCustomer(request, response);
                break;
            }
            case "delete": {
                deleteCustomer(request,response);
                break;
            }
            default:
                customerList(request, response);
                break;
        }

    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          int customerID=Integer.parseInt(request.getParameter("customerID"));
        iCustomerService.deleteCustomer(customerID);
        customerList(request,response);
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerID = Integer.parseInt(request.getParameter("customerID"));
        Customer customer = iCustomerService.selectCustomer(customerID);
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("customer/edit.jsp").forward(request, response);
    }

    private void customerList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> listCustomer = iCustomerService.selectAllCustomer();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create": {
                createCustomer(request, response);
                break;
            }
            case "edit": {
                updateCustomer(request, response);
                break;
            }
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerID= Integer.parseInt(request.getParameter("customerID"));
        String customerName =request.getParameter("customerName");
        Date birthDay= Date.valueOf(request.getParameter("birthDay"));
        byte gender= Byte.parseByte(request.getParameter("gender"));
        String idCardPeople=request.getParameter("idCardPeople");
        String phoneNumber=request.getParameter("phoneNumber");
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        int type_customerID= Integer.parseInt(request.getParameter("type_customerID"));
        Customer customer=new Customer(customerID,customerName,birthDay,gender,idCardPeople,phoneNumber,email,address,type_customerID);
        iCustomerService.updateCustomer(customer);
        List<Customer> listCustomer = iCustomerService.selectAllCustomer();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerName =request.getParameter("customerName");
        Date birthDay= Date.valueOf(request.getParameter("birthDay"));
        byte gender= Byte.parseByte(request.getParameter("gender"));
        String idCardPeople=request.getParameter("idCardPeople");
        String phoneNumber=request.getParameter("phoneNumber");
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        int type_customerID= Integer.parseInt(request.getParameter("type_customerID"));
        Customer customer=new Customer(customerName,birthDay,gender,idCardPeople,phoneNumber,email,address,type_customerID);
        iCustomerService.insertCustomer(customer);
        customerList(request,response);

    }
}
