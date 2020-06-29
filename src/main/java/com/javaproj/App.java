package com.javaproj;

public class App extends init {


    public interface klasapoli1 {
        void doSomething();
    }
    public static class klasapoli2 implements klasapoli1 {
        public void doSomething(){
            System.out.println("polimorfizm, dziala chyba");
        }
    }

    public static void main(String[] args) {
        try {
            create_gui();
            klasapoli1 asd = new klasapoli2();
            asd.doSomething();
        }
        catch (Exception e) {
            System.out.println("GUI went wrong.");
        }


    }
}