package homework.v3.entityExt;

import java.io.*;

/**
 * Например, ADMIN/USER/SUPER_VISOR & etc
 * */
public class Role implements Externalizable {
    
    public static final long SerialVersionUID = 1L;
    private String role;

    Role(){}
    public Role(String role){
        this.role=role;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(role);
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        role = (String) objectInput.readObject();
    }
}
