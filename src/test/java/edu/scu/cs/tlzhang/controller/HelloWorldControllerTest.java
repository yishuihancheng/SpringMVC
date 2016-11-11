package edu.scu.cs.tlzhang.controller;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tlzhang on 16-11-11.
 */
public class HelloWorldControllerTest {
    @Test
    public void helloWorld() throws Exception {
        new HelloWorldController().helloWorld("Test");
    }

}