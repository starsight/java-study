package com.wenjiehe.NowCoder;

import java.util.Scanner;

public class Tencent00 {

    public static void main(String[] args) {
        Tencent00 tencent00 =new Tencent00();
        tencent00.getMaxPaid();
    }

    public void getMaxPaid(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] machineTime = new int[n];
        int[] machineLevel = new int[n];

        int[] taskTime = new int[m];
        int[] taskLevel = new int[m];

        for (int i = 0; i < n; i++) {
           machineTime[i] = sc.nextInt();
           machineLevel[i] = sc.nextInt();

        }

        for (int i = 0; i < m; i++) {
            taskTime[i] = sc.nextInt();
            taskLevel[i] = sc.nextInt();
        }

        maoPaoSort(machineTime,null,machineLevel);

        int[] sortResult = cal(taskTime,taskLevel);

        int maxValue =0;
        int maxCount=0;

        for (int i = 0,j=0; i < m && j<n; i++) {
            if(taskTime[i]<=machineTime[j]&&taskLevel[i]<=machineLevel[i]){
                maxValue+=sortResult[i];
                j++;
                maxCount++;
            }
        }

        System.out.println(maxCount+" "+maxValue);

    }

    public int[] cal(int[] taskTime,int[] taskLevel){
        int l =taskLevel.length;
        int [] result = new int[l];
        for (int i = 0; i < l ; i++) {
            result[i] = 200*taskTime[i]+3*taskLevel[i];
        }

        maoPaoSort(result,taskTime,taskLevel);
        return result;
    }


    private  void maoPaoSort(int[] nums,int[] taskTime,int[] taskLevel ){
        for (int i = 0; i <nums.length-1 ; i++) {
            for (int j = 0; j < nums.length-i-1; j++) {
                if(nums[j]<nums[j+1]){
                    int t = nums[j];
                    nums[j] =nums[j+1];
                    nums[j+1] = t;

                    if(taskTime!=null){
                        t = taskTime[j];
                        taskTime[j] =taskTime[j+1];
                        taskTime[j+1] = t;
                    }


                    t = taskLevel[j];
                    taskLevel[j] =taskLevel[j+1];
                    taskLevel[j+1] = t;
                }
            }
        }
    }


}
