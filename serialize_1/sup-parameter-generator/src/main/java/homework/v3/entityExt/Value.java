package homework.v3.entityExt;

import java.io.Serializable;

public class Value implements Serializable {
    
    public static final long SerialVersionUID = 1L;
    
    private String value;

    Value(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
