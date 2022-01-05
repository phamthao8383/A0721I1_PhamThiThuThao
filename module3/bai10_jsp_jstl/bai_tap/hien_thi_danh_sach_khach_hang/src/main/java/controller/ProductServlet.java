package controller;

import dao.ProductDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private ProductDao productDao=new ProductDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        detailProduct(request,response);
       // request.setAttribute("product",productDao);

    }

    private void detailProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
     request.setAttribute("productList",productDao.getListProduct());
        request.getRequestDispatcher("/detail.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
