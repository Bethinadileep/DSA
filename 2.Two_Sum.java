/*Problem Statement
You are given an array of integers 'ARR' of length 'N' and an integer Target. Your task is to return all pairs of elements such that they add up to Target.
Note:
We cannot use the element at a given index twice.
Follow Up:
Try to do this problem in O(N) time complexity. 
Input Format:
The first line of input contains an integer ‘T’ denoting the number of test cases to run. Then the test case follows.

The first line of each test case contains two single space-separated integers ‘N’ and ‘Target’ denoting the number of elements in an array and the Target, respectively.

The second line of each test case contains ‘N’ single space-separated integers, denoting the elements of the array.
Output Format :
For each test case, print a single line containing space-separated integers denoting all pairs of elements such that they add up to the target. A pair (a, b) and (b, a) is the same, so you can print it in any order.

Each pair must be printed in a new line. If no valid pair exists, print a pair of (-1, -1). Refer to sample input/output for more clarity.
Note:
You do not need to print anything; it has already been taken care of. Just implement the given function.
Constraints:
1 <= T <= 100
1 <= N <= 5000
-10 ^ 9 <= TARGET <=10 ^ 9
-10 ^ 9 <= ARR[i] <=10 ^ 9

Where 'T' denotes the number of test cases, 'N' represents the size of the array, 'TARGET' represents the sum required, and 'ARR[i]' represents array elements.

Time Limit: 1 sec.
Sample Input 1 :
2
4 9
2 7 11 13
5 1
1 -1 -1 2 2
Sample Output 1:
2 7
-1 2
-1 2
*/

//Brute Force Approach
import java.util.*;

public class Solution {
	int[] twoSum(int[] arr, int target, int n) {
		// Write your code here.
        int[] arr5 = new int[2];
        arr5[0] = -1;
        arr5[1] = -1;
        for(int i=0;i<n;i++){
            for(int j=1+i;j<n;j++){
                if(arr[i]+arr[j]==target){
                   arr5[0] = i;
                   arr5[1] = j;
                }
            }
        }
	}
}

//Optimized Approach
/*
	Time Complexity: O(N)
	Space Complexity: O(N)

	Where 'N' is the total number of elements in the array.
*/

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
	public static ArrayList<Pair<Integer, Integer>> twoSum(ArrayList<Integer> arr, int target, int n) {

		// Declaring a hashmap.
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			if (map.containsKey(arr.get(i))) {
				map.put(arr.get(i), map.get(arr.get(i)) + 1);
			} else {
				map.put(arr.get(i), 1);
			}

		}
		ArrayList<Pair<Integer, Integer>> ans = new ArrayList<>();

		// Looping over all elements in the array.
		for (int i = 0; i < n; i++) {
			if (target - arr.get(i) == arr.get(i)) {
				if (map.get(arr.get(i)) > 1) {
					ans.add(new Pair(arr.get(i), arr.get(i)));
					map.put(arr.get(i), map.get(arr.get(i)) - 2);
				}
			} else {
				if (map.containsKey(target - arr.get(i)) && map.get(arr.get(i)) > 0
						&& map.get(target - arr.get(i)) > 0) {
							
					ans.add(new Pair(arr.get(i), target - arr.get(i)));
					map.put(arr.get(i), map.get(arr.get(i)) - 1);
					map.put(target - arr.get(i), map.get(target - arr.get(i)) - 1);
				}
			}
		}

		if (ans.size() == 0)
			ans.add(new Pair(-1, -1));

		return ans;
	}
}



//three SumGiven an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

/*Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List < List <Integer>> sum3 = new ArrayList <List <Integer>>();
        if(nums.length < 3){
            return sum3;
        }
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List <Integer> triplet = new ArrayList <Integer>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        Collections.sort(triplet);
                        sum3.add(triplet);
                    }
                }
            }
        }
        
        sum3 = new ArrayList < List < Integer>> (new LinkedHashSet < List < Integer>> (sum3));
        return sum3;
    }
}

