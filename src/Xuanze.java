import java.util.Calendar;

/**
 * createby : JinxLbj
 * date : 2018/11/29
 * desc :
 **/

public class Xuanze {

    //最常用的排序方式，十万数据量只需6秒，与插入排序相同，无法承受百万数据量
    public static void main(String[] args) throws InterruptedException {
//        int[] ints = Data.genInts(10);
        Thread.sleep(1000);
        System.out.println(xuanze(Data.genInts(10)) + " ms");
        System.out.println(xuanze(Data.genInts(100)) + " ms");
        System.out.println(xuanze(Data.genInts(1000)) + " ms");
        System.out.println(xuanze(Data.genInts(10000)) + " ms");
        System.out.println(xuanze(Data.genInts(100000)) + " ms");
    }

    public static long xuanze(int[] ints) {
        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i < ints.length; i++) {
            int minIndex = i;
            for (int j = i; j < ints.length; j++) {
                if (ints[j] < ints[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = ints[i];
            ints[i] = ints[minIndex];
            ints[minIndex] = temp;
        }
        Calendar calendar1 = Calendar.getInstance();
//        for (int i = 0; i < ints.length; i++) {
//            System.out.print(ints[i] + " | ");
//        }
        return calendar1.getTimeInMillis() - calendar.getTimeInMillis();
    }


}
