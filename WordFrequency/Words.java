package HW10module.WordFrequency;


import java.io.*;
import java.util.*;

public class Words {

        public static void main(String[] args) {
            Map<String, Integer> textMap = new HashMap<>();
            File file = new File("HW10/src/HW10module/WordFrequency/words.txt");

            try (InputStream fis = new FileInputStream(file);
                 Scanner scanner = new Scanner(fis)) {

                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    String[] splitLine = line.split(" ");

                    for (int i = 0; i < splitLine.length; i++) {
                        if (textMap.containsKey(splitLine[i])) {
                            int count = textMap.get(splitLine[i]);
                            textMap.put(splitLine[i], count + 1);
                        } else {
                            textMap.put(splitLine[i], 1);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            Comparator<String> comparator = (o1, o2)
                    -> textMap.get(o1).compareTo(textMap.get(o2)) > 0 ? 1 : -1;

            Map<String, Integer> result = new TreeMap<>(comparator.reversed());
            result.putAll(textMap);
            System.out.println(result);
    }

}
