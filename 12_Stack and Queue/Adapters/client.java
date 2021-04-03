public class client {

    public static void main(String[] args){
    // queueUsingStack_push que = new queueUsingStack_push();
    // for(int i=1; i<=10; i++){
    //     que.add(i*10);
    // }
    // for(int i=0; i<5; i++){
    //     System.out.println(que.peek());
    //     que.remove();
    // }
    // }
    // queueUsingStack_pop que = new queueUsingStack_pop();
    // for(int i=1; i<=10; i++){
    //     que.add(i*10);
    // }
    // for(int i=0; i<5; i++){
    //     System.out.println(que.peek());
    //     que.remove();
    // }
    // stackUsingQueue_push st = new stackUsingQueue_push();
    // for(int i=1; i<10; i++){
    //     st.push(i*10);
    // }
    // for(int i=0; i<5; i++){
    //     System.out.println(st.peek());
    //     st.pop();
    // }
    stackUsingQueue_pop st = new stackUsingQueue_pop();
    for(int i=1; i<10; i++){
        st.push(i*10);
    }
    System.out.println(st.size());
    for(int i=0; i<5; i++){
        System.out.println(st.peek());
        st.pop();
    }

    }
}
