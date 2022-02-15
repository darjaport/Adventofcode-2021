import java.io.*;
import java.util.*;

public class Day_3 {

    public static int secondStar(ArrayList<String> list) {
        ArrayList<String> tmpOxygen = new ArrayList<>(list);
        ArrayList<String> tmpCO2 = new ArrayList<>(list);
        int oxygen = 0;
        int co2 = 0;
        int i = 0;

        while (i < list.get(0).length()) {
            int z = i;
            int zero = 0;
            int one = 0;

            for (String x : tmpOxygen) {
                if (x.charAt(i) == '0') {
                    zero++;
                } else if (x.charAt(i) == '1') {
                    one++;
                }
            }

            if (tmpOxygen.size() > 1) {
                if (zero == one || zero < one) {
                    tmpOxygen.removeIf(y -> y.charAt(z) == '0');
                } else {
                    tmpOxygen.removeIf(y -> y.charAt(z) == '1');
                }
            }

            zero = 0;
            one = 0;
            for (String x : tmpCO2) {
                if (x.charAt(i) == '0') {
                    zero++;
                } else if (x.charAt(i) == '1') {
                    one++;
                }
            }

            if (tmpCO2.size() > 1) {
                if (zero == one || zero < one) {
                    tmpCO2.removeIf(y -> y.charAt(z) == '1');
                } else {
                    tmpCO2.removeIf(y -> y.charAt(z) == '0');
                }
            }

            i++;
        }

        oxygen = Integer.parseInt(tmpOxygen.get(0), 2);
        co2 = Integer.parseInt(tmpCO2.get(0), 2);

        return oxygen * co2;
    }

    public static int firstStar(ArrayList<String> list) {
        int gamma = 0;
        int epsilon = 0;
        int i = 0;
        String resultGamma = "";
        String resultEpsilon = "";

        while (i < list.get(0).length()) {
            int zero = 0;
            int one = 0;

            for (String x : list) {
                if (x.charAt(i) == '0') {
                    zero++;
                } else if (x.charAt(i) == '1') {
                    one++;
                }
            }

            if (zero < one) {
                resultEpsilon += "0";
                resultGamma += "1";
            } else {
                resultEpsilon += "1";
                resultGamma += "0";
            }

            i++;
        }

        gamma = Integer.parseInt(resultGamma, 2);
        epsilon = Integer.parseInt(resultEpsilon, 2);

        return gamma * epsilon;
    }

    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<String>();

        try {

            BufferedReader br = new BufferedReader(new FileReader("day-3.txt"));

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
