package hometask;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.List;
import java.util.ArrayList;

public class GroupFileStorage {

	public void saveGroupToCSV(Group gr) throws IOException {
		File exportGroup = new File(gr.getGroupName() + ".csv");
		try {
			exportGroup.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Student> studentArr = gr.getStudents();
		for (int i = 0; i < studentArr.size(); i++) {
//			if (studentArr[i] != null) {
			CSVStringConverter studentInfo = new CSVStringConverter();
			try (FileWriter os = new FileWriter(exportGroup, true)) {
				os.write(studentInfo.toStringRepresentation(studentArr.get(i)) + System.lineSeparator());
			} catch (IOException e) {
				e.printStackTrace();
			}
//			}
		}
	}

	public Group loadGroupFromCSV(File file) {
		Group group = new Group(file.getName().substring(0, file.getName().indexOf(".csv")));
		CSVStringConverter studentInfo = new CSVStringConverter();
		String temp = "";
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			for (;;) {
				temp = br.readLine();
				if (temp == null) {
					break;
				}
				try {
					group.addStudent(studentInfo.fromStringRepresentation(temp));
				} catch (GroupOverflowException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
		}
		return group;
	}

	public File findFileByGroupName(String groupName, File workFolder) {
		File[] fileList = workFolder.listFiles();
		for (int i = 0; i < fileList.length; i++) {
			if (fileList[i] != null && fileList[i].getName().contains(groupName)) {
				return fileList[i];
			}
		}
		return null;
	}
}