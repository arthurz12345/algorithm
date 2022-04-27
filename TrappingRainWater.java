//https://leetcode.com/problems/trapping-rain-water/

public class TrappingRainWater {
    public static void main(String args[]) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};

        trap(arr);
    }

    public static int trap(int[] height) {
        int highest = 3;
        int maxWaterInRow = height.length;

        int totalWaterTrapped = 0;
        for (int h = highest; h > 0; h--){
            int waterInRow = maxWaterInRow;
            System.out.println("line of height " + h);
            int found = 0;
            int leftBank = 0;
            int rightBank = 0;
            int foundPos = 0;
            for (int j = 0; j < height.length; j++) {
                if (height[j] >= h)
                {
                    foundPos = j;
                    found++;
                    if (found == 1){
                        waterInRow -= j;
                        System.out.println("minus left water : " + j);
                    }

                    if (found % 2 == 1){
                        System.out.println("found a left bank " + j);
                        leftBank = j;
                    }
                    else
                    {
                        System.out.println("found a right bank " + j);
                        rightBank = j;
                    }


                    waterInRow -= 1;
                    System.out.println("minus water on bank: " + 1);


                }
            }
            if (foundPos < height.length - 1)
            {
                waterInRow -= height.length - 1 - foundPos;
                System.out.println("minus right water : " + (height.length - 1 - foundPos));
            }

            System.out.println("water in line of height " + h + " is " + waterInRow);
            totalWaterTrapped += waterInRow;
        }
        System.out.println("totalWaterTrapped " + totalWaterTrapped);
        return totalWaterTrapped;
    }

}