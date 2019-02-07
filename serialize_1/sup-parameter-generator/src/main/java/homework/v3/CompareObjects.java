package homework.v3;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;


import java.io.File;
import java.io.IOException;


public class CompareObjects {
    public static boolean CompareJson(String urlleft, String urlright) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        JsonNode tree1 = mapper.readTree(new File(urlleft));
        JsonNode tree2 = mapper.readTree(new File(urlright));

        return tree1.equals(tree2);


    }

}
