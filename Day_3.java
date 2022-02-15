import java.io.*;
import java.util.*;

public class Day_3 {

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

    }

}
