package utils;

import org.junit.Test;

public class SimHashUtilTest {

    /**
     * 测试样例一
     */
    @Test
    public void Test1(){
        SimHashUtil.getSimHash("就像阳光穿过黑夜，黎明悄悄划过天边。");
        SimHashUtil.getSimHash("谁的身影穿梭轮回间，未来的路就在脚下，不要悲伤不要害怕。");
    }

    /**
     * 测试样例二
     */
    @Test
    public void Test2(){
        //源文件
        String path1="C:\\Users\\sk\\Desktop\\个人项目\\src\\main\\resources\\com\\lw\\测试样例\\测试-源文件\\orig.txt";
        //抄袭文件
        String path2="C:\\Users\\sk\\Desktop\\个人项目\\src\\main\\resources\\com\\lw\\测试样例\\测试-抄袭文件\\orig_0.8_add.txt";
        String txtString1 = TxtUtil.readFile(path1);
        String txtString2 = TxtUtil.readFile(path2);
        SimHashUtil.getSimHash(txtString1);
        SimHashUtil.getSimHash(txtString2);
    }
}