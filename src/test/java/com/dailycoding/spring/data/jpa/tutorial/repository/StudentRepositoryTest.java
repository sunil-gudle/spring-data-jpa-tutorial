package com.dailycoding.spring.data.jpa.tutorial.repository;

import com.dailycoding.spring.data.jpa.tutorial.entity.Guardian;
import com.dailycoding.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("sunilgudle@gmail.com")
                .firstName("Sunil")
                .lastName("Gudle")
//                .guardianEmail("rajk@gmail.com")
//                .guardianName("Raju")
//                .guardianMobile("8348784792")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .email("kajuk@gmail.com")
                .name("Kaju")
                .mobile("8987493902")
                .build();

        Student student = Student.builder()
                .emailId("anilgudle@gmail.com")
                .firstName("Anil")
                .lastName("Gudle")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();

        System.out.println("StudentList: " + studentList);
    }

    @Test
    public void printStudentByFirstName(){

        List<Student> students = studentRepository.findByFirstName("Anil");

        System.out.println("Student: "+ students);
    }

    @Test
    public void printStudentByFirstNameContaining(){

        List<Student> students = studentRepository.findByFirstNameContaining("nil");

        System.out.println("Student: "+ students);
    }

    @Test
    public void printStudentByGuardianName(){

        List<Student> students = studentRepository.findByGuardianName("Raju");

        System.out.println("Student: "+ students);
    }

    @Test
    public void printStudentByLastNameNotNull(){

        List<Student> students = studentRepository.findByLastNameNotNull();

        System.out.println("Student: "+ students);
    }


    @Test
    public void printgetStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("sunilgudle@gmail.com");
        System.out.println("Student: " + student);
    }

    @Test
    public void printgetStudentFirstNameByEmailAddress(){
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("sunilgudle@gmail.com");
        System.out.println("Student: "+ firstName);
    }

    @Test
    public void printgetStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("sunilgudle@gmail.com");
        System.out.println("Student: " + student);
    }

    @Test
    void printgetStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("sunilgudle@gmail.com");
        System.out.println("Student: "+ student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId("Anil R", "anilgudle@gmail.com");
    }
}