# TodoList(待办事项)

## 使用技术

* **[Vue2.x][Vue2.x]**
* **[VueX][VueX]**
* **[Vue Router][Vue Router]**
* **[Vue CLI][Vue CLI]**
* **[Bootstrap4.3.1][Bootstrap4.3.1]**
* **[Spring Boot 2.3.4][Spring Boot 2.3.4]**
* **[Oracle11g][Oracle11g]**

### [Vue2.x][Vue2.x]

Vue 是一套用于构建用户界面的**渐进式框架**。

使用原因/vue的特点：

* 可以自底向上逐层应用
* 易于上手
* 与第三方库有项目整合

### [VueX][VueX]

Vuex 是一个专为 Vue.js 应用程序开发的**状态管理模式**。它采用集中式存储管理应用的所有组件的状态，并以相应的规则保证状态以一种可预测的方式发生变化。

### [Vue Router][Vue Router]

Vue Router 是 [Vue.js](http://cn.vuejs.org/) 官方的路由管理器。它和 Vue.js 的核心深度集成，让构建单页面应用变得易如反掌。包含的功能有：

- 嵌套的路由/视图表
- 模块化的、基于组件的路由配置
- 路由参数、查询、通配符
- 基于 Vue.js 过渡系统的视图过渡效果
- 细粒度的导航控制
- 带有自动激活的 CSS class 的链接
- HTML5 历史模式或 hash 模式，在 IE9 中自动降级
- 自定义的滚动条行为

### [Vue CLI][Vue CLI]

Vue CLI是使用命令行方式进行开发。

* 功能丰富：对 Babel、TypeScript、ESLint、PostCSS、PWA、单元测试和 End-to-end 测试提供开箱即用的支持。

* 易于扩展：它的插件系统可以让社区根据常见需求构建和共享可复用的解决方案。

* 无需 Eject：Vue CLI 完全是可配置的，无需 eject。这样你的项目就可以长期保持更新了。

* CLI 之上的图形化界面：通过配套的图形化界面创建、开发和管理你的项目。

* 即刻创建原型：用单个 Vue 文件即刻实践新的灵感。

* 面向未来：为现代浏览器轻松产出原生的 ES2015 代码，或将你的 Vue 组件构建为原生的 Web Components 组件。

### [Bootstrap4.3.1][Bootstrap4.3.1]

Bootstrap是世界上最流行的前端开源工具包，具有Sass变量和mixin、响应式网格系统、广泛的预构建组件和强大的JavaScript插件，可以快速设计和定制响应式移动优先的站点。

使用原因/特点：

* 响应式的界面
* 丰富的组件库
* 栅格化布局系统

### [Spring Boot 2.3.4][Spring Boot 2.3.4]

Spring Boot其设计目的是用来简化新Spring应用的初始搭建以及开发过程。Spring Boot使得创建可以“直接运行”的独立的、生产级的基于Spring的应用程序变得很容易。

* 创建独立的Spring应用程序
* 直接嵌入Tomcat(不需要部署WAR文件)
* 提供自以为是的“启动器”依赖关系来简化构建配置
* 在可能的情况下自动配置Spring和第三方库
* 提供可用于生产的特性，如度量、运行状况检查和外部化配置
* 绝对不需要代码生成，也不需要XML配置

### [Oracle11g][Oracle11g]

Oracle 11g 为关系型数据库,g为Grid的缩写代表网格,即多台结点服务器利用高速网络组成一个虚拟的高性能服务器，负载在整个网格中均衡，提供分布式处理能力。

Oracle11g中将大量复杂的配置和部署进行简化，常见的操作过程自动化。

为什么使用/特性：

* 可管理性
  * 进行自动SQL优化
  * 自动内存优化
  * 资源管理器
  * SQL计划管理
  * SQL重演
  * 数据库重演，等
* PL/SQL新特性
  * 新的数据类型 simple_integer，执行效率更高
  * 继承性
  * 提高编译速度
  * 结果集缓存
  * 提高触发器执行效率
* 增强应用开发能力
  * 具有Java实时编译功能
  * 利用SQL Develop可以轻松建立查询，等
* 高可用性
  * Oracle11g扩展了闪回能力
  * 缩短数据库的升级时间
  * 热修补功能，不必关闭数据库就可以进行数据库修补，提高了系统的可用性。
  * 并行备份和恢复功能，可改善数据库的备份和存储性能。

#### 表结构

* TUSER表：

![](C:\Users\10365\todo\User.png)

* todolist表：

![](C:\Users\10365\todo\todolist.png)



#### 建表语句

* TUSER表:

> CREATE TABLE "HEHAO"."TBUSER" 
>    (	"ACCOUNT" NUMBER(*,0), 
> 	"USERNAME" VARCHAR2(255) NOT NULL ENABLE, 
> 	"PASSWORD" VARCHAR2(255) NOT NULL ENABLE, 
> 	 CONSTRAINT "SYS_C0011112" PRIMARY KEY ("ACCOUNT")
>   USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
>   STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
>   PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
>   TABLESPACE "booksystem"  ENABLE
>    ) SEGMENT CREATION IMMEDIATE 
>   PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
>   STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
>   PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
>   TABLESPACE "booksystem"

* TBTODO表：

 >CREATE TABLE "HEHAO"."TBTODO" 
  >(	"ID" NUMBER, 
  >	"ACCOUNT" NUMBER NOT NULL ENABLE, 
  >   	"TODONAME" VARCHAR2(255), 
  >	"STATUS" VARCHAR2(255) NOT NULL ENABLE, 
  >	 CONSTRAINT "SYS_C0011115" PRIMARY KEY ("ID")
  >USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  >STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  >  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  >  TABLESPACE "booksystem"  ENABLE
  >  ) SEGMENT CREATION IMMEDIATE 
  >  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  >   STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  >  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  >  TABLESPACE "booksystem" 
  >  ;
  >  
  > CREATE OR REPLACE TRIGGER "HEHAO"."TRTBTODO" 
  >
  >BEFORE INSERT ON TBTODO FOR EACH ROW  WHEN (new.ID is null) begin
  >
  >select SEQTODO.nextval into:new.ID from dual;
  >
  >end;
  >ALTER TRIGGER "HEHAO"."TRTBTODO" ENABLE

* 添加序列和触发器

> create sequence SEQBOOK
>
> minvalue 1
>
> nomaxvalue
>
> start with 1
>
> increment by 1
>
> nocycle
>
> cache 10;
>
> CREATE OR REPLACE TRIGGER TRTBBOOK
>
> BEFORE INSERT ON BOOK FOR EACH ROW WHEN (new.ID is null)
>
> begin
>
> select SEQBOOK.nextval into:new.ID from dual;
>
> end;
>
> DROP TRIGGER TRTBBOOK;
>
> DROP SEQUENCE SEQBOOK;
>

## 项目演示

### 进入cmd

```
windows + R 
cmd
```

### 切换路径

```
cd C:\Users\10365\Desktop\todoproject\todo-springboot\target
```

### 运行jar包

```
java -jar tbTodo-0.0.1-SNAPSHOT.jar
```

### 重启另一个cmd

```
windows + R 
cmd
```

### 切换路径

```
cd C:\Users\10365\Desktop\todoproject\todo
```

### 运行vue项目

```
npm run serve
```

### 进入链接

**http://localhost:8080/**

## 总结与收获

项目一开始使用的是MySQL进行数据存储，后来进行数据库的转换，使用了Oracle11g数据库。

收获有：

* 表名、字段应使用大写
* 表名、字段不能使用Oracle的关键字
* 设置主键自增时应该创建相应的序列和触发器

[Vue2.x]:https://cn.vuejs.org/v2/guide/
[VueX]: https://vuex.vuejs.org/zh/
[Vue Router]: https://router.vuejs.org/zh/
[Vue CLI]: https://cli.vuejs.org/zh/
[Bootstrap4.3.1]: https://getbootstrap.com/docs/5.0/getting-started/introduction/
[Spring Boot 2.3.4]: https://spring.io/projects/spring-boot
[Oracle11g]: https://www.oracle.com/database/technologies/