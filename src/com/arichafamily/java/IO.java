package com.arichafamily.java;

import java.util.Scanner;

/**
 * Created by hackeru on 02/02/2017.
 */
public class IO {
    public static String getString(String message) {
        Scanner in = new Scanner(System.in);
        if (!message.endsWith(":") && !message.endsWith("?"))
            message += ":";
        System.out.println(message);
        return in.next();
    }

    public static int getInt(String message) {
        Scanner in = new Scanner(System.in);
        if (!message.endsWith(":") && !message.endsWith("?"))
            message += ":";
        System.out.println(message);
        return in.nextInt();
    }
}
