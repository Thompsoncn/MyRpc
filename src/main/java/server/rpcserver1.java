package server;

import commom.RPCRequest;
import commom.RPCResponse;
import service.impl.UserServiceImpl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class rpcserver1 {
    public static void main(String[] args) throws IOException {
        UserServiceImpl userService = new UserServiceImpl();
        ServerSocket serverSocket = new ServerSocket(8899);
        System.out.println("服务端启动了");
        // BIO的方式监听Socket
        while (true){
            Socket socket = serverSocket.accept();
            // 开启一个线程去处理
            new Thread(()->{
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                    // 读取客户端传过来的request
                    RPCRequest request = (RPCRequest)ois.readObject();
                    //反射调用对应方法
                    Method method = userService.getClass().getMethod(request.getMethodName(), request.getParamsTypes());
                    Object invoke = method.invoke(userService, request.getParams());
                    // 封装，写入response对象
                    oos.writeObject(RPCResponse.success(invoke));
                    oos.flush();
                } catch (IOException | ClassNotFoundException e){
                    e.printStackTrace();
                    System.out.println("从IO中读取数据错误");
                } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
