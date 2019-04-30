import java.util.Calendar;

/**
 * createby : JinxLbj
 * date : 2018/12/3
 * desc :
 **/

public class GuiBing2 {

    //大数据量表现良好，上亿数据量只需40秒
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int[] ints = Data.genInts(10000000);
        sort(ints, 0, ints.length - 1);
        Calendar calendar1 = Calendar.getInstance();
        System.out.println(calendar1.getTimeInMillis() - calendar.getTimeInMillis() + "ms");
    }

    public static void sort(int[] ints, int start, int end) {
//        if (end - start != 0) {
//            int mid = (start + end) / 2;
//            sort(ints, start, mid);
//            sort(ints, mid + 1, end);
//            merge(ints, start, end, mid);
//        }
        for (int i = 1; i < ints.length; i *= 2) {
            for (int j = 0; j < ints.length; j += i) {
                int s = j;
                int e = j + i - 1 > ints.length - 1 ? ints.length - 1 : j + i - 1;
                if(s == e) {
                    break;
                }
                merge(ints, s, e, (s + e) / 2);
            }
        }
        merge(ints, start, end, (start + end) / 2);
    }

    public static void merge(int[] ints, int start, int end, int mid) {
        int[] copy = new int[end - start + 1];
        for (int i = start, j = mid + 1, k = 0; k < copy.length; k++) {
            if (i > mid) {
                copy[k] = ints[j];
                j++;
            } else if (j > end) {
                copy[k] = ints[i];
                i++;
            } else if (ints[i] < ints[j]) {
                copy[k] = ints[i];
                i++;
            } else {
                copy[k] = ints[j];
                j++;
            }
        }
        for (int i = 0; i < copy.length; i++) {
            ints[start + i] = copy[i];
        }
    }


}
