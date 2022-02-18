import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Day_5 {

    public static ArrayList<Integer> getInt(String n) {
        ArrayList<Integer> values = new ArrayList<Integer>();
        int num = 0;
        Pattern numbers = Pattern.compile("\\d+");
        Matcher m = numbers.matcher(n);

        while (m.find()) {
            num = Integer.parseInt(m.group());
            values.add(num);
        }
        return values;
    }

    public static int firstStar(ArrayList<ArrayList<Integer>> list) {
        int[][] grid = new int[1000][1000];
        int sum = 0;

        Iterator<ArrayList<Integer>> i = list.iterator();
        while (i.hasNext()) {
            ArrayList<Integer> arr = i.next();

            int x1 = arr.get(0);
            int y1 = arr.get(1);
            int x2 = arr.get(2);
            int y2 = arr.get(3);

            if (x1 != x2 && y1 != y2) {
                continue;
            } else if (x1 == x2) {
                for (int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
                    grid[y][x1] += 1;

                    if (grid[y][x1] == 2) {
                        sum++;
                    }
                }

            } else if (y1 == y2) {
                for (int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
                    grid[y1][x] += 1;

                    if (grid[y1][x] == 2) {
                        sum++;
                    }
                }
            }
        }

        // for (ArrayList<Integer> x : list) {
        // System.out.println(x);
        // }

        // for (int[] x : grid) {
        // System.out.println(Arrays.toString(x));
        // }

        return sum;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();

        try {

            BufferedReader br = new BufferedReader(new FileReader("day-5.txt"));

            while (br.ready()) {
                String line = br.readLine().trim();
                input.add(getInt(line));
            }

            br.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("First star: " + firstStar(input));

    }
}