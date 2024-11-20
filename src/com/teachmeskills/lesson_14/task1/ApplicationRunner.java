package com.teachmeskills.lesson_14.task1;

import com.teachmeskills.lesson_14.task1.constant.Constants;
import com.teachmeskills.lesson_14.task1.exception.WrongFileException;
import com.teachmeskills.lesson_14.task1.validator.FileManager;

import java.util.Scanner;

/**
 * Let's say there is a file with document numbers.
 * A document number is a string consisting of letters and numbers (without service characters).
 * Let this file contain each document number on a new line and no other information in the line,
 * only the document number.
 * A valid document number must be 15 characters long and begin with the sequence
 * docnum (hereinafter any sequence of letters/numbers) or сontract (hereinafter any sequence of
 * letters/numbers).
 * Write a program to read information from the input file - the path to the input file must be
 * specified through the console.
 * The program must check the validity of document numbers.
 * Valid docnum document numbers should be written to one report file.
 * Valid contract numbers сontract should be written to another report file.
 * Invalid document numbers should be written to another report file, but after the document numbers
 * you should add information about why this document is invalid (incorrect
 * sequence of characters at the beginning/there are service characters in the document name, etc.).
 */
public class ApplicationRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path;
        while (true){
            System.out.print(Constants.INTERN_PATH);
            path = scanner.nextLine().trim();

            if (path.isEmpty()){
                System.out.println(Constants.EMPTY_PATH);
            }else {
                break;
            }
        }

        FileManager fileManager = new FileManager();

        try {
            fileManager.parserDocument();
            System.out.println(Constants.STATUS_DONE);
        } catch (WrongFileException e) {
            System.out.println(Constants.WRONG_FILE);
        }

    }
}
