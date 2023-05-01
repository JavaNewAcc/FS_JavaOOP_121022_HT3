package hometask;

import java.util.Collections;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Group {
	private final String groupName;
	private final List<Student> students;

	public Group(String groupName) {
		super();
		this.groupName = groupName;
		students = new ArrayList<>();
	}

	public String getGroupName() {
		return groupName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) throws GroupOverflowException {
		if (students.size() >= 10) {
			throw new GroupOverflowException("В групі " + groupName + " немає вільних місць.");
		} else {
			students.add(student);
		}
	}

	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
		for (Student element : students) {
			if (element.getLastName().equals(lastName)) {
				return element;
			}
		}
		throw new StudentNotFoundException("Студента з прізвищем " + lastName + " не знайденою");
	}

	public boolean removeStudentByID(int id) {
		for (Student element : students) {
			if (element.getId() == id) {
				students.remove(students.indexOf(element));
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		int counter = 0;
		String result = "Група " + groupName + ":" + System.lineSeparator();
		Collections.sort(students, new SortStudentsByLastName().thenComparing(new SortStudentsByName()));

		for (Student element : students) {
			result = result + element.toString() + System.lineSeparator();
		}

		if (students.size() == 0) {
			result = "Група " + groupName + " ще не набрана";
		}
		return result;
	}

	@Override
	public int hashCode() {
		return Objects.hash(groupName, students);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		return Objects.equals(groupName, other.groupName) && Objects.equals(students, other.students);
	}

	public boolean searchRepeats() {
		Set<Student> set1 = new HashSet<>(students);

		if (set1.size() < students.size()) {
			return false;
		}
		return true;
	}
}