package hometask;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {

		Group group1 = new Group("Java OOP");

		Student student1 = new Student("Іван", "Янчук", Gender.MALE, 111, "Java OOP");
		Student student2 = new Student("Олена", "Іванова", Gender.FEMALE, 222, "Java OOP");
		Student student3 = new Student("Петро", "Петров", Gender.MALE, 333, "Java OOP");
		Student student4 = new Student("Ірина", "Петрова", Gender.FEMALE, 444, "Java OOP");
		Student student5 = new Student("Юрій", "Юровський", Gender.MALE, 555, "Java OOP");
		Student student6 = new Student("Катерина", "Юровська", Gender.FEMALE, 666, "Java OOP");
		Student student7 = new Student("Олег", "Капустін", Gender.MALE, 777, "Java OOP");
		Student student8 = new Student("Юлія", "Капустіна", Gender.FEMALE, 888, "Java OOP");
		Student student9 = new Student("Кирило", "Капустін", Gender.MALE, 999, "Java OOP");
		Student student10 = new Student("Марина", "Макарова", Gender.FEMALE, 101010, "Java OOP");
		Student student11 = new Student("Оксана", "Кринична", Gender.FEMALE, 111111, "Java OOP");

		try {
			group1.addStudent(student1);
			group1.addStudent(student2);
			group1.addStudent(student3);
			group1.addStudent(student4);
			group1.addStudent(student5);
			group1.addStudent(student6);
			group1.addStudent(student7);
			group1.addStudent(student8);
			group1.addStudent(student9);
			group1.addStudent(student10);
			group1.addStudent(student11);
		} catch (GroupOverflowException e) {
			e.printStackTrace();
		}

		System.out.println(group1);

		try {
			System.out.println(group1.searchStudentByLastName("Іванов"));
		} catch (StudentNotFoundException e) {
			e.printStackTrace();
		}

		try {
			System.out.println(group1.searchStudentByLastName("Іваненко"));
		} catch (StudentNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println();
		System.out.println(group1.removeStudentByID(222));
		System.out.println();

		try {
			group1.addStudent(student11);
		} catch (GroupOverflowException e) {
			e.printStackTrace();
		}
		System.out.println(group1);
	}
}