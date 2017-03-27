package pers.solax.template;

import pers.solax.collection.FileCollection;
import pers.solax.model.Files;

/**
 * Created by solax on 2017-3-25.
 */
public abstract class BaseTemplate {

    protected final static String FILE_TYPE_CONF = ".conf";

    protected final static String FILE_TYPE_BAT  = ".bat";

    protected final static String FILE_TYPE_SH   = ".sh";

    protected final static String VM_IMPORT_BAT1   = "import.bat1.vm";

    protected final static String VM_IMPORT_BAT2   = "import.bat2.vm";

    protected final static String VM_IMPORT_BAT3   = "import.bat3.vm";

    protected final static String VM_CONF   = "conf.vm";

    protected  FileCollection fileCollection = new FileCollection();

    public FileCollection getFileCollection() {
        return fileCollection;
    }

    public void setFileCollection(FileCollection fileCollection) {
        this.fileCollection = fileCollection;
    }
    public void addFile (String path, String content) {
        Files files = new Files(path, content);
        fileCollection.add(files);
    }
}
