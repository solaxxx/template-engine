package com.rishiqing.bean.LogStash.input;

/**
 * Created by solax on 2017-3-25.
 */
public class Jdbc {
    final static String JDBC_DRIVER_LIBRARY     = "import/mysql-connector-java-5.1.39.jar";
    final static String JDBC_DRIVER_CLASS     = "com.mysql.jdbc.Driver";
    final static String JDBC_URL        = "jdbc:mysql://localhost:3306/es-test";
    final static String JDBC_PAGE_SIZE  = "50000";
    final static String JDBC_PAGING_ENABLED ="true";
    final static String JDBC_USER = "root";
    final static String JDBC_PASSWORD = "admin";

    String jdbc_driver_library;

    String jdbc_driver_class;

    String jdbc_connection_string;

    String jdbc_user;

    String jdbc_password;

    String jdbc_page_size;

    String jdbc_paging_enabled;

    String statement;

    public Jdbc () {
        this.setJdbc_driver_library(JDBC_DRIVER_LIBRARY);
        this.setJdbc_driver_class(JDBC_DRIVER_CLASS);
        this.setJdbc_connection_string(JDBC_URL);
        this.setJdbc_user(JDBC_USER);
        this.setJdbc_password(JDBC_PASSWORD);
        this.setJdbc_page_size(JDBC_PAGE_SIZE);
        this.setJdbc_paging_enabled(JDBC_PAGING_ENABLED);
    }

    public String getJdbc_driver_library() {
        if (jdbc_driver_library == null) return JDBC_DRIVER_LIBRARY;
        return jdbc_driver_library;
    }

    public void setJdbc_driver_library(String jdbc_driver_library) {
        this.jdbc_driver_library = jdbc_driver_library;
    }

    public String getJdbc_driver_class() {
        if (jdbc_driver_class == null) return JDBC_DRIVER_CLASS;
        return jdbc_driver_class;
    }

    public void setJdbc_driver_class(String jdbc_driver_class) {
        this.jdbc_driver_class = jdbc_driver_class;
    }

    public String getJdbc_connection_string() {
        if (jdbc_connection_string == null) return JDBC_URL;
        return jdbc_connection_string;
    }

    public void setJdbc_connection_string(String jdbc_connection_string) {
        this.jdbc_connection_string = jdbc_connection_string;
    }

    public String getJdbc_user() {
        if (jdbc_user == null) return  JDBC_USER;
        return jdbc_user;
    }

    public void setJdbc_user(String jdbc_user) {
        this.jdbc_user = jdbc_user;
    }

    public String getJdbc_password() {
        if (jdbc_password ==  null) return  JDBC_PASSWORD;
        return jdbc_password;
    }

    public void setJdbc_password(String jdbc_password) {
        this.jdbc_password = jdbc_password;
    }

    public String getJdbc_page_size() {
        if (jdbc_page_size == null) return JDBC_PAGE_SIZE;
        return jdbc_page_size;
    }

    public void setJdbc_page_size(String jdbc_page_size) {
        this.jdbc_page_size = jdbc_page_size;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getJdbc_paging_enabled() {
        if (jdbc_paging_enabled ==  null) return  JDBC_PAGING_ENABLED;
        return jdbc_paging_enabled;
    }

    public void setJdbc_paging_enabled(String jdbc_paging_enabled) {
        this.jdbc_paging_enabled = jdbc_paging_enabled;
    }
}
