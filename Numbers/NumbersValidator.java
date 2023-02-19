package HW10module.Numbers;

import java.io.*;
import java.util.Scanner;

public class NumbersValidator {

    File file = new File("HW10/src/HW10module/Numbers/file.txt");

    public void file() {
        if (file.exists()) {
            try (InputStream fis = new FileInputStream(file);
                 Scanner scanner = new Scanner(fis)) {
                while (scanner.hasNext()) {
                    String number = scanner.nextLine();
                    if (number.matches("(\\(\\d{3}\\) |\\d{3}-)\\d{3}-\\d{4}")) {
                        System.out.println(number);
                    }
                }
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }


        public static void main (String[]args)  {
            NumbersValidator numbersValidator = new NumbersValidator();
            numbersValidator.file();
        }

}