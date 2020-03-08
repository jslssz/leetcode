### Java基础

#### 网络

1、以下关于TCP和UDP说法正确的是（B）

```
 A   TCP数据传输慢，UDP数据传输快
 B   TCP通过滑动窗口机制进行拥塞控制         //tcp 的滑动窗口进行[流量]控制
 C   UDP缓冲区小于报文长度，则会丢失报文
 D   DNS协议用于域名解析，默认53端口
```

拥塞控制与流量控制的区别 :

拥塞控制是防止过多的数据注入到网络中，可以使网络中的路由器或链路不致过载，是一个全局性的过程。

流量控制是点对点通信量的控制，是一个端到端的问题，主要就是【抑制发送端】发送数据的速率，以便接收端来得及接收。

2、IPV4中，数据包传播方式包括以下的(  C  )

```
A.广播
B.单播
C.任播   //任播是IPV6加入的新技术。
D.组播
```

3、各层所使用的协议

![](../../image/网络对应的协议.png)

 `TCP/IP模型中，ARP协议属于网络层，在OSI参考模型中，ARP属于数据链路层 `   所以选的是VPN是

4、 以下哪些可以用于进程间通信（） 

```
套接字、信号量、消息队列、共享内存
```

5、 总部给某分公司分配的网络地址是172.16.2.0/24,该分公司有三个部门，每个部门计算机不多于30台,在网络配置时，进行子网划分，可以使用的子网掩码是（） 

```
A    255.255.255.128
B    255.255.255.192
C    255.255.255.224
D    255.255.255.240
```

```
1.分公司的网络地址是172.16.2.0/24，子网掩码长度就是24位11111111.11111111.11111111.00000000
2.分公司3个部门，那么就用第25位和第26位来区分三个部门，11111111.11111111.11111111.**00**000000（00~11），直接排除A；
3.那么各个部门用来区分自己的子网掩码只剩下最后6位（27~32位）来表示了
4.若用255.255.255.192，最后8位是11000000，只能表示11000000~11111111除去广播地址一共62台
5.若用255.255.255.224，最后8位是11100000，只能表示11100000~11111111除去广播地址一共30台
6.若用255.255.255.240，最后8位是11110000，只能表示11110000~11111111除去广播地址一共14台,小于30不可以
```

7、 TCP 三次握手的过程，accept 发生在三次握手哪个阶段？  D

```
A.第一次握手
B.第二次握手
C.第三次握手
D.三次握手后
```

```
第一次握手：客户端发送syn包(syn=j)到服务器。 
第二次握手：服务器收到syn包，必须确认客户的SYN（ack=j+1），同时自己也发送一个ASK包（ask=k）。 
第三次握手：客户端收到服务器的SYN＋ACK包，向服务器发送确认包ACK(ack=k+1)。 
三次握手完成后，客户端和服务器就建立了tcp连接。这时可以调用accept函数获得此连接
```





#### 计算机原理

1、计算机是由硬件、操作系统和软件组成，操作系统是缺一不可的组成部分。  这句话是错的：

```
百科：计算机由硬件系统和软件系统组成，没有安装任何软件的计算机称为裸机。
```

2、假设磁头当前位于第99道，正在向磁道序号增加的方向移动。现有一个磁道访问请求序列为33，59，13，77，123，170，160，185，===========>小到大，大到小

采用SCAN调度(电梯调度)算法得到的磁道访问序列是(    )

```
123，160，170，185，77，59，33，13
```

3、进程获得处理机而运行是通过~~申请~~而得到的   X    调度

​     磁盘上物理结构为链接结构的文件只能顺序存取；   √

4、下列`不是`进程间的通信方式的是（“回调”）， 是一种编程机制

5、 以下哪种方式，在读取磁盘上多个顺序数据块时的效率最高？    通道方式

6、测得某个采用按需调页策略的计算机系统部分状态数据为：CPU利用率5%，用于交换空间的磁盘利用率95%，其他I/O设备利用率5%。试问，这种情况下（  AC ）能提高CPU的利用率。

```
A.增大内存的容量
B.增大磁盘交换区的容量
C.减少多道程序的度数
D.使用更快速的磁盘交换区
```

解释：

```
CPU利用率5%，用于交换空间的磁盘利用率95%，其他I/O设备利用率5%。
CPU利用率：运行的程序占用的CPU资源，表示机器在某个时间点的运行程序的情况。[使用率](**](https://baike.so.com/doc/5382543-5618902.html)**)越高，说明机器在这个时间上运行了很多程序，反之较少。
CPU是负责运算和处理的，内存是交换数据的。
1.可以看出CPU利用率低；
CPU一次读取的太多的程序放入内存中，因此需要降低多道程序的度数
2.交换空间的磁盘利用率高（增大内存的容量）
3.I/O设备利用率低（减少多道程序的度数）
交换空间利用率高，因此需要扩大数据交换空间（增大内存的容量）
```

7、 以下哪种方式不被用来解耦？ B

```
A.delegate
B.mutex
C.NotificationCenter
D.block
```

解释:

```
delegate: 可以映射成***模式, 可以解耦
mutex: synchronized 的底层应用, 好像和解耦没啥关系
NotificationCenter: 可以映射成发布/订阅模式, 可以实现订阅者和发布者间的解耦
block: 不知道是该翻译成块呢? 还是阻塞呢? 这俩都想不到和解耦有什么关系
```





#### 基本概念

1、构造方法不带返回值，而普通方法是必须有返回值的，这就是区别他们的方法。例如下面的代码是可以编译通过的：即可以存在于构造方法同名的普通方法

2、It is an important feature of the Java language that it always provides a default constructor to a class.

题目翻译过来就是：总是为一个类提供了一个默认的构造函数是Java语言的一个重要特性 。

事实上只有在我们没有显示声明任何构造方法时java才会为我们提供一个默认的无参构造函数。所以是false

3、引用变量被final修饰之后，不能再指向其他对象，它指向的对象的内容也是不可变的。  X内容是可变的

```
finalize是Object类的一个方法，在垃圾收集器执行的时候会调用被回收对象的此方法  X
这个方法一个对象只能执行一次，只能在第一次进入被回收的队列，而且对象所属于的类重写了finalize方法才会被执行。第二次进入回收队列的时候，不会再执行其finalize方法，而是直接被二次标记，在下一次GC的时候被GC。
```

4、构造内部类对象：

```
InsideOne ei=eo.new InsideOne();
EnclosingOne.InsideOne ei=eo.new InsideOne();
```

5、形式参数可被视为`local variable`就是形参的意思

6、Java赋值符号

```
<<表示左移位
>>表示带符号右移位
>>>表示无符号右移
没有<<<运算符
```

7、This调用语句必须是构造函数中的第一个可执行语句。    X   构造方法this()才要在第一行

8、 下面哪些可能是重载的基本条件（） 参数类型不同、参数顺序不同、参数个数不同

9、Java关键的官方描述`true, false, and null`不是关键字` const and goto `是保留字

```
Here is a list of keywords in the Java programming language. You cannot use any of the following as identifiers in your programs. The keywords const and goto are reserved, even though they are not currently used. true, false, and null might seem like keywords, but they are actually literals; you cannot use them as identifiers in your programs.

abstract	continue	for	new	switch
assert***	default	goto*	package	synchronized
boolean	do	if	private	this
break	double	implements	protected	throw
byte	else	import	public	throws
case	enum****	instanceof	return	transient
catch	extends	int	short	try
char	final	interface	static	void
class	finally	long	strictfp**	volatile
const*	float	native	super	while
```

10、 以下声明合法的是   B

```
A、default  String  s   #错误，不可以用default来修饰变量
B、public  final  static  native  int  w( )   #native可以用修饰任何变量，不能与abstract连用
C、abstract  double  d	#abstract只能用来修饰方法和类
D、abstract  final  double  hyperbolicCosine( )  #错误
```

11、一个空栈，如果有顺序输入：a1，a2，a3...an（个数大于3），而且输出第一个为an-1,那么所有都出栈后，（D） 

```
A、输出的最后元素一定为an
B、输出的最后元素一定为a1
C、不能确定元素a1~an-2在输出顺序
D、an-2一定比an-3先出
```

解释：既然an-1先出栈，说明 an-2, an-3已经入栈并且还未出栈，所以D肯定是对的，B的话an始终不进栈，a1~an-2都出栈了以后再进栈，这时候弹出的是an为最后一个。

12、Json的正确格式 B,D,E

```
A.{company：4399}
B.{"company":{"name":[4399,4399,4399]}}
C.{[4399,4399,4399]}
D.{"company":[4399,4399,4399]}
E.{"company":{"name":4399}}
```

13、权限修饰符

![](../../image/Java权限修饰2.jfif)



14、 在java7中，下列不能做switch( C )的参数类型是？ 

```
A.int型
B.枚举类型
C.字符串    // JDK1.8后引入的
D.浮点型
```

15、 java 语言使用的字符码集是   Unicode

16、 Java程序的种类有： 

```
1、内嵌于Web文件中，由浏览器来观看的Applet   
2、可独立运行的 Application 
3、服务器端的 Servlets 
```

17、 下面的Java赋值语句哪些是有错误的 （2,6） 

