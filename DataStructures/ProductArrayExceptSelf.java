import java.util.Arrays;

public class ProductArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;

        int[] product = new int[N];
        int runningProduct = nums[N-1];
        Arrays.fill(product, 1);

        for (int i = 1; i < N; i++)
            product[i] = product[i-1] * nums[i-1];

        for (int i = N - 2; i > -1; i--){
            product[i] = product[i] * runningProduct;
            runningProduct*= nums[i];
        }
        return product;
    }

    public static void main(String[] argv){
        ProductArrayExceptSelf solution = new ProductArrayExceptSelf();
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{-1,1,0,-3,3})));
    }
}
