package hometask;

import java.util.Comparator;

public class SortByName implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Student student1 = (Student) o1;
		Student student2 = (Student) o2;

		if (student1.getName().compareTo(student2.getName()) > 0) {
			return 1;
		}
		if (student1.getName().compareTo(student2.getName()) < 0) {
			return -1;
		}
		return 0;
	}

}
