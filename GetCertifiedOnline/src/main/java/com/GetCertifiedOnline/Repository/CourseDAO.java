package com.GetCertifiedOnline.Repository;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.GetCertifiedOnline.Entity.Course;


@Repository

public interface CourseDAO extends JpaRepository<Course, Integer> {

}
