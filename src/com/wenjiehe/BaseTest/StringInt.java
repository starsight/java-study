package com.wenjiehe.BaseTest;

import com.wenjiehe.Algorithm.Sort;

import java.util.Arrays;

/**
 * Created by yiyuan on 17/2/17.
 */
public class StringInt {

    public static void main(String args[]){
//        String a = "123";
//        int aInt = Integer.parseInt(a);
//        System.out.println(aInt);
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
//        try {
//            Date d = sdf.parse("2017-10-01");
//            //System.out.println(d);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        Person peron = new Person(){
            void getPerson(){
                System.out.print("implements");
            }
        };
        peron.getPerson();
        int[] nums = {5,4,3,2,88,10,7,9,1};
        int[] record = new int[nums.length];
        //System.out.println(Arrays.toString(findRelativeRanks(nums)));
        //Sort.quickSort2(nums,0,nums.length-1);
        //Sort.shellSort(nums,nums.length);
        //sort(nums,0,nums.length-1);


       Sort.maoPaoSort(nums);
        System.out.println(Arrays.toString(nums));
    }



    public static int partition(int []array,int lo,int hi){
        //固定的切分方式
        int key=array[lo];
        while(lo<hi){
            while(array[hi]>=key&&hi>lo){//从后半部分向前扫描
                hi--;
            }
            array[lo]=array[hi];
            while(array[lo]<=key&&hi>lo){//从前半部分向后扫描
                lo++;
            }
            array[hi]=array[lo];
        }
        array[hi]=key;
        return hi;
    }

    public static void sort(int[] array,int lo ,int hi){
        if(lo>=hi){
            return ;
        }
        int index=partition(array,lo,hi);
        sort(array,lo,index-1);
        sort(array,index+1,hi);
    }

    public static String[] findRelativeRanks(int[] nums) {
        String[] result = new String[nums.length];
        int [] numsTmp = new int[nums.length];

        for(int i=0;i<nums.length;i++) {
            numsTmp[i] = i;
        }
        int temp = 0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=0;j<nums.length-i-1;j++){
                if(nums[j+1]>nums[j]){
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    temp = numsTmp[j];
                    numsTmp[j] = numsTmp[j+1] ;
                    numsTmp[j+1] = temp;
                }
            }
        }
        for(int i=0;i<numsTmp.length;i++){
            System.out.println(i);
            result[numsTmp[i]] = i+1+"";
        }
        result[numsTmp[0]] = "Gold Medal";
        result[numsTmp[1]] = "Silver Medal";
        result[numsTmp[2]] = "Bronze Medal";

        return result;
    }
}
 class Person{
    void getPerson(){
        System.out.print("get Person");
    }
}