class Solution {
    public int change(int amount, int[] coins) {
        int combinations = 0, currentSum = 0;
        combinations = backtrack(coins, amount, currentSum, combinations, 0);
        return combinations;
    }
    
    private int backtrack(int[] coins, int amount, int currentSum, int combinations, int start) {
        if(currentSum == amount) {
            System.out.println("currentSum: " + currentSum + " combinations:" + combinations);
            combinations++;
            return combinations;
        } else if (currentSum > amount) {
            return combinations;
        }
        
        for(int i=start; i<coins.length; i++) {
            currentSum += coins[i];
            combinations = backtrack(coins, amount, currentSum, combinations, i);
            currentSum -= coins[i];
        }
        
        return combinations;
    }
}