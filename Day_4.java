import java.io.*;
import java.util.*;

public class Day_4 {

    public static int firstStar(ArrayList<String[]> bingo) {
        int jump = 3;
        int lastCalled = 0;
        String[] winningLine;
        int winningIndex = 0;

        String[] drawnNums = bingo.get(0);
        bingo.remove(0);

        whileLoop: while (true) {
            jump++;

            for (String[] x : bingo) {
                int count = 0;
                winningLine = x;

                for (String y : x) {
                    for (int z = 0; z < drawnNums.length && z <= jump; z++) {
                        if (Integer.parseInt(y) == Integer.parseInt(drawnNums[z])) {
                            count++;
                        }
                    }
                }

                if (count == 5) {
                    winningIndex = bingo.indexOf(x);
                    lastCalled = Integer.parseInt(drawnNums[jump]);
                    break whileLoop;
                }
            }
        }

        int sum = 0;
        int start = 0;

        if (winningIndex % 5 == 0) {
            start = winningIndex;
        } else {
            while (winningIndex % 5 != 0) {
                winningIndex--;
            }
            start = winningIndex;
        }

        for (int x = start; x < start + 5; x++) {
            for (int i = 0; i < 5; i++) {
                boolean found = false;
                int tmp = Integer.parseInt(bingo.get(x)[i]);
                for (int j = 0; j <= jump; j++) {
                    int tmpNum = Integer.parseInt(drawnNums[j]);
                    if (tmp == tmpNum) {
                        found = true;
                    }
                }
                if (!found) {
                    sum += tmp;
                }
            }
        }

        return sum * lastCalled;
    }

    public static void main(String[] args) {
        ArrayList<String[]> bingo = new ArrayList<String[]>();

        try {

            BufferedReader br = new BufferedReader(new FileReader("day-4.txt"));

            while (br.ready()) {
                String[] list = br.readLine().trim().split("[\\s,]+");
                if (list.length != 1) {
                    bingo.add(list);
                }
            }

            br.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("First star: " + firstStar(bingo));

    }
}
