package Basic;

/**
 * @author wq
 * @date 2021-01-22 17:26
 */
public class StringTest1 {
    public static void main(String[] args) {
        String s1 = new String("zs");
        String s2 = new String("zs");
        System.out.println(s1 == s2);
        String s3 = "zs";
        String s4 = "zs";
        System.out.println(s3 == s4);
        System.out.println(s3 == s1);
        String s5 = "zszs";
        String s6 = s3 + s4;
        System.out.println(s5 == s6);
        final String s7 = "zs";
        final String s8 = "zs";
        String s9 = s7 + s8;
        System.out.println(s5 == s9);
        final String s10 = s3 + s4;
        System.out.println(s5 == s10);
    }

    public void test2(){
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s3 == s6);
        System.out.println(s3 == s7);
        System.out.println(s5 == s6);
        System.out.println(s5 == s7);
        System.out.println(s6 == s7);
        String s8 = s6.intern();
        System.out.println(s3 == s8);
    }
}
