package vn.techmaster.demorelationship.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="tag")
@Table(name="tag")
@Data
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @JsonBackReference
    @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
    List<Product> products = new ArrayList<>();

    public Tag() {
    }
    public Tag(String name) {
        this.name = name;
    }
}
