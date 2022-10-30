import java.io.*;

public class DiveAim {
    public static void main(String[] args) {
        try {
            String[] input = stringArrayFromFile("input.txt");
            int position = 0;
            int depth = 0;
            int aim = 0;
            for (int i = 0; i < input.length; i+=2) {
                if (input[i].equals("forward")) {
                    position += Integer.parseInt(input[i+1]);
                    depth += aim * Integer.parseInt(input[i+1]);
                } else if (input[i].equals("down")) {
                    aim += Integer.parseInt(input[i+1]);
                } else if (input[i].equals("up")) {
                    aim -= Integer.parseInt(input[i+1]);
                }
            }

            System.out.println("Position: " + position + ", Depth: " + depth);
            System.out.println("Multiplied: " + position * depth);
        } catch (IOException e) {
            // TODO Auto-generated catch block
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
