package homework.v3;

import homework.v3.entityExt.JsonFileClass;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class JsonParameterExternalizableWriter {

    public void customWriterExt (JsonFileClass parameters, String fileName) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileName)){
            try (ObjectOutputStream oos = new ObjectOutputStream(fos);){
                oos.writeObject(parameters);
            }
        }
    }

}