```
int i =1000;
float f = 45.0;
char s = ‘\u0639’
Object o = ‘f’;
String s = "hello,world\0";
Double d = 100;   // cannot convert from int to Double”。
```

18、 循环优化：死代码删除，代码外提，强度削弱，删除归纳变量，复写传播 

19、 局部变量能否和成员变量重名？     //可以，局部变量可以与成员变量重名，这时可用“this”来指向成员变量

20、 由3 个“1”和 5 个“0”组成的 8 位二进制补码，能表示的最小整数（B） 

```
-126
-125
-32
-3
```

```
基本概念: 1.正数的原码、反码、补码都相同； 2.负数的原码：最高位为1，其余位为真值的绝对值； 3.负数的反码：在原码的基础上，符号位不变，其余位按位取反； 4.负数的补码：在原码的基础上，符号位不变，其余位取反，最后加1；也就是在反码的基础上加1。 负数的补码向源码转换步骤 1. -12的补码：1111 0100 2. 最高位不变，其余位取反：1000 1011 3. 加一得到原码：1000 1100 思路分析: 1. 求最小的值，那么肯定是负数最小，最高位为1表示为负数 2. 剩下的5个0和2个1要组成一个补码，只有1000 0011这种补码形式转换成原码后值最大 操作步骤 1. 最高位不变，其余位去反 1111 1100 2.加1 1111 1101 计算后得到-（64+32+16+8+4+1）＝-125
```

21、 对于子类的构造函数说明，下列叙述中错误的是（   ）。 

```
A.子类可以继承父类的构造函数。   //说法错误 应该是隐式调用
B.子类中调用父类构造函数不可以直接书写父类构造函数，而应该用super();。
C.用new创建子类的对象时，若子类没有带参构造函数，将先执行父类的无参构造函数，然后再执行自己的构造函数。
D.子类的构造函数中可以调用其他函数。
```



#### 接口&抽象类

1、关于抽象类和接口叙述正确的是？ (D )

```
A.抽象类和接口都能实例化的
B.抽象类不能实现接口
C.抽象类方法的访问权限默认都是public
D.接口方法的访问权限默认都是public
```

抽象类特点:

- 抽象类方法默认访问权限都是`default`
- 抽象类中可以构造方法
- 抽象类中可以存在普通属性，方法，静态属性和方法。
- 抽象类中可以存在抽象方法。
- 如果一个类中有一个抽象方法，那么当前类一定是抽象类；抽象类中不一定有抽象方法。
- 抽象类中的抽象方法，需要有子类实现，如果子类不实现，则子类也需要定义为抽象的。
- 抽象类不能被实例化，抽象类和抽象方法必须被abstract修饰

关键字使用注意：抽象类中的抽象方法（其前有abstract修饰）不能用private、static、synchronized、native访问修饰符修饰。

- 在接口中只有方法的声明，没有方法体。
- 在接口中只有常量，因为定义的变量，在编译的时候都会默认加上public static final
- 在接口中的方法，永远都被public来修饰。
- 接口中没有构造方法，也不能实例化接口的对象**。（所以接口不能继承类）**
- 接口可以实现多继承
- 接口中定义的方法都需要有实现类来实现，如果实现类不能实现接口中的所有方法则实现类定义为抽象类。
- 接口可以继承接口，用extends

#### 内部类

![](../../image/内部类.png)

```
1、静态内部类才可以声明静态方法
2、静态方法不可以使用非静态变量
3、抽象方法不可以有函数体
4、 局部内部类可以用哪些修饰符修饰？ 
```

2、 JDK1.8版本之前，抽象类和接口的区别，以下说法错误的是   D

```
接口是公开的，里面不能有私有的方法或变量，是用于让别人使用的，而抽象类是可以有私有方法或私有变量的。
abstract class 在 Java 语言中表示的是一种继承关系，一个类只能使用一次继承关系。但是，一个类却可以实现多个interface，实现多重继承。接口还有标识（里面没有任何方法，如Remote接口）和数据共享（里面的变量全是常量）的作用。
在abstract class 中可以有自己的数据成员，也可以有非abstarct的成员方法，而在interface中，只能够有静态的不能被修改的数据成员（也就是必须是 static final的，不过在 interface中一般不定义数据成员），所有的成员方法默认都是 public abstract 类型的。
abstract class和interface所反映出的设计理念不同。其实abstract class表示的是"has-a"关系，interface表示的是"is-a"关系。// abstract class表示的是"is-a"关系，interface表示的是"like-a"关系。
```

解释： is-a:继承关系 has-a:从属关系 like-a:组合关系 







#### 锁&线程

1、调用 sleep()方法，线程不会释放对象锁。而调用 wait() 方法线程会释放对象锁；

2、下面有关Java Threadlocal说法正确的有？

```
1.ThreadLocal存放的值是线程封闭，线程间互斥的，主要用于线程内共享一些数据，避免通过参数来传递
2.线程的角度看，每个线程都保持一个对其线程局部变量副本的隐式引用，只要线程是活动的并且 ThreadLocal 实例是可访问的；在线程消失之后，其线程局部实例的所有副本都会被垃圾回收
3.在Thread类中有一个Map，用于存储每一个线程的变量的副本。
4.对于多线程资源共享的问题，同步机制采用了“以时间换空间”的方式，而ThreadLocal采用了“以空间换时间”的方式
```

3、以下哪些类是线程安全的（Properties） 

Properties类是Hashtable的一个子类，hashTable是线程安全的，所以properties是线程安全的

4、 下列有关Thread的描述，哪个是正确的？ 

```
1.将一个线程标记成daemon线程，意味着当主线程结束，并且没有其它正在运行的非daemon线程时，该daemon线程也会自动结束。
2.结束一个线程的通常做法是：thread. stop()  //这个描述是错误的，结束线程用的是interrupt()方法，而stop()是强制结束线程，并不推荐使用，同时stop()方法已被弃用
```

5、 下列说法正确的是（BD）？ 

```
A.我们直接调用Thread对象的run方法会报异常，所以我们应该使用start方法来开启一个线程
B.一个进程是一个独立的运行环境，可以被看做一个程序或者一个应用。而线程是在进程中执行的一个任务。Java运行环境是一个包含了不同的类和程序的单一进程。线程可以被称为轻量级进程。线程需要较少的资源来创建和驻留在进程中，并且可以共享进程中的资源
C.synchronized可以解决可见性问题，volatile可以解决原子性问题    //volatile不能解决原子性问题
D.ThreadLocal用于创建线程的本地变量，该变量是线程之间不共享的
```

解释：特别是对C项的说明， 记住一句话，synchronized很强大，既可以保证可见性，又可以保证原子性，而volatile不能保证原子性！## synchronized保证三大性，原子性，有序性，可见性，volatile保证有序性，可见性，不能保证原子性 

6、 countDownLatch和cyclicBarrier的形象比喻：

```
就是在百米赛跑的比赛中若使用 countDownLatch的话冲过终点线一个人就给评委发送一个人的成绩，10个人比赛发送10次，如果用CyclicBarrier，则只在最后一个人冲过终点线的时候发送所有人的数据，仅仅发送一次，这就是区别。 
```

7、线程的生命状态

![](../../image/线程生命状态.jfif)



8、 下列方法中哪个是线程执行的方法？ （A） 

```
run（）
start（）  //启动线程
sleep（）
suspend（）
```

9、 下列哪些操作会使线程释放锁资源？ 

```
sleep()
wait()
join()  //底层调用wait()方法
yield()
```

10、 下列代码执行结果为（A）  //2  1 

```java
public static void main(String args[])throws InterruptedException{
            Thread t=new Thread(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.print("2");
                }
            });
            t.start();
             
            t.join();
            System.out.print("1");
        }
```

```
A.21
B.12
C.可能为12，也可能为21
D.以上答案都不对
```

解释： join()的作用是：“等待该线程终止”，这里需要理解的就是该线程是指的主线程等待子线程的终止。也就是在子线程调用了join()方法后面的代码，只有等到子线程结束了才能执行。 

11、 以下多线程对int型变量x的操作,哪个不需要进行同步(D) 

```
++x
x=y
x++
x=1
```

解释：同步是害怕在操作过程的时候被其他线程也进行读取操作，一旦是原子性的操作就不会发生这种情况。因为一步到位的操作，其他线程不可能在中间干涉。另外三项都有读取、操作两个步骤，而X=1则是原子性操作。

12、 关于下面一段代码，以下说法正确的是： (ACD) 

```
public class Test {
    private synchronized void a() {
    }
    private void b() {
        synchronized (this) {
        }
    }
    private synchronized static void c() {
    }
    private void d() {
        synchronized (Test.class) {
        }
    }
}
```

```
A.同一个对象，分别调用方法a和b，锁住的是同一个对象
B.同一个对象，分别调用方法a和c，锁住的是同一个对象
C.同一个对象，分别调用方法b和c，锁住的不是同一个对象
D.同一个对象，分别调用方法a、b、c，锁住的不是同一个对象
```

解释：修饰非静态方法锁的是this 对象，修饰静态方法 锁的是class对象







#### 事物

事物的四大特性：

