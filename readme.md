# MySpringBoot
  2018-02-05----
  声明：资料仅供学习使用，严禁任何商业用途。造福学者，做一个无声的媒介。
  很开心，有好的资料，好的项目代码供我学习参考，非常感谢很多无私奉献的教程，
  你们的殷勤奉献，没齿难忘。
   1.项目教程地址：http://acheng1314.cn/front/post/412
   2.学习资料一：http://blog.csdn.net/ityouknow/article/details/70139667
   后续待更新，
   2018-02-07----
   理解 shiro
   Shiro的核心部分是SecurityManager，它负责安全认证与授权。Shiro本身已经实现了所有的细节，用户可以完全把它当做一个黑盒来使用。SecurityUtils对象，本质上就是一个工厂类似Spring中的ApplicationContext。Subject是初学者比较难于理解的对象，很多人以为它可以等同于User，其实不然。Subject中文翻译：项目，而正确的理解也恰恰如此。
   它是你目前所设计的需要通过Shiro保护的项目的一个抽象概念。通过令牌（token）与项目（subject）的登陆（login）关系，Shiro保证了项目整体的安全。
   框架解析：https://www.cnblogs.com/learnhow/p/5694876.html