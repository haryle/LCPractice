public class TrappingRainWater {
    public int trap(int[] height) {
        int length = height.length;
        int left = 0, right = length - 1;
        int result = 0;
        int LBound = height[left], RBound = height[right];
        while (left < right){
            if (LBound <= RBound){
                if (LBound >= height[left+1])
                    result+= LBound - height[left+1];
                else
                    LBound = height[left+1];
                left++;
            }else{
                if (RBound >= height[right-1])
                    result+= RBound - height[right-1];
                else
                    RBound = height[right-1];
                right--;
            }
        }
        return result;
    }

    public static void main(String[] argv){
        TrappingRainWater solution = new TrappingRainWater();
        System.out.println(solution.trap(new int[]{4,2,0,3,2,5}));
        System.out.println(solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
