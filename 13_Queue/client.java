public class client {
    public static void main(String[] args){
        queue que = new queue(6);
        for(int i=0; i<6; i++){
            que.push(i*10);
        }
        System.out.println(que.display());
    }
}
