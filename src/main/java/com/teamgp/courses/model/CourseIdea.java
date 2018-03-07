package com.teamgp.courses.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.github.slugify.Slugify;

public class CourseIdea {
	private String title;
	private String creator;
	private String slug;
	private Set<String> voters;
	
	public CourseIdea(String title, String creator) {
		voters = new HashSet<>();
		this.title = title;
		this.creator = creator;
		try {
			Slugify slugify = new Slugify();
			slug = slugify.slugify(title);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getTitle() {
		return title;
	}

	public String getCreator() {
		return creator;
	}
	
	public String getSlug() {
		return slug;
	}
	
	public boolean addVoter(String voterUsername) {
		return voters.add(voterUsername);
	}
	
	public int getVoteCount() {
		return voters.size();
	}
	
	public List<String> getVoters(){
		return new ArrayList<>(voters);
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseIdea other = (CourseIdea) obj;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}


}
