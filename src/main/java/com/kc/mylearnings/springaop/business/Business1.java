package com.kc.mylearnings.springaop.business;

import com.kc.mylearnings.springaop.aspect.TrackTime;
import com.kc.mylearnings.springaop.dao.Dao1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Business1 {
    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    Dao1 dao1;

    public String calculateSomething(){
        return dao1.retrieveSomething();
    }
}
