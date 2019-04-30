import java.util.Calendar;

/**
 * createby : JinxLbj
 * date : 2018/12/11
 * desc : 快速排序 结合小数组插入排序
 **/

public class QuickPlus {

    /**
     * 定义小数组
     */
    private static int M = 15;

    //千万数据2秒,上亿数据22秒
    public static void main(String[] args) {

        int[] ints = Data.genInts(10000000);
        Calendar calendar = Calendar.getInstance();
        sort(ints, 0, ints.length - 1);
        Calendar calendar1 = Calendar.getInstance();
        System.out.println(calendar1.getTimeInMillis() - calendar.getTimeInMillis() + "ms");

        for (int i = 0; i < ints.length - 1; i++) {
            if (ints[i] > ints[i + 1]) {
                System.out.println(ints[i] + "," + ints[i + 1]);
                System.out.println("ERROR");
                break;
            }
//            System.out.println(ints[i] + "|");
        }
    }

    public static void sort(int[] ints, int start, int end) {
        int divide = divide(ints, start, end);
        if (divide - 1 - start > 0) {
            if(divide - 1 - start < M) {
                insertSort(ints, start, divide - 1);
            } else {
                sort(ints, start, divide - 1);
            }

        }
        if (end - (divide + 1) > 0) {
            if(end - (divide + 1) < M) {
                insertSort(ints, divide + 1, end);
            } else {
                sort(ints, divide + 1, end);
            }
        }
    }

    public static void insertSort(int[] ints, int start, int end) {
        for (int i = start + 1; i < end + 1; i++) {
            for (int j = i; j > 0; j--) {
                if (ints[j] < ints[j - 1]) {
                    int temp = ints[j];
                    ints[j] = ints[j - 1];
                    ints[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public static int divide(int[] ints, int start, int end) {

        int i = start, j = end + 1;
        int v = ints[start];
        while(true) {
            while (ints[++i] < v) {
                if(i == end) {
                    break;
                }
            }
            while (ints[--j] > v) {
                if(j == start) {
                    break;
                }
            }
            if(i >= j) {
                break;
            }
            int temp = ints[i];
            ints[i] = ints[j];
            ints[j] = temp;
        }
        int temp = ints[start];
        ints[start] = ints[j];
        ints[j] = temp;
        return j;
    }


}
