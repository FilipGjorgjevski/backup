package com.example.class10.service;

import com.example.class10.model.Course;
import com.example.class10.model.Grade;
import com.example.class10.model.Student;
import com.example.class10.repository.CourseRepository;
import com.example.class10.repository.GradeRepository;
import com.example.class10.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private GradeRepository gradeRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudent(Long id) {
        return studentRepository.findById(id);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getStudentsByCourse(Long courseId) {
        // Try to find the course by ID
        Optional<Course> optionalCourse = courseRepository.findById(courseId);

        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            Set<Student> studentsSet = course.getStudents();
            return new ArrayList<>(studentsSet);
        } else {
            // Return empty list if course doesn't exist
            return new ArrayList<>();
        }
    }

    public Student addStudentToCourse(Long courseId, Long studentId) {
        Course course = courseRepository.findById(courseId).orElseThrow();
        Student student = studentRepository.findById(studentId).orElseThrow();
        course.getStudents().add(student);
        student.getCourses().add(course);
        courseRepository.save(course);
        return studentRepository.save(student);
    }

    public void removeStudentFromCourse(Long courseId, Long studentId) {
        Course course = courseRepository.findById(courseId).orElseThrow();
        Student student = studentRepository.findById(studentId).orElseThrow();
        course.getStudents().remove(student);
        student.getCourses().remove(course);
        courseRepository.save(course);
        studentRepository.save(student);
    }

    public Grade addGrade(Long courseId, Long studentId, Double gradeValue) {
        Course course = courseRepository.findById(courseId).orElseThrow();
        Student student = studentRepository.findById(studentId).orElseThrow();
        Grade grade = new Grade(gradeValue, student, course);
        return gradeRepository.save(grade);
    }

    public Double getAverageGradeForCourse(Long courseId) {
        List<Grade> grades = gradeRepository.findByCourseId(courseId);
        return grades.stream().collect(Collectors.averagingDouble(Grade::getGradeValue));
    }
}
