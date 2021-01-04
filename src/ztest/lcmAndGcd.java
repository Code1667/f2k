package ztest;

import java.util.Scanner;

/**
 * @author wq
 * @date 2020-03-29 19:42
 */
public class lcmAndGcd {

    /**
     * 求最小公倍数
     *
     * @param a
     * @param b
     * @return
     */
    public static int lcm(int a, int b) {
        if (a % b != 0 && b % a != 0) {
            return a*b;
        }else{
            return a>b?a:b;
        }
    }

    /**
     * 求最大公约数
     *
     * @param a
     * @param b
     * @return
     */
    public static int gcd(int a, int b) {
        if (a % b != 0 && b % a != 0) {
            return -1;
        }
        int r = 0;
        if (a % b == 0) {
            r = b;
            return r;
        } else if (b % a == 0) {
            r = a;
            return r;
        }
        return -1;
    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        Scanner input2 = new Scanner(System.in);
        int b = input2.nextInt();


        System.out.println("最小公倍数：" + lcm(a, b));
        System.out.println("最大公约数：" + gcd(a, b));
        int lcm_gcd = lcm(a, b) - gcd(a, b);
        System.out.println(lcm_gcd);

    }
}
