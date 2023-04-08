package hometask;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class CSVStringConverter implements StringConverter {

	@Override
	public String toStringRepresentation(Student student) {
		File exportStudent = new File("ExportStudent.csv");
		String result = student.getLastName() + "," + student.getName() + "," + student.getId() + ","
				+ student.getGender() + "," + student.getGroupName();
		try {
			exportStudent.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (PrintWriter pw = new PrintWriter(exportStudent)) {
			pw.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Student fromStringRepresentation(String str) {
		Student newStudent = new Student();
		String[] strArr = str.split(",");
		newStudent.setLastName(strArr[0]);
		newStudent.setName(strArr[1]);
		newStudent.setId(Integer.valueOf(strArr[2]));
		newStudent.setGender(Gender.valueOf(strArr[3]));
		newStudent.setGroupName(strArr[4]);
		return newStudent;
	}

}
