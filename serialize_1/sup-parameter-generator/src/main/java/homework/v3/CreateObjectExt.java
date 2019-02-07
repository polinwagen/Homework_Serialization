package homework.v3;

import homework.v3.entityExt.JsonParameters;
import homework.v3.entityExt.Bundle;
import homework.v3.entityExt.JsonFileClass;
import homework.v3.entityExt.Path;
import java.util.ArrayList;

public class CreateObjectExt {
    public  static JsonFileClass fileClass = new JsonFileClass();

    public static JsonFileClass  fillObjectExt(int i) {

        ArrayList<String> listStrings = new ArrayList<String>();
        ArrayList<Path> paths = new ArrayList<Path>();
        ArrayList<Bundle> bundles = new ArrayList<Bundle>();
        ArrayList<JsonParameters> parameters = new ArrayList<JsonParameters>();

        for(int j = 0 ; j <= i ;  j++ ){
            paths.add(new Path(Integer.toString(i), "value " + i));
            listStrings.add("value " + i);
            bundles.add(new Bundle(paths, listStrings));
            parameters.add(new JsonParameters("name " + i, "description " + i, true, listStrings, "type", bundles));
        }
        fileClass = new JsonFileClass("1.2", parameters);


        return fileClass;
    }

    public JsonFileClass getFileClassExt() {
        return this.fileClass;
    }



}
