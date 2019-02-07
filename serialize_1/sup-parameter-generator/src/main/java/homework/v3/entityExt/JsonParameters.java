package homework.v3.entityExt;

import org.codehaus.jackson.annotate.JsonPropertyOrder;

import java.io.Externalizable;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.List;

@JsonPropertyOrder({"name", "description", "isList", "roles", "type", "bundle"})
public class JsonParameters implements Externalizable {
    
    public static final long SerialVersionUID = 1L;
    
    private String name;
    private String description = "";
    private boolean isList;
    private List<String> roles;
    private String type;
    private List<Bundle> bundle;


    public JsonParameters(){}

    public JsonParameters(String name, String description, boolean isList, List<String> roles, String type, List<Bundle> bundle){
        this. name= name;
        this.description = description;
        this.isList = isList;
        this.roles = roles;
        this.type = type;
        this.bundle = bundle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getisList() {
        return isList;
    }

    public void setList(boolean isList) {
        this.isList = isList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Bundle> getBundle() {
        return bundle;
    }

    public void setBundle(List<Bundle> bundle) {
        this.bundle = bundle;
    }

    @Override
    public String toString() {

        String s = "";
        for (String s1: roles){
            s += s1;
        }

        return  name + "\n" +
                description + "\n" +
                isList + "\n" +
                type + "\n" +
                bundle + "\n" +
                s;

    }

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(name);
        objectOutput.writeObject(description);
        objectOutput.writeObject(isList);
        objectOutput.writeObject(roles);
        objectOutput.writeObject(type);
        objectOutput.writeObject(bundle);
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {

        name = (String) objectInput.readObject();
        description = (String) objectInput.readObject();
        isList = (Boolean) objectInput.readObject();
        roles = (List<String>) objectInput.readObject();
        type = (String) objectInput.readObject();
        bundle= (List<Bundle>) objectInput.readObject();
    }
}
