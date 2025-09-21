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
import java.util.List;

public class StudentGrades{
    private double participation;
    private double midterm;
    private double finalExam;
    private Collection<Double> labs;
    private Collection<Double> projects;
    private Collection<Double> exercises;
    private List<Double> readings;


    private double participationWeight;
    private double readingsWeight;
    private double labsWeight;
    private double exercisesWeight;
    private double projectsWeight;
    private double midtermWeight;
    private double finalExamWeight;

    private String studentName;
    private String gNumber;

    public StudentGrades(String name, String gNumber, double[] weights){
        this.studentName = name;
        this.gNumber = gNumber;
        this.participationWeight = weights[0];
        this.readingsWeight = weights[1];
        this.labsWeight = weights[2];
        this.exercisesWeight = weights[3];
        this.projectsWeight = weights[4];
        this.midtermWeight = weights[5];
        this.finalExamWeight = weights[6];
        this.labs = new ArrayList<>();
        this.projects = new ArrayList<>();
        this.exercises = new ArrayList<>();
        this.readings = new ArrayList<>();
        
    }
    /**
     * 
     * @param p set participation grade
     */
    public void setParticipation(double p){
        this.participation = p;
    }
    /**
     * 
     * @return participation grade as double
     */
    public double getParticipation(){
        return participation;
    }
    /**
     * 
     * @param m, set midterm grade
     */
    public void setMidterm(double m){
        this.midterm = m;
    }
    /**
     * 
     * @return midterm grade as double
     */
    public double getMidterm(){
        return midterm;
    }
    /**
     * 
     * @param fe set final exam score
     */
    public void setFinalExam(double fe){
        this.finalExam = fe;
    }
    /**
     * 
     * @return final exam score as double
     */
    public double getFinalExam(){
        return finalExam;
    }
    /**
     * 
     * @param name set student name
     */
    public void setStudentName(String name){
        this.studentName = name;
    }
    /**
     * 
     * @return student name as string
     */
    public String getStudentName(){
        return studentName;
    }
    /**
     * 
     * @param gNumber sets gNumber
     */
    public void setGNumber(String gNumber){
        this.gNumber = gNumber;
    }
    /**
     * 
     * @return gNumber as string
     */
    public String getGNumber(){
        return gNumber;
    }
    /**
     * 
     * @param d reading grade input
     */
    public void addReading(double d){
        readings.add(d);

    }
    /**
     * 
     * @param d lab grade input
     */
    public void addLab(double d){
        labs.add(d);
    }
    /**
     * 
     * @param d exercise grade input
     */
    public void addExercise(double d){
        exercises.add(d);
    }
    /**
     * 
     * @param d project grade input
     */
    public void addProject(double d){
        projects.add(d);
    }
    /**
     * 
     * @param weights array of predetermined weights
     * set weights for all categories
     */
    public void setWeights(double[] weights){
        this.participationWeight = weights[0];
        this.readingsWeight = weights[1];
        this.labsWeight = weights[2];
        this.exercisesWeight = weights[3];
        this.projectsWeight = weights[4];
        this.midtermWeight = weights[5];
        this.finalExamWeight = weights[6];
    }
    /**
     * 
     * @return unweighted readings score
     * sorts formatted reading scores and returns the unweighted score
     * if readings are less than 16, score is 100
     */
    public double unweightedReadingsScore(){
        int i;
        if (readings.size() < 16){
            return 100.0;

        }
        List<Double> readingsFormatted = new ArrayList<>(readings);
        Collections.sort(readingsFormatted);
        double total = 0.0;
        
        for (i = 15; i < readingsFormatted.size(); i++){
            total += readingsFormatted.get(i);
        }
        return total / (readingsFormatted.size() - 15);
        

    }
    /**
     * 
     * @return unweighted labs score (total divided by size of category)
     * if labs is empty, return 100 indicating full credit
     * 
     */
    public double unweightedLabsScore(){
        if (labs.isEmpty()){
            return 100.0;
        }
        double total = 0;
        for (Double score : labs){
            total += score;
        }
        return total / labs.size();

    }
    /**
     * 
     * @return unweighted exercise score (total divided by size of category)
     * if exercise category is empty, return 100 indicating full score
     */
    public double unweightedExercisesScore(){
        if (exercises.isEmpty()){
            return 100.0;
        }
        double total = 0;
        for (Double score : exercises){
            total +=score;
        }
        return total / exercises.size();
    }
    /**
     * 
     * @return unweighted projects score (total divided by size of category)
     * if projects category is empty, return 100 indicating full score
     */
    public double unweightedProjectsScore(){
        if (projects.isEmpty()){
            return 100.0;
        }
        double total = 0;
        for (Double score : projects){
            total += score;
        }
        return total / projects.size();

    }
    /**
     * 
     * @return true if finalExam score is greater than midterm score, false otherwise
     */
    public boolean finalReplacesMidterm(){
        if (finalExam > midterm){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * 
     * @return true if finalExam is greater than or equal to 60, false otherwise
     */
    public boolean finalIsPassing(){
        if (finalExam >= 60){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * 
     * @return total score as a double
     * if final is passing and final score is > midterm, then midterm is replaced by final grade
     * else, add regular final exam and midterm scores to total
     */
    public double totalScore(){
        double total = (unweightedLabsScore() * labsWeight) +
        (unweightedExercisesScore() * exercisesWeight) + 
        (unweightedProjectsScore() * projectsWeight) +
        (participation * participationWeight) +
        (unweightedReadingsScore() * readingsWeight);

        if (finalIsPassing() == true && finalReplacesMidterm() == true){
            midterm = finalExam * midtermWeight;
            total += midterm;
            total += finalExam * finalExamWeight;
        }
        else{
            total += finalExam * finalExamWeight;
            total += midterm*midtermWeight;
        }
        return total;
    }
    /**
     * 
     * @return letter grade as string
     */
    public String letterGrade(){
        double total = totalScore();
        if (finalIsPassing() == false){
            return "F";
        }
        if (total >= 98){
            return "A+";
        }
        else if (total >= 92){
            return "A";
        }
        else if (total >= 90){
            return "A-";
        }
        else if (total >= 88){
            return "B+";
        }
        else if (total >= 82){
            return "B";
        }
        else if (total >= 80){
            return "B-";
        }
        else if (total >=78){
            return "C+";
        }
        else if (total >= 72){
            return "C";
        }
        else if (total >= 70){
            return "C-";
        }
        else if (total >= 60){
            return "D";
        }
        else{
            return "F";
        }

    }
    @Override
    public String toString(){
		String rv = "Name: "+getStudentName()+"\n";
		rv += "G#: "+getGNumber()+"\n";
		rv += "Participation: "+getParticipation()+"\n";
		rv += "Readings: "+unweightedReadingsScore()+", "+readings+"\n";
		rv += "Labs: "+unweightedLabsScore()+", "+labs+"\n";
		rv += "Exercises: "+unweightedExercisesScore()+", "+exercises+"\n";
		rv += "Projects: "+unweightedProjectsScore()+", "+projects+"\n";
		rv += "Midterm: "+getMidterm()+"\n";
		rv += "Final Exam: "+getFinalExam()+"\n";
		rv += totalScore()+", "+letterGrade()+"\n";
		return rv;
	}
}   