- Atomicity：原子性体现在对于一个事务来讲，要么一起执行成功要么一起失败，执行的过程中是不能被打断或者执行其他操作的。
- Consistency：一致性表现为事务进行过后和执行前，整体系统都是稳定的，比如对于入账出账操作是不会有总资金的变化的。
- Isolation：隔离性表示`各个事务之间`不会互相影响，数据库一般会提供多种级别的隔离。实际上多个事务是并发执行的，但是他们之间不会互相影响。
- Durability：持久性表示一旦一个事务成功了，`那么他的改变是永久性的被记录和操作。`

6.若事务T对数据R已加X锁，则其它事务对R__________。

```
可以加S锁不能加X锁；
可以加S锁也可以加X锁；
不可以加S锁可以加X锁；
不能加任何锁。
```

S锁：共享锁，看成读锁。  X锁：排他锁，看成写锁。

就像操作系统中的读者和写着问题，要实现读读共享、读写互斥、写写互斥。只要有一个在读，就不允许写，而只要有一个在读，另一个就还可以读。`只要有一个再写，就不允许其他的读，也不允许其他的写`。

#### JVM

1、以下哪些jvm的垃圾回收方式采用的是复制算法回收 

​     新生代串行垃圾收集器、新生代并行垃圾收集器[**新生代的都是复制算法**]

2、java用（监视器）机制实现了进程之间的同步执行 

​     每一个对象都有一个**监视器**，或者叫做**锁**。 

3、下面哪种情况会导致`持久区j`vm堆内存溢出？[注意审题]

```
年老代溢出原因有:  循环上万次的字符串处理、创建上千万个对象、在一段代码内申请上百M甚至上G的内存，既A B D选项 持久代溢出原因  动态加载了大量Java类而导致溢出
```

4、java程序内存泄露的最直接表现是（C ） 

```
频繁FullGc
jvm崩溃
程序抛`内存`控制的Exception
java进程异常消失
```

```
A答案：FullGC 是老年代内存空间不足的时候，才会触发的，老年代一般是生命周期较长的对象或者大对象，频繁的 FullGC 不会可能会影响程序性能（因为内存回收需要消耗CPU等资源），但是并不会直接导致内存泄漏。
B 答案：JVM奔溃的可能是内存溢出引起的，也可能是其他导致 JVM崩溃的操作，例如设置了错误的JVM参数等。
C 答案：内存异常，最常见的就是 StackOverFlow 了把，内存溢出，其实内存泄漏的最终结果就是内存溢出。所以，基本上C是对的答案。
D 答案：Java 进程异常消失，这个明显不对的。
```

5、 jvm中垃圾回收分为scanvenge gc和full GC，其中full GC触发的条件可能有哪些    CDE

```
A.栈空间满
B.年轻代空间满
C.老年代满
D.持久代满
E.System.gc()
```

6、 对于JVM内存配置参数： 

>  -Xmx10240m -Xms10240m -Xmn5120m -XXSurvivorRatio=3 

 其最小内存值和Survivor区总大小分别是（D） 

```
A.5120m，1024m
B.5120m，2048m
C.10240m，1024m
D.10240m，2048m
```

```
-Xmx：最大堆大小
-Xms：初始堆大小
-Xmn:年轻代大小
-XXSurvivorRatio：年轻代中Eden区与Survivor区的大小比值
年轻代5120m， Eden：Survivor=3，Survivor区大小=1024m（Survivor区有两个，即将年轻代分为5份，每个Survivor区占一份），总大小为2048m。
-Xms初始堆大小即最小内存值为10240m
```

7、 关于Java中的ClassLoader下面的哪些描述是错误的：(  BDF  ) 

```
A.默认情况下，Java应用启动过程涉及三个ClassLoader: Boostrap, Extension, System
B.一般的情况不同ClassLoader装载的类是不相同的，但接口类例外，对于同一接口所有类装载器装载所获得的类是相同的
C.类装载器需要保证类装载过程的线程安全
D.ClassLoader的loadClass在装载一个类时，如果该类不存在它将返回null
E.ClassLoader的父子结构中，默认装载采用了父优先
F.所有ClassLoader装载的类都来自CLASSPATH环境指定的路径
```

解释：

```
A、java中类的加载有5个过程，加载、验证、准备、解析、初始化；这便是类加载的5个过程，而类加载器的任务是根据一个类的全限定名来读取此类的二进制字节流到JVM中，然后转换为一个与目标类对应的java.lang.Class对象实例，在虚拟机提供了3种类加载器，引导（Bootstrap）类加载器、扩展（Extension）类加载器、系统（System）类加载器（也称应用类加载器）。A正确
B、一个类，由不同的类加载器实例加载的话，会在方法区产生两个不同的类，彼此不可见，并且在堆中生成不同Class实例。所以B前面部分是正确的，后面接口的部分真的没有尝试过，等一个大佬的讲解吧；
C、类加载器是肯定要保证线程安全的；C正确
D、装载一个不存在的类的时候，因为采用的双亲加载模式，所以强制加载会直接报错，D错误
java.lang.SecurityException: Prohibited package name: java.lang
E、双亲委派模式是在Java 1.2后引入的，其工作原理的是，如果一个类加载器收到了类加载请求，它并不会自己先去加载，而是把这个请求委托给父类的加载器去执行，如果父类加载器还存在其父类加载器，则进一步向上委托，依次递归，请求最终将到达顶层的启动类加载器，如果父类加载器可以完成类加载任务，就成功返回，倘若父类加载器无法完成此加载任务，子加载器才会尝试自己去加载，这就是双亲委派模式，即每个儿子都很懒，每次有活就丢给父亲去干，直到父亲说这件事我也干不了时，儿子自己想办法去完成，所以默认是父装载，E正确
F、自定义类加载器实现 继承ClassLoader后重写了findClass方法加载指定路径上的class，F错误
```

8、 关于Java内存区域下列说法【不正确】的有哪些   BC

```
A.程序计数器是一块较小的内存空间，它的作用可以看做是当前线程所执行的字节码的信号指示器，每个线程都需要一个独立的程序计数器.
B.Java【虚拟机栈】描述的是java方法执行的内存模型，每个方法被执行的时候都会创建一个栈帧，用于存储局部变量表、类信息、动态链接等信息   //虚拟机栈中不存储类信息
C.Java堆是java虚拟机所管理的内存中最大的一块，【每个线程都拥有一块内存区域】，所有的对象实例以及数组都在这里分配内存。  //共享的
D.方法区是各个线程共享的内存区域，它用于存储已经被虚拟机加载的常量、即时编译器编译后的代码、静态变量等数据。
```

9.强软弱虚引用的描述,都是正确的

```
对于一个对象来说，只要有强引用的存在，它就会一直存在于内存中
如果一个对象只具有软引用，则内存空间足够，垃圾回收器就不会回收它；如果内存空间不足了，就会回收这些对象的内存
一旦发现了只具有弱引用的对象，不管当前内存空间足够与否，都会回收它的空间
如果一个对象仅持有虚引用，那么它就和没有任何引用一样，在任何时候都可能被垃圾回收器回收。
```



#### String

 1、java中 String str = "hello world"下列语句错误的是？ 

```
str+='      a'             X  'a'只能有单个字符，不能有多余的其他东西
int strlen = str.length    X   数组的才是instance.length方法,字符串的是instance.length();
str=100                    X
str=str+100                √
```

2、 StringBuilder和StringBuffer的区别，下面说法错误的是？ 

```
A.StringBuffer是线程安全的
B.StringBuilder是非线程安全的
C.StringBuffer对 String 类型进行改变的时候其实都等同于生成了一个新的 String 对象，然后将指针指向新的 String 对象。X 
对C项的解释：对String的修改其实是new了一个StringBuilder并调用append方法，然后调用toString返回一个新的String。
```



#### Switch

switch语句后的控制表达式只能是short、char、int、long整数类型和枚举类型，**不能**是`float`，`double`和`boolean`类型。**String类型是java7开始支持。** 

#### HashMap

1、HashMap的数据结构

![](../../image/hashMap结构.png)

2、与Hashtable的区别

```
HashMap和Hashtable都实现了Map接口
HashMap是非synchronized，而Hashtable是synchronized
HashTable使用Enumeration，HashMap使用Iterator
HashMap允许将 null 作为一个 entry 的 key 或者 value，而 Hashtable 不允许。
```

3、HashMap通过 <u>拉链法</u> 解决哈希冲突     

4、 threadlocalmap使用开放定址法解决haah冲突，hashmap使用链地址法解决hash冲突 

#### 反射

1、 Method m1[]=c.getDeclaredMethods();  返回类或接口声明的所有方法，但不包括继承的方法

​       Method m2[]=c. getMethods()返回类的所有public方法，包括其继承类的公用方法，当然也包括它所实现接口的方法

2、 Java是一门支持反射的语言,基于反射为Java提供了丰富的动态性支持，关于Java反射的描述，错误的是(  ADF   ) 

```
A.Java反射主要涉及的类如Class, Method, Filed,等，他们都在java.lang.reflet包下  //class 在lang包中
B.通过反射可以动态的实现一个接口，形成一个新的类，并可以用这个类创建对象，调用对象方法
C.通过反射，可以突破Java语言提供的对象成员、类成员的保护机制，访问一般方式不能访问的成员
D.Java反射机制提供了字节码修改的技术，可以动态的修剪一个类
E.Java的反射机制会给内存带来额外的开销。例如对永生堆的要求比不通过反射要求的更多
F.Java反射机制一般会带来效率问题，效率问题主要发生在查找类的方法和字段对象，因此通过缓存需要反射类的字段和方法就能达到与之间调用类的方法和访问类的字段一样的效率
```



