import java.util.Calendar;

/**
 * createby : JinxLbj
 * date : 2019/4/30
 * desc :
 **/

public class GuiBingChaRu {

    //大数据量表现良好，上亿数据量只需40秒
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int[] ints = Data.genInts(10000);
        sort(ints, 0, ints.length - 1);
        Calendar calendar1 = Calendar.getInstance();
        System.out.println(calendar1.getTimeInMillis() - calendar.getTimeInMillis() + "ms");
    }

    public static void sort(int[] ints, int start, int end) {
        if (end - start != 0) {
            int mid = (start + end) / 2;
            sort(ints, start, mid);
            sort(ints, mid + 1, end);
            merge(ints, start, end, mid);
        }
    }

    public static void merge(int[] ints, int start, int end, int mid) {
//        int[] copy = new int[end - start + 1];
        for(int i = start + 1 ; i <= end; i++) {
            for(int j = i ; j > start ; j--) {
                if(ints[j] < ints[j - 1]) {
                    int temp = ints[j];
                    ints[j] = ints[j - 1];
                    ints[j - 1] = temp;
                }else {
                    break;
                }
            }
        }
//        for (int i = 0; i < copy.length; i++) {
//            ints[start + i] = copy[i];
//        }
    }

}
