import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * createby : JinxLbj
 * date : 2019/4/29
 * desc :
 **/

public class Alg2a1a12 {

    public static class Node {

        public double num;

        public int count;

    }

    public static void main(String[] args) {
        Map<String, Integer> resultMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        new ArrayList<String>().sort((o1, o2) -> {
            int o1v = Integer.valueOf(o1.split(" ")[0]);
            int o2v = Integer.valueOf(o2.split(" ")[0]);
            return Integer.compare(o1v, o2v);
        });

        for(int i = 100 ; i < 10000000 ; i *= 10) {
            Node[] ints = Data.genDoublesPlus(i);
            soft(ints);
            double total = 0d;
            for (int j = 0 ; j < ints.length ; j++) {
//                System.out.println(i + " -> " + ( Double.valueOf(ints[j].count) / Double.valueOf(ints.length) ));
                total += (double) ints[j].count;
            }
            System.out.println(i + " -> " + total / (double) ints.length);
        }


    }

    private static void soft(Node[] ints) {
        int inv = ints.length / 3;
        for (int i = inv; i > 0; i = i / 3) {

            for (int j = 0; j < i; j++) {
                for (int k = j + i; k < ints.length; k += i) {
                    for (int l = k; l >= j + i; l -= i) {
                        if (ints[l].num < ints[l - i].num) {
                            ints[l].count++;
                            ints[l - i].count++;
                            Node temp = ints[l];
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
    }


}
