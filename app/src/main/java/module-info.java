module csvmonitor {
    requires java.base;
    requires org.apache.logging.log4j;
    requires org.apache.logging.log4j.core;
    requires java.management;
    requires org.apache.commons.csv;
    requires java.xml;
    requires com.google.common;
    requires okhttp3;
    requires com.google.gson;
    requires kotlin.stdlib;

    exports com.example.csvmonitor;
}