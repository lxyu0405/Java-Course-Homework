package _3Homework;

public class _10_9_Course {
	private String courseName;
	private String[] students = new String[50];
	private int numberOfStudents;
	public _10_9_Course(String courseName){
		this.courseName = courseName;
	}
	public void addStudents(String student){
		if(numberOfStudents == 50){
			String[] newStudents = new String[numberOfStudents + 50];
			//System.arraycopy(students, 0, newStudents,numberOfStudents , numberOfStudents);
			for(int i = 0;i < numberOfStudents;i++)
				newStudents[i] = students[i];
			students = newStudents;
			System.out.println("Grow Automatically");
		}
		students[numberOfStudents] = student;
		numberOfStudents++;
		//System.out.println(students.length);
	}
	public String[] getStudents(){
		return students;
	}
	public int getNumberOfStudents(){
		return numberOfStudents;
	}
	public String getCourseName(){
		return courseName;
	}
	public void dropStudents(String student){
		//System.out.println("dropStudents");
		for(int i = 0;i < numberOfStudents;i++){
			//System.out.println("testDrop" + numberOfStudents+ students[i]);
			if(students[i].equals(student)){
				numberOfStudents--;
				students[i] = "empty";
			}
		}
	}
	public void clear(){
		for(int i = 0;i < numberOfStudents;i++)
			students[i] = "null";
		numberOfStudents = 0;
	}
}