#### 异常

1、面哪个行为被打断'不会'导致InterruptedException：（Thread.suspend ）？

2、 下面有关JAVA异常类的描述，说法【错误】的是？   B是对的，

```
A.异常的继承结构：基类为Throwable，Error和Exception继承Throwable，RuntimeException和IOException等继承Exception
B.非RuntimeException一般是外部错误(非Error)，其必须被 try{}catch语句块所捕获
C.Error类体系描述了Java运行系统中的内部错误以及资源耗尽的情形，Error不需要捕捉
D.RuntimeException体系包括错误的类型转换、数组越界访问和试图访问空指针等等，必须被 try{}catch语句块所捕获
```

3、 AccessViolationException异常触发后，下列程序的输出结果为（ A  )

```
static void Main(string[] args)  
{  
    try  
    {  
        throw new AccessViolationException();  
        Console.WriteLine("error1");  
    }  
    catch (Exception e)  
    {  
        Console.WriteLine("error2");  
    }  
    Console.WriteLine("error3");  
} 

```

```
A.error2error3
B.error3
C.error2
D.error1
```

解释： 

1.若catch(){	}块中，如果有throw 语句，则，try{	}、 catch(){	} 、finally{	}块之外的代码不执行；否则，执行。 

2.try{	}中有异常，则异常下面代码不执行。 

3.finally{	}中代码必执行。 







#### 静态

-  有关静态初始化块说法正确的是？  ABC

```
A    无法直接调用静态初始化块
B    在创建第一个实例前或引用任何静态成员之==前==，将自动调用静态初始化块来初始化
C    静态初始化块既没有访问修饰符，也没有参数
D    在程序中，用户可以控制合适执行静态初始化块
```

#### 数据结构与算法

1、一组记录排序码为(5 11 7 2 3 17),则利用堆排序方法建立的初始堆为

![](../../image/第一次构建堆.jpg)

2、利用栈完成数制转换，将十进制的169转换为八进制，出栈序列为（）

```
169/8 = 21 余1  
21/8 = 2 余5  
2/8 = 0 余 2
余数倒过来 251 
169=2*8^2+5*8^1+1*8^0，栈是先进后出，那么出来的数则为251
```

3、稳定和不稳定的排序算法是：

```
不稳定的排序: 选择排序/快速排序/希尔排序/堆排序   选快希堆
稳定的排序: 冒泡排序/插入排序/归并排序/基数排序	 冒插归基
```

4、 算法的基本要素有两个：1.数据对象的运算和操作 2.控制结构

5、 以下哪个输出序列`不可能`是二叉查找树（Binary Search Tree）后序遍历的输出。 B

```
A.1, 2, 3, 4, 5
B.5, 4, 3, 2, 1
C.1, 3, 2, 4, 5
D.1, 2, 5, 3, 4
```

 解释：假设B正确，则1为根，无论如何，左右孩子节点都比父节点大，不满足BST的条件

6、 假设一个无向图中包含12个顶点，其中5个顶点有5个度，7个顶点有7个度，那么这个图有几条边？（）  

解：37

 释：一条边带来两个度，（7* 7+5*5）/2=37 

#### IO流

1、基本框架

```
字节流：
InputStream
|-- FileInputStream (基本文件流）
|-- BufferedInputStream
|-- DataInputStream
|-- ObjectInputStream
字符流
Reader
|-- InputStreamReader (byte->char 桥梁）
|-- BufferedReader (常用）
Writer
|-- OutputStreamWriter (char->byte 桥梁）
|-- BufferedWriter
|-- PrintWriter （常用）
```





#### spring

1、AOP技术优势在于（B）

```
通过接口、抽象及组合增强对象内部能力
将核心关注点与横切关注点完全隔离
有利增强业务安全性
让一些公共逻辑更好的分布在对象核心逻辑中
```

2、 在J2EE中，使用Servlet过滤器，需要在web.xml中配置（A.B）元素 

```
A.<filter>
B.<filter-mapping>
C.<servlet-filter>
D.<filter-config>
```













#### 代码题

1、class A {}
class B extends A {}
class C extends A {}
class D extends B {}
Which four statements are true ? ACDG

```
The type List<A>is assignable to List.
The type List<B>is assignable to List<A>.
The type List<Object>is assignable to List<?>.
The type List<D>is assignable to List<?extends B>.
The type List<?extends A>is assignable to List<A>.
The type List<Object>is assignable to any List reference.
The type List<?extends B>is assignable to List<?extends A>.
```

```
public static void main(String[] args) {
        List<A> a;
        List list;
        list = a;   //A对，因为List就是List<?>，代表最大的范围，A只是其中的一个点，肯定被包含在内
        List<B> b;
        a = b;      //B错，点之间不能相互赋值
        List<?> qm;
        List<Object> o;
        qm = o;     //C对，List<?>代表最大的范围，List<Object>只是一个点，肯定被包含在内
        List<D> d;
        List<? extends B> downB;
        downB = d;  //D对，List<? extends B>代表小于等于B的范围，List<D>是一个点，在其中
        List<?extends A> downA;
        a = downA;  //E错，范围不能赋值给点
        a = o;      //F错，List<Object>只是一个点
        downA = downB;  //G对，小于等于A的范围包含小于等于B的范围，因为B本来就比A小，B时A的子类嘛
    }

```

2、Given the following code:

```
public class Test {
    private static int j = 0;
 
    private static Boolean methodB(int k) {
        j += k;
        return true;
    }
 
    public static void methodA(int i) {
        boolean b;
        b = i < 10 | methodB(4);
        b = i < 10 || methodB(8);
 
    }
 
    public static void main(String args[]) {
        methodA(0);
        System.out.println(j);
    }
}
```

What is the result?  4  or  8

这道题主要考的是"|"与"||"的区别

用法：condition 1 | condition 2、condition 1 || condition 2

"|"是按位或：先判断条件1，不管条件1是否可以决定结果（这里决定结果为true)，都会执行条件2

"||"是逻辑或：先判断条件1，如果条件1可以决定结果（这里决定结果为true)，那么就不会执行条件2

3、下面代码的运行结果是（）

```
public static void main(String[] args){
    String s;
    System.out.println("s="+s);
}
```

成员变量有初始值，而局部变量没有初始值得。本体中的s定义在方法中所以为局部变量-没有初始值。变量没有初始值就使用了，编译通不过

4、代码题

```
package Wangyi;
class Base
{
    public void method()
    {
        System.out.println("Base");
    } 
}
class Son extends Base
{
    public void method()
    {
        System.out.println("Son");
    }
     
    public void methodB()
    {
        System.out.println("SonB");
    }
}
public class Test01
{
    public static void main(String[] args)
    {
        Base base = new Son();
        ====base.method();
        ====base.methodB();
    }
}
```

编译不通过，不能调用父类没有的方法

5、下面代码将输出什么内容：（）

```
public class SystemUtil{
    public static boolean isAdmin(String userId){
        return userId.toLowerCase()=="admin";
    }
    public static void main(String[] args){
        System.out.println(isAdmin("Admin"));
    }
}
```

主要考的是`==`和`equals`的区别：

==用在基本数据类型，比较的是值是否相等，equals（如果重写了方法的话）比较的是内容，

6、下面代码的输出是什么？  null

```java
public class Base
{
    private String baseName = "base";
    public Base()
    {
        callName();
    }
 
    public void callName()
    {
        System. out. println(baseName);
    }
 
    static class Sub extends Base
    {
        private String baseName = "sub";
        public void callName()
        {
            System. out. println (baseName) ;
        }
    }
    public static void main(String[] args)
    {
        Base b = new Sub();
    }
}
```

```
 new Sub();在创造派生类的过程中首先创建基类对象，然后才能创建派生类。
创建基类即默认调用Base()方法，在方法中调用callName()方法，由于派生类中存在此方法，则被调用的callName（）方法是派生类中的方法，此时派生类还未构造，所以变量baseName的值为null
```

7、类Parent和Child定义如下： 

```
class  Parent{
         public  float  aFun(float a, float b) { }
}
class  Child  extends  Parent{
		// todo
}
```

   将以下哪种方法插入行5是不合法的。（  ）**注意看题,重载和重写的区别**

8、下面哪段程序能够正确的实现了GBK编码字节流到UTF-8编码字节流的转换： 

```
dst=new String(src，"GBK").getBytes("UTF-8")
```

9、假设如下代码中，若t1线程在t2线程启动之前已经完成启动。代码的输出是（）

```
public static void main(String[]args)throws Exception {
    final Object obj = new Object();
    Thread t1 = new Thread() {
        public void run() {
            synchronized (obj) {
                try {
                    obj.wait();
                    System.out.println("Thread 1 wake up.");
                } catch (InterruptedException e) {
                }
            }
        }
    };
    t1.start();
    Thread.sleep(1000);//We assume thread 1 must start up within 1 sec.
    Thread t2 = new Thread() {
        public void run() {
            synchronized (obj) {
                obj.notifyAll();
                System.out.println("Thread 2 sent notify.");
            }
        }
    };
    t2.start();
}
```

