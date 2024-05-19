package juniverse.core.java8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LamdaExpressionDemo {

    static Map<String,String> map = new HashMap<>();
    static {
        map.put("tu", "tu nguyen");
        map.put("ranky", "ranky nguyen");
        map.put("kiddy", "kiddy nguyen");
    }

    public static void main(String[] args) {
        java7Demo();
        java8Demo();
    }

    static void java7Demo() {
        MathOperation addition = new MathOperation() {
            public int operate(int a, int b) {
                return a + b;
            }
        };

        int sum = addition.operate(1, 2);
        System.out.println(sum);

        GreetingService greetingService = new GreetingService() {
            @Override
            public void welcome(String message) {
                System.out.println("Welcome " + message);
            }
        };
        greetingService.welcome("Tu Nguyen");

        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.compareTo(t1);
            }
        };

        for (Map.Entry<String,String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread started");
            }
        });
    }

    static void java8Demo() {
        MathOperation addition = (a, b) -> a + b;
        MathOperation addition2 = (int a, int b) -> a + b;
        MathOperation addition1 = (int a, int b) -> { return a + b; };
        System.out.println(addition.operate(1,2));

        GreetingService greetingService = (message) -> System.out.println("Welcome " + message);

        greetingService.welcome("Tu Nguyen");

        Comparator<String> stringComparator = (s1, s2) -> (s1.compareTo(s2));

        map.forEach((k, v) -> System.out.println(k + ": " + v));

        new Thread(() -> System.out.println("Thread started"));
    }
}

interface MathOperation {
    int operate(int a, int b);
}

interface GreetingService {
    void welcome(String message);
}