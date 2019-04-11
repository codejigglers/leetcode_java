package code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class FileReaders {

    public static void main(String[] args) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new java.io.FileReader(
                    "C:\\Users\\varda\\OneDrive\\Desktop\\fileee.txt"));
            String line = reader.readLine();
            HashSet<String> hashSet = new HashSet<>();
            while (line != null) {
                if(hashSet.contains(line)) {
                    System.out.println(line);
                } else {
                    hashSet.add(line);
                }
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
