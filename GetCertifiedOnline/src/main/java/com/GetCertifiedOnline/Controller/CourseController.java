package com.GetCertifiedOnline.Controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GetCertifiedOnline.Entity.Course;
import com.GetCertifiedOnline.Exception.CourseNotFoundException;
import com.GetCertifiedOnline.Service.CourseService;

@CrossOrigin("*")
@RestController()
@RequestMapping("/course")
@Validated
 
    public class CourseController {
	private static final Logger logger = LoggerFactory.getLogger(CourseController.class);
	 @Autowired
		CourseService courseservice;
	 
	 @PostMapping("/addcourse")
	 public Course addCourse(@Valid @RequestBody Course c) {
		 logger.info("Course is added");
		 return courseservice.addCourse(c);
		  }
	 
	 @PutMapping("/updatecourse")
	 public Course updateCourse( @Valid @RequestBody Course c) {
		 logger.info("Course is updated");
		 return courseservice.updateCourse(c);
		  }
	 
	 @GetMapping("/viewAllcourse")
	 public List<Course> viewAllcourse() {
		 logger.info("view all the course");
		 return courseservice.viewAllcourse();
		 }
	 
	 @GetMapping(value="/viewcoursebyid/{id}")
	 public Course viewcourseById(@PathVariable Integer id) throws CourseNotFoundException {
		 logger.info("In Course Controller to retrive a Course by Id...>!!!");
		 Course c = null;
		 try {
			 logger.info("Course Id to be searched.."+id);
			 c=courseservice.viewcourseById(id);
		 }catch(Exception e) {
			 throw new CourseNotFoundException("Enter valid Course id");
		 }
		 return c;
		 }
	
		 @DeleteMapping(value="/deletecourse/{id}")
	 public Boolean deletecourse(@PathVariable Integer id) throws CourseNotFoundException {
			 logger.info("In Course Controller to delete Course by Id...>!!!");
			 try {
				 logger.info("Course Id to be deleted.."+id);
				 courseservice.deletecoursebyId(id);
				 return true;
			 }catch(Exception e) {
				 logger.info("In catch block of DeleteCourseById()..!");
				 throw new CourseNotFoundException("Enter an existing Course id to be deleted");
				 }
//                  return courseservice.deletecoursebyId(id);
		    }
}
	 
	 
	 
	 

	 
	 
	 

