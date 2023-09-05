package com.crud.CRUD.api.controllers;

import com.crud.CRUD.entities.concretes.Student;
import com.crud.CRUD.requests.CourseCreateRequest;
import com.crud.CRUD.business.abstracts.CourseService;
import com.crud.CRUD.entities.concretes.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CoursesController {
    private CourseService courseService;

    public CoursesController(CourseService courseService) {
        super();
        this.courseService = courseService;
    }

    @GetMapping("/getall")
    public List<Course> getAll(){
        return this.courseService.getAll(); }
    @PostMapping("/add")
    public Course create(@RequestBody CourseCreateRequest newCourseRequest){
        return this.courseService.create(newCourseRequest);
    }
    @GetMapping("/{courseId}")
    public Course get(@PathVariable int courseId){
        return this.courseService.get(courseId);
    }
    @PutMapping("/{courseId}")
    public Course update(@PathVariable int courseId, @RequestBody Course newCourse){
        return this.courseService.update(courseId,newCourse);}
    @DeleteMapping("/{courseId}")
    public void delete(@PathVariable int courseId){
        courseService.delete(courseId);
    }
    @GetMapping("/getby/{courseName}")
    Course getByCourseName(@PathVariable String courseName){
       return courseService.getByCourseName(courseName);
    }
    @DeleteMapping("/deletemultcourse")
    public void deleteMultCourse(@RequestParam List<Integer> courseIds){
        this.courseService.deleteMultCourse(courseIds);
    }
    @GetMapping("/{courseId}/students")
    List<Student> getStudentsEnrolledInCourse(@PathVariable int courseId){
        return this.courseService.getStudentsEnrolledInCourse(courseId);
    }

}
