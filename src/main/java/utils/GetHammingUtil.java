package utils;

/**
 * @author lw
 */
public class GetHammingUtil  {

    /**
     *
     * @param simHash1
     * @param simHash2
     * @return 海明距离
     */
    public static int getHammingDistance(String simHash1, String simHash2) {
        //前者小于后者重新调用此方法
        if (simHash1.length() < simHash2.length()) {
            return getHammingDistance(simHash2,simHash1);
        }

        // 不相等则高位补0,此时已知前者大于等于后者
        while(simHash1.length() > simHash2.length()){
            StringBuilder sb=new StringBuilder();
            sb.append('0').append(simHash2);
            simHash2 = sb.toString();
        }

        int distance = 0;
        for (int i = 0; i < simHash1.length(); i++) {
            // 每一位进行比较,得到相异的部分数量
            if (simHash1.charAt(i) != simHash2.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }

    /**
     * 计算相似度
     * @param simHash1
     * @param simHash2
     * @return  相似度
     */
    public static double getSimilarity(String simHash1, String simHash2) {
        //  获得海明距离
        int distance = getHammingDistance(simHash1, simHash2);
        // 通过海明距离计算出相似度(保留两位小数)
        double similarity = 0.01 * (100 - distance * 100 / 256);
        return similarity;
    }

}
