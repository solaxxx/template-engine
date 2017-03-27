package pers.solax.util;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by solax on 2017-3-1.
 */
public class Config {

    private static Properties properties;

    private static String rootPath;

    public static  String clusterName;

    public static String sever;

    public static int port;

    public static String username;

    public static String password;

    public static Boolean xPeck;

    public static String index;

    static {
        String configFile = "elasticsearch.properties";
        properties = loadProperties(rootPath != null ? (rootPath + "/" + configFile) : configFile);
        generateConfig();
    }

    private static void generateConfig () {
        Config.clusterName =    properties.getProperty("cluster.name");
        Config.sever       =    properties.getProperty("sever");
        Config.port        =    Integer.parseInt(properties.getProperty("port"));
        Config.username    =    properties.getProperty("username");
        Config.password    =    properties.getProperty("password");
        Config.xPeck       =    Boolean.parseBoolean(properties.getProperty("x-peck")) ;
        Config.index       =    properties.getProperty("index");
    }

    private  static Properties loadProperties (String path) {
        Properties config= new Properties();
        try {
            InputStream is =Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
            config .load(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return config;
    }

    public static void setRootPath (String path) {
        rootPath = path;
    }

    public static String getRootPath () {
        return  rootPath;
    }


}
