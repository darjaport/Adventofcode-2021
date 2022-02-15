import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Day_2 {

    public static int getInt(String n) {
        int num = 0;
        Pattern numbers = Pattern.compile("\\d+");
        Matcher m = numbers.matcher(n);

        while (m.find()) {
            num = Integer.parseInt(m.group());
        }
        return num;
    }

    public static String getString(String n) {
        String str = "";
        Pattern stringPattern = Pattern.compile("[a-z]");
        Matcher m = stringPattern.matcher(n);

        while (m.find()) {
            str += m.group();
        }
        return str;
    }

    public static int firstStar(ArrayList<String> list) {
        int depth = 0;
        int horizontal = 0;
        int i = 0;

        while (i < list.size()) {
            int num = getInt(list.get(i));
            String condition = getString(list.get(i));

            switch (condition) {
                case "forward":
                    horizontal += num;
                    break;
                case "down":
                    depth += num;
                    break;
                case "up":
                    depth -= num;
                    break;
            }

            i++;
        }
        return depth * horizontal;
    }

    public static int secondStar(ArrayList<String> list) {
        int depth = 0;
        int horizontal = 0;
        int aim = 0;
        int i = 0;

        while (i < list.size()) {
            int num = getInt(list.get(i));
            String condition = getString(list.get(i));

            switch (condition) {
                case "forward":
                    horizontal += num;
                    depth = depth + (aim * num);
                    break;
                case "down":
                    aim += num;
                    break;
                case "up":
                    aim -= num;
                    break;
            }

            i++;
        }
        return depth * horizontal;
    }

    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<String>();

        try {

            BufferedReader br = new BufferedReader(new FileReader("day-2.txt"));

            while (br.ready()) {
                String line = br.readLine().trim();
                input.add(line);
            }

            br.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("First star: " + firstStar(input));
        System.out.println("Second star: " + secondStar(input));

    }
}