public class client {
    public static void main(String args[]) throws Exception{
        stack st = new stack(5);
        for(int i=1;i<5;i++){
            st.push(i*10);
        }
        System.out.println(st.top());
        st.pop();
        st.display();
        System.out.println(st.size());
        dynamicStack dst = new dynamicStack(5);
        for(int i=0;i<8;i++){
            dst.push(i*10);
        }
        System.out.println(dst.top());
    }
}
