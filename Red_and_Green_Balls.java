/*
Red and Green Balls You have a square grid (NxN). Each cell of the grid has either a red ball or a green ball. 
Your job is to arrange the balls in such a way that all the red balls are either on or below the main diagonal. 
The main diagonal starts from cell 1x1 and ends at cell NxN. You have only one move which is to swap adjacent rows. 
You need to achieve the final arrangement in minimal number of moves. If it is not possible to come to a resolution by s
wapping then print -1 Input: First line of input is the number of rows in grid. Rest are the lines in the grid Ouput: Minimum number of moves

Input
2
RG
RR
Output
0
Input 2
GR
RG
Output
1

*/


import java.io.*;
import java.util.*;
class code {
  public static void main(String[] args) throws Exception {
    Scanner s = new Scanner(System.in);
    
    int n = s.nextInt();
    int arr[] = new int[n];
    for(int i=0;i<n;i++){
        String str = s.next();
        int p = -1;
        
        for(int y=0;y<n;y++){
            if(str.charAt(y) == 'R'){
                p = y;
            }
        }
        arr[i] = p;
    }
    int ans = 0;
    for(int i=0;i<n;i++){
        for(int y=0;y<n-1;y++){
            if(arr[y]>arr[y+1]){
                ans++;
                int temp = arr[y];
                arr[y] = arr[y+1];
                arr[y+1] = temp;
            }
        }
    }
    boolean found = true;
    for(int i=0;i<n;i++){
        if(arr[i]>i){
            found = false;
            break;
        }
    }
    System.out.println(found?ans:-1);
  }
}
