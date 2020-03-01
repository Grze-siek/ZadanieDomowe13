import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class NumberOfOccurrences {
    public static void main(String[] args) {
        Map<Integer, Integer> numbers = readMap();
        ptintMap(numbers);
      }

    private static Map<Integer, Integer> readMap() {
        File file = new File("numbers.txt");
        Map<Integer, Integer> numbers = new TreeMap<>();
        Scanner scan = null;
        try {
            scan = new Scanner(file);
            while (scan.hasNextLine()) {
                int number = scan.nextInt();
                scan.nextLine();
                int numberOfOccurrences = 1;
                if(numbers.containsKey(number))
                    numberOfOccurrences = numbers.get(number) + 1;
                numbers.put(number, numberOfOccurrences);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            if (scan != null);
            scan.close();
        }
        return numbers;
    }

    private static void ptintMap(Map<Integer, Integer> numbers) {
        for (Map.Entry<Integer, Integer> entry : numbers.entrySet())
            System.out.println(entry.getKey() + " - liczba wystapien: " + entry.getValue());
    }
}