执行obj.wait();时已释放了锁，所以t2可以再次获得锁，然后发消息通知t1执行，但这时t2还没有释放锁，所以肯定是执行t2，然后释放锁，之后t1才有机会执行。

10、URL u =new URL("http://www.123.com");。如果www.123.com不存在，则返回__。

11、

```
public static boolean isOdd(int i) {
	return i % 2 == 1;
}
```

上面是小明写的一段判断奇数的方法，请问下面那些会返回true？（  ）

```
isOdd(-5)  // 返回-1
```

12、 what is the result of the following code? 

```
enum AccountType
{
    SAVING, FIXED, CURRENT;
    private AccountType()
    {
        System.out.println(“It is a account type”);
    }
}
class EnumOne
{
    public static void main(String[]args)
    {
        System.out.println(AccountType.FIXED);
    }
}
```

![](../../image/枚举1.png)

 13、Which statement declares a variable a which is suitable for referring to an array of 50 string objects?（Java）   BCF

```
A    char a[][];
B   String a[];
C    String[] a;
D    Object a[50];
E    String a[50];
F    Object a[];
```

14、输出的是 0；

```
public class Inc { 
    public static void main(String[] args) { 
       Inc inc = new Inc(); 
       int i = 0; 
       inc.fermin(i); 
       i= i ++; 
       System.out.println(i);
    
    } 
    void fermin(int i){ 
       i++; 
    } 
}
```

15、 代码片段：  

```
byte b1=1,b2=2,b3,b6; 
final byte b4=4,b5=6; 
b6=b4+b5; 
b3=(b1+b2); 
System.out.println(b3+b6);
```

正确的是：C    解释：会出现将int的值赋值给我byte，不能这样

```
A输出结果：13
B语句：b6=b4+b5编译出错
C语句：b3=b1+b2编译出错
D运行期抛出异常
```

16、代码将打印出  C 

```
public static void main (String[] args) { 
    String classFile = "com.jd.". replaceAll(".", "/") + "MyClass.class";
    System.out.println(classFile);
}
```

```
A.com. jd
B.com/jd/MyClass.class
C.///////MyClass.class
D.com.jd.MyClass
```

解释：由于replaceAll方法的第一个参数是一个正则表达式，而"."在正则表达式中表示任何字符，所以会把前面字符串的所有字符都替换成"/"。如果想替换的只是"."，那么久要写成"\\.". 

17、 有如下一段代码，请选择其运行结果（C） 

```
public class StringDemo{
  private static final String MESSAGE="taobao";
  public static void main(String [] args) {
    String a ="tao"+"bao";
    String b="tao";
    String c="bao";
    System.out.println(a==MESSAGE);
    System.out.println((b+c)==MESSAGE);
  }
}
```

```
A.true true
B.false false
C.true false
D.false true
```

解释： 这题是在考编译器的优化，hotspot中 编译时"tao"+"bao"将直接变成"taobao"，b+c则不会优化，因为不知道在之前的步骤中bc会不会发生改变，而针对b+c则是用语法糖，新建一个StringBuilder来处理 

18、 下面程序的输出是什么？   B  

```
public class TestDemo
{
    public static String output = ””;
    public static void foo(inti)
    {
        try
        {
            if (i == 1)
            {
                throw new Exception();
            }
        }
        catch (Exception e)
        {
            output += “2”;
            return ;
        } finally
        {
            output += “3”;
        }
        output += “4”;
    }
    public static void main(String[] args)
    {
        foo(0);
        foo(1);
        System.out.println(output);
    }
}

```

```
A.342
B.3423
C.34234
D.323
```

19、执行如下程序代码

```
char chr = 127;
int sum = 200;
chr += 1;
sum += chr;
后，sum的值是  ; （   ）
备注：同时考虑c/c++和Java的情况的话
```

```
72
99
328
327
```

解释：java中只有byte, boolean是一个字节, char是两个字节, 所以对于java来说127不会发生溢出, 输出328

但是对于c/c++语言来说, char是一个字节, 会发生溢出, 对127加一发生溢出, 0111 1111 --> 1000 0000, 1000 0000为补码-128, 所以结果为200-128=72

20、 以下代码运行输出的是   C   // 太简单不解释

```java
public class Person{
    private String name = "Person";
    int age=0;
}
public class Child extends Person{
    public String grade;
    public static void main(String[] args){
        Person p = new Child();
        System.out.println(p.name);
    }
}
```

```
A.输出：Person
B.没有输出
C.编译出错
D.运行出错
```

21、输出的是

```
class Foo {
    final int i;
    int j;
    public void doSomething() {
        System.out.println(++j + i);
    }
}
```

```
A.0
B.1
C.2
D.不能执行，因为编译有错
```

解释：final作为对象成员存在时，必须初始化；但是，如果不初始化，也可以在类的构造函数中初始，因为java允许将数据成员声明为final，却不赋初值。但是，blank finals必须在使用之前初始化，且必须在构造函数中初始化 

22、代码的运行结果为： 022   #自己思考问题

```
public class Spike
{
    public static void main(String[] args)
    {
        Counter a = new Counter();
        System.out.println(a.increment());
        System.out.println(a.anotherIncrement());
        Counter b = new Counter();
        System.out.println(b.increment());
    }
}
class Counter
{
    private static int count = 0;
    public int increment()
    {
        return count++;
    }
    public int anotherIncrement()
    {
        return ++count;
    }
}

```

23、代码的执行结果是：21  

```
下列代码执行结果为（）
public static void main(String args[])throws InterruptedException{
            Thread t=new Thread(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.print("2");
                }
            });
            t.start();
             
            t.join();
            System.out.print("1");
        }

```

解释： 因为子线程的休眠时间太长，因此主线程很有可能在子线程之前结束也就是输出结果是12，但是子线程用了join函数，因此主线程必须等待子线程执行完毕才结束因此输出结果只能是21 。 join()的作用是：“等待该线程终止”，这里需要理解的就是该线程是指的主线程等待子线程的终止。也就是在子线程调用了join()方法后面的代码，只有等到子线程结束了才能执行。 

24、 阅读如下代码。 请问，对语句行 test.hello(). 描述正确的有（A） 

```
class Test {
    public static void hello() {
        System.out.println("hello");
    }
}
public class MyApplication {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Test test=null;
        test.hello();
    }
}
```

```
A.能编译通过，并正确运行
B.因为使用了未初始化的变量，所以不能编译通过
C.以错误的方式访问了静态方法
D.能编译通过，但因变量为null，不能正常运行
```

解释：hello()为静态方法

25、下列代码输出的结果是： 0；

![](../../image/代码题.png)

解释：`count=count++`;这个代码表示的意思是：

```
temp = count;
count = count+1; 
count = temp;
```

26、根据以下代码段，下列说法中正确的是( C )。

```
public class Parent {
  private void m1(){}
  void m2(){}
  protected void m3(){}
  public static void m4(){}
}
```

```
A.子类中一定能够继承和覆盖Parent类的m1方法  // 私有不可以
B.子类中一定能够继承和覆盖Parent类的m2方法	// 
C.子类中一定能够继承和覆盖Parent类的m3方法
D.子类中一定能够继承和覆盖Parent类的m4方法  // 不可以
```

27、 下面代码的输出是什么？   null

```
public class Base
{
    private String baseName = "base";
    public Base()
    {
        callName();
    }
 
    public void callName()
    {
        System. out. println(baseName);
    }
 
    static class Sub extends Base
    {
        private String baseName = "sub";
        public void callName()
        {
            System. out. println (baseName) ;
        }
    }
    public static void main(String[] args)
    {
        Base b = new Sub();
    }
}

```

```
null
sub
base
```

选A，解释：

 new Sub();在创造派生类的过程中首先创建基类对象，然后才能创建派生类。

创建基类即默认调用Base()方法，在方法中调用callName()方法，由于派生类中存在此方法，则被调用的callName（）方法是派生类中的方法，此时派生类还未构造，所以变量baseName的值为null

28、 以下代码运行输出的是    C

```
public class Person{
    private String name = "Person";
    int age=0;
}
public class Child extends Person{
    public String grade;
    public static void main(String[] args){
        Person p = new Child();
        System.out.println(p.name);
    }
}
```

```
A.输出：Person
B.没有输出
C.编译出错
D.运行出错
```

解释:这题错误很多：1、一个类文件里面出现多个public类，2、不能访问父类的私有方法和私有变量

29、 String 类是java中最常用的类之一，现有如下程序： 

```
public static void main(String[] args){
    String  s1 = “s1”;
    String  s2 = new String (“s2”);
    String  s3 = new String(“s3”);
    System.out.println(s1 + s2 + s3);
}
```

 上面方法一共创建了几个对象？（A） 

```
A.4个
B.5个
C.6个
D.7个
```

30、 下面代码的运行结果是（C） 

```
public static void main(String[] args){
    String s;
    System.out.println("s="+s);
}
```

```
A.代码编程成功，并输出”s=”
B.代码编译成功，并输出”s=null”
C.由于String s没有初始化，代码不能编译通过。
D.代码编译成功，但捕获到NullPointException异常
```

解释：s是局部变量，必须初始化赋值



31、设有下面两个赋值语句：

