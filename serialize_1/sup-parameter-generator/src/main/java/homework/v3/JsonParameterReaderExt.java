package homework.v3;

import homework.v3.entityExt.JsonFileClass;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonParameterReaderExt {
        public static JsonFileClass read(String url) throws IOException {
            ObjectMapper mapper = new ObjectMapper();
            final JsonFileClass fileClassExt = mapper.readValue(new File(url), JsonFileClass.class);
            return fileClassExt;
        }
}
