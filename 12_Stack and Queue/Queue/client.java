public class client {
    public static void main(String[] args) throws Exception {
        dynamicQueue que = new dynamicQueue(6);
        for (int i = 1; i <= 15; i++)
            que.push(i * 100);
        System.out.println(que);
        System.out.println(que.pop());
        System.out.println(que.pop());
        System.out.println(que.pop());
        System.out.println(que.front());
        System.out.println(que.pop());
        System.out.println(que.pop());
        System.out.println(que);
    }
}