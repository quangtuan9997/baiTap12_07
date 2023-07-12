package baitap12t7.model.entity;

import lombok.Builder;
import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    @Id
    private String id;
    private String name;
    private String desciption;

    public Role() {
    }

    public Role(String id, String name, String desciption) {
        this.id = id;
        this.name = name;
        this.desciption = desciption;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }
}
