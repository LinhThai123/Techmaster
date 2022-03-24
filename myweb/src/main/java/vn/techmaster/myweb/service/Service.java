package vn.techmaster.myweb.service;

import java.util.List;

import vn.techmaster.myweb.model.Student;

public class Service {
      public static void getListStudent(List<Student> listStudent){
            for(Student student : listStudent){
                System.out.println(student);
            }
        }
}
