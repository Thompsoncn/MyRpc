package client;

import service.pojo.User;
import service.UserService;

public class RPCClient {
    public static void main(String[] args) {
//        try {
//            // 建立Socket连接
//            Socket socket = new Socket("127.0.0.1", 8899);
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
//            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
//            // 传给服务器id
//            objectOutputStream.writeInt(new Random().nextInt());
//            objectOutputStream.flush();
//            // 服务器查询数据，返回对应的对象
//            User user  = (User) objectInputStream.readObject();
//            System.out.println("服务端返回的User:"+user);
//
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//            System.out.println("客户端启动失败");
//        }
            ClientProxy clientProxy = new ClientProxy("127.0.0.1", 8899);
            UserService proxy = clientProxy.getProxy(UserService.class);

            // 服务的方法1
            User userByUserId = proxy.getUserByUserId(10);
            System.out.println("从服务端得到的user为：" + userByUserId);
            // 服务的方法2
            User user = User.builder().userName("张三").id(100).sex(true).build();
            Integer integer = proxy.insertUserId(user);
            System.out.println("向服务端插入数据："+integer);
    }
}