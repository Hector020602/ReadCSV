import java.io.*;
import java.util.Scanner;

public class ReadCSV {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("Usage: Calculate <filename>");
            System.exit(1);
        }
        String[] fieldnames;
        int[] accumulators;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new
                    FileReader(args[0]));
            int numFields = 0;
            String line = in.readLine();
            Scanner s = new Scanner(line);
            s.useDelimiter(",");
            while (s.hasNext()) {
                numFields++;
                s.next();
            }
            fieldnames = new String[numFields];
            accumulators = new int[numFields];
            s = new Scanner(line);
            s.useDelimiter(",");
            for (int i = 0; i < numFields; i++) {
                fieldnames[i] = s.next();
                accumulators[i] = 0;
            }
            while ((line = in.readLine()) != null) {
                s = new Scanner(line);
                s.useDelimiter(",");
                for (int i = 0; i < numFields; i++) {
                    if (s.hasNextInt()) {
                        accumulators[i] += s.nextInt();
                    }
                }
            }
// print result
            for (int i = 0; i < numFields; i++) {
                System.out.println(fieldnames[i] + ": " + accumulators[i]);
            }
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }
}

