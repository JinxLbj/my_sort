import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * createby : JinxLbj
 * date : 2018/12/11
 * desc : 二叉树排序
 **/

public class Tree {

    private static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }
    }


    //千万数据18秒，亿数据无法承受，但空间复杂度高
    public static void main(String[] args) {

        int[] ints = Data.genInts(100000000);
        Calendar calendar = Calendar.getInstance();
        TreeNode root = new TreeNode(ints[0]);
        TreeNode cur = root;
        for (int i = 1; i < ints.length; i++) {
            while(true) {
                if(ints[i] < cur.value){
                    if(cur.left == null) {
                        cur.left = new TreeNode(ints[i]);
                        cur = root;
                        break;
                    } else {
                        cur = cur.left;
                    }
                } else {
                    if(cur.right == null) {
                        cur.right = new TreeNode(ints[i]);
                        cur = root;
                        break;
                    } else {
                        cur = cur.right;
                    }
                }
            }
        }
        getTree(ints, root);
        Calendar calendar1 = Calendar.getInstance();
        System.out.println(calendar1.getTimeInMillis() - calendar.getTimeInMillis() + "ms");
        for (int i = 0; i < ints.length - 1; i++) {
            if(ints[i] > ints[i + 1]){
                System.out.println(ints[i] + "," + ints[i + 1]);
                System.out.println("ERROR");
                break;
            }
//            System.out.println(ints[i] + "|");
        }
    }

    private static int index = 0;

    private static void getTree(int[] ints, TreeNode cur) {
        if(cur.left != null) {
            getTree(ints, cur.left);
        }
        ints[index] = cur.value;
        index++;
        if(cur.right != null) {
            getTree(ints, cur.right);
        }

    }


}
