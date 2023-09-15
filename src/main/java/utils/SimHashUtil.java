package utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
/**
 * @author lw
 */
public class SimHashUtil {

    public static int hashBit;
    /**
     * 计算hash值
     * @param str
     * @return
     */
    public static String calculateHash(String str){
        try {
            // 创建MessageDigest对象，选择哈希算法（SHA-256）
            MessageDigest messageDigest  = MessageDigest.getInstance("SHA-256");
            hashBit=256;
            // 将文本转换为字节数组，并计算哈希值
            byte[] hashBytes = messageDigest .digest(str.getBytes(StandardCharsets.UTF_8));
            // 将字节数组转换为BigInteger,进而转化成二进制
            return new BigInteger(1, hashBytes).toString(2);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("出错啦！");
            return null;
        }
    }

    /**
     * 此方法用于计算simhash值
     * @param str 传入的字符串
     * @return 返回smash值
     */
    public static String getSimHash(String str){

        if(("").equals(str)) {
            System.out.println("请检查你的文本内容");
        }
        int[] hash = new int[hashBit];
        //1、分词操作,运用正则表达式,并且规定了常见的几种符号作为分割标志
        String[] terms=str.split("\\s+|[，。！？《》；：“”]");
        int len = terms.length;
        int i = 0;
        for(String term : terms){
            //2、求hash值
            String cHash = calculateHash(term);
            if(cHash.length() < hashBit){
                int x = hashBit-cHash.length();
                //哈希值的位数不足 256，则在低位用 0 补齐。
                for (int j = 0; j < x; j++) {
                    cHash += cHash.charAt('0');
                }
            }
            //3、加权，加权的权重与词语在文本中的位置i有关
            for (int j = 0; j < hash.length ; j++) {
                if (cHash.charAt(j) == '1') {
                    hash[j] +=(int) (10 - (i / ((double)len / 10)));
                } else {
                    hash[j] -= (int)(10 - (i / ((double)len / 10)));
                }
            }
            i++;
        }
        //4、降维
        String smash = "";
        for (int j = 0; j <hash.length ; j++) {
            if(hash[j]<0){
                smash += "0";
            }else {
                smash += "1";
            }
        }
        System.out.println("该阶段相似hash结束");
        return smash;
    }



}