```
a = Integer.parseInt("1024");
b = Integer.valueOf("1024").intValue();
```

下述说法正确的是（D）

```
A.a是整数类型变量，b是整数类对象。
B.a是整数类对象，b是整数类型变量。
C.a和b都是整数类对象并且它们的值相等。
D.a和b都是整数类型变量并且它们的值相等。
```

32、 以下程序的输出结果为 （D）

```
class Base{
    public Base(String s){
        System.out.print("B");
    }
}
public class Derived extends Base{
   // 必须要有super调用父类的构造方法
    public Derived (String s) {
        System.out.print("D");
    }
    public static void main(String[] args){
        new Derived("C");
    }
}
```

```
A.BD
B.DB
C.C
D.编译错误
```

33、 Which lines of the following will produce an error?   A

```
1. byte a1 = 2, a2 = 4, a3;
2. short s = 16;
3. a2 = s;
4. a3 = a1 * a2;   //会转成int类型进行运算
```

```
A.Line 3 and Line 4
B.Line 1 only
C.Line 3 only
D.Line 4 only
```








#### JSP&Servlet

1、下面有关jsp中静态include和动态include的区别，说法错误的是？4   

```
1.动态INCLUDE:用jsp:include动作实现 
2.静态INCLUDE:用include伪码实现，定不会检查所含文件的变化，适用于包含静态页面<%@ include file="included.htm" %>
3.静态include的结果是把其他jsp引入当前jsp，两者合为一体;动态include的结构是两者独立，直到输出时才合并
4.静态include和动态include都可以允许变量同名的冲突.页面设置也可以借用主文件的
```

2、Servlet的生命周期

```
1.加载：容器通过类加载器使用Servlet类对应的文件来加载Servlet
2.创建：通过调用Servlet的构造函数来创建一个Servlet实例
3.初始化：通过调用Servlet的init()方法来完成初始化工作，这个方法是在Servlet已经被创建，但在向客户端提供服务之前调用。
4.处理客户请求：Servlet创建后就可以处理请求，当有新的客户端请求时，Web容器都会创建一个新的线程来处理该请求。接着调用Servlet的
Service()方法来响应客户端请求（Service方法会根据请求的method属性来调用doGet（）和doPost（））
5.卸载：容器在卸载Servlet之前需要调用destroy()方法，让Servlet释放其占用的资源。
```

3、jsp的九大内置对象  request、response、session、application、out、pagecontext、config、page、exception 

4、JSP的基本操作

```
SP 共有以下 6 种基本动作：
jsp:include：在页面被请求的时候引入一个文件；
jsp:useBean：寻找或者实例化一个JavaBean。；
jsp:setProperty：设置 JavaBean 的属性。；
jsp:getProperty：输出某个 JavaBean 的属性；
jsp:forward：把请求转到一个新的页面；
jsp:plugin：根据浏览器类型为 Java 插件生成 OBJECT 或 EMBED 标记。
```

5、 以下哪些方法可以取到http请求中的cookie值（B.D）? 

```
A.request.getAttribute     // 服务端
B.request.getHeader      
C.request.getParameter      //服务端
D.request.getCookies
```

6、 下面有关forward和redirect的描述，正确的是( B C D  ) ？ 

```
A.forward是服务器将控制权转交给另外一个内部服务器对象，由新的对象来全权负责响应用户的请求
B.执行forward时，浏览器不知道服务器发送的内容是从何处来，浏览器地址栏中还是原来的地址
C.执行redirect时，服务器端告诉浏览器重新去请求地址
D.forward是内部重定向，redirect是外部重定向
E.redirect默认将产生301 Permanently moved的HTTP响应
```

解释：

```
1.从地址栏显示来说 
forward是服务器请求资源,服务器直接访问目标地址的URL,把那个URL的响应内容读取过来,然后把这些内容再发给浏览器.浏览器根本不知道服务器发送的内容从哪里来的,所以它的地址栏还是原来的地址.
redirect是服务端根据逻辑,发送一个状态码,告诉浏览器重新去请求那个地址.所以地址栏显示的是新的URL.
2.从数据共享来说 
forward:转发页面和转发到的页面可以共享request里面的数据.
redirect:不能共享数据.
3.从运用地方来说 
forward:一般用于用户登陆的时候,根据角色转发到相应的模块.
redirect:一般用于用户注销登陆时返回主页面和跳转到其它的网站等.
4.从效率来说 
forward:高.
redirect:低.
```

7、 Servlet的生命周期可以分为初始化阶段，运行阶段和销毁阶段三个阶段，以下过程属于初始化阶段是（）。 

```
A.加载Servlet类及.class对应的数据
B.创建servletRequest和servletResponse对象
C.创建ServletConfig对象
D.创建Servlet对象
```

8、 下面有关servlet service描述错误的是？ B

```
A.不管是post还是get方法提交过来的连接，都会在service中处理
B.doGet/doPost 则是在 javax.servlet.GenericServlet 中实现的
C.service()是在javax.servlet.Servlet接口中定义的
D.service判断请求类型，决定是调用doGet还是doPost方法
```

解释： doGet/doPost 则是在 javax.servlet.http.HttpServlet 中实现的 

![](../../image/servlet类图.png)

9、 Servlet接口的方法有哪些？ c

```
A.doGet方法
B.doPost方法
C.init方法
D.forward方法
```

解释： doGet和doPost是HttpServlet中的方法；forward是RequestDispatcher的方法  

10、 下面有关JSP内置对象的描述，说法错误的是？ 

```
A.session对象：session对象指的是客户端与服务器的一次会话，从客户连到服务器的一个WebApplication开始，直到客户端与服务器断开连接为止
B.request对象：客户端的请求信息被封装在request对象中，通过它才能了解到客户的需求，然后做出响应
C.application对象：多个application对象实现了用户间数据的共享，可存放全局变量  #只有一个application对象
D.response对象：response对象包含了响应客户请求的有关信息
```

11、 从以下哪一个选项中可以获得Servlet的初始化参数?    C

```
Servlet
ServletContext
ServletConfig
GenericServlet
```

