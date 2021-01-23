import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        
        printSS(str,"");
    }

    public static void printSS(String qsf, String asf) {
        //base case
        if(qsf.length()==0){
            System.out.println(asf);
            return;
        }
        char ch = qsf.charAt(0);
        String next = qsf.substring(1);
        //if ch included
        printSS(next,asf+ch);
        //if ch not included
        printSS(next,asf);
    }

}