package com.cc2000;

import java.util.Vector;

public class Student {
	
	private String id;
	private String name;
	private String grade;
	private String avgScore;
	private String profile;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getAvgScore() {
		return avgScore;
	}
	public void setAvgScore(String avgScore) {
		this.avgScore = avgScore;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	public Vector<String> getStuInfo(){
		Vector<String> retVector = new Vector<String>();
		retVector.add(id);
		retVector.add(name);
		retVector.add(grade);
		retVector.add(avgScore);
		retVector.add(profile);
		return retVector;
	}
	
	@Override
	public String toString(){
		return this.name;
	}
	

}
