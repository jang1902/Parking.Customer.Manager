package core.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @Column
    @NonNull
    private String fullname;

    @Column(unique = true)
    private String phone_number;

    @Column
    private String address;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String identity;

    @OneToMany(mappedBy = "user")
    private List<Vehicle> vehicles;
}
