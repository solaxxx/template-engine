package pers.solax.util;

import java.io.*;

/**
 * Created by solax on 2017-3-27.
 */
public class FileUtil {
    public  static void main (String [] args) {
        FileUtil.copy("D:\\ideaGitWorkSpace3\\template-engine\\src\\main\\resources\\mysql-connector-java-5.1.39.jar", "E:\\test\\comeon\\mysql-connector-java-5.1.39.jar");
    }
    /**
     * 复制
     * @param from
     * @param to
     */
    public static void copy (String from, String to) {
        File fileFrom = new File (from);
        File fileTo   = new File (to);
        InputStream inputStream = null;
        OutputStream  outputStream = null;
        try {
            if (!fileFrom.exists())  throw  new Exception("copy source file not found");
            inputStream = new FileInputStream(fileFrom);
            outputStream = new FileOutputStream(fileTo);
            byte[] buffer = new byte[1024];
            int byteRead = 0; // 读取的字节数
            while ((byteRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, byteRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) outputStream.close();
                if (inputStream !=null ) inputStream.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}
