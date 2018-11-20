package com.base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author: yangmengjun
 * @date: 2018\11\19 0019 17:56
 */
public class LeetCodeDemo {

    /**
     * 获取字符串非重复的最长子串长度
     * */
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        if(s.length()==1){
            return 1;
        }
        String largestStr = null;
        for(int i=0;i<s.length();i++){
            a:for(int j=1;j<=s.length()-i;j++){
                System.out.printf("[%d,%d]",j-1,i+j);
                String childStr = s.substring(j-1,i+j);
                System.out.println(childStr);
                if(i+1==getNotDumplicateStrLength(childStr)){
                    largestStr = childStr;
                    result = i+1;
                    continue a;
                }
            }

        }
        System.out.println("最长的子串为："+largestStr);
        return result;
    }
    public Integer getNotDumplicateStrLength(String s){
        List<Character> list = new ArrayList<Character>();
        for(int i=0;i<s.length();i++){
            if(!list.contains(s.charAt(i))){
                list.add(s.charAt(i));
            }
        }
        return list.size();
    }

    public static void main(String[] args){
        int[] arr1 = new int[]{7,1,5,3,6,4};
//        System.out.println(calPoints(arr));
        System.out.println(maxProfit(arr1));
    }

    /**
     * 棒球比赛积分
     * @param ops
     * @return
     */
    public static int calPoints(String[] ops) {
        Stack<Integer> s = new Stack();
        for(String op:ops){
            if("+".equals(op)){
                Integer temp = s.pop();
                Integer tempadd = s.peek()+temp;
                s.push(temp);
                s.push(tempadd);
            }else if("D".equals(op)){
                s.push(s.peek()*2);
            }else if("C".equals(op)){
                s.pop();
            }else{
                s.push(Integer.parseInt(op));
            }
        }
        Integer result = 0;
        for(Integer i :s){
            result +=i;
        }
        return result;
    }
    public static int maxProfit(int[] prices) {
        int size = prices.length;
        int maxprofit = 0;
        for(int i=0;i<size-1;i++){
            for(int j=i+1;j<size;j++){
                System.out.printf("prices[j] [%d],prices[i] [%d]",prices[j],prices[i]);
                System.out.println();
                if(prices[j]>prices[i]&&maxprofit<prices[j]-prices[i]){
                    maxprofit = prices[j]-prices[i];
                }
            }
        }
        return maxprofit;
    }

    /**
     * 输入:
     [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
     ]
     输出: [1,2,3,6,9,8,7,4,5]

     输入:
     [
     [1, 2, 3, 4],
     [5, 6, 7, 8],
     [9,10,11,12]
     ]
     输出: [1,2,3,4,8,12,11,10,9,5,6,7]
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        List<String> reachedRecord = new ArrayList<>();
        int x = matrix.length;
        int y = matrix[0].length;
        int k = 0;
        int j = 0;
        while (k < x && j < y) {
            String key = k + "" + j;
            if (k < x) {
                k++;
                if (!reachedRecord.contains(key)) {
                    reachedRecord.add(key);
                } else {

                }
            }
        }

        return result;

    }
}
