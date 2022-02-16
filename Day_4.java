import java.io.*;
import java.util.*;

public class Day_4 {

    public static int checkFirstLine(int num) {
        int start = 0;
        if (num % 5 == 0) {
            start = num;
        } else {
            while (num % 5 != 0) {
                num--;
            }
            start = num;
        }
        return start;
    }

    public static ArrayList<String[]> deleteInputs(ArrayList<String[]> bingo, int index) {
        index = checkFirstLine(index);
        for (int i = index; i < index + 5; i++) {
            bingo.remove(index);
        }
        return bingo;
    }

    public static int getSum(int start, int jump, ArrayList<String[]> bingo, String[] drawnNums) {
        int sum = 0;
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
        return sum;
    }

    public static int firstStar(ArrayList<String[]> bingo) {
        int jump = 3;
        int lastCalled = 0;
        int winningIndex = 0;

        String[] drawnNums = bingo.get(0);
        bingo.remove(0);

        whileLoop: while (true) {
            jump++;

            for (String[] x : bingo) {
                int count = 0;

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

        int start = checkFirstLine(winningIndex);
        int sum = getSum(start, jump, bingo, drawnNums);

        return sum * lastCalled;
    }

    public static int secondStar(ArrayList<String[]> bingo) {
        int jump = 3;
        int lastCalled = 0;
        int winningIndex = 0;

        String[] drawnNums = bingo.get(0);
        bingo.remove(0);

        whileLoop: while (true) {
            jump++;

            for (int i = 0; i < bingo.size(); i++) {
                int countVertical = 0;
                int count = 0;

                for (String y : bingo.get(i)) {
                    for (int z = 0; z < drawnNums.length && z <= jump; z++) {
                        if (Integer.parseInt(y) == Integer.parseInt(drawnNums[z])) {
                            count++;
                        }
                    }
                }

                if (i % 5 == 0) {
                    int repeat = 1;
                    int n = i;
                    int m = 0;

                    loop: while (repeat <= 25) {

                        for (int z = 0; z < drawnNums.length && z <= jump; z++) {
                            if (Integer.parseInt(bingo.get(n)[m]) == Integer.parseInt(drawnNums[z])) {
                                countVertical++;
                            }
                        }

                        if (countVertical == 5) {
                            break loop;
                        }

                        n++;
                        repeat++;

                        if (n - 5 == i) {
                            countVertical = 0;
                            n = i;
                            m = repeat / 5;
                        }
                    }
                }

                if (count == 5 || countVertical == 5) {
                    winningIndex = i;
                    lastCalled = Integer.parseInt(drawnNums[jump]);

                    if (bingo.size() <= 5) {
                        break whileLoop;
                    }

                    bingo = deleteInputs(bingo, i);
                    i = checkFirstLine(i - 1);
                    if (i < 0) {
                        i = 0;
                    }
                }
            }
        }

        int start = checkFirstLine(winningIndex);
        int sum = getSum(start, jump, bingo, drawnNums);

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

        // System.out.println("First star: " + firstStar(bingo));
        System.out.println("Second star: " + secondStar(bingo));

    }
}
