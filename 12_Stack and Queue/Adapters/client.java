public class client {

    public static void main(String[] args){
    queueUsingStack_push que = new queueUsingStack_push();
    for(int i=1; i<=10; i++){
        que.push(i*10);
    }
    for(int i=0; i<5; i++){
        System.out.println(que.front());
        que.pop();
    }
    }
}
