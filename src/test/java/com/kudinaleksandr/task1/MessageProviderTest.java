package com.kudinaleksandr.task1;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.Assert.*;

/**
 * Created by homeuser on 17.08.2017.
 */
public class MessageProviderTest {

    private static final Locale locale = new Locale("ru", "RU");
    private static final Locale enLocale = new Locale("en", "US");
    private static final MyControl control = new MyControl();
    private static ResourceBundle  rb = ResourceBundle.getBundle("bundles.GreetingBundle", locale, control);
    private static ResourceBundle  enRB = ResourceBundle.getBundle("bundles.GreetingBundle", enLocale, control);
    private final static MessageProvider MP = new MessageProvider();


    @Test
    public void getMorningMessage() throws Exception {
        int[] morningHours = new int[]{6, 7, 8};
        for (int i : morningHours){
            assertEquals("Доброе утро, Мир!", MP.getMessage(rb, i));
            assertEquals("Good morning, World!", MP.getMessage(enRB, i));
        }
    }

    @Test
    public void getDayMessage() throws Exception {
        int[] morningHours = new int[]{9, 10, 11, 12, 13, 14, 15, 16, 17, 18};

        for (int i : morningHours){
            assertEquals("Добрый день, Мир!", MP.getMessage(rb, i));
            assertEquals("Good day, World!", MP.getMessage(enRB, i));
        }
    }

    @Test
    public void getEveningMessage() throws Exception {
        int[] morningHours = new int[]{19, 20, 21, 22};

        for (int i : morningHours){
            assertEquals("Добрый вечер, Мир!", MP.getMessage(rb, i));
            assertEquals("Good evening, World!", MP.getMessage(enRB, i));
        }
    }

    @Test
    public void getNightMessage() throws Exception {
        int[] morningHours = new int[]{23, 0, 1, 2, 3, 4, 5};

        for (int i : morningHours){
            assertEquals("Доброй ночи, Мир!", MP.getMessage(rb, i));
            assertEquals("Good night, World!", MP.getMessage(enRB, i));
        }
    }
}