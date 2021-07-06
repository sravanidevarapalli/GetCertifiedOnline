package com.GetCertifiedOnline.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GetCertifiedOnline.Entity.Course;
import com.GetCertifiedOnline.Repository.CourseDAO;



@Service

public class CourseServiceImpl implements CourseService {
	@Autowired
	CourseDAO coursedao;

	public Course addCourse(Course c) {
		coursedao.saveAndFlush(c);
		return c;
	}

	public Course updateCourse(Course c) {
		coursedao.saveAndFlush(c);
		return c;
	}

	public List<Course> viewAllcourse() {
		return coursedao.findAll();
	}

	public Boolean deletecoursebyId(Integer id) {
		coursedao.deleteById(id);
		return true;
	}

	public Course viewcourseById(Integer id) {
	Optional<Course> course = coursedao.findById(id);
	return course.get();
	}
		
	
}
