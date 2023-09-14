package utils;

import org.junit.Test;

public class GetHammingUtilTest {

    /**
     * 测试位数相等字符串的海明距离和相似度
     */
    @Test
    public void test1() {
        String str0 = "110110110110";
        String str1 = "101101101101";
        int distance = GetHammingUtil.getHammingDistance(str0, str1);
        double similarity = GetHammingUtil.getSimilarity(str0, str1);
        System.out.println("两者的海明距离：" + distance);
        System.out.println("两者的相似度:" + similarity);
    }

    /**
     * 测试前者小于后者的海明距离和相似度
     */
    @Test
    public void test2() {
        String str0 = "110101110101";
        String str1 = "110101111111111111";
        int distance = GetHammingUtil.getHammingDistance(str0, str1);
        double similarity = GetHammingUtil.getSimilarity(str0, str1);
        System.out.println("两者的海明距离：" + distance);
        System.out.println("两者的相似度:" + similarity);
    }

    /**
     * 测试其中存在空字符串时的海明距离和相似度
     */
    @Test
    public void test3() {
        String str0 = "110101010110";
        String str1 = "";
        int distance = GetHammingUtil.getHammingDistance(str0, str1);
        double similarity = GetHammingUtil.getSimilarity(str0, str1);
        System.out.println("两者的海明距离：" + distance);
        System.out.println("两者的相似度:" + similarity);
    }

}