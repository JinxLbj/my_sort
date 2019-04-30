import java.util.Calendar;
import java.util.Date;

/**
 * createby : JinxLbj
 * date : 2018/11/28
 * desc : 冒泡
 **/

public class MaoPao {

    //适合小排序，十万数据量就已需要24秒
    public static void main(String[] args) throws InterruptedException {
        int[] ints = Data.genInts(100000);
        Calendar calendar = Calendar.getInstance();
//        int[] ints = Data.ints;
        for (int i = ints.length - 1; i > 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (ints[j] > ints[j + 1]) {
                    int temp = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = temp;
                }
            }
        }
        Calendar calendar1 = Calendar.getInstance();
        System.out.println(calendar1.getTimeInMillis() - calendar.getTimeInMillis() + "ms");
//        System.out.println(ints);
//        for (int i = 0; i < ints.length; i++) {
//            System.out.println(ints[i] + "|");
//        }
    }
}


