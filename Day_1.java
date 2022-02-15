import java.io.*;
import java.util.*;

class Day_1 {

	public static int secondStar(ArrayList<Integer> list) {
		int count = 0;
		int prevSum = 0;
		int sum = 0;
		int tmpI = 3;
		int i = 0;

		while (i < list.size()) {
			sum += list.get(i);

			if (i + 1 == tmpI) {
				if (prevSum != 0 && prevSum < sum) {
					count++;
				}

				tmpI++;
				prevSum = sum;
				sum -= list.get(i - 2);
			}

			i++;
		}

		return count;
	}

	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<Integer>();

		try {

			BufferedReader br = new BufferedReader(new FileReader("day-1.txt"));

			while (br.ready()) {
				int line = Integer.parseInt(br.readLine().trim());
				input.add(line);
			}

			br.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		int count = secondStar(input);

		System.out.println("Second star: " + count);

	}
}