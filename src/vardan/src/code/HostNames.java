package code;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class HostNames {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {


        String fileName;
        fileName = scan.nextLine();
        HashMap<String, Integer> hMap = new HashMap<>();
        File fileName_new = new File("/Users/vardan.gupta/FirstTest/leetcode_java/src/file.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(fileName_new))) {
            String l;
            while ((l = br.readLine()) != null) {
                List<String> lines = Arrays.asList(l.split(" "));
                l = lines.get(0);

                if(hMap.containsKey(l)) {
                    hMap.put(l, hMap.get(l) + 1 );
                }
                else {
                    hMap.put(l, 1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter file = new FileWriter("records_" + fileName_new)) {

            for (String s : hMap.keySet()) {  // Note: added a i++
                file.write(s + " " + hMap.get(s) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
