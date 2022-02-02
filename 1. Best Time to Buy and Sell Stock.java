class Solution {
    public int maxProfit(int[] prices) {
        int minBuy = Integer.MAX_VALUE;
        int op = 0;
        int maxprofit = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minBuy){
                minBuy = prices[i];
            }
            maxprofit = prices[i]-minBuy;
            if(op<maxprofit)
                op = maxprofit;
            
        }
    return op;
    }
    
}
