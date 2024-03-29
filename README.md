本项目基于 Spring + Netty + Zookeeper + Protostuff 从零开始设计实现一个轻量级分布式 RPC 框架

你需要下面这些技术储备：
+ Java 基础
    + 动态代理机制
    + Java I/O 系统
    + 序列化机制以及序列化框架（Kryo ......）的基本使用
    + Java 网络编程（Socket 编程）
    + Java 并发/多线程
    + Java 反射
    + Java 注解
+ Netty 4.x：使 NIO 编程更加容易，屏蔽了 Java 底层的 NIO 细节

+ Zookeeper：提供服务注册与发现功能，开发分布式系统的必备选择，具备天生的集群能力

+ Spring：最强大的依赖注入框架，业界的权威标准
### 功能列表

------

+ 使用 Spring 提供依赖注入与参数配置
+  集成 Spring 通过注解注册服务
+  集成 Spring 通过注解消费服务
+  使用 Netty 进行网络传输
+  使用 Zookeeper（ZkClient 客户端）实现服务注册和发现

