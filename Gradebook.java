/*
* Names: Stephen Doudaklian & Sharif Saeed
* netID: sdoudakl, ssaeed24
* G#: 01422164, 01314603
* Lecture section: 004
* Lab section: 209, 208
*/

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Gradebook implements Comparator<StudentGrades>{
	
	private Collection<StudentGrades> grades;
	
	public Gradebook(){
		grades = new ArrayList<>();
	}
	
	public void addGrade(StudentGrades sg){
		grades.add(sg);
	}
	/**
	 * 
	 * @return average score, total score divided by size of grades
	 */
	public double average(){
		double totscore;
		totscore = 0;
		for (StudentGrades sg : grades){
			totscore += sg.totalScore();
		}
		return totscore / grades.size();
	}
	/**
	 * 
	 * @return minimum element of grades
	 */
	public StudentGrades min(){
		return Collections.min(grades, this);
	}
	/**
	 * 
	 * @return maximum element of grades
	 */
	public StudentGrades max(){
		return Collections.max(grades, this);

	}
	/**
	 * 
	 * @return StudentGrades object, median grade from grades
	 */
	public StudentGrades median(){
		ArrayList<StudentGrades> gradelist = new ArrayList<>(grades);
		Collections.sort(gradelist, this);
		int midpoint = gradelist.size() / 2;
		StudentGrades getter = gradelist.get(midpoint);
		return getter;
	}

	public int compare(StudentGrades left, StudentGrades right){
		return (int)(left.totalScore()-right.totalScore());
	}

	//provided
	public String toString(){
		String rv = "Grades: [ ";
		for(StudentGrades sg : grades){
			rv += "("+sg.getStudentName()+": "+sg.letterGrade()+"), ";
		}
		rv += "]\n";
		rv += "Max: "+max()+", Median: "+median()+", Average: "+average()+", Min: "+min();
		return rv;
	}


}