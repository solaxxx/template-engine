package pers.solax.generator;

import java.io.File;
import java.io.PrintWriter;

/**
 * Created by solax on 2017-3-25.
 */
public class Document {
    /**
     * 生成文件
     * @param filePath
     * @param content
     */
    public static void make (String filePath, String content) {
        PrintWriter printWriter = null;
        File file = new File(filePath);
        System.out.println("staring create file ..." + filePath);
        try {
            if (file.exists()) {
                file.delete();
            }
            File fileParent = file.getParentFile();
            if (!fileParent.exists()) {
                fileParent.mkdirs();
            }
            file.createNewFile();
            printWriter = new PrintWriter(file);
        } catch ( Exception e) {
            e.printStackTrace();
        }
        printWriter.print(content);
        printWriter.close();
    }
}
