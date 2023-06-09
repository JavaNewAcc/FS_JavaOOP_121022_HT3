package hometask;

import java.io.IOException;
import java.io.File;

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
		Student student12 = new Student("Іван", "Янчук", Gender.MALE, 1112, "Java OOP");

		try {
			group1.addStudent(student1);
			group1.addStudent(student2);
			group1.addStudent(student3);
			group1.addStudent(student3);
			group1.addStudent(student4);
			group1.addStudent(student5);
//			group1.addStudent(student6);
//			group1.addStudent(student7);
//			group1.addStudent(student8);
//			group1.addStudent(student9);
//			group1.addStudent(student10);
			group1.addStudent(student11);
//			group1.addStudent(student12);
		} catch (GroupOverflowException e) {
			e.printStackTrace();
		}

		try {
			System.out.println(group1.searchStudentByLastName("Іванова"));
		} catch (StudentNotFoundException e) {
			e.printStackTrace();
		}

		try {
			System.out.println(group1.searchStudentByLastName("Іваненко"));
		} catch (StudentNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println();
		System.out.println("Результат роботи метода по видаленню студента: " + group1.removeStudentByID(333));
		group1.removeStudentByID(111);
//		group1.removeStudentByID(444);
//		group1.removeStudentByID(555);
//		group1.removeStudentByID(777);
		System.out.println();

		try {
			group1.addStudent(student12);
		} catch (GroupOverflowException e) {
			e.printStackTrace();
		}
		System.out.println(group1);

		try {
			InputStudentFromKeyboard inputNewStudent = new InputStudentFromKeyboard();
			Student newStudent = inputNewStudent.inputStudentFromKeyboard();
			try {
				group1.addStudent(newStudent);
				newStudent.setGroupName(group1.getGroupName());
			} catch (GroupOverflowException e) {
				e.printStackTrace();
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		System.out.println(group1);

		CSVStringConverter converter = new CSVStringConverter();
		System.out.println(converter.toStringRepresentation(student1));

		try {
			group1.addStudent(converter.fromStringRepresentation("Янчурук,Іванчик,654,MALE,Java OOP"));
		} catch (GroupOverflowException e) {
			e.printStackTrace();
		}
		System.out.println(group1);

		GroupFileStorage gfs = new GroupFileStorage();
		try {
			gfs.saveGroupToCSV(group1);
		} catch (IOException e) {
			e.printStackTrace();
		}

		File file = new File("Java OOPs.csv");
		System.out.println(gfs.loadGroupFromCSV(file));

		File workFolder = new File(".");
		String fileName = "Java OOP";

		if (gfs.findFileByGroupName(fileName, workFolder) == null) {
			System.out.println("Файл не знайдено");
		} else {
			System.out.println("Знайдено файл з назвою: " + gfs.findFileByGroupName(fileName, workFolder).getName());
		}
		System.out.println(group1.toString());

		if (group1.searchRepeats()) {
			System.out.println("В групі " + group1.getGroupName() + " всі студенти уникальні");
		} else {
			System.out.println("В групі " + group1.getGroupName() + " є повтори.");
		}
	}
}