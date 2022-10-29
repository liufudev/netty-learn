package org.lf.learn;


import ch.qos.logback.classic.util.ContextInitializer;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class Main {
    public static void main(String[] args) {
        System.setProperty(ContextInitializer.AUTOCONFIG_FILE, "/path/to/config.xml");
        log.info("main param is [args] ");
    }
}