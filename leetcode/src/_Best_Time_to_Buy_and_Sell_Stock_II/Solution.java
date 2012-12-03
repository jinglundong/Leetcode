package _Best_Time_to_Buy_and_Sell_Stock_II;

public class Solution {
	/**
	 * AC
	 * @param prices
	 * @return
	 */
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (prices == null || prices.length <2){
            return 0;
        }
        int result = 0;
        int previous = prices[0];
        for (int i=1; i<prices.length; i++){
            if (prices[i] >= previous){
                result += prices[i] - previous;                
            }            
            previous = prices[i];                    
        }
        return result;
    }
}