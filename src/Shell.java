import java.util.Calendar;

/**
 * createby : JinxLbj
 * date : 2018/11/30
 * desc :
 **/

public class Shell {

    //小数量与中等数据量表现较好，上亿数据量速度明显减慢，约100秒
    public static void main(String[] args) {
        int[] ints = Data.genInts(1000000);
//        int[] ints = Data.ints;
        Calendar calendar = Calendar.getInstance();
//        int[] ints = Data.ints;
        int inv = ints.length / 3;
        for (int i = inv; i > 0; i = i / 3) {

            for (int j = 0; j < i; j++) {
                for (int k = j + i; k < ints.length; k += i) {
                    for (int l = k; l >= j + i; l -= i) {
                        if (ints[l] < ints[l - i]) {
                            int temp = ints[l];
                            ints[l] = ints[l - i];
                            ints[l - i] = temp;
                        } else {
                            break;
                        }
                    }
                }
            }
            if(i > 1 && i / 3 == 0) {
                i = 3;
            }
        }
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

}
