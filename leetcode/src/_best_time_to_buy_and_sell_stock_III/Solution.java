package _best_time_to_buy_and_sell_stock_III;

public class Solution {
	/**
	 * find max profit transaction first. After that, there are two cases:
	 * the best two profit transactions are both in the max transaction.
	 * the other case is one is the max profit transaction, the other one is either on its
	 * left or right.
	 * if it is the first case, find the max lost in the range, the max profit is the max single 
	 * profit plus the max lost.
	 * @param prices
	 * @return
	 */
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (prices == null || prices.length < 2){
            return 0;
        }        
        Result maxResult = oneTransaction(prices, 0, prices.length);
        int tmpMinValue = prices[maxResult.minIndex];
        int twoInMaxResult = maxResult.difValue + maxLost(prices, 
            maxResult.minIndex, maxResult.maxIndex);        
        int leftMax = oneTransaction(prices, 0, maxResult.minIndex).difValue;
        int rightMax = oneTransaction(prices, maxResult.maxIndex+1, prices.length).difValue;
        int oneInMaxResult = Math.max(leftMax, rightMax) + maxResult.difValue;
        return Math.max(twoInMaxResult, oneInMaxResult);        
    }
    
    public int maxLost(int[] prices, int left, int right){
        if (prices == null || right-left <1){
            return 0;
        }
        int result = 0;
        int maxIndex = left;
        int minIndex = left;
        int curMax = Integer.MIN_VALUE;
        for (int i=left; i<right; i++){
            if (prices[i] > curMax){
                curMax = prices[i];   
                maxIndex = i;
            }
            if ( curMax - prices[i] > result){
                result = curMax - prices[i];                
                minIndex = i;
            }
        }
        return result;
    }
    
    static class Result{
        public int minIndex;
        public int maxIndex;
        public int difValue;
        public Result(int first, int second, int value){
            this.minIndex = first;
            this.maxIndex = second;
            this.difValue = value;
        }
    }
    
    public Result oneTransaction(int[] prices, int left, int right){
        if (prices == null || right - left < 1){
            return new Solution.Result(left, left, 0);
        }
        int result = 0;
        int minIndex = left;     
        int resultMinIndex = left;
        int maxIndex = left;        
        int curMin = Integer.MAX_VALUE;
        for (int i=left; i<right; i++){
            if (prices[i] < curMin){
                curMin = prices[i];   
                minIndex = i;
            }
            if (prices[i] - curMin > result){
                result = prices[i] - curMin;   
                resultMinIndex = minIndex;
                maxIndex = i;
            }
        }
        return new Solution.Result(resultMinIndex, maxIndex, result);
    }
}
