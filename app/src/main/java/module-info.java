module yuhnab {
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
    requires java.security.jgss;
    requires java.security.sasl;
    requires jdk.crypto.ec;
    requires jdk.crypto.cryptoki;
    requires java.net.http;

    exports ch.orthogonal.yuhnab;
    exports ch.orthogonal.yuhnab.config;
    exports ch.orthogonal.yuhnab.service;
    exports ch.orthogonal.yuhnab.parser;
    exports ch.orthogonal.yuhnab.client;
}