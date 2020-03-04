package com.kc.mylearnings.springaop.business;

import com.kc.mylearnings.springaop.dao.Dao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Business2 {

    @Autowired
    Dao2 dao2;

    public String calculateSomething(){
        return dao2.retrieveSomething();
    }
}
