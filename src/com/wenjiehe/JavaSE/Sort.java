package com.wenjiehe.JavaSE;

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
}