package service;

import model.Student;
import repository.IStudentRepository;
import repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService {
    private IStudentRepository iStudentRepository= new StudentRepository();

    @Override
    public List<Student> findAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public Student findById(String id) {
        return iStudentRepository.findById(id);
    }

    @Override
    public void save(String id, String name, String grade) {
       if(!name.matches("^[A-Za-z]{4,}$")){

       }
        iStudentRepository.save(id, name, grade);
    }

    @Override
    public void delete(Integer id) {
        iStudentRepository.delete(id);
    }


}
