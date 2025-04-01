package TestPractice.FileOpenings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class moreTesting {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\TestPractice\\FileOpenings\\RemovingBlankBegEnd.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String trimmedLine = line.trim();
                System.out.println(trimmedLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
