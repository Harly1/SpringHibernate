package model;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long   id;

    @Column(name = "login", unique = true)
    private String login;

    @Column(name = "password", unique = false)
    private String password;

    @Column(name = "role", unique = false)
    private String role;

    public User(long id, String login, String password, String role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }



}
