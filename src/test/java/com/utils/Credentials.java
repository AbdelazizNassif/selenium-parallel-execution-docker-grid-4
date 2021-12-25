package com.utils;

import java.util.Random;


public class Credentials {

    static Random rand = new Random(); //instance of random class
    static int upperbound = 3000000;
    protected static int int_random = rand.nextInt(upperbound);
    protected static String email = "dummy_ln" + int_random + "@email.com";
    protected static String password = "umtheking456";


}
