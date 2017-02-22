package com.wenjiehe.Algorithm;

import java.util.ArrayList;
import java.util.List;

public class Sort{

	public static void individualSort(List<Integer> item){
		if(item.size()>1){
			List<Integer> small = new ArrayList<>();
			List<Integer> same = new ArrayList<>();
			List<Integer> big = new ArrayList<>();

			Integer a = item.get(item.size()/2);
			for(Integer in : item){
				if(a<in){
					big.add(in);
				}
				else if(a>in){
					small.add(in);
				}
				else{
					same.add(in);
				}
			}

			individualSort(small);
			individualSort(big);

			item.clear();
			item.addAll(small);
			item.addAll(same);
			item.addAll(big);
		}
	}

	public static void quickSort(int[] nums,int record[],int start,int end){

		if(start<end){
			int temp = nums[start];
			int startTmp= start,endTmp = end;
			while(start<end) {
				while (start < end && nums[end] < temp) {
					--end;
				}
				if(start < end) {
				    record[start] = end;
				    record[end] = start;
					nums[start++] = nums[end];
				}

				while (start < end && nums[start] >= temp) {
					++start;
				}
				if(start < end) {
                    record[start] = end;
                    record[end] = start;
                    nums[end--] = nums[start];
                }

			}
			nums[start] = temp;
			quickSort(nums,record,startTmp,start-1);
			quickSort(nums,record,start+1,endTmp);
		}
	}

	public static void shellSort(int[] nums,int length){
		int gap,i,j;
		for(gap = length/2;gap > 0;gap /= 2){
			for(i = 0;i < gap; i++){
				for(j = i + gap;j < length;j += gap){
					if(nums[j] < nums[j - gap]){
						int temp = nums[j];
						int k = j- gap;
						for(;k >= 0 && nums[k] > temp;){
							nums[k + gap] = nums[k];
							k -= gap;
						}
						nums[k + gap] = temp;
					}
				}
			}
		}
	}

	public static void insertSort(int[] nums,int n){

		for(int i = 1;i < n;i++){
            int j;
			if(nums[i]<nums[i-1]){
				int temp = nums[i];

				for(j = i - 1;j >= 0 ; j--){
					if(nums[j] > temp)
						nums[j + 1 ] = nums[j];
					else
					    break;
				}
				nums[j + 1] = temp;
			}
		}
	}

	public static void quickSort2(int nums[],int start,int end){
		int temp = nums[start];
		int startTmp = start, endTmp = end;
		if(start<end) {
            while (start < end) {
                while (start < end && nums[end] > temp) {
                    end--;
                }
                if (start < end)
                    nums[start++] = nums[end];
                while (start < end && nums[start] <= temp) {
                    start++;
                }
                if (start < end) {
                    nums[end--] = nums[start];
                }
            }
            nums[start] = temp;
            quickSort2(nums,startTmp,start - 1);
            quickSort2(nums,start + 1,endTmp);
		}
	}

	public static void quickSort3(int nums[],int start,int end){
		
		if(start<end){
			int temp = nums[start];
			int startTemp = start, endTemp = end;
			while(start < end){
				while(start < end && nums[end] > temp){
					end--;
				}
				if(start < end){
					nums[start++] = nums[end];
				}

				while(start < end && nums[start] <= temp){
					start++;
				}
				if (start < end) {
					nums[end--] = nums[start];
				}
			}
			nums[start] = temp;
			quickSort3(nums,startTemp,start - 1);
			quickSort3(nums,start + 1,endTemp);
		}
	}

}