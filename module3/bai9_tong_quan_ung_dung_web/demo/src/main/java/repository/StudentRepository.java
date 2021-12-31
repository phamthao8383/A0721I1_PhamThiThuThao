package repository;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private static List<Student> studentList= new ArrayList<>();
    static {
        studentList.add(new Student(1,"HaiTT","01/01/1999",1,7.7));
        studentList.add(new Student(2,"Trung","01/01/1995",1,8.5));
        studentList.add(new Student(3,"Tam","12/01/1999",0,9.5));
    }
    @Override
    public void save(String id, String name, String grade) {
        Integer temp = Integer.parseInt(id);
        for(Student student: studentList) {
            if(student.getId().equals(temp)) {
                student.setName(name);
                student.setGrade(Double.valueOf(grade));
            }
        }
    }

    @Override
    public void delete(String id) {
        Integer temp = Integer.parseInt(id);
        for(Student student: studentList){
            if(student.getId().equals(temp)){
                studentList.remove(temp);
            }
        }
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public Student findById(String id) {
        Integer temp=Integer.parseInt(id);
        for(Student student:studentList){
            if(student.getId().equals(temp)){
                return student;
            }
        }
        return null;
    }
}
