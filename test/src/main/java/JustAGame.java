/**
 * Created by wb.zhengcheng on 2017/8/17.
 */
public class JustAGame {
    public static void main(String[] args) {
        int[] array = {12,2,16,30,28,10,16,20,6,18};

        int z = zhijiecharu(array);
    }

    private static int zhijiecharu(int[] array) {
        int sum = 0;
        for (int i =1; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                sum++;
                if(array[i]<array[j]){

                    break;
                }
            }
        }
        return sum;
    }

}
