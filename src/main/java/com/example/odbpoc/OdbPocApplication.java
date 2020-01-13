package com.example.odbpoc;


import com.sun.jna.Structure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.example.odbpoc.Constants.windoslibName;

@SpringBootApplication
public class OdbPocApplication {

    private native int AddStep(int numStep);

    /*static {
        System.loadLibrary(windoslibName);
    }*/
    public static void main(String[] args) {

        SpringApplication.run(OdbPocApplication.class, args);
        System.out.println("Before calling dll");
        System.loadLibrary("ODBIF.win64.opt.CCZExport");
		System.out.println("dll loaded successfully");
//		getSystemTimeUsingNativeLib();
		new OdbPocApplication().AddStep(1);

    }

    private static void getSystemTimeUsingNativeLib() {
        simpleDLL sdll = simpleDLL.INSTANCE;
        SYSTEMTIME time = new SYSTEMTIME();
        //	sdll.GetSystemTime(time);
        System.out.println("After calling dll " + time.wDayOfWeek);
    }


    @Structure.FieldOrder({"wYear", "wMonth", "wDayOfWeek", "wDay", "wHour", "wMinute", "wSecond", "wMilliseconds"})
    public static class SYSTEMTIME extends Structure {
        public short wYear;
        public short wMonth;
        public short wDayOfWeek;
        public short wDay;
        public short wHour;
        public short wMinute;
        public short wSecond;
        public short wMilliseconds;
    }
}
