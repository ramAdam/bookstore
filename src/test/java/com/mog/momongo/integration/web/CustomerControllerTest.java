package com.mog.momongo.integration.web;

import static org.junit.Assert.assertNotNull;

import com.mog.momongo.BaseTest;
import com.mog.momongo.controller.CustomerController;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;



public class CustomerControllerTest extends BaseTest{

    @Autowired
    private CustomerController controller;
   
    @Before
    public void setUp(){

    }


    @Test
    public void customerControllerTest(){
        assertNotNull(controller);
    }
    
}