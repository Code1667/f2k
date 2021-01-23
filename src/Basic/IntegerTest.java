package Basic;

/**
 * @author wq
 * @date 2021-01-22 17:28
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer i1 = new Integer(12);
        Integer i2 = new Integer(12);
        System.out.println(i1 == i2);

        Integer i3 = 126;
        Integer i4 = 126;
        int i5 = 126;
        System.out.println(i3 == i4);
        System.out.println(i3 == i5);

        Integer i6 = 128;
        Integer i7 = 128;
        int i8 = 128;
        System.out.println(i6 == i7);
        System.out.println(i6 == i8);
    }
}
