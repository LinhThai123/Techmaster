package vn.techmaster.myweb.repository;

import java.util.ArrayList;
import java.util.List;

import vn.techmaster.myweb.model.Student;

public class ListStudent {
      public static List<Student> getStudent() {
            List<Student> students = new ArrayList<>();
            students.add(new Student(1,"Cường",21,"Hà Nội"));
            students.add(new Student(2,"Quân",23,"Vĩnh Phúc"));
            students.add(new Student(3,"Hải",21,"Hải Dương"));
            students.add(new Student(4,"Minh",23,"Hà Nội"));
            return students;
        }
}
