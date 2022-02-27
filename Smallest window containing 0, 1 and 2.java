/*
Given a string S consisting of the characters 0, 1 and 2. Your task is to find the length of the smallest substring of string S that contains all the three characters 0, 1 and 2. If no such substring exists, then return -1.

Example 1:

Input:
S = "01212"
Output:
3
Explanation:
The substring 012 is the smallest substring
that contains the characters 0, 1 and 2.
Example 2:

Input: 
S = "12121"
Output:
-1
Explanation: 
As the character 0 is not present in the
string S, therefor no substring containing
all the three characters 0, 1 and 2
exists. Hence, the answer is -1 in this case.
Your Task:
Complete the function smallestSubstring() which takes the string S as input, and returns the length of the smallest substring of string S that contains all the three characters 0, 1 and 2.


*/

//code
// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String S) {
        // Code here
        int j=0,n=S.length();
        int[] mp=new int[3];
        int ans=Integer.MAX_VALUE;
        Arrays.fill(mp,0);
        for(int i=0;i<n;i++){
            mp[S.charAt(i)-'0']++;
            while(mp[S.charAt(j)-'0']>1){
                mp[S.charAt(j++)-'0']--;
            }
            if(mp[0]>0 && mp[1]>0 && mp[2]>0) ans=Math.min(ans,i-j+1);
        }
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
};
