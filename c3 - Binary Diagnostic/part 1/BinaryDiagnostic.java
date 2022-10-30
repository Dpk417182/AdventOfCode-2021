import java.io.*;

public class BinaryDiagnostic {
    public static void main(String[] args) {
        try {
            String[] input = stringArrayFromFile("input.txt");
            String[] mostCommonBit = new String[input[0].length()];
            int[] onesCount = new int[input[0].length()];

            for (int i = 0; i < input.length; i++) {
                for (int j = 0; j < input[i].length(); j++) {
                    if (input[i].charAt(j) == '1') {
                        onesCount[j]++;
                    }
                }
            }

            for (int i = 0; i < onesCount.length; i++) {
                if (onesCount[i] > input.length / 2) {
                    mostCommonBit[i] = "1";
                } else {
                    mostCommonBit[i] = "0";
                }
            }

            String result = String.join("", mostCommonBit);
            
            int gamma = Integer.parseInt(result, 2);
            System.out.println("Gamma: " + gamma);

            int epsilon = 0b111111111111 - gamma;
            System.out.println("Epsilon: " + epsilon);

            System.out.println("multiplied: " + epsilon * gamma);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] stringArrayFromFile(String fileName) throws IOException {
        // Load input file and read to byte buffer
        File file = new File(fileName);
        byte[] bytes = new byte[(int) file.length()];
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            fis.read(bytes);
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }

        return new String(bytes).trim().split("\\s+");
    }
}
