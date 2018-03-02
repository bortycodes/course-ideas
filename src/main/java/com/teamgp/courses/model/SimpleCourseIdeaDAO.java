package com.teamgp.courses.model;

import java.util.ArrayList;
import java.util.List;

public class SimpleCourseIdeaDAO implements CourseIdeaDAO{
	private List<CourseIdea> ideas;
	
	public SimpleCourseIdeaDAO() {
		ideas = new ArrayList<>();
	}
	
	
	@Override
	public boolean add(CourseIdea idea) {
		// TODO Auto-generated method stub
		return ideas.add(idea);
	}

	@Override
	public List<CourseIdea> findAll() {
		// TODO Auto-generated method stub
		return new ArrayList<>(ideas);
	}

}
