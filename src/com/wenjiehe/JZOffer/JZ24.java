package com.wenjiehe.JZOffer;

public class JZ24 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0)
            return false;

        return vertify(sequence,0,sequence.length-1);
    }

    public boolean vertify(int[] seq,int from ,int end){
        int root =seq[end];
        int i=from,j=from;

        while(i<end){//attention
            if(seq[i]>root)
                break;
            i++;
        }
        j=i;
        while(j<end){//attention
            if(seq[j]<root)
                return false;
            j++;
        }

        i--;
        j--;

        boolean left=true,right=true;
        if(i>from)
            left = vertify(seq,0,i);

        if(j>i)//attention
            right = vertify(seq,i+1,end-1);

        return left&&right;
    }

    public static void main(String[] args) {
        JZ24 jz24 =new JZ24();
        boolean is = jz24.VerifySquenceOfBST(new int[]{5,7,6,9,11,10,8});
        System.out.println(is);
    }
}
