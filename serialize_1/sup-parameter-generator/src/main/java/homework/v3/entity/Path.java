package homework.v3.entity;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;

public class Path  implements Serializable {
    
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
}
