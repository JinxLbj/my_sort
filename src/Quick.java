import java.util.Calendar;

/**
 * createby : JinxLbj
 * date : 2018/12/11
 * desc : 快速排序
 **/

public class Quick {

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
            sort(ints, start, divide - 1);
        }
        if (end - (divide + 1) > 0) {
            sort(ints, divide + 1, end);
        }
    }

    public static int divide(int[] ints, int start, int end) {

        int num = ints[start];
        int i = start + 1;
        int j = end;
        while (i <= j) {
            if (ints[i] > num) {
                if (ints[j] < num) {
                    int temp = ints[i];
                    ints[i] = ints[j];
                    ints[j] = temp;
                    i++;
                }
                j--;
            } else {
                i++;
            }
        }
        int temp = ints[start];
        ints[start] = ints[i - 1];
        ints[i - 1] = temp;
        return i - 1;
    }


}
