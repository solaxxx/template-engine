package pers.solax.collection;

import pers.solax.model.Files;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by solax on 2017-3-25.
 */
public class FileCollection {
    List<Files> filesList = new ArrayList<Files>();

    public void add (Files files) {
        filesList.add(files);
    }

    public List<Files> getFilesList() {
        return filesList;
    }

    public void setFilesList(List<Files> filesList) {
        this.filesList = filesList;
    }
}
