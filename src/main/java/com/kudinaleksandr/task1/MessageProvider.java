package com.kudinaleksandr.task1;

import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * Created by KUDIN ALEKSANDR on 14.08.2017.
 */
public class MessageProvider {
    private static Logger log = Logger.getLogger(MessageProvider.class.getName());

    public String getMessage(ResourceBundle bundle, int hour){
        String greeting = "";
        if (6 <= hour && hour < 9)greeting = bundle.getString("good.morning");
        if (9 <= hour && hour < 19)greeting = bundle.getString("good.day");
        if (19 <= hour && hour < 23)greeting = bundle.getString("good.evening");
        if ((0 <= hour &&  hour < 6) || hour == 23)greeting = bundle.getString("good.night");

        return greeting;
    }
}
