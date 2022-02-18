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

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("day-6.txt"));

            String[] line = br.readLine().split(",");

            ArrayList<Integer> list = new ArrayList<Integer>();
            for (String i : line) {
                list.add(Integer.parseInt(i));
            }

            br.close();

            System.out.println("First star: " + firstStar(list));

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}