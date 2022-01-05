package controller;

import Services.ProductDao;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductServlet", value = "/productServlet")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "create":{
                response.sendRedirect("/create.jsp");
                break;
            }
            case "edit":{
                editP(request,response);
                break;
            }
            default :
                goProductList(request,response);
                break;
        }

    }

    private void editP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Integer id= Integer.valueOf(request.getParameter("id"));
        Product product =ProductDao.findById(id);
        request.setAttribute("product",product);
        request.getRequestDispatcher("/edit.jsp").forward(request,response);
    }


    private void goProductList(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        request.setAttribute("productList", ProductDao.getListProduct());
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action) {
            case "create":{
                createProduct(request,response);
                break;
            }
            case "edit":
                editProduct(request,response);
                break;
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id= Integer.valueOf(request.getParameter("id"));
        String name= request.getParameter("name");
        Double price= Double.valueOf(request.getParameter("price"));
        Integer quantity= Integer.valueOf(request.getParameter("quantity"));
        String color=request.getParameter("color");
        String category=request.getParameter("category");
        Product product=new Product(id,name,price,quantity,color,category);
        ProductDao.save(product);
        request.setAttribute("message","Edit successfully!!");
        goProductList(request,response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        Integer id= Integer.valueOf(request.getParameter("id"));
        String name= request.getParameter("name");
        Double price= Double.valueOf(request.getParameter("price"));
        Integer quantity= Integer.valueOf(request.getParameter("quantity"));
        String color=request.getParameter("color");
        String category=request.getParameter("category");
        Product product=new Product(id,name,price,quantity,color,category);
        ProductDao.save(product);
        response.sendRedirect("/productServlet");

    }
}

