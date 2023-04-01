package hometask;

import java.util.Arrays;
import java.util.Comparator;

public class Group {
	private final String groupName;
	private final Student[] students;

	public Group(String groupName) {
		super();
		this.groupName = groupName;
		students = new Student[10];
	}

	public String getGroupName() {
		return groupName;
	}

	public Student[] getStudents() {
		return students;
	}

	public void addStudent(Student student) throws GroupOverflowException {
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = student;
				return;
			}
		}
		throw new GroupOverflowException("В групі " + groupName + " немає вільних місць.");
	}

	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				if (students[i].getLastName().equals(lastName)) {
					return students[i];
				}
			}
		}
		throw new StudentNotFoundException("Студента з прізвищем " + lastName + " не знайденою");
	}

	public boolean removeStudentByID(int id) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				if (students[i].getId() == id) {
					students[i] = null;
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String toString() {
		int counter = 0;
		Arrays.sort(students,
				Comparator.nullsLast(new SortStudentsByLastName().thenComparing(new SortStudentsByName())));
		String result = "Група " + groupName + ":" + System.lineSeparator();
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				counter++;
			} else {
				result += students[i].getLastName() + " " + students[i].getName() + ", номер залікової книжки: "
						+ students[i].getId() + ";" + System.lineSeparator();
			}
		}
		if (counter == students.length) {
			result = "Група " + groupName + " ще не набрана";
		}
		return result;
	}
}