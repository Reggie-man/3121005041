package main;

import org.junit.Test;

public class MainTest {
    //源文件
    String path1="C:\\Users\\sk\\Desktop\\个人项目\\src\\main\\resources\\com\\lw\\测试样例\\测试-源文件\\orig.txt";
    //抄袭文件
    String path2="C:\\Users\\sk\\Desktop\\个人项目\\src\\main\\resources\\com\\lw\\测试样例\\测试-抄袭文件\\orig_0.8_add.txt";
    String path3="C:\\Users\\sk\\Desktop\\个人项目\\src\\main\\resources\\com\\lw\\测试样例\\测试-抄袭文件\\orig_0.8_del.txt";
    String path4="C:\\Users\\sk\\Desktop\\个人项目\\src\\main\\resources\\com\\lw\\测试样例\\测试-抄袭文件\\orig_0.8_dis_1.txt";
    String path5="C:\\Users\\sk\\Desktop\\个人项目\\src\\main\\resources\\com\\lw\\测试样例\\测试-抄袭文件\\orig_0.8_dis_10.txt";
    String path6="C:\\Users\\sk\\Desktop\\个人项目\\src\\main\\resources\\com\\lw\\测试样例\\测试-抄袭文件\\orig_0.8_dis_15.txt";
    //结果路径
    String resultFile = "C:\\Users\\sk\\Desktop\\个人项目\\src\\main\\resources\\com\\lw\\测试样例\\结果文件\\result.txt";
    //空白路径
    String whiteFile = "C:\\Users\\sk\\Desktop\\个人项目\\src\\main\\resources\\com\\lw\\测试样例\\辅助文件\\white.txt";

    /**
     * 测试一：正常情况
     */
    @Test
    public void test1(){
        try {
            new Main().main(new String[]{path1,path2,resultFile});
        }catch (Exception e){
            System.err.println("发生错误：" + e.getMessage());
        }
    }
    /**
     * 测试二：正常情况
     */
    @Test
    public void test2(){
        try {
            new Main().main(new String[]{path1,path3,resultFile});
        }catch (Exception e){
            System.err.println("发生错误：" + e.getMessage());
        }
    }
    /**
     * 测试三：正常情况
     */
    @Test
    public void test3(){
        try {
            new Main().main(new String[]{path1,path4,resultFile});
        }catch (Exception e){
            System.err.println("发生错误：" + e.getMessage());
        }
    }
    /**
     * 测试四：正常情况
     */
    @Test
    public void test4(){
        try {
            new Main().main(new String[]{path1,path5,resultFile});
        }catch (Exception e){
            System.err.println("发生错误：" + e.getMessage());
        }
    }
    /**
     * 测试五：正常情况
     */
    @Test
    public void test5(){
        try {
            new Main().main(new String[]{path1,path6,resultFile});
        }catch (Exception e){
            System.err.println("发生错误：" + e.getMessage());
        }
    }
    /**
     * 测试六：原文与原文对比
     */
    @Test
    public void test6(){
        try {
            new Main().main(new String[]{path1,path1,resultFile});
        }catch (Exception e){
            System.err.println("发生错误：" + e.getMessage());
        }
    }
    /**
     * 测试七：原文与空白文件对比
     */
    @Test
    public void test7(){
        try {
            new Main().main(new String[]{path1,whiteFile,resultFile});
        }catch (Exception e){
            System.err.println("发生错误：" + e.getMessage());
        }
    }

}