
/*Q)Problem Statement
You are given an array/list 'prices' where the elements of the array represent the prices of the stock as they were yesterday and indices of the array represent minutes. 
Your task is to find and return the maximum profit you can make by buying and selling the stock. You can buy and sell the stock only once.


    Time Complexity: O(N^2)
    Space Complexity: O(1)

    Where N is the size of the array.


Brute Force
We will check all the possible ways of buying and selling stocks. We will fix the time we are buying the stock and check all the possible minutes we can sell this stock and update the maximum profit we can get. Now we will take the maximum profit for all the possible buying time and that would be our final maximum profit.

 

Algorithm: 
 
Initialize an integer variable ‘maxProfit’ to store the maximum profit we can achieve and initialize it with 0. Since if the maximum profit is negative we have to return 0.
Now iterate over the array.
Consider the current index as the buying minute.
Now for this buying minute iterate over all the minutes after that(when we can sell the stock)
Store the maximum profit in a variable called ‘CurMaxProfit’.
Then take the maximum of all the ‘CurMaxProfit’ and store it in the ‘MaxProfit’ variable
Finally, return the ‘MaxProfit’ value.
  
*/

import java.util.ArrayList;

public class Solution {
    public static int maximumProfit(ArrayList<Integer> prices) {

        // Variable to store the maximum profit.
        int maxProfit = 0;
        int n = prices.size();

        // Iterating over the array for the buying price.
        for (int i = 0; i < n - 1; i++) {

            /*
                Variables to store current buying price and
                maximum profit for if we buy stock at this minute.
            */
            int buy = prices.get(i), curMaxProfit = 0;

            /*
                Iterating over the next minutes for selling price,
                and storing the maximum profit we can get in curMaxProfit.
            */
            for (int j = i + 1; j < n; j++) {
                curMaxProfit = Math.max(curMaxProfit, (prices.get(j) - buy));
            }

            /*
                Taking the maximum of all the curMaxProfit and
                storing it in the maxProfit variable.
            */
            maxProfit = Math.max(maxProfit, curMaxProfit);
        }

        return maxProfit;
    }
}

/*
Optimised Brute Force
We will iterate over the array and as we go along we will update the buying price as the minimum of the prices till now and will also update the ‘MaxProfit’ variable if selling at this time is more profitable. 
 

Algorithm:

 

Initialize a variable ‘BUY’ to store the buying price and ‘MaxProfit’ to store the maximum profit we can achieve.
Now we will iterate over the array.
If the current price is less than our buying price, we will update that.
Else if selling at this minute gives us more profit, then we will update our ‘MaxProfit’ variable as ‘Prices[i]’ - ‘BUY’.
Finally, return the ‘MaxProfit’ variable.
Time Complexity
O(N), where ‘N’ is the size of the array.

 

Since we are simultaneously updating our buying and selling time by iterating only once, the time complexity will be O(N).

Space Complexity
O(1).

 

Constant space is used.

*/
/*
    Time Complexity: O(N)
    Space Complexity: O(1)

    Where N is the size of the array.
*/

import java.util.ArrayList;

public class Solution {
    public static int maximumProfit(ArrayList<Integer> prices){
        
        // Variables to store the buying price and maximum profit
        int buy = prices.get(0),maxProfit = 0;
        int n = prices.size();

        // Iterating over the array
        for(int i = 1; i < n; i++){

            /*
                If current price is less than buying price
                we will update buying price as the current price.
            */
            if(prices.get(i) < buy){
                buy = prices.get(i);
            }
            
            /*
                Else if selling at this price is more profitable,
                then we will update out maximum profit.
            */
            else if( (prices.get(i) - buy) > maxProfit){
                maxProfit = prices.get(i) - buy;
            }
        }
        return maxProfit;
    }
}
