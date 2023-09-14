package main;

import utils.GetHammingUtil;
import utils.SimHashUtil;
import utils.TxtUtil;

/**
 * @author lw
 */
public class Main {
    public static void main(String[] args) {

        if(null==args||args.length<3){
            System.out.println("输入格式错误，请重新尝试");
            return;
        }
        //源文件，抄袭文件，结果文件路径
        String path1 = args[0];
        String path2 = args[1];
        String resultFile = args[2];
        //读取文本
        String TxtString1 = TxtUtil.readFile(path1);
        String TxtString2 = TxtUtil.readFile(path2);
        //获取simHash码
        String simHash1 = SimHashUtil.getSimHash(TxtString1);
        String simHash2 = SimHashUtil.getSimHash(TxtString2);
        //相似度
        double similarity = GetHammingUtil.getSimilarity(simHash1, simHash2);
        //结果展示
        StringBuilder builder = new StringBuilder();
        builder.append("原文文件：").append(path1).append("\n");
        builder.append("抄袭文件：").append(path2).append("\n");
        builder.append("两个文件的相似度为：").append(similarity).append("\n");
        System.out.println("-----------------");
        System.out.println("两个文件相似度："+similarity);
        System.out.println("-----------------");
        //写入文件
        TxtUtil.writeFile(resultFile,builder.toString());
    }
}