import java.io.*;

public class SonarSweep {
    public static void main(String[] args) throws IOException {
        // Load input file and read to byte buffer
        File file = new File("input.txt");
        byte[] bytes = new byte[(int) file.length()];
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            fis.read(bytes);
            fis.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }

        // Push contents of input file into int array nums
        String[] valueStr = new String(bytes).trim().split("\\s+");
        int[] nums = new int[valueStr.length];
        int increaseCount = 0;
        for (int i = 0; i < valueStr.length; i++)
            nums[i] = Integer.parseInt(valueStr[i]);

        // For each element in nums, check if the previous element is less than
        // the current element
        // If so, increment increaseCount
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i])
                increaseCount++;
        }

        // Print value of increaseCount
        System.out.println(increaseCount);
    }
}