package recycle;

import java.util.ArrayList;
import java.util.Arrays;

public class Recycle {

public void printout(){

    ArrayList<String> listaElemenata = new ArrayList<>(Arrays.asList("link1", "link2", "link3", "link4", "alertCloseButton"));

    for (String objekat : listaElemenata) {
        System.out.println("private String" + " " + objekat + " " + "= \"\";");
    }
    for (String objekat : listaElemenata) {
        System.out.println("public WebElement get"+objekat+"(){ return findElement("+objekat+");}");
    }
}

}
