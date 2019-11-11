iOS死开发硬转JAVA后台 入门到XX（1）

在和组里的后台大佬请教了入门 java 后台的初步学习路线后，我剩余不多的自由时间变成了 面朝JAVA，头发掉光的美（zi）好（nue）生活～

## 学习路线

大佬建议先从以下 3 点逐步学习：

* Java 基础语法
* spring boot基础知识
* 构建一个基础的web服务端

## Java 基础语法

大学选修浅显的听过Java，并没有实践过。用了2天时间，大概4个小时过了下基础语法。看的 [**菜鸟教程**](https://www.runoob.com/java/java-tutorial.html) 版本，也没有对比其他版本，应该都差不多。

## Spring Boot


整了本 **spring boot 实践**，配合 blibli 上随便找的的[**视频教程**](https://www.bilibili.com/video/av24683994?p=4)，想着趁周六周日2天时间把书和视频过一遍。 梦想宏大，现实残酷，用了快4个小时才把初始工程跑起来。。。

### 开发环境配置

#### 安装 Java 

* 安装 Java

```
$ java -version
java version "1.8.0_181"
Java(TM) SE Runtime Environment (build 1.8.0_181-b13)
Java HotSpot(TM) 64-Bit Server VM (build 25.181-b13, mixed mode)
$ which java
/Library/Java/JavaVirtualMachines/jdk1.8.0_181.jdk/Contents/Home/bin/java
```

* 配置 Java 环境变量

```
$ open ~/.bash_profile 

// 打开 profile文件 插入以下代码
# JAVA
JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_181.jdk/Contents/Home
PATH=$JAVA_HOME/bin:$PATH:.
CLASSPATH=$JAVA_HOME/lib/tools.jar:$JAVA_HOME/lib/dt.jar:.
export JAVA_HOME
export PATH
export CLASSPATH

// 立即生效并确认
$ source ~/.bash_profile
$ echo $JAVA_HOME
/Library/Java/JavaVirtualMachines/jdk1.8.0_181.jdk/Contents/Home
```

#### 安装 Maven

* [官网](http://maven.apache.org/download.cgi) 下载 **apache-maven-3.6.2-bin.zip**

* 解压到 **/usr/local/Cellar/maven3.6.2/** 
* 配置环境变量

```
$ open ~/.bash_profile 

// 打开 profile文件 插入以下代码
# Maven
export M2_HOME=/usr/local/Cellar/maven3.6.2
export PATH=$PATH:$M2_HOME/bin

// 立即生效并确认
$ source ~/.bash_profile
$ echo $M2_HOME
/usr/local/Cellar/maven3.6.2
```
* 更改设置，配置 mirror，proxy，profile

```
$ open /usr/local/Cellar/maven3.6.2/conf/setting.xml

// 插入以下 mirror，可以配置多个mirror
<mirror>
    <id>alimaven</id>
    <mirrorOf>central</mirrorOf>
    <name>aliyun maven</name>
    <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
</mirror>

// 如果配置多个mirror，想自由切换，可以配置profile
<profile>
        <id>alimaven</id>
        <repositories>
            <repository>
                <id>ali-central</id>
                <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
            </repository>
        </repositories>
</profile>

// 默认激活策略
<activeProfiles>
    <activeProfile>internal</activeProfile>
</activeProfiles>


// 配置代理，以下为模版，需自定义
<proxy>
      <id>optional</id>
      <active>true</active>
      <protocol>http</protocol>
      <username>proxyuser</username>
      <password>proxypass</password>
      <host>proxy.host.net</host>
      <port>80</port>
      <nonProxyHosts>local.net|some.host.com</nonProxyHosts>
</proxy>
```

#### 配置 IDEA

* **配置代理** Preferences -> Search Proxy 
* **配置 Maven** Preferences -> Search Maven
* 修改 **Maven home directory** 为 /usr/local/Cellar/maven3.6.2/
* 修改 **User Settings file** 为 /usr/local/Cellar/maven3.6.2/conf/setting.xml
* 勾选 **import** 的 import maven projects automatically

### 构建第一个 spring boot 程序

* 图一 创建工程 
![图一 创建工程](https://raw.githubusercontent.com/melody5417/JAVA/master/JAVA_1/图一.png)

Create new project -> Spring Initializr -> Default (https://start.spring.io) -> Next

* 图二 填写工程信息
![图二 填写工程信息](https://raw.githubusercontent.com/melody5417/JAVA/master/JAVA_1/图二.png)

* 图三 选择工程依赖
![图三 选择工程依赖](https://raw.githubusercontent.com/melody5417/JAVA/master/JAVA_1/图三.png)

Web -> Spring Web

* 图四 确定工程信息
![图四 确定工程信息](https://raw.githubusercontent.com/melody5417/JAVA/master/JAVA_1/图四.png)

* 图五 设置 maven 自动 import
![图五 设置 maven 自动 import](https://raw.githubusercontent.com/melody5417/JAVA/master/JAVA_1/图五.png)

* 图六 工程预览
![图六 工程预览](https://raw.githubusercontent.com/melody5417/JAVA/master/JAVA_1/图六.png)

* 图七 sync 下载依赖
![图七 sync 下载依赖](https://raw.githubusercontent.com/melody5417/JAVA/master/JAVA_1/图七.png)

此时如果 Build 信息栏显示正在 Sync，恭喜你，代理配置成功，IDEA 自动下载依赖包。
如果自动下载失败，可以在当前目录下运行 ```mvn install```可以手动安装依赖。

## 总结

国内的网真的是开发最大的拦路虎啊！！！

## 参考
https://blog.csdn.net/fenglailea/article/details/53304479#t6









