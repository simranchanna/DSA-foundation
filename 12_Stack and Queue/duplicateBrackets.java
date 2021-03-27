import java.io.*;
import java.util.*;

public class Main {
    public static boolean duplicateBrackets(String str){
        Stack<Character> st = new Stack<>();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) != ')'){
                st.push(str.charAt(i));
                continue;
            }
            boolean flag = false;
            while(st.size() != 0 && st.peek() != '('){
                flag = true;
                st.pop();
            }
            if(!flag)
                return true;
            st.pop();    
        }
        return false;
    }
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(duplicateBrackets(str));
    }

}