import java.io.*;
import java.util.*;

class Day_6 {

    public static int firstStar(ArrayList<Integer> list) {

        int x = 0;
        while (x < 80) {
            int add = 0;
            for (int i = 0; i < list.size(); i++) {

                if (list.get(i) == 0) {
                    list.set(i, 6);
                    add++;

                } else {
                    int tmp = list.get(i) - 1;
                    list.set(i, tmp);
                }
            }

            int a = 0;
            while (a < add) {
                list.add(8);
                a++;
            }

            x++;
        }

        return list.size();
    }

    public static long secondStar(ArrayList<Integer> list) {
        Map<Integer, Long> values = new HashMap<>();
        int i = 0;

        while (i <= 8) {
            values.put(i, 0L);
            i++;
        }

        for (Integer a : list) {
            values.put(a, values.get(a) + 1);
        }

        i = 0;
        while (i < 256) {
            int x = 0;
            long zero = 0L;

            while (x < 8) {
                if (x == 0) {
                    zero = values.get(x);
                    values.put(x, values.get(x + 1));
                } else {
                    values.put(x, values.get(x + 1));
                }
                x++;
            }

            values.put(6, values.get(6) + zero);
            values.put(8, zero);
            i++;
        }

        long sum = 0L;
        i = 0;
        while (i <= 8) {
            sum += values.get(i);
            i++;
        }

        return sum;
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("day-6.txt"));

            String[] line = br.readLine().split(",");

            ArrayList<Integer> list = new ArrayList<Integer>();
            for (String i : line) {
                list.add(Integer.parseInt(i));
            }

            br.close();

            // System.out.println("First star: " + firstStar(list));
            System.out.println("First star: " + secondStar(list));

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}