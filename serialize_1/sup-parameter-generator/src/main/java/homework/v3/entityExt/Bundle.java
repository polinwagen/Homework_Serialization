package homework.v3.entityExt;
import java.io.*;
import java.util.List;

public class Bundle implements Externalizable {
    
    public static final long SerialVersionUID = 1L;
    
    private List<Path> path;
    private List<String> values;
    public Bundle(){}


    public Bundle(List<Path> path, List<String> values){
        this.path = path;
        this.values = values;
    }


    public List<Path> getPath() {
        return path;
    }
    public void setPath(List<Path> path) {
        this.path = path;
    }

    public List<String> getValues() {
        return values;
    }
    public void setValues(List<String> values) {
        this.values = values;
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(path);
        objectOutput.writeObject(values);
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        path = (List<Path>)objectInput.readObject();
        values = (List<String>) objectInput.readObject();

    }
}

