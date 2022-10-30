import java.io.*;

public class SonarSweepSlidingWindow {
    public static void main(String[] args) {
        int[] nums;
        int increaseCount = 0;
        try {
            // Load input data into integer array
            nums = intArrayFromFile("input.txt");
            // For each "triplet" of nums, check if the last "triplet" is less than it
            for (int i = 3; i < nums.length; i++) {
                int currCount = nums[i] + nums[i - 1] + nums[i - 2];
                int prevCount = nums[i - 1] + nums[i - 2] + nums[i - 3];
                if (prevCount < currCount)
                    increaseCount++;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Print value of increaseCount
        System.out.println(increaseCount);
    }

    public static int[] intArrayFromFile(String fileName) throws IOException {
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

        // Push contents of input file into int array nums
        String[] valueStr = new String(bytes).trim().split("\\s+");
        int[] nums = new int[valueStr.length];
        for (int i = 0; i < valueStr.length; i++)
            nums[i] = Integer.parseInt(valueStr[i]);

        return nums;
    }
}