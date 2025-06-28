module csvmonitor {
    requires java.base;
    requires org.apache.logging.log4j;
    requires org.apache.logging.log4j.core;
    requires java.management;
    requires org.apache.commons.csv;
    requires java.xml;

    exports com.example.csvmonitor;
}