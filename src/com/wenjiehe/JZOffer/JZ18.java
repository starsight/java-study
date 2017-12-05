package com.wenjiehe.JZOffer;

/**
 * Created by Administrator on 2017/12/5.
 */
public class JZ18 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null||root2==null)
            return false;

        boolean result =false;
        if(root1.val==root2.val){
            result = HasSubTree2(root1,root2);

            if(result==false)
                result=HasSubtree(root1.left,root2);


            if(result==false)
                result = HasSubtree(root1.right,root2);

        }

        return result;
    }

    public boolean HasSubTree2(TreeNode root1,TreeNode root2) {
        if(root2==null)
            return true;
        if(root1==null)
            return false;
        if(root1.val!=root2.val)
            return false;

        return HasSubTree2(root1.left,root2.left)&&HasSubTree2(root1.right,root2.right);
    }
}
