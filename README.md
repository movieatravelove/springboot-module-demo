### SpringBoot2 多模块工程脚手架

     SpringBoot升级为2.0   
     使用MyBatis Plus 分页更友好
     Lombok 集成，ide需要安装lombok插件，自行百度
     alibaba.druid 数据库连接池 项目中可结合aop快速实现多数据源
      
          
### api
     
     SpringBoot基础工程，可以在此基础上再扩展
     
     该工程技术栈：
         Swagger 自动api文档，无缝切换knife4j
         SpringAop + druid实现多数据源注解
         统一异常链接
         定时任务
         http://127.0.0.1:8081/swagger-ui.html
         http://127.0.0.1:8081/doc.html
                      
### web
     
     结合shiro实现权限认证，与redis搭配使用可以实现session保持，服务重启后用户无需二次登录。
     适合实现基于浏览器的网站或后台管理系统
     
     该工程技术栈：
         Swagger 自动api文档，无缝切换knife4j
         SpringAop + druid实现多数据源注解
         统一异常链接
         定时任务
         http://127.0.0.1:8082/swagger-ui.html
         http://127.0.0.1:8082/doc.html
     
### common
      
      公共模块  

   
### 注意事项
    
    添加新模块
    
    1. 工程右键 -> new -> Module
    2. 在主工程的pom文件中添加  <module>新工程名</module>
    3. 在子工程的pom文件中添加  <parent></parent>
    
    
### 启动报错原因
    
    配置
    
    ```
    Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.
    ```
    翻译就是：无法配置DataSource：未指定'url'属性，也无法配置嵌入数据源。
    
    1. 就是说在你的项目配置文件中没有引入datasource的相关属性，例如：地址值、数据库驱动、用户名、密码等。
                 
    2。 也可以不配置，启动类声明头部就可：                 
    @SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})                                     
     
     3. 还有一种错误，就是pom.xml里导入了其它工程的依赖，然后这个其它工程的pom.xml里有需要配置dataSource数据源的依赖，
     解决办法就是在当前工程导入其他工程依赖时，把其它工程里需要配置dataSource的依赖给exclude掉                          
    <dependency>
        <groupId>com.xuecheng</groupId>
        <artifactId>xc-framework-model</artifactId>
        <version>0.0.1-SNAPSHOT</version>
        <exclusions>
            <exclusion>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-data-jpa</artifactId>
            </exclusion>
        </exclusions>
    </dependency>
    
    
    
    
    
    1.DataSourceAutoConfiguration会自动加载.
    @SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
    
    2. 没有配置spring - datasource - url 属性.
    spring:
      datasource:
        url: jdbc:mysql://localhost:3306/read_data?useUnicode=true&characterEncoding=UTF-8&useSSL=false
        username: root
        password: 123456
        driver-class-name: com.mysql.jdbc.Driver
        
    3. spring - datasource - url 配置的地址格式有问题.
    
    4. 配置 spring - datasource - url的文件没有加载.
    <resources>
        <resource>
            <directory>src/main/java</directory>
            <includes>
                <include>**/*.yml</include>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>false</filtering>
        </resource>
        <resource>
            <directory>src/main/resources</directory>
            <includes>
                <include>**/*.yml</include>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>false</filtering>
        </resource>
    </resources>

 

    
    