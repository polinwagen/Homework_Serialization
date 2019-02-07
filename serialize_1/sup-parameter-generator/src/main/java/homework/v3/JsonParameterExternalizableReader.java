package homework.v3;

import homework.v3.entityExt.JsonFileClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class JsonParameterExternalizableReader {

    public JsonFileClass customReaderExt (String filename) throws IOException, ClassNotFoundException {
        try (FileInputStream fos = new FileInputStream(filename)){
            try (ObjectInputStream oos = new ObjectInputStream(fos)){
                return (JsonFileClass)oos.readObject();
            }
        }

    }
}
