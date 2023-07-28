package com.yc;

import org.ycframework.context.YcAnnotationConfigApplicationContext;
import org.ycframework.context.YcApplicationContext;

public class Test01 {
    public static void main(String[] args) {
//        Logger logger = LoggerFactory.getLogger(Test01.class);
//        logger.error("error");
//        logger.warn("warn");
//        logger.info("info");
//        logger.debug("debug");
//        logger.trace("trace");

        YcApplicationContext ac = new YcAnnotationConfigApplicationContext(MyConfig.class);

    }
}
