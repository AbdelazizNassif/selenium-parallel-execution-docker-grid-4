package com.utils;

import java.util.Random;


public class CommonData {

    static Random rand = new Random(); //instance of random class
    static int upperbound = 3000000;
    protected static int int_random = rand.nextInt(upperbound);
    protected static String email = "dummy_ln" + int_random + "@email.com";
    protected static String password = "P@ssw0rd456";
    protected static String localSeleniumGridUrl = "http://localhost:4444";
    private String gridUrl = "http://localhost:4444/wd/hub" ;


}
