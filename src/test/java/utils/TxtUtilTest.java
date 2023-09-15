package utils;

import org.junit.Test;

public class TxtUtilTest {
    //结果路径
    String resultFile = "C:\\Users\\sk\\Desktop\\个人项目\\src\\main\\resources\\com\\lw\\测试样例\\结果文件\\result.txt";
    //异常结果路径
    String falseFile = "C:\\Users\\sk\\Desktop\\个人项目\\src\\main\\resources\\com\\lw\\测试样例\\结果文件\\son.txt";
    //空例子
    String mouse="";

    /**
     * 测试读取空路径
     */
    @Test
    public void test1(){
        //路径为空
        TxtUtil.readFile("");
    }

    /**
     * 测试读取错误路径的文章
     */
    @Test
    public void test2(){
        TxtUtil.readFile("C:\\Users\\sk\\Desktop\\个人项目\\src\\main\\resources\\com\\lw\\测试样例\\我是错误的父目录\\orig.txt");
    }

    /**
     * 测试读取正确路径(这里例子为源文件路径)
     */
    @Test
    public void test3(){
        TxtUtil.readFile("C:\\Users\\sk\\Desktop\\个人项目\\src\\main\\resources\\com\\lw\\测试样例\\测试-源文件\\orig.txt");
    }


    /**
     * 测试读取文件夹
     */
    @Test
    public void test4(){
        TxtUtil.readFile("C:\\Users\\sk\\Desktop\\个人项目\\src\\main\\resources\\com\\lw\\测试样例\\测试-源文件");
    }

    /**
     * 测试不存在路径
     */
    @Test
    public void test5(){
        //路径不存在
        TxtUtil.readFile("C:\\Users\\sk\\Desktop\\个人项目\\lll");

    }

    /**
     * 测试写入地址为空的路径
     */
    @Test
    public void test6(){
        TxtUtil.writeFile(mouse, "我是一个例子");
    }

    /**
     * 测试写入正确文件但是内容为空
     */
    @Test
    public void test7(){
        String text = "";
        TxtUtil.writeFile(resultFile, text);
    }

    /**
     * 测试写入正确文件且包含内容
     */
    @Test
    public void test8(){
        String text = "我是一个例子";
        TxtUtil.writeFile(resultFile, text);
    }

    /**
     * 测试写入错误地址文件且包含内容
     */
    @Test
    public void test9(){
        String text = "我又是一个例子";
        TxtUtil.writeFile(falseFile, text);
    }


}