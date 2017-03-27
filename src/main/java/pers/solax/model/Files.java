package pers.solax.model;

/**
 * Created by solax on 2017-3-25.
 */
public class Files {
    // 路径及文件名
    String path;
    // 内容
    String content;

    public Files () {}

    public Files(String path, String content) {
        this.path = path;
        this.content = content;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
