package acheng1314.cn.config;

import lombok.Data;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *  加载数据源配置对象MultipleMongoProperties
 */
@Data
//@ConfigurationProperties(prefix = "mongodb")
@ConfigurationProperties(prefix = "spring.data.mongodb")
public class MultipleMongoProperties {

    private MongoProperties primary = new MongoProperties();
    private MongoProperties secondary = new MongoProperties();


    public MongoProperties getPrimary() {
        return primary;
    }

    public MongoProperties getSecondary() {
        return secondary;
    }
}
