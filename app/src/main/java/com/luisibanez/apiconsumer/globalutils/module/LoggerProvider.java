package com.luisibanez.apiconsumer.globalutils.module;

import com.luisibanez.apiconsumer.globalutils.interfaces.Logger;

import javax.inject.Inject;


public class LoggerProvider {

    @Inject
    static Logger logger;

    public LoggerProvider() {

    }

    public static Logger getLogger() {
        return logger;
    }
}
