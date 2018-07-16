package com.wenjiehe.NowCoder;

public class Ali03_0716 {
    /*阿里有很多三位一体小组会使用敏捷开发。

    敏捷开发中会有工作量估算环节，选定某个任务由谁开发。

    团队各成员会针对某个任务估计工时，每人的工时估计用一个整形数组表示，如：[1,3,12,6,10]。

    作为敏捷小组Master，请找到按工时排序后，相邻两个工时估计最大的差距。

    注：要求线性时间和空间复杂度完成，如果只有一人估计工时，输出0



    输入为整数数组，如：[1,3,12,6,10]

    输出：4*/
    // https://blog.csdn.net/SUNbrightness/article/details/79260558


    public static void main(String[] args){
        //时间复杂度的限制让我们不可以排序
        //已知任何排序的时间复杂度都可能是O(N)
        //但是我们可以利用桶排序
        //比如有arr.length 9个数 我们给他10个桶
        //用我9个数的最大值和最小值 给他们划分10个等价空间
        int[] arr  = {1,3,15,10,9};
        int max = MaxGap(arr);
        System.out.println(max);
    }

    public static int MaxGap(int[] arr){
        if(arr.length<2||arr==null){
            return 0;
        }
        int len =arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //找出最大值和最小值
        for(int i=0;i<len;i++){
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
        }
        //如果所有的值都相等
        if(min==max){
            return 0;
        }
        //准备3个动态数组
        //分别，判断空桶、桶中的最小值、桶中最大值
        boolean[] hasNum = new boolean[len+1];
        int[] mins = new int[len+1];
        int[] maxs = new int[len+1];
        //桶的序号
        int bid=0;
        for(int i=0;i<len;i++){
            //计算该数应该放在桶的下标
            bid = bucket(arr[i],len,min,max);

            mins[bid] = hasNum[bid]?Math.min(mins[bid],arr[i]):arr[i];
            maxs[bid] = hasNum[bid]?Math.max(maxs[bid],arr[i]):arr[i];
            hasNum[bid]=true;
        }



        //之所以用这种差值判断方式是为了防止空桶的存在
        int res= 0;
        int lastMax=maxs[0];

        for(int i=1;i<=len;i++){
            if(hasNum[i]){
                res = Math.max(res,mins[i]-lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    //计算该数应该放在桶的下标
    public static int bucket(long num,long len,long min,long max){
        return (int)((num-min)*len/(max-min));
    }

}
