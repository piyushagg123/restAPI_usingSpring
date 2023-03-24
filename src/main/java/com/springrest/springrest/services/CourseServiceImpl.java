package com.springrest.springrest.services;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;

@Service

public class CourseServiceImpl implements CourseService{

	List<Course> list;
	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Course(145,"Java core course","this course contains basics of java"));
		list.add(new Course(4343,"spring boot course","creating rest apis"));
	}
	
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Course getCourse(long courseId) {
		// TODO Auto-generated method stub
		Course c = null;
		for(Course course:list) {
			if(course.getId()==courseId) {
				c=course;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		// TODO Auto-generated method stub
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		list.forEach(e->{
			if(e.getId()==course.getId()) {
				e.setTitle(e.getTitle());
				e.setDescription(e.getDescription());
			}
		});
		// TODO Auto-generated method stub
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
		// TODO Auto-generated method stub
		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
	}

}
