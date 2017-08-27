## Chapter 02 the observer pattern 第02章 观察者模式
 
**ch2.part1**
 
### 1. The Observer Pattern defines a one-to-many dependency between objects so that one object change state,all of its dependents are notified and updated automatically.   (P51)
观察者模式：定义了对象之间的一对多依赖，这样一来，当一个对象改变状态时，它的所有依赖者都会收到通知并自动更新。

> 简单来说，有点类似微博的过程，关注某个大V后，大V更新的状态会推送到我们的微博首页，简单理解。
> 
>


---

### 今天要做一个天气预报的系统，不同的展示板都需要及时获取气象中心发布的天气信息。

### 相关类UML图：
![类UML图](https://github.com/FreshStudent/HeadFirstDesignPatternsTest/blob/master/src/bookCode/ch2/part1/ch2_part1UML.png)
先摆一个类图，然后说明大概的代码思路，采用倒叙的方式来写，然后贴上关键代码！！
