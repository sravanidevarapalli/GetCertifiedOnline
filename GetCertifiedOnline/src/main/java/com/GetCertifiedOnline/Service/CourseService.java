package com.GetCertifiedOnline.Service;
import java.util.List;

import com.GetCertifiedOnline.Entity.Course;



public interface CourseService {
	public Course addCourse(Course c);
	public Course updateCourse(Course c);
	public List<Course> viewAllcourse();
	public Boolean deletecoursebyId(Integer id);
	public Course viewcourseById(Integer id);
	}
