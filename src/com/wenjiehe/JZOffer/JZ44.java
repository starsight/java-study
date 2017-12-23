package com.wenjiehe.JZOffer;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/12/23.
 */
public class JZ44 {


    public boolean isContinuous(int[] numbers) {
        int zeroNumber = 0;
        int len = numbers.length - 1;
        if (len != 4)
            return false;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0)
                zeroNumber++;
        }

        Arrays.sort(numbers);

        int index = 0;

        while (index < len) {
            if (numbers[index] == 0) {
                index++;
                continue;
            }
            if (numbers[index + 1] == numbers[index])
                return false;
            int gap = numbers[index + 1] - numbers[index];
            if (gap != 1) {
                zeroNumber = zeroNumber - (gap - 1);
                if (zeroNumber < 0)
                    return false;
            }
            index++;
        }
        return true;

    }


    public static void main(String[] args) {

    }
}
