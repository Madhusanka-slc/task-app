package lk.ijse.dep9.app.entity;

import lombok.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "taskSet")
@EqualsAndHashCode(exclude = "taskSet")
public class Project implements SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//dbms generated
    private int id;
    @Column(nullable = false)
    private String name;
//    @Column(nullable = false)
    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username",nullable = false)
    private User user;

    @OneToMany(mappedBy = "project",fetch = FetchType.EAGER,cascade = {CascadeType.REMOVE})
    @Setter(AccessLevel.NONE)
    private Set<Task> taskSet=new HashSet<>();

    public Project(String name, User user) {
        this.name = name;
        this.user = user;
    }

}
