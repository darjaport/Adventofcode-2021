import java.io.*;
import java.util.*;

class Day_7 {

    public static int firstStar(ArrayList<Integer> list, int max) {
        int bestSum = 0;

        int i = 0;
        while (i <= max) {
            int sum = 0;

            for (int x : list) {
                sum += Math.max(x, i) - Math.min(x, i);
            }

            if (bestSum == 0 || bestSum > sum) {
                bestSum = sum;
            }

            i++;
        }

        return bestSum;
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("day-7.txt"));

            String[] line = br.readLine().split(",");

            ArrayList<Integer> list = new ArrayList<Integer>();

            int max = 0;
            for (String i : line) {
                int num = Integer.parseInt(i);
                if (max < num) {
                    max = num;
                }
                list.add(num);
            }

            br.close();

            System.out.println("First star: " + firstStar(list, max));

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}