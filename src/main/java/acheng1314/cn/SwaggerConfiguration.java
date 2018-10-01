package acheng1314.cn;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**教学地址：http://blog.didispace.com/springbootswagger2/
 1.创建Swagger2配置类
 2.在Application.java同级创建Swagger2的配置类Swagger2。
 3.通过@Configuration注解，让Spring来加载该类配置。再通过@EnableSwagger2注解来启用Swagger2。
 */

/**
 * 再通过createRestApi函数创建Docket的Bean之后，
 * apiInfo()用来创建该Api的基本信息（这些基本信息会展现在文档页面中）。
 * select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现，
 * 本例采用指定扫描的包路径来定义，
 * Swagger会扫描该包下所有Controller定义的API（@ApiOperation注解来给API增加说明、通过@ApiImplicitParams、@ApiImplicitParam注解来给参数增加说明。）
 * 并产生文档内容（除了被@ApiIgnore指定的请求）
 */

/**注意：
 *  SwaggerConfiguration 配置类流程
 *  1.添加Swagger2依赖
 *  2.在Application.java同级创建Swagger2的 配置类Swagger2。*/

@Configuration    //加载配置咯，1.通过@Configuration注解，让Spring来加载该类配置
@EnableSwagger2   //启动Swagger2 ,快递来开箱咯 , 2.再通过@EnableSwagger2注解来启用Swagger2。
public class SwaggerConfiguration {
                 //3.再通过createRestApi函数创建Docket的Bean之后，apiInfo()用来创建该Api的基本信息
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)  //Docket，Springfox的私有API设置初始化为Swagger2
                //select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现，
                // 本例采用指定扫描的包路径来定义，Swagger会扫描该包下所有Controller定义的API，并产生文档内容
                .select()
                .paths(PathSelectors.any())
                .build()
                //设置API文档的主体说明
                .apiInfo(new ApiInfoBuilder()
                        .title("SpringBoot探索之路ApiDocs")
                        .description("SpringBoot探索之路")
                        .version("v1.01")
                        .termsOfServiceUrl("http://asbook.com/").build());
    }
                //引入包是springfox.documentation.service.ApiInfo;
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("更多Spring Boot相关文章请关注：http://blog.didispace.com/")
                .termsOfServiceUrl("http://blog.didispace.com/")
                .contact("哈哈君")
                .version("1.1")
                .build();
    }
    /**在完成了上述配置后，其实已经可以生产文档内容，但是这样的文档主要针对请求本身，
    而描述主要来源于函数等命名产生，对用户并不友好，我们通常需要自己增加一些说明来丰富文档内容。
     */
}
