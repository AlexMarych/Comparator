import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

enum ColComponent{
    RED,GREEN,BLUE
}
class MyColor extends Color implements Comparable<MyColor>{
    public MyColor(int r, int g, int b) {
        super(r, g, b);
    }
    @Override
    public String toString(){
        return "(" + getRed() + "," + getGreen() + "," + getBlue() + ")";
    }

    @Override
    public int compareTo(MyColor o) {
        int sum1 = this.getRed() + this.getGreen() + this.getBlue();
        int sum2 = o.getRed() + o.getGreen() + o.getBlue();
        return Integer.compare(sum1, sum2);
    }
}
class MyColorCompar implements Comparator<MyColor>{
    ColComponent rgb;
    public MyColorCompar(ColComponent rgb) {
        this.rgb = rgb;
    }


    @Override
    public int compare(MyColor o1, MyColor o2) {
        switch (rgb){
            case RED:
                return Integer.compare(o1.getRed(), o2.getRed());
            case GREEN:
                return Integer.compare(o1.getGreen(), o2.getGreen());
            case BLUE:
                return Integer.compare(o1.getBlue(), o2.getBlue());
            default:
                return 0;
        }
    }
}

public class ColorComparing {
    public static void main(String[] args) {
        List<MyColor> list = Arrays.asList(
            new MyColor(  1,  2,  3),
            new MyColor(255,  0,  0),
            new MyColor( 55, 55,100),
            new MyColor( 10,255, 10)
        );
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(
            list, new MyColorCompar(ColComponent.RED));
        System.out.println(list);
        Collections.sort(
            list, new MyColorCompar(ColComponent.GREEN));
        System.out.println(list);
        Collections.sort(
            list, new MyColorCompar(ColComponent.BLUE));
        System.out.println(list);
    }
}
