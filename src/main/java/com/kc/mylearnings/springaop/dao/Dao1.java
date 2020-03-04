package com.kc.mylearnings.springaop.dao;

import com.kc.mylearnings.springaop.aspect.TrackTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {

    Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @TrackTime
    public String retrieveSomething(){
        LOGGER.info("Returning Dao1");
        return "Dao1";
    }
}