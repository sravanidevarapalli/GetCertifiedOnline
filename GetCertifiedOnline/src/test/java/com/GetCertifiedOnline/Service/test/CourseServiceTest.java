package com.GetCertifiedOnline.Service.test;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
	import static org.mockito.Mockito.times;
	import static org.mockito.Mockito.verify;
	import static org.mockito.Mockito.when;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Optional;
	import org.junit.jupiter.api.Test;
	import org.junit.jupiter.api.extension.ExtendWith;
	import org.junit.runner.RunWith;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.junit.jupiter.MockitoExtension;
	import org.springframework.test.context.junit4.SpringRunner;

import com.GetCertifiedOnline.Entity.Course;
import com.GetCertifiedOnline.Repository.CourseDAO;
import com.GetCertifiedOnline.Service.CourseServiceImpl;


	@ExtendWith(MockitoExtension.class)
	@RunWith(SpringRunner.class)
	public class CourseServiceTest {

		@InjectMocks
		CourseServiceImpl service;

		@Mock
		CourseDAO dao;
		

		@Test
		public void addCourseTest() {

			Course c = new Course(1,"Python","2months","abc",5000);

			when(dao.saveAndFlush(c)).thenReturn(c);

			assertEquals(c, service.addCourse(c));

		}

		

		@Test
		public void updateCourseTest() {

			Course c = new Course(1,"Html","1month","xyz",5000);	
			when(dao.saveAndFlush(c)).thenReturn(c);
            assertEquals(c, service.updateCourse(c));

		}
		
		@Test
		public void getAllCourseTest() {

			List<Course> list = new ArrayList<>();
			Course c1 = new Course(1,"Python","2months","abc",5000);			
					Course c2 = new Course(2,"Html","1month","xyz",4000);	
			list.add(c2);
			list.add(c1);

			when(dao.findAll()).thenReturn(list);
			List<Course> CourseList = service.viewAllcourse();
			assertEquals(2, CourseList.size());
			verify(dao, times(1)).findAll();

		}
		
		@Test 
		public void viewCourseByIdTest() {
			 
			Course c1 = new Course(1,"Python","2months","abc",5000);	
			Course c2 = new Course(2,"Html","1month","xyz",4000);	
			dao.saveAndFlush(c1);
			dao.saveAndFlush(c2);
		
		     when(dao.findById(c1.getCourseid())).thenReturn(Optional.of(c1));
		     
		     assertEquals(c1,service.viewcourseById(c1.getCourseid()));
		}
		
	
		@Test
		public void DeleteCourseByIdTest() {
			Course c = new Course(1,"Python","2months","abc",5000);		
		
			when(dao.existsById(c.getCourseid())).thenReturn(false);
			assertFalse(dao.existsById(c.getCourseid()));
		}    
		}

