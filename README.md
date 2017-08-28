startDate:2017-08-22 
--------------------------------------------------
#### Chapter 01 Intro to Design Patterns 第01章 设计模式入门
 
##### 1. Design Principle Identify the aspects of your application that vary and separate them from what stays the same.  (P9)
设计原则：找出应用中可能需要变化之处，把它们独立出来，不要和那些不需要变化的代码混在一起。
[参考链接](https://github.com/FreshStudent/HeadFirstDesignPatternsTest/blob/master/src/bookCode/ch1/part1/ch1_part1.md)

##### 2. Design Principle Program to an interface, not an implementation. (P11)
设计原则：针对接口编程，而不是针对实现编程。
[参考链接](https://github.com/FreshStudent/HeadFirstDesignPatternsTest/blob/master/src/bookCode/ch1/part2/ch1_part2.md)

##### 3. Design Principle Favor composition over inheritance.   (P23)
设计原则：多用组合，少用继承。

##### 4. The Strategy Pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it.  (P24）
策略模式：定义了算法族，分别封装起来，让它们之间可以互相替换，此模式让算法的变化独立于使用算法的客户。

-------------------------------------------------- 
 
#### Chapter 02 the observer pattern 第02章 观察者模式
 
##### 1. The Observer Pattern defines a one-to-many dependency between objects so that one object change state,all of its dependents are notified and updated automatically.   (P51)
观察者模式：定义了对象之间的一对多依赖，这样一来，当一个对象改变状态时，它的所有依赖者都会收到通知并自动更新。

##### 2. Design Principle Strive for loosely coupled designs between objects that interact.  (P53)
设计原则：为了交互对象之间的松耦合设计而努力。

##### 3. Loosely coupled designs allow use to build flexible OO systems that can handle change because they minimize the interdependency between objects. (P53)
松耦合的设计之所以能让我们建立有弹性的OO系统，能够应对变化，是因为对象之间的互相依赖降到了最低。
[参考链接·ch2_part1](https://github.com/FreshStudent/HeadFirstDesignPatternsTest/blob/master/src/bookCode/ch2/part2/ch2_part1.md)
[参考链接·ch2_part2](https://github.com/FreshStudent/HeadFirstDesignPatternsTest/blob/master/src/bookCode/ch2/part2/ch2_part2.md)
 
-------------------------------------------------- 
 
#### Chapter 03 the decorator pattern 第03章 装饰者模式
 
##### 1. Design Principle Classes should be open for extension, but closed for modification.  (P86)
设计原则：类应该对扩展开放，对修改关闭。

##### 2. Be careful when choosing the areas of code that need to be extended; applying the Open-Closed Principle EVERYWHERE is wasteful, unnecessary, and can lead to complex, hard to understand code. (P87)
在选择需要被扩展的代码部分时需要小心。每个地方都采用 开放-关闭 原则是一种浪费，也没必要，还会导致代码变得复杂而且难以理解。

##### 3. The Decorator Pattern attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.        (P91)
装饰者模式：动态地将责任附加到对象上。若要扩展功能，装饰者提供了比继承更有弹性的替代方案。

##### 4. But Java I/O also points out one of the downsides of the Decorator Pattern: designs using this pattern often result in a large number of small classes that can be overwhelming to a developer trying to use the Decorator-based API. (P101)
但是java I/O 也引出装饰者模式的一个“缺点”：利用装饰者模式，常常造成设计中有大量的小类，数量实在太多，可能会造成使用此API程序员的困扰。
 
-------------------------------------------------- 
 
#### Chapter 04 the factory pattern 第04章 工厂模式
 
##### 1. The Factory Method Pattern defines an interface for creating an object,but lets subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses. (P134)
工厂方法模式：定义了一个创建对象的接口，但由子类决定要实例化的是哪一个。工厂方法让类把实例化推迟到子类。

#####2. Design Principle Depend upon abstractions. Do not depend upon concrete classes. (P139)
设计原则：要依赖抽象，不要依赖具体类。

##### 3. The Abstract Factory Pattern provides an interface for creating families related or dependent objects without specifying their concrete classes. (P156)
抽象工厂模式：提供一个接口，用于创建相关或依赖对象的家族，而不需要明确指定具体类。

##### 4. The intent of Factory Method is to allow a class to defer instantiation to its subclasses. (P162)
工厂方法允许类将实例化延迟到子类进行。

##### 5. The intent of Abstract Factory is to create families of related objects without having to depend on their concrete classes.        (P162)
抽象工厂创建相关的对象家族，而不需要依赖它们的具体类。
 
--------------------------------------------------
 
#### Chapter 05 the singleton pattern 第05章 单例模式

##### 1. The Singleton Pattern ensures a class has only one instance, and provides a global point of access to it. (P177)
单例模式：确保一个类只有一个实例，并提供一个全局访问点。

--------------------------------------------------
 
#### Chapter 06 the command pattern 第06章 命令模式
 
##### 1. The Command Pattern encapsulates a request as an object, thereby letting you parameterize other objects with different requests, queue or log requests, and support undoable operations. (P206)
命令模式：将“请求”封装成对象，以便使用不用的请求、队列或者日志来参数化其他对象。命令模式也支持可撤销的操作。

##### 2. The Command Pattern decouples an object making a request from one that knows how to perform it. (P230)
命令模式将发出请求的对象和执行请求的对象解耦。
 
-------------------------------------------------- 
 
#### Chapter 07 the Adapter and Facade Patterns 第07章 适配器模式与外观模式
 
##### 1. Here's how the client uses the Adapter     (P241)
- 1.1 The client makes a request to the adapter by calling a method on it using the target interface.
- 1.2 The adapter translates that request into one or more calls on the adaptee using the adaptee interface.
- 1.3 The client receives the result of the call and never knows there is an adapter doing the translation.

客户使用适配器的过程如下：

- 1.1 客户通过目标接口调用适配器的方法对适配器发出请求。
- 1.2 适配器使用被适配者接口把请求转换成被适配者的一个或多个调用接口。
- 1.3 客户接收到调用的结果，但未察觉这一切是适配器在起转换作用

##### 2. The Adapter Pattern converts the interface of a class into another interface the clients expect. Adapter lets classes work together that couldn't otherwise because of incompatible interfaces. (P243)
适配器模式：将一个类的接口，转换成客户期望的另一个接口，适配器让原本接口不兼容的类可以合作无间。

##### 3. A facade not only simplifies an interface, it decouples a client from a subsystem of components. (P260)
外观模式不只是简化了接口，也将客户从组件的子系统中解耦。

##### 4. Facades and adapters may wrap multiple classes, but a facade's intent is to simplify, while an adapter's is to convert the interface to something different. (P260)
外观和适配器可以包装许多类，但是外观的意图是简化接口，而适配器的意图是将接口转换成不同接口。

##### 5. The Facade Pattern provides a unified interface to a set of interfaces inn a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use. (P264)
外观模式：提供了一个统一的接口，用来访问子系统中的一群接口。外观定义了一个高层接口，让子系统更容易使用。

##### 6. Design Principle Principle of Least Knowledge - talk only to your immediate friends. (P265)
设计原则：最少知识原则，只和你的密友谈话。

##### 7. The principle tells us that we should only invoke methods that belong to: (P266)
     The object itself
     Objects passed in as a parameter to the method
     Any object the method creates or instantiates
     Any components of the object
这个原则告诉我们应该调用以下方法：
     对象本身
     被当作方法的参数而传递进来的对象
     此方法所创建或实例化的任何对象
     对象的所有组件

--------------------------------------------------
 
#### Chapter 08 the template method Pattern 第08章 模版方法模式
 
##### 1. The Template Method defines the steps of an algorithm and allows subclasses to provide the implementation for one or more steps. (P286)
模版方法定义了一个算法的步骤，并允许子类为一个或多个步骤提供实现。

##### 2. The Template Method Pattern defines the skeleton of an algorithm in a method, deferring some stepss to subclasses. Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure. (P289)
模版方法模式：在一个方法中定义一个算法的骨架，而将一些步骤延迟到子类中。模版方法使得子类可以在不改变算法结构的情况下，重新定义算法中的某些步骤。

##### 3. The Hollywood Principle Don't call us, we'll call you.  (P296)
好莱坞原则：别调用我们，我们会调用你。

--------------------------------------------------
 
#### Chapter 09 the iterator and  composite pattern第09章 迭代器与组合模式

##### 1. The Iterator Patternprovides a way to access the eleemnts of an aggregate object sequentially without exposing its underlying respresentation.  (P336)
迭代器模式 提供一种方法顺序访问一个聚合对象中的各个元素，而又不暴露其内部的表示。

##### 2. Design Principle :  A class should have only one reason to change.  (P339)
设计原则： 一个类应该只有一个引起变化的原因。

##### 3. The Composite Pattern allows you to compose objects into tree structures to represent part-whole hierarchies. Composite lets clients treat individual objects and compositions of objects uniformly. (P356)
组合模式：允许你将对象组合成树形结构来表现“整体/部分”层次结构。组合能让客户以一致的方式处理个别对象以及对象组合。

##### 4. The Composite Pattern allows us to build structures of objects in the form of trees that contain both compositions of objects and individual objects as nodes. (P357)
组合模式让我们能用树形方式创建对象的结构，树里面包含了组合以及个别的对象。

##### 5. Using a composite structure, we can apply the same operations over both composites and individual objects. In other words, in most cases we can ignore the differences between compositions of objects and individual objects. (P357)
使用组合结构，我们能把相同的操作应用在组合和单独的对象上。换句话说，在大多数情况下，我们可以忽略对象组合和单独对象之间的差别。
 
--------------------------------------------------
 
#### Chapter 10 the State Pattern 第10章 状态模式
 
##### 1. The State Pattern allows an object to alter its behavior when its internal state changes. The object will appear to change its class. (P410)
状态模式:允许对象在内部状态改变时改变它的行为，对象看起来好像修改了它的类。

--------------------------------------------------
 
#### Chapter 11 the proxy pattern第11章 代理模式

##### 1. By invoking methods on the proxy, a remote call is made across the wire and a String, an integer and a State object are returned. Because we are using a proxy, the GumballMonitor doesn't know, or care, that calls are remote(other than having to worry about remote exceptions). (P457)
通过调用代理的方法，远程调用可以跨过网络，返回字符串、整数和State对象。因为我们使用的是代理，调用的方法会在远程执行，GumallMonitor根本就不知道/或不在于这一点（唯一要操心的是：要处理远程异常）。

##### 2. The Proxy Pattern provides a surrogate or placeholder for another object to control access to it. (P460)
代理模式：为另一个对象提供一个替身或占位符以控制对这个对象的访问。

##### 3. Use the Proxy Pattern to create a representative object that controls access to another object, which may be remote, expensive to create or in need of securing. (P460)
使用代理模式创建代表对象，让代表对象控制某对象的访问，被代理的对象可以是远程的对象、创建开销大的对象或需要安全控制的对象。

--------------------------------------------------
 
#### Chapter 12 Compound Patterns 第12章 复合模式
 
##### 1. Patterns are often used together and combined within the same design solution. (P500)
模式通常被一起使用，并被组合在同一个设计解决方案中。

##### 2. A compound pattern combines two or more patterns into a solution that solves a recurring or general problem. (P500)
符合模式在一个解决方案中结合两个或多个模式，以解决一般或重复发生的问题。