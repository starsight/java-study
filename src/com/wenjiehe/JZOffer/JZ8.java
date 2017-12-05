package com.wenjiehe.JZOffer;

/**
 * Created by Administrator on 2017/12/4.
 */
public class JZ8 {
    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0)
            return 0;
        else if (array.length == 1)
            return array[0];
        else
            return rotateMiddle(array, 0, array.length - 1);
    }

    public static int rotateMiddle(int[] array, int left, int right) {
        int middle = left;
        while (array[left]>=array[right]) {
            if(right-left==1){
                middle = right;
                break;
            }

            middle = (right - left) / 2 + left;
            if (array[left] < array[middle])
                left = middle;
            else if (array[left] > array[middle])
                right = middle;
            else
                right = right - 1;
        }
        return array[middle];
    }

    public static  int findMin(int[] nums) {
        int left=0,right=nums.length-1;
        int center =0;
        while(nums[left]>nums[right]){
            center = left+(right-left)/2;

            if(right-left==1)
                return nums[right];

            if(nums[center]<nums[right]){
                right = center;
            }else if(nums[center]>nums[left]){
                left = center;
            }
        }

        return nums[center];
    }

    public static void main(String[] args) {
        minNumberInRotateArray(new int[]{1,0,1,1,1});
        findMin(new int[]{1,0,1,1,1});
    }
}
