package HW10module.JSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class User {

    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) throws IOException {

        File file = new File("D:\\JAVA\\JAVA1\\HW10\\src\\HW10module\\JSON\\file.txt");
        FileInputStream fis = new FileInputStream(file);
        Scanner scanner = new Scanner(fis);
        scanner.nextLine();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        ArrayList<User> users = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] splitLine = line.split(" ");
            User user = new User(splitLine[0], Integer.parseInt(splitLine[1]));
            users.add(user);
        }
        String jsonOutput = gson.toJson(users.toArray());

        FileWriter filewriter = new FileWriter("D:\\JAVA\\JAVA1\\HW10\\src\\HW10module\\JSON\\user.json");
        filewriter.write(jsonOutput);
        filewriter.close();
//        System.out.println(jsonOutput); //test
    }

}
