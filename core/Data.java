package core;

import java.io.Serializable;

public class Data implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String [][] grade;
	private String GPA;
	private String[] user_token;
	private Course[][][] timetable;
	private String name;
	private String major;
	private String [][] Exam;
	

	public String[][] getGrade() {
		return grade;
	}

	public void setGrade(String[][] grade) {
		this.grade = grade;
	}

	public String getGPA() {
		return GPA;
	}

	public void setGPA(String gPA) {
		GPA = gPA;
	}

	public String[] getUser_token() {
		return user_token;
	}

	public void setUser_token(String[] user_token) {
		this.user_token = user_token;
	}

	

	public Course[][][] getTimetable() {
		return timetable;
	}

	public void setTimetable(Course[][][] timetable) {
		this.timetable = timetable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String[][] getExam() {
		return Exam;
	}

	public void setExam(String[][] exam) {
		Exam = exam;
	}
	
	
	
	
}
