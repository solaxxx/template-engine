import com.rishiqing.schedule.LocalSchedule;
import pers.solax.generator.Generator;
import com.rishiqing.template.TestTemplate;

/**
 * Created by solax on 2017-3-25.
 */
public class Main {

    public  static void main (String [] args) {
/*        TestTemplate local =  new TestTemplate();
        Generator generator =  new Generator(local);
        generator.exec();*/
        LocalSchedule localSchedule =  new LocalSchedule();
        Generator generator = new Generator(localSchedule);
        generator.exec();
    }
}
