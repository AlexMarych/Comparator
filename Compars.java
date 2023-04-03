import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class MyComp implements Comparator<Integer> {
    public static final int
            BY_VAL = 0, BY_VAL_REV = 1,
            BY_NUM_OF_DIVS = 2, BY_SUM_OF_DIGS = 3;

    private int sortType;

    public MyComp(int sortType) {
        this.sortType = sortType;
    }

    private int getNumOfDiv(int value) {
        int numOfDiv = 0;
        for (int i = 1; i < value; i++) {
            if (value % i == 0) numOfDiv++;
        }
        return numOfDiv;
    }

    private int getSumOfDigits(int value) {
        int sum = 0;
        while (value > 0) {
            sum += value % 10;
            value /= 10;
        }
        return sum;
    }


    @Override
    public int compare(Integer o1, Integer o2) {
        int result = 0;
        switch (sortType){
            case 0:
                result = o1.compareTo(o2);
                break;
            case 1:
                result = o2.compareTo(o1);
                break;
            case 2:
                result = Integer.compare(getNumOfDiv(o1), getNumOfDiv(o2));
                break;
            case 3:
                result = Integer.compare(getSumOfDigits(o1), getSumOfDigits(o2));
                break;
        }

        if (result == 0) result = o1.compareTo(o2);

        return result;
    }
}

public class Compars {
    public static void main(String[] args) {
        Integer[] a = {1, 5, 33, 12, 98, 15};
        printTable("Original    ", a);

        Arrays.sort(a, new MyComp(MyComp.BY_VAL));
        printTable("ByVal       ", a);

        Arrays.sort(a, new MyComp(MyComp.BY_VAL_REV));
        printTable("ByValRev    ", a);

        Arrays.sort(a, new MyComp(MyComp.BY_NUM_OF_DIVS));
        printTable("ByNumOfDivs ", a);

        Arrays.sort(a, new MyComp(MyComp.BY_SUM_OF_DIGS));
        printTable("BySumOfDigs ", a);
    }

    static void printTable(String mess, Integer[] a) {
        System.out.print(mess + "[ ");
        for (int d : a) System.out.print(d + " ");
        System.out.print("]\n");
    }
}
