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

    
    
 

    
    