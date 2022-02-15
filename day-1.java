import java.io.*;

class Day_1 {

	public static void main(String[] args) {
		int count = 0;
		int prevLine = 0;

		try {

			BufferedReader br = new BufferedReader(new FileReader("day-1.txt"));

			while (br.ready()) {

				int line = Integer.parseInt(br.readLine().trim());

				if (line > prevLine && prevLine > 0) {
					count++;
				}

				prevLine = line;

			}

			br.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("First star: " + count);

	}
}