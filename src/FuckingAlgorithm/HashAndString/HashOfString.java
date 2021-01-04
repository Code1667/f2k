package FuckingAlgorithm.HashAndString;

/**
 * @author wq
 * @date 2020-04-22 15:33
 * 字符哈希
 *
 */
public class HashOfString {
    public static void main(String[] args) {
        String str = "Aabcdefgaaxxy";
        str_Hash(str);
        System.out.println("*************");
        int[] random = {999,1,6,15,2,37,82,22,1,20};
        sort_Hash(random, 1000);
    }

    /**
     * 字符串hash
     * @param str
     */
    public static void str_Hash(String str){
        int[] char_map = new int[128];
        for (int i = 0; i < str.length(); i++) {
            char_map[str.charAt(i)]++;
        }
        for (int i = 0; i < 128; i++) {
            if (char_map[i] > 0) {
                System.out.println("[" + (char) i + "]" + "[" + i + "]" + ":" + char_map[i]);
            }
        }
    }

    /**
     * 利用hash进行排序
     * 999,1,6,15,2,37,82,22,1,20
     * @param arr  无序数组
     * @param n 规定给定数组arr中元素的最大值
     */
    public static void sort_Hash(int[] arr,int n){
        int[] hash_map = new int[n];
        for (int i = 0; i < arr.length; i++) {
            hash_map[arr[i]]++;
        }
        for (int i = 0; i < hash_map.length; i++) {
            for (int j = 0; j < hash_map[i]; j++) {
                System.out.println(i);
            }
        }
    }
}
