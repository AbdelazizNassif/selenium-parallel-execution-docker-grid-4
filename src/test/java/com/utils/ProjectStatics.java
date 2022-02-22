package com.utils;

import java.util.Random;

public class ProjectStatics {


    static Random rand = new Random(); //instance of random class
    static int upperbound = 3000000;
    protected static int int_random = rand.nextInt(upperbound);
    public static String fName = "dummy_user fn";
    public static String lName = "dummy_user ln";
    public static String email = "dummy_user" + int_random + "@email.com";
    public static String password = "P@ssw0rd456";
    public static String localSeleniumGridUrl = "http://localhost:4444/wd/hub";
    public static String dockerHubUrl = "http://localhost:4445/wd/hub" ;
    public static final String HOME_URL = "https://demo.nopcommerce.com/" ;


}
