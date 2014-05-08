package _3Homework;

public class _10_9_CourseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_10_9_Course course1 = new _10_9_Course("Data Strctures");
		course1.addStudents("Peter Jones");
		//for(int i = 0;i < 50;i++)
			course1.addStudents("Anne Kennedy");
		course1.addStudents("Brian Smith");
		int count = 0;
		String[] temp = course1.getStudents();		
		System.out.println("Course <<"+course1.getCourseName()+">> has "
				+course1.getNumberOfStudents()+" Students.They are :");
		for(int i = 0;i < temp.length ;i++)
			if(temp[i] != "empty"){
				System.out.println(temp[i]);
				count++;
				if(count == course1.getNumberOfStudents())
					break;
			}
		course1.dropStudents("Peter Jones");

		System.out.println("After drop,Course <<"+course1.getCourseName()+">> has "
				+course1.getNumberOfStudents()+" Students.They are :");
		count = 0;
		for(int i = 0;i < temp.length ;i++)
			if(temp[i] != "empty"){
				System.out.println(temp[i]);
				count++;
				if(count == course1.getNumberOfStudents())
					break;
			}
	}

}
