package mx.com.plantilla.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by dzuniga on 13/04/2018.
 */
@Entity
@Table(name="Usuarios")
@JsonIgnoreProperties
public class Usuario implements Serializable {
    /** Identificador único del registro.  */
    @Id
    @Column(name="usuario_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    /** Usuario. */
    @Column(name="usuario_nombre", updatable = false)
    private String username;

    /** Password del Usuario. */
    @Column(name="usuario_password")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
