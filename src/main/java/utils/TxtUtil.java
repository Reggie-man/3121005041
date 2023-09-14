package utils;
import java.io.*;

/**
 * @author lw
 */
public class TxtUtil {
    /**
     * 读取文件
     * @param filePath
     * @return 返回文件内容
     */
    public static String readFile(String filePath)  {
        //空路径异常处理
        if(filePath.length()==0){
            System.out.println("请检查是否输入路径");
            return null;
        }

        File file = new File(filePath);
        //路径错误和文件错误异常处理
        if(!file.exists()||!file.isFile()){
            try {
                throw new FileNotFoundException("请重新检查路径");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            finally {
                return null;
            }
        }

        StringBuilder content = new StringBuilder();
        try {
            FileInputStream   fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader  bufferedReader= new BufferedReader(inputStreamReader);
            String line;
            //逐行读取
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }
            // 关闭资源
            inputStreamReader.close();
            bufferedReader.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("读取文件时发生错误：" + e.getMessage());
        }
        System.out.println("读取该文件成功！");
        return content.toString();
    }

    /**
     * 写入文件
     * @param filePath
     * @param content
     * @throws Exception
     */
    public static void writeFile(String filePath, String content)  {
        //空路径或者空文本异常处理
        if(filePath.length()==0){
            System.out.println("请检查是否输入路径");
            return;
        }
        if(content.length()==0){
            System.out.println("请检查是否输入文本");
            return;
        }
        File file = new File(filePath);
        //路径异常处理
        if(!file.exists()){
            //创建父目录命名的文件
            file.getParentFile().mkdirs();
            try {
                //当且仅当具有该名称的文件尚不存在时，创建一个由该抽象路径名命名的新的空文件
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //文件错误异常处理
        if(!file.isFile()){
            System.out.println("路径："+filePath+" 写入文件失败");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("文件写入成功：" + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("写入文件时发生错误：" + e.getMessage());
        }
    }

}