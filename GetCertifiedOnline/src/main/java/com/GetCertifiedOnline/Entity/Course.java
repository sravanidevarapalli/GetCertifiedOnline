package com.GetCertifiedOnline.Entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "course_table")
public class Course {
	@Id
	@GeneratedValue
	private int courseid;
	@NotBlank(message="name is mandatory")
	private String name;
	@NotBlank(message="duration should not be blank")
    private String duration;
	@NotBlank(message="description should not be blank")
    private String description;
	@DecimalMin("500")
    private int cost;
   
 public Course() {
    }
    public Course(int courseid, @NotBlank(message = "name is mandatory") String name,
			@NotBlank(message = "duration should not be blank") String duration,
			@NotBlank(message = "description should not be blank") String description, @DecimalMin("500") int cost) {
		super();
		this.courseid = courseid;
		this.name = name;
		this.duration = duration;
		this.description = description;
		this.cost = cost;
	}


	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}


	@Override
	public String toString() {
		return "Course [courseid=" + courseid + ", name=" + name + ", duration=" + duration + ", description="
				+ description + ", cost=" + cost + "]";
	}
		
    
}
	