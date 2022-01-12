package controller;

import model.Student;
import repository.IStudentRepository;
import service.IStudentService;
import service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = {"/student"})
public class StudentServlet extends HttpServlet {
    private IStudentService iStudentService =new StudentService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action= request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action) {
            case "update": {
                String id=request.getParameter("id");
                String name =request.getParameter("name");
                String grade =request.getParameter("grade");
                iStudentService.save(id,name,grade);
                response.sendRedirect("/student");
            }

        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action= request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "update":{
                String id =request.getParameter("id");
                Student student =iStudentService.findById(id);
                request.setAttribute("student",student);
                request.getRequestDispatcher("/update_student.jsp").forward(request,response);
            }
            case "delete":{
                Integer id= Integer.valueOf(request.getParameter("id"));
                iStudentService.delete(id);
                List<Student> studentList =iStudentService.findAll();
                request.setAttribute("studentList",studentList);
                request.getRequestDispatcher("/list_student.jsp").forward(request,response);
                response.sendRedirect("/student");
            }

            default :{
                List<Student> studentList =iStudentService.findAll();
                request.setAttribute("studentList",studentList);
                request.getRequestDispatcher("/list_student.jsp").forward(request,response);

            }
        }
    }
}
