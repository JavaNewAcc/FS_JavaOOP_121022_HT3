package hometask;

import java.util.Scanner;

public class InputStudentFromKeyboard {

	public Student inputStudentFromKeyboard() throws IllegalArgumentException {
		Student student = new Student();
		Scanner scan = new Scanner(System.in);
		System.out.println("Введіть прізвище студента:");
		try {
			String lastName = scan.nextLine();
			stringSymbolsChecker(lastName);
			student.setLastName(lastName);
		} catch (IllegalArgumentException e) {
			throw e;
		}

		System.out.println("Введіть ім'я студента:");
		try {
			String name = scan.nextLine();
			stringSymbolsChecker(name);
			student.setName(name);
		} catch (IllegalArgumentException e) {
			throw e;
		}

		System.out.println("Введіть номер залікової книжки студента:");
		try {
			int id = scan.nextInt();
			student.setId(id);
			scan.nextLine();
		} catch (IllegalArgumentException e) {
			throw e;
		}

		System.out.println("Вкажіть стать (Ч або Ж):");
		String gender = scan.nextLine();
		char[] genderArr = gender.toLowerCase().toCharArray();
		if (genderArr.length == 1) {
			if (genderArr[0] == 'ч') {
				student.setGender(Gender.MALE);
			} else if (genderArr[0] == 'ж') {
				student.setGender(Gender.FEMALE);
			} else {
				throw new IllegalArgumentException();
			}
		} else {
			throw new IllegalArgumentException();
		}
		return student;
	}

	private boolean stringSymbolsChecker(String string) throws IllegalArgumentException {
		boolean result = true;
		char[] charsOfString = string.toLowerCase().toCharArray();
		if (charsOfString.length <= 0) {
			result = false;
			throw new IllegalArgumentException("ПОЛЕ НЕ МОЖЕ ЗАЛИШАТИСЬ ПУСТИМ");
		} else {
			for (int i = 0; i < charsOfString.length; i++) {
				if (!(charsOfString[i] >= 'а' && charsOfString[i] <= 'я' || charsOfString[i] == 'і'
						|| charsOfString[i] == 'ї' || charsOfString[i] == '\'')) {
					result = false;
					throw new IllegalArgumentException("НЕДОПУСТИМІ СИМВОЛИ");
				}
			}
		}
		return result;
	}

}