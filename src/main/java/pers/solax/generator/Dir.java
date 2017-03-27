package pers.solax.generator;

import java.io.File;

/**
 * Created by solax on 2017-3-25.
 */
public class Dir {
    /**
     * 生成一个文件夹
     * @param Path
     */
    public static void make (String Path) {
        File folder = new File (Path);
        if (!folder.exists() ||  !folder.isDirectory()) {
            folder.mkdir();
        }
    }
    public static  void main (String [] args) {
        Dir.make("E:\\test\\comeon");
    }
}
