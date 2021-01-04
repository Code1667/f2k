package FuckingAlgorithm.SlidingWindow;

/**
 * leetcode 424 替换后最长重复子串
 */
public class CharacterReplacement {

    public static void main(String[] args) {
        String s = "ABAC";
        int i = characterReplacement(s, 1);
        System.out.println(i);

    }


    public static int characterReplacement(String s, int k) {
        int[] map = new int[26];
        char[] arr = s.toCharArray();

        int left = 0;
        int right = 0;
        //重复字母的个数 （出现的最大值）
        int maxCount = 0;

        for (right = 0; right < arr.length; right++) {
            int index = arr[right]-'A';
            map[index]++;
            maxCount = Math.max(maxCount, map[index]);
            if(right-left+1 - maxCount > k){//窗口大小-窗口内重复字符数>可改变的字符数
                //需要缩小窗口
                map[arr[left]-'A']--;
                left++;
            }
        }
        return right - left;
        //核心思想是：窗口大小-最大重复字符数=k
        //不用管窗口内是什么元素！

    }
}
