package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AmazonAkash {

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();

        a.add("zld 93 12");
        a.add("fp kindle book");
        a.add("10a echo show");
        a.add("17g 12 25 6");
        a.add("ab1 kindle book");
        a.add("125 echo dot second generation");
        List<String> answer = prioritizedOrders(6, a);
        System.out.println(answer);
    }

    public static List<String> prioritizedOrders(int numOrders, List<String> orders) {

        List<String> primeOrders = new ArrayList<>();
        List<String> nonPrimeOrders = new ArrayList<>();
        for(String s : orders) {
            if(isPrime(s)) {
                primeOrders.add(s);
            } else {
                nonPrimeOrders.add(s);
            }
        }

        Collections.sort(primeOrders, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] splitted1 = o1.split(" ");
                String[] splitted2 = o2.split(" ");

                int mini = Math.min(splitted1.length, splitted2.length);

                for(int i = 1; i < mini; i++) {
                    String s1 = splitted1[i];
                    String s2 = splitted2[i];
                    for(int k = 0; k < Math.min(s1.length(), s2.length()); k++) {
                        if(s1.charAt(k) > s2.charAt(k)) {
                            return 1;
                        } else if(s1.charAt(k) < s2.charAt(k)) {
                            return -1;
                        }
                    }
                }

                String s1 = splitted1[0];
                String s2 = splitted2[1];

                for(int k = 0; k < Math.min(s1.length(), s2.length()); k++) {
                    if(s1.charAt(k) > s2.charAt(k)) {
                        return 1;
                    } else if(s1.charAt(k) < s2.charAt(k)) {
                        return -1;
                    } else {
                        return 0;
                    }
                }

                return 0;
            }
        });

        for(String s : nonPrimeOrders) {
            primeOrders.add(s);
        }

        return primeOrders;
    }

    public static boolean isPrime(String order) {
        String[] splitted = order.split(" ");
        for(int i = 0; i < splitted[1].length(); i++) {
            if(splitted[1].charAt(i) >= '0' && splitted[1].charAt(i) <= '9') {
                return false;
            }
        }
        return true;
    }
}
