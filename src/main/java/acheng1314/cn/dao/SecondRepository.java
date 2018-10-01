package acheng1314.cn.dao;

import acheng1314.cn.domain.SecondMongoObject;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SecondRepository extends MongoRepository<SecondMongoObject, String> {

}
