package homework.v3.entity;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;

/**
 * Например, ADMIN/USER/SUPER_VISOR & etc
 * */
public class Role implements Serializable {
    
    public static final long SerialVersionUID = 1L;
    private String role;

    Role(){}
    Role(String role){
        this.role=role;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
