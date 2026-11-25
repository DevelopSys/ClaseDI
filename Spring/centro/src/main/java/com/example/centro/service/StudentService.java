package com.example.centro.service;

import com.example.centro.model.Student;
import com.example.centro.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional // gestionar solo commit
public class StudentService {

    @Autowired
    private StudentRepository repository;

    /*
    public StudentService(SubjectRepository repository){
        // haz algo mas
        this.repository = repository;
    }*/
    // logica del negocio
    // dar de alta a un alumno
    /*
    confirmo que no existe es email
    mando un mail de confirmcion de alta
    inserto el usuario en BD
     */
    public List<Student> getAll() {
        List<Student> studentList = repository.findAll();
        return studentList;
    }

    public Optional<Student> getById(Long id) {
        // logica
        return repository.findById(id);
    }

    public Student add(Student student) {
        /*Optional<Student> studentFind
                = repository.findByEmail(student.getEmail());


        if (!studentFind.isPresent()) {
            return repository.save(student);
        } else {
            return null;
        }*/
        return repository.save(student);
    }

    public String updateByEmail(String email, Student student) {
        Optional<Student> studentFind = repository.findByEmail(email);
        if (studentFind.isPresent()) {
            Student st = studentFind.get();
            st.setAddress(student.getAddress());
            st.setPhone(student.getPhone());
            // update
            repository.save(st);
            return "Actualizado correctamente";
        }
        return "No hay usuario para actualizar";
    }

    public String updateById(Long id, Student student) {
        Optional<Student> studentFind = repository.findById(id);
        if (studentFind.isPresent()) {
            Student st = studentFind.get();
            st.setAddress(student.getAddress());
            st.setPhone(student.getPhone());
            // update
            repository.save(st);
            return "Actualizado correctamente";
        }
        return "No hay usuario para actualizar";
    }

    public int updateByLocation(String location, int phone) {
        /*List<Student> list = repository.findByAddress(location);
        for (Student item : list) {
            item.setPhone(phone);
            repository.save(item);
        }
        return list.size();*/
        // return repository.updateByLocation(location, phone);
        return -1;
    }

    public Optional<Student> getByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Student deleteById(Long id) {
        Optional<Student> student = repository.findById(id);
        if (student.isPresent()) {
            repository.deleteById(id);
            return student.get();
        }
        return null;
    }
}
