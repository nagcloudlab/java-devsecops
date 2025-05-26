package com.example;


class NPCI {

    static {
        /// One time initialization at class-level
        System.out.println("npci - static block..");
    }

    NPCI() {
        // One time intialization at object-level
        System.out.println("npci - constructor block..");
    }

}


public class StaticBlockExample {
    public static void main(String[] args) {

        System.out.println("im main");
        NPCI npciHyd = new NPCI();
        NPCI npciChennai = new NPCI();

    }
}
