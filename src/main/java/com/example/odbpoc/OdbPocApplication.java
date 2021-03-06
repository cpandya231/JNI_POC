package com.example.odbpoc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.example.odbpoc.Constants.windoslibName;

@SpringBootApplication
public class OdbPocApplication {

    private native int AddStep(int numStep);

    public static void main(String[] args) {

        SpringApplication.run(OdbPocApplication.class, args);

        System.out.println("Loading " + windoslibName + " DLL");
        System.loadLibrary(windoslibName);
        System.out.println("DLL loaded successfully");

        //		new OdbPocApplication().AddStep(1);
    }



}
