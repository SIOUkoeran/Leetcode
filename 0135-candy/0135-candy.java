class Solution {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);
        preFillCandy(candy, ratings);
        postFillCandy(candy, ratings);
        System.out.println(Arrays.toString(candy));
        return calcAnswer(candy);
    }
    
    private static void preFillCandy(int[] candy, int[] ratings) {
        for (int i = 1; i < candy.length; i++) {
            candy[i] = ratings[i] > ratings[i - 1] 
                ? candy[i - 1] + 1
                : candy[i];
        }
    }
    
    private static void postFillCandy(int[] candy, int[] ratings) {
        for (int i = candy.length - 2; i >= 0; i--) {
            candy[i] = ratings[i + 1] < ratings[i]
                ? Math.max(candy[i], candy[i + 1] + 1)
                : candy[i];
        }
    }
    
    private static int calcAnswer(int[] candy) {
        int sum = 0;
        for (int i = 0; i < candy.length; i++) {
            sum += candy[i];
        }
        return sum;
    }
}