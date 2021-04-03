import java.io.*;
import java.util.*;

public class balancedBrackets {

    public static boolean balancedBrackets(String str){
        Stack<Character> st = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '[' || ch == '{' || ch == '('){
                st.push(ch);
                continue;
            }
            if(ch == ']' || ch == '}' || ch == ')'){
                if(st.size() == 0)
                    return false;
                else if((ch==']' && st.peek()!='[') || (ch=='}' && st.peek()!='{') || (ch==')' && st.peek()!='('))
                    return false;
                else
                    st.pop();    
            }        
        }
        if(st.size() != 0)
            return false;
        return true;
    }
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(balancedBrackets(str));
    }

}