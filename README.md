# Java登录注册界面

#### 介绍
这是自己编写的Java课设，很水，屎山代码属于是

#### 软件架构
这是由Java Swing框架开发的一个GUI界面。非常简单，有登录，注册界面，修改密码，密码加密等功能。

#### 开发环境
系统：Windows10 22H2专业版<br />
开发工具：IntelliJ IDEA Community 2023.2<br />
JDK版本：20.0.2<br />

#### Tips：
有默认用户名，在UserData这个类里，登录是和UserData这个类里面的用户名和密码进行对比的，可以进行修改。
然后注册时是修改，UserData这个类的用户和密码的变量。<br />
默认用户名：demo <br/>
默认密码：demo <br/>
现在UserData保存的密码是经过哈希加密后的密码，同时也保存有盐值。

