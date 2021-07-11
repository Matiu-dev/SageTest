package org.openjfx;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openjfx.service.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ServiceTests {

        private final static String PATH = System.getProperty("user.dir")+"\\src\\test\\java\\result\\";

        private Service service;

        @BeforeAll
        public void initialize(){
                service = new Service();
        }
//
//        @org.junit.Test
//        public void testGetData() {
//                fxmlController.getData();
//        }
//
        @Test
        void testSaveToFile() {
                assertEquals("OK", service.save(PATH, "example text", "file"));
        }
}
