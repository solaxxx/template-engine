package pers.solax.generator;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;

/**
 * Created by solax on 2017-3-25.
 */
public class Velocity {

    String template;

    String content;

    public  Velocity (String template) {
        this.template = template;
    }

    public  String  make (Map map) {
        Properties prop = new Properties();
        prop.setProperty(org.apache.velocity.app.Velocity.ENCODING_DEFAULT, "UTF-8");
        prop.setProperty(org.apache.velocity.app.Velocity.INPUT_ENCODING, "UTF-8");
        prop.setProperty(org.apache.velocity.app.Velocity.OUTPUT_ENCODING, "UTF-8");
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init(prop);
        Template t = ve.getTemplate(this.template);
        VelocityContext ctx = new VelocityContext();
        for (Object key : map.keySet()) {
            ctx.put(key.toString(), map.get(key));
        }
        StringWriter sw = new StringWriter();
        t.merge(ctx, sw);
        return sw.toString();
    }
}
