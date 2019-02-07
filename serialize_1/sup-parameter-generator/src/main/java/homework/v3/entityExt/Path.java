package homework.v3.entityExt;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Path  implements Externalizable {
    
    public static final long SerialVersionUID = 1L;
    
    private String code;
    private String value;



    public Path(){}
    public Path(String code, String value){
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(code);
        objectOutput.writeObject(value);
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        code = (String) objectInput.readObject();
        value = (String) objectInput.readObject();
    }
}
