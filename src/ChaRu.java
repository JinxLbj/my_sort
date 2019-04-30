import java.util.Calendar;

/**
 * createby : JinxLbj
 * date : 2018/11/29
 * desc :
 **/

public class ChaRu {

    //比冒泡快，十万数据只需要5秒左右，但百万数据就已经无法承受，时间复杂度过高
    public static void main(String[] args) {
        int[] ints = Data.genInts(1000000);
        Calendar calendar = Calendar.getInstance();
//        int[] ints = Data.ints;

        for (int i = 1; i < ints.length; i++) {
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

        Calendar calendar1 = Calendar.getInstance();
        System.out.println(calendar1.getTimeInMillis() - calendar.getTimeInMillis() + "ms");
//        for (int i = 0; i < ints.length; i++) {
//            System.out.println(ints[i] + "|");
//        }
    }

    public static void sort(int[] ints) {
        for (int i = 1; i < ints.length; i++) {
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
}
