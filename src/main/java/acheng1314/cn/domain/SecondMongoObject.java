package acheng1314.cn.domain;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "second_mongo")
public class SecondMongoObject {
    @Id
    private String id;

    private String value;

    @Override
    public String toString() {
        return "SecondMongoObject{" + "id='" + id + '\'' + ", value='" + value + '\''
                + '}';
    }
}
