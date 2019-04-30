import java.util.Calendar;

/**
 * createby : JinxLbj
 * date : 2018/12/11
 * desc : 快速排序 三分
 **/

public class QuickPlusPlus {

    /**
     * 定义小数组
     */
    private static int M = 15;

    //千万数据2秒,上亿数据22秒
    public static void main(String[] args) {

        int[] ints = Data.genInts(100);
        Calendar calendar = Calendar.getInstance();
        sort(ints, 0, ints.length - 1);
        Calendar calendar1 = Calendar.getInstance();
        System.out.println(calendar1.getTimeInMillis() - calendar.getTimeInMillis() + "ms");


//        Calendar calendar2 = Calendar.getInstance();
//        Quick.sort(ints, 0, ints.length - 1);
//        Calendar calendar3 = Calendar.getInstance();
//        System.out.println(calendar3.getTimeInMillis() - calendar2.getTimeInMillis() + "ms");


        for (int i = 0; i < ints.length - 1; i++) {
            if (ints[i] > ints[i + 1]) {
                System.out.println(ints[i] + "," + ints[i + 1]);
                System.out.println("ERROR");
                break;
            }
            System.out.println(ints[i] + "|");
        }
    }

    public static void sort(int[] ints, int start, int end) {
        int[] divide = divide(ints, start, end);
        if (divide[0] - 1 - start > 0) {
            sort(ints, start, divide[0] - 1);
        }
        if (end - (divide[1] + 1) > 0) {
            sort(ints, divide[1] + 1, end);
        }
    }

    public static int[] divide(int[] ints, int start, int end) {
        int lt = start;
        int ht = end;
        int i = start + 1;
        int v = ints[start];
        while (i <= ht) {
            if (ints[i] < v) {
                int temp = ints[i];
                ints[i] = ints[lt];
                ints[lt] = temp;
                i++;
                lt++;
            } else if (ints[i] > v) {
                int temp = ints[i];
                ints[i] = ints[ht];
                ints[ht] = temp;
                ht--;
            } else {
                i++;
            }
        }
        return new int[]{lt, ht};
    }


}
