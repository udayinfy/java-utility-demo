package demo.dom4j.xo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUtil {

    public static void main(String[] args) {

        String fileUrl = FileUtil.class.getResource("/").getFile()
                + File.separator + "poi.xml";
        String encode = "GBK";
        String string = FileUtil.readToBuffer(fileUrl, encode);
        System.out.println(string);
    }

    /**
     * 本地目录,不存在创建
     */
    public static void mkDir(String dir) {
        File file = new File(dir);
        if (!file.isDirectory()) {
            file.mkdir();
        }
    }

    /**
     * 得到项目的bin目录
     * @return
     */
    public static String getBinPath(){
        String fileUrl = FileUtil.class.getResource("/").getFile();
        return fileUrl;
    }

    /**
     * 指定编码把文件读入字符串
     * @param file
     * @param encode
     * @return
     */
    public static String readToBuffer(File file, String encode) {

        StringBuilder buffer = new StringBuilder();
        String line = "";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), encode));
            line = reader.readLine();
            while (line != null) {
                buffer.append(line);
                buffer.append(System.getProperty("line.separator"));
                line = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return buffer.toString();
    }

    /**
     * 指定编码把文件读入字符串
     * @param fileUrl
     * @param encode
     * @return
     */
    public static String readToBuffer(String fileUrl, String encode) {

        StringBuilder buffer = new StringBuilder();
        String line = "";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(fileUrl), encode));
            line = reader.readLine();
            while (line != null) {
                buffer.append(line);
                buffer.append(System.getProperty("line.separator"));
                line = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return buffer.toString();
    }
}
