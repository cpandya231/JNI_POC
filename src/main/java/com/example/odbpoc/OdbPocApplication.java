package com.example.odbpoc;


import com.sun.jna.Structure;
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
        String text = "P 1.52 0.56 1 P 0 8 0;1=0,2=1;ID=96";
         ODBToJsonConverter.convertFeaturesToJson(text);
        //		new OdbPocApplication().AddStep(1);
    }



}
