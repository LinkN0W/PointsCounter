package org.example.logger;

import lombok.Getter;
import org.example.logger.entities.Logger;

import java.util.List;
import java.util.UUID;

@Getter
public class LoggerFunctional {

    private final LoggerService loggerService;


    public LoggerFunctional(){
        loggerService = new LoggerService();
    }


    public void addLogToTable(Logger logger){
        logger.setSessionId(UUID.randomUUID());
        loggerService.addLogger(logger);
    }

    public void addLogToTable(List<Logger> loggers){
        UUID sessionId = UUID.randomUUID();
        for(Logger logger : loggers) {
            logger.setSessionId(sessionId);
            loggerService.addLogger(logger);
        }
    }

}
