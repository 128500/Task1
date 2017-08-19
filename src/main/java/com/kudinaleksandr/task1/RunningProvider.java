package com.kudinaleksandr.task1;

import java.awt.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.*;

/**
 * Created by KUDIN ALEKSANDR on 14.08.2017.
 */
public class RunningProvider {

    private static Logger log = Logger.getLogger(RunningProvider.class.getName());

    public static void main(String[] args) {

       if(System.getProperty("java.util.logging.config.class") == null &&
              System.getProperty("java.logging.config.file") == null) {
            try {
                Logger.getLogger("").setLevel(Level.INFO);
                final int LOG_ROTATION_COUNT = 10;
                Handler handler = new FileHandler("%h/task1.log", 0, LOG_ROTATION_COUNT);
                Logger.getLogger("").addHandler(handler);
            } catch (IOException ex) {
                log.log(Level.SEVERE, "Couldn't create log file handler", ex);
            }
       }

        MessageProvider mp = new MessageProvider();
        MyControl control = new MyControl();

        Locale locale = Locale.getDefault();

        int hour = LocalDateTime.now().getHour();

        ResourceBundle currentLocale = ResourceBundle.getBundle("bundles.GreetingBundle", locale, control);

        String message = mp.getMessage(currentLocale, hour);

        EventQueue.invokeLater(() -> new FrameProvider(null, message));
    }
}