解释：ServletContext对象：servlet容器在启动时会加载web应用，并为每个web应用创建唯一的servlet context对象，可以把ServletContext看成是一个Web应用的[服务器](http://server.chinaitlab.com/)端组件的共享内存，在ServletContext中可以存放共享数据。ServletContext对象是真正的一个全局对象，凡是web容器中的Servlet都可以访问。整个web应用只有唯一的一个ServletContext对象

servletConfig对象：用于封装servlet的配置信息。从一个servlet被实例化后，对任何客户端在任何时候访问有效，但仅对servlet自身有效，一个servlet的ServletConfig对象不能被另一个servlet访问。



#### 正则表达式

| 元字符       | 描述                                                         |
| ------------ | ------------------------------------------------------------ |
| \            | 将下一个字符标记符、或一个向后引用、或一个八进制转义符。例如，“\\n”匹配\n。“\n”匹配换行符。序列“\\”匹配“\”而“\(”则匹配“(”。即相当于多种编程语言中都有的“转义字符”的概念。 |
| ^            | 匹配输入字符串的开始位置。如果设置了RegExp对象的Multiline属性，^也匹配“\n”或“\r”之后的位置。 |
| $            | 匹配输入字符串的结束位置。如果设置了RegExp对象的Multiline属性，$也匹配“\n”或“\r”之前的位置。 |
| *            | 匹配前面的子表达式任意次。例如，zo*能匹配“z”，也能匹配“zo”以及“zoo”。*等价于o{0,} |
| +            | 匹配前面的子表达式一次或多次(大于等于1次）。例如，“zo+”能匹配“zo”以及“zoo”，但不能匹配“z”。+等价于{1,}。 |
| ?            | 匹配前面的子表达式零次或一次。例如，“do(es)?”可以匹配“do”或“does”中的“do”。?等价于{0,1}。 |
| {n}          | n是一个非负整数。匹配确定的n次。例如，“o{2}”不能匹配“Bob”中的“o”，但是能匹配“food”中的两个o。 |
| {n,}         | n是一个非负整数。至少匹配n次。例如，“o{2,}”不能匹配“Bob”中的“o”，但能匹配“foooood”中的所有o。“o{1,}”等价于“o+”。“o{0,}”则等价于“o*”。 |
| {n,m}        | m和n均为非负整数，其中n<=m。最少匹配n次且最多匹配m次。例如，“o{1,3}”将匹配“fooooood”中的前三个o为一组，后三个o为一组。“o{0,1}”等价于“o?”。请注意在逗号和两个数之间不能有空格。 |
| ?            | 当该字符紧跟在任何一个其他限制符（*,+,?，{n}，{n,}，{n,m}）后面时，匹配模式是非贪婪的。非贪婪模式尽可能少的匹配所搜索的字符串，而默认的贪婪模式则尽可能多的匹配所搜索的字符串。例如，对于字符串“oooo”，“o+”将尽可能多的匹配“o”，得到结果[“oooo”]，而“o+?”将尽可能少的匹配“o”，得到结果 ['o', 'o', 'o', 'o'] |
| .点          | 匹配除“\r\n”之外的任何单个字符。要匹配包括“\r\n”在内的任何字符，请使用像“[\s\S]”的模式。 |
| (pattern)    | 匹配pattern并获取这一匹配。所获取的匹配可以从产生的Matches集合得到，在VBScript中使用SubMatches集合，在JScript中则使用$0…$9属性。要匹配圆括号字符，请使用“\(”或“\)”。 |
| (?:pattern)  | 非获取匹配，匹配pattern但不获取匹配结果，不进行存储供以后使用。这在使用或字符“(\|)”来组合一个模式的各个部分时很有用。例如“industr(?:y\|ies)”就是一个比“industry\|industries”更简略的表达式。 |
| (?=pattern)  | 非获取匹配，正向肯定预查，在任何匹配pattern的字符串开始处匹配查找字符串，该匹配不需要获取供以后使用。例如，“Windows(?=95\|98\|NT\|2000)”能匹配“Windows2000”中的“Windows”，但不能匹配“Windows3.1”中的“Windows”。预查不消耗字符，也就是说，在一个匹配发生后，在最后一次匹配之后立即开始下一次匹配的搜索，而不是从包含预查的字符之后开始。 |
| (?!pattern)  | 非获取匹配，正向否定预查，在任何不匹配pattern的字符串开始处匹配查找字符串，该匹配不需要获取供以后使用。例如“Windows(?!95\|98\|NT\|2000)”能匹配“Windows3.1”中的“Windows”，但不能匹配“Windows2000”中的“Windows”。 |
| (?<=pattern) | 非获取匹配，反向肯定预查，与正向肯定预查类似，只是方向相反。例如，“(?<=95\|98\|NT\|2000)Windows”能匹配“2000Windows”中的“Windows”，但不能匹配“3.1Windows”中的“Windows”。 |
| (?<!pattern) | 非获取匹配，反向否定预查，与正向否定预查类似，只是方向相反。例如“(?<!95\|98\|NT\|2000)Windows”能匹配“3.1Windows”中的“Windows”，但不能匹配“2000Windows”中的“Windows”。这个地方不正确，有问题此处用或任意一项都不能超过2位，如“(?<!95\|98\|NT\|20)Windows正确，“(?<!95\|980\|NT\|20)Windows 报错，若是单独使用则无限制，如(?<!2000)Windows 正确匹配 |
| x\|y         | 匹配x或y。例如，“z\|food”能匹配“z”或“food”(此处请谨慎)。“[zf]ood”则匹配“zood”或“food”。 |
| [xyz]        | 字符集合。匹配所包含的任意一个字符。例如，“[abc]”可以匹配“plain”中的“a”。 |
| [^xyz]       | 负值字符集合。匹配未包含的任意字符。例如，“[^abc]”可以匹配“plain”中的“plin”。 |
| [a-z]        | 字符范围。匹配指定范围内的任意字符。例如，“[a-z]”可以匹配“a”到“z”范围内的任意小写字母字符。注意:只有连字符在字符组内部时,并且出现在两个字符之间时,才能表示字符的范围; 如果出字符组的开头,则只能表示连字符本身. |
| [^a-z]       | 负值字符范围。匹配任何不在指定范围内的任意字符。例如，“[^a-z]”可以匹配任何不在“a”到“z”范围内的任意字符。 |
| \b           | 匹配一个单词边界，也就是指单词和空格间的位置（即正则表达式的“匹配”有两种概念，一种是匹配字符，一种是匹配位置，这里的\b就是匹配位置的）。例如，“er\b”可以匹配“never”中的“er”，但不能匹配“verb”中的“er”。 |
| \B           | 匹配非单词边界。“er\B”能匹配“verb”中的“er”，但不能匹配“never”中的“er”。 |
| \cx          | 匹配由x指明的控制字符。例如，\cM匹配一个Control-M或回车符。x的值必须为A-Z或a-z之一。否则，将c视为一个原义的“c”字符。 |
| \d           | 匹配一个数字字符。等价于[0-9]。grep 要加上-P，perl正则支持   |
| \D           | 匹配一个非数字字符。等价于[^0-9]。grep要加上-P，perl正则支持 |
| \f           | 匹配一个换页符。等价于\x0c和\cL。                            |
| \n           | 匹配一个换行符。等价于\x0a和\cJ。                            |
| \r           | 匹配一个回车符。等价于\x0d和\cM。                            |
| \s           | 匹配任何不可见字符，包括空格、制表符、换页符等等。等价于[ \f\n\r\t\v]。 |
| \S           | 匹配任何可见字符。等价于[^ \f\n\r\t\v]。                     |
| \t           | 匹配一个制表符。等价于\x09和\cI。                            |
| \v           | 匹配一个垂直制表符。等价于\x0b和\cK。                        |
| \w           | 匹配包括下划线的任何单词字符。类似但不等价于“[A-Za-z0-9_]”，这里的"单词"字符使用Unicode字符集。 |
| \W           | 匹配任何非单词字符。等价于“[^A-Za-z0-9_]”。                  |

2、 关于身份证号，以下正确的正则表达式为（A C） 

```
isIDCard=/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/;
isIDCard=/^[1-9]\d{7}((9\d)|(1[0-2]))(([0|1|2]\d)|3[9-1])\d{3}$/;
isIDCard=/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{4}$/;
isIDCard=/^[1-9]\d{5}[1-9]\d{3}((9\d)|(1[9-2]))(([0|1|2]\d)|3[9-1])\d{4}$/;
```

解释：

```
^：起始符号，^x表示以x开头
$：结束符号，x$表示以x结尾
[n-m]：表示从n到m的数字
\d：表示数字，等同于[0-9]
X{m}：表示由m个X字符构成，\d{4}表示4位数字

15位身份证的构成：六位出生地区码+六位出身日期码+三位顺序码
18位身份证的构成：六位出生地区码+八位出生日期码+三位顺序码+一位校验码

C选项的构成：
[1-9]\d{5}：六位出生地区码，出生地区码没有以0开头，因此第一位为[1-9]。
[1-9]\d{3}：八位出生日期码的四位年份，同样年份没有以0开头。
((0\d)|(1[0-2]))：八位出生日期码的两位月份，| 表示或者，月份的形式为0\d或者是10、11、12。
(([0|1|2]\d)|3[0-1])：八位出生日期码的两位日期，日期由01至31。
\d{4}：三位顺序码+一位校验码，共四位。
A选项的构成：
[1-9]\d{7}：六位出生地区码+两位出生日期码的年份，这里的年份指后两位，因此没有第一位不能为0的限制，所以合并了。
后面的与C选项类似了。
好吧其实我也是第一次知道身份证还有15位的。
```











#### ASCII

1、 关于ASCII码和ANSI码，以下说法不正确的是（D）？  特殊字符不可以打印 

```
A、标准ASCII只使用7个bit
B、在简体中文的Windows系统中，ANSI就是GB2312
C、ASCII码是ANSI码的子集
D、ASCII码都是可打印字符
```











### Linux

#### 基本命令

1. 文件目录data当前权限为rwx --- ---，只需要增加用户组可读权限，但不允许写操作，具体方法为： 

```
A.chmod+050data
B.chmod+040data
C.chmod+005data
D.chmod+004data
```

 data是一个目录，要读取目录下文件，对这个目录需要读取和执行权限 ,所以选A

#### 脚本参数的含义

![](../../image/Linux脚本参数.png)

2、 以下哪个命令用于查看tar（backup.tar）文件的内容而不提取它?（B） 

```
tar -xvf backup.tar
tar -tvf backup.tar
tar -svf backup.tar
none of these
```

解释：

- -s 还原文件的顺序和备份文件内的存放顺序相同。
- -t 列出备份文件的内容。
- -v 显示指令执行过程。
- -f 指定压缩文件
- -x 从备份文件中还原文件。

把常用的tar解压命令总结下，当作备忘：

 

tar

 

-c: 建立压缩档案
-x：解压
-t：查看内容
-r：向压缩归档文件末尾追加文件
-u：更新原压缩包中的文件

这五个是独立的命令，压缩解压都要用到其中一个，可以和别的命令连用但只能用其中一个。下面的参数是根据需要在压缩或解压档案时可选的。

-z：有gzip属性的
-j：有bz2属性的
-Z：有compress属性的
-v：显示所有过程
-O：将文件解开到标准输出

下面的参数-f是必须的

-f: 使用档案名字，切记，这个参数是最后一个参数，后面只能接档案名。

\# tar -cf all.tar *.jpg 
这条命令是将所有.jpg的文件打成一个名为all.tar的包。-c是表示产生新的包，-f指定包的文件名。

\# tar -rf all.tar *.gif 
这条命令是将所有.gif的文件增加到all.tar的包里面去。-r是表示增加文件的意思。

\# tar -uf all.tar logo.gif 
这条命令是更新原来tar包all.tar中logo.gif文件，-u是表示更新文件的意思。

\# tar -tf all.tar 
这条命令是列出all.tar包中所有文件，-t是列出文件的意思

\# tar -xf all.tar 
这条命令是解出all.tar包中所有文件，-x是解开的意思


压缩

- tar –cvf jpg.tar *.jpg 将目录里所有jpg文件打包成tar.jpg
- tar –czf jpg.tar.gz *.jpg  将目录里所有jpg文件打包成jpg.tar后，并且将其用gzip压缩，生成一个gzip压缩过的包，命名为jpg.tar.gz
- tar –cjf jpg.tar.bz2 *.jpg 将目录里所有jpg文件打包成jpg.tar后，并且将其用bzip2压缩，生成一个bzip2压缩过的包，命名为jpg.tar.bz2
- tar –cZf jpg.tar.Z *.jpg  将目录里所有jpg文件打包成jpg.tar后，并且将其用compress压缩，生成一个umcompress压缩过的包，命名为jpg.tar.Z
- rar a jpg.rar *.jpg rar格式的压缩，需要先下载rar for linux
- zip jpg.zip *.jpg  zip格式的压缩，需要先下载zip for linux 

解压

- tar –xvf file.tar 解压 tar包
- tar -xzvf file.tar.gz 解压tar.gz
- tar -xjvf file.tar.bz2  解压 tar.bz2
- tar –xZvf file.tar.Z  解压tar.Z
- unrar e file.rar 解压rar
- unzip file.zip 解压zip



总结

1. *.tar 用 tar –xvf 解压
2. *.gz 用 gzip -d或者gunzip 解压
3. *.tar.gz和*.tgz 用 tar –xzf 解压
4. *.bz2 用 bzip2 -d或者用bunzip2 解压
5. *.tar.bz2用tar –xjf 解压
6. *.Z 用 uncompress 解压
7. *.tar.Z 用tar –xZf 解压
8. *.rar 用 unrar e解压
9. *.zip 用 unzip 解压

 

 

linux下最常用的打包程序就是tar了，使用tar程序打出来的包我们常称为tar包，tar包文件的命令通常都是以.tar结尾的。生成tar包后，就可以用其它的程序来进行压缩。

1．命令格式：

tar[必要参数][选择参数][文件] 

2．命令功能：

用来压缩和解压文件。tar本身不具有压缩功能。他是调用压缩功能实现的 

3．命令参数：

必要参数有如下：

-A 新增压缩文件到已存在的压缩

-B 设置区块大小

-c 建立新的压缩文件

-d 记录文件的差别

-r 添加文件到已经压缩的文件

-u 添加改变了和现有的文件到已经存在的压缩文件

-x 从压缩的文件中提取文件

-t 显示压缩文件的内容

-z 支持gzip解压文件

-j 支持bzip2解压文件

-Z 支持compress解压文件

-v 显示操作过程

-l 文件系统边界设置

-k 保留原有文件不覆盖

-m 保留文件不被覆盖

-W 确认压缩文件的正确性

可选参数如下：

-b 设置区块数目

-C 切换到指定目录

-f 指定压缩文件

--help 显示帮助信息

--version 显示版本信息

4．常见解压/压缩命令

tar 
解包：tar xvf FileName.tar
打包：tar cvf FileName.tar DirName
（注：tar是打包，不是压缩！）


.gz
解压1：gunzip FileName.gz
解压2：gzip -d FileName.gz
压缩：gzip FileName

.tar.gz 和 .tgz
解压：tar zxvf FileName.tar.gz
压缩：tar zcvf FileName.tar.gz DirName

.bz2
解压1：bzip2 -d FileName.bz2
解压2：bunzip2 FileName.bz2
压缩： bzip2 -z FileName

.tar.bz2
解压：tar jxvf FileName.tar.bz2
压缩：tar jcvf FileName.tar.bz2 DirName

.bz
解压1：bzip2 -d FileName.bz
解压2：bunzip2 FileName.bz
压缩：未知

.tar.bz
解压：tar jxvf FileName.tar.bz
压缩：未知

.Z
解压：uncompress FileName.Z
压缩：compress FileName

.tar.Z
解压：tar Zxvf FileName.tar.Z
压缩：tar Zcvf FileName.tar.Z DirName

.zip
解压：unzip FileName.zip
压缩：zip FileName.zip DirName

.rar
解压：rar x FileName.rar
压缩：rar a FileName.rar DirName 

 

5．使用实例

实例1：将文件全部打包成tar包

命令：

tar -cvf log.tar log2012.log

tar -zcvf log.tar.gz log2012.log

tar -jcvf log.tar.bz2 log2012.log



### 数据库

#### MySQL

1、ResultSet中记录行的第一列索引为____   1;

2、SQL的创建 

```
#方式一
Statement sta=con.createStatement();
ResultSet rst=sta.executeQuery(“select * from book”);

#方式二
PreparedStatement pst=con.prepareStatement(“select * from book”);
ResultSet rst=pst.executeQuery();
```

```
Statement sta=con.createStatement();ResultSet rst=sta.executeQuery(“select * from book”);
PreparedStatement pst=con.prepareStatement(“select * from book”);
ResultSet rst=pst.executeQuery();
```

3、某打车公司将驾驶里程（drivedistanced）超过5000里的司机信息转移到一张称为seniordrivers 的表中,他们的详细情况被记录在表drivers 中，正确的sql为（）

```sql
select * into seniordrivers from drivers where drivedistanced >=5000
```

4、 如果ORDER BY子句后未指定ASC或DESC，默认使用以下哪个？      答案：ASC

5、 关系模式如R=({A,B,C,D,E},{AB→CE,E→AB,C→D})属于第几范式（） 

```
1NF
2NF
3NF
4NF
```

```
解释：E——AB，又AB——CE，所以E——C；又c——D，所以E——D；
得E决定AB、C、D。一个表只有一个列为主键==》2NF
```

6、SQL题

![](../../image/SQL题20200113.png)

```sql
#建表SQL
CREATE TABLE tt_tmp(gt VARCHAR(255),result VARCHAR(255));

#查询SQL1
SELECT gt, SUM(CASE WHEN result='S' THEN 1 ELSE 0 END)'success',
SUM(CASE WHEN result='F' THEN 1 ELSE 0 END)'failure' FROM tt_tmp GROUP BY gt;
#查询SQL2
SELECT s.gt,s.success,f.failure FROM
(SELECT gt,COUNT(*) AS 'success' FROM tt_tmp WHERE result='S'GROUP BY gt) s,
(SELECT gt,COUNT(*) AS 'failure' FROM tt_tmp WHERE result='F'GROUP BY gt) f WHERE  s.gt=f.gt
#查询SQL3
SELECT s.gt,s.success,f.failure FROM
(SELECT gt,COUNT(*) AS 'success' FROM tt_tmp WHERE result='S'GROUP BY gt) AS s INNER JOIN
(SELECT gt,COUNT(*) AS 'failure' FROM tt_tmp WHERE result='F'GROUP BY gt) AS f
ON s.gt=f.gt

```

7、 mysql数据库，game_order表表结构如下，下面哪些sql能使用到索引（BCDE）？ 

![](../../image/MySql索引的使用.png)

```mysql
A.select * from game_order where plat_game_id=5 and plat_id=134
B.select * from game_order where plat_id=134 and plat_game_id=5 and plat_order_id=’100’
C.select * from game_order where plat_order_id=’100’
D.select * from game_order where plat_game_id=5 and plat_order_id=’100’ and plat_id=134
E.select * from game_order where plat_game_id=5 and plat_order_id=’100’
```

解释： 带头大哥不能死，中间兄弟不能断！ 

```
这道题目想考察的知识点是MySQL组合索引（复合索引）的最左优先原则。最左优先就是说组合索引的第一个字段必须出现在查询组句中，这个索引才会被用到。只要组合索引最左边第一个字段出现在Where中，那么不管后面的字段出现与否或者出现顺序如何，MySQL引擎都会自动调用索引来优化查询效率。
根据最左匹配原则可以知道B-Tree建立索引的过程，比如假设有一个3列索引(col1,col2,col3),那么MySQL只会会建立三个索引(col1),(col1,col2),(col1,col2,col3)。
所以题目会创建三个索引（plat_order_id）、（plat_order_id与plat_game_id的组合索引）、（plat_order_id、plat_game_id与plat_id的组合索引）。根据最左匹配原则，where语句必须要有plat_order_id才能调用索引（如果没有plat_order_id字段那么一个索引也调用不到），如果同时出现plat_order_id与plat_game_id则会调用两者的组合索引，如果同时出现三者则调用三者的组合索引。
题目问有哪些sql能使用到索引，个人认为只要Where后出现了plat_order_id字段的SQL语句都会调用到索引，只不过是所调用的索引不同而已，所以选BCDE。如果题目说清楚是调用到三个字段的复合索引，那答案才是BD。
```



































#### Redis

 1、关于redis下面说法错误的是（B） 

```
A	Redis主要消耗内存资源
B	Redis集群使用一致性hash       X       
C	Redis集群之间是异步复制的
D	分区可以让Redis管理更大的内存
```

解释： *Redis Cluster*在设计中没有*使用一致性哈希*(Consistency *Hashing*),而是使用数据分片引入哈希槽(*hash* slot)来实现 





### 智力题

1、 编号为1至10个果盘中，每盘都盛有水果，共盛放100个。其中第一盘里有16个，并且编号相邻的三个果盘中水果数的合都相等，求第8盘中水果最多可能有几个？ 

解答：

2、有一次数学比赛，共有A，B和C三道题目。所有人都至少解答出一道题目，总共有25人。在没有答出A的人中，答出B的人数是答出C的人数的两倍；单单答出A的人，比其他答出A的人总数多1；在所有只有答出一道题目的人当中，答出B和C的人数刚好是一半。

求只答出B的人数。    6人

