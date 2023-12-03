public class FindPivotInteger {
    public int pivotInteger(int n) {
        int retVal = (int) Math.sqrt((double) ((n*n + n)/2));
        if (2*retVal * retVal == (n*(n+1)))
            return retVal;
        return -1;
    }

    public static void main(String[] argv){
        FindPivotInteger solution = new FindPivotInteger();
        System.out.println(solution.pivotInteger(8));
        System.out.println(solution.pivotInteger(1));
        System.out.println(solution.pivotInteger(4));
    }
}
