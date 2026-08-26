/* You are given an array prices where prices[i] is the price of a given stock on the ith day.
 
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0. */

package Arrays;

public class StockBuyAndSell {
    
    // Brute Force approach: Check all possible pairs of buy and sell days and return the maximum profit.
    // Time Complexity: O(n^2), Space Complexity: O(1)
    public int maxProfitBruteForce(int[] prices) {
        int maxProfit = 0;
        for(int i=0; i<prices.length; i++){
            for(int j=i+1; j<prices.length; j++){
                int profit = prices[j]-prices[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
 
        return maxProfit;
    }
 
    // Optimal approach: Use a variable to keep track of the minimum price seen so far and update the maximum profit accordingly.
    // Time Complexity: O(n), Space Complexity: O(1)
    public int maxProfitOptimal(int[] prices) {
        int min = prices[0], profit = 0;
        for(int i=1; i<prices.length; i++){
            int cost = prices[i] - min;
            profit = Math.max(profit, cost);
            min = Math.min(min, prices[i]);
        }
 
        return profit;
    }
}
