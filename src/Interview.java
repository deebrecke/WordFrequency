import java.util.Arrays;

public class Interview {
    public static void main(String[] args) {

        int[] nums = {2, 4, 4, 7};//tgt 8
        int[] num2 = {3, 2, 4};//tgt6
        int[] num3 = {3, 2};//tgt5
        int[] num4 = {2, 4, 4, 7, 9};//tgt 16
        int[] num5 = {2, 4, 4, 7};//tgt 9
        int[] num6 = {2, 4, 10, 7, 5};//tgt 11
        int[] num7 = {2, 4, 4, 7, 5};//tgt 12
        int[] num8 = {2, 4, 4, 7};//tgt 8


        System.out.println(Arrays.toString(twoSum(num2, 6)));//1,2
        System.out.println(Arrays.toString(twoSum(nums, 8)));//1,2
        System.out.println(Arrays.toString(twoSum(num3, 5)));//0,1
        System.out.println(Arrays.toString(twoSum(num4, 16)));//3,4

        System.out.println(Arrays.toString(twoSum(num5, 9)));//0,3

        System.out.println(Arrays.toString(twoSum(num6, 11)));//1,3
        System.out.println(Arrays.toString(twoSum(num7, 12)));//3,4
        System.out.println(Arrays.toString(twoSum(num8, 9)));//1,4//0,3
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] outputArray= {0,1};
        for(int i = 0; i<nums.length; i++){
            for(int j = i+1; j< nums.length; j++){
                if(nums[i] + nums[j] == target){
                    outputArray[0] = i;
                    outputArray[1] = j;
                }
            }
        }
        return outputArray;
    }

}
/*

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
1. sort array alphabetically
2. compare each char of the first and last words in the array
3. add matching chars to string
4. exit loop once a mismatached one is found
    }
}
 */
