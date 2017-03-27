package pers.solax.schedule;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by solax on 2017-3-27.
 */
public abstract class BaseSchedule {

    protected  Map<String, Map> schedule = new HashMap();

    protected final static String FILE_TYPE_CONF = ".conf";

    protected final static String FILE_TYPE_BAT  = ".bat";

    protected final static String FILE_TYPE_SH   = ".sh";

    protected final static String VM_IMPORT_BAT1   = "import.bat1.vm";

    protected final static String VM_IMPORT_BAT2   = "import.bat2.vm";

    protected final static String VM_IMPORT_BAT3   = "import.bat3.vm";

    protected final static String VM_CONF   = "conf.vm";

    protected final static String VM_MAPPING  = "mapping.bat.vm";

    public BaseSchedule () {
        this.schedule();
    }

    protected  abstract void schedule ();

    public Map getSchedule() {
        return schedule;
    }

    public void setSchedule(Map schedule) {
        this.schedule = schedule;
    }
}
