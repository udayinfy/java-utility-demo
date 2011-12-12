package utility.file;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileUtil {

    public static void main(String[] args) {
        try {
            //        String fileUrl = FileUtil.class.getResource("/").getFile()
            //                + File.separator + "1.1关键字检索abc.xml";
            //        System.out.println(fileUrl);
            //        String encode = "GBK";
            //        String string = FileUtil.readToBuffer(fileUrl, encode);
            //        System.out.println(string);
            //        String filePath = getFileUrl("POSDES");
            //        System.out.println(filePath);


            byte[] imageBytes = readImage();
            System.out.println(imageBytes.length);

        } catch (Exception ex) {
            Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * 把图片的二进制读入byte数组
     * @return
     * @throws IOException
     */
    public static byte[] readImage() throws IOException {
        byte[] retValue = null;
//        String imageUrl = System.getProperty("user.dir") + File.separator + "image" + File.separator + "image.png";
         String imageUrl = FileUtil.getBinPath() + File.separator + "image.png";
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File(imageUrl));
            retValue = new byte[fileInputStream.available()];
            fileInputStream.read(retValue);
        } finally {
            fileInputStream.close();
        }
        return retValue;
    }

    public static String getFileUrl(String config) {
        String fileUrl = "";

        Properties props = new Properties();
        try {
            InputStream inStream = new FileInputStream(FileUtil.getBinPath()
                    + "protocalMapping.properties");
            props.load(inStream);
        } catch (Exception ex) {
            Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        Set<Object> keySet = props.keySet();
        for (Object obj : keySet) {
            String key = (String) obj;
            if (config.equals(key)) {
                fileUrl = FileUtil.getBinPath() + props.getProperty(key);
            }
        }

        return fileUrl;
    }

    /**
     * 把图片的二进制读入byte数组
     * @return
     * @throws IOException
     */
    public static byte[] readImage2(String filePath) throws Exception {
		File tmpFile = new File(filePath);
		FileInputStream fin = new FileInputStream(tmpFile);
		DataInputStream is = null;
		byte[] btemp;
		try {
			is = new DataInputStream(fin);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			byte[] bufferByte = new byte[256];
			int l = -1;
			int downloadSize = 0;
			while ((l = is.read(bufferByte)) > -1) {
				downloadSize += l;
				out.write(bufferByte, 0, l);
				out.flush();
			}
			btemp = out.toByteArray();
			out.close();
		} catch (Exception ex) {
			throw ex;
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (Exception ex) {
			}
		}
		return btemp;
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
    public static String getBinPath() {
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
                if (reader != null) {
                    reader.close();
                }
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
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return buffer.toString();
    }
}
