import java.util.Random;

/**
 * createby : JinxLbj
 * date : 2018/11/28
 * desc :
 **/

public class Data {

    public static int[] ints = {4, 7, 4, 3, 12, 3, 4, 5, 6, 7, 1, 1, 34, 2, 6, 8};

    public static int[] genInts(int length) {
        int[] genInts = new int[length];
        for (int i = 0; i < genInts.length; i++) {
            genInts[i] = new Random().nextInt(1000);
        }
        return genInts;
    }

    public static Alg2a1a12.Node[] genDoublesPlus(int length) {
        Alg2a1a12.Node[] genInts = new Alg2a1a12.Node[length];
        for (int i = 0; i < genInts.length; i++) {
            Alg2a1a12.Node node = new Alg2a1a12.Node();
            node.num = new Random().nextDouble();
            genInts[i] = node;
        }
        return genInts;
    }

}
