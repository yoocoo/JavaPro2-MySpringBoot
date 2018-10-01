package acheng1314.cn.dao;

import acheng1314.cn.domain.Menu;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MenuDao extends MongoRepository<Menu,Long> {

    default void saveUser(Menu menu) {

    }

}
