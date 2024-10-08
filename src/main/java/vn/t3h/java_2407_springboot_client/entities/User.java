package vn.t3h.java_2407_springboot_client.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "user")
@Data

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 25)
    private String username;

    @Column(nullable = false, length = 32)
    private String password;

    private String fullname;

    private String email;

    private String phoneNumber;

    private Boolean gender;

    private String address;

    private String role;

    @OneToMany(mappedBy = "user")
    private List<Cart> carts;
}
