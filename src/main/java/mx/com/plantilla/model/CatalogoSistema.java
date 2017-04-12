package mx.com.plantilla.model;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by dzuniga on 15/03/2017.
 */
@Entity
@Table(name = "CATALOGOSISTEMA")
public class CatalogoSistema implements Serializable {
    /** Identificador único del registro.  */
    @Id
    @Column(name="CATSIS_ID", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    /** Clave única de identificación del CatalogoSistema. */
    @NotNull
    @Length(max = 50)
    @Column(name="CATSIS_CODIGO")
    private String codigo;

    /** Descripción detallada del CatalogoSistema. */
    @NotNull
    @Length(max = 200, min = 4)
    @Column(name="CATSIS_DESCRIPCION")
    private String descripcion;

    /** Descripción detallada del CatalogoSistema. */
    @NotNull
    @Length(max = 50, min = 4)
    @Column(name="CATSIS_SALIDAHTML")
    private String salidaHtml;

    /** Bandera booleana que indica si el CatalogoSistema esta activo. */
    @NotNull
    @Column(name="CATSIS_ACTIVO")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean activo;

    /** Fecha de registro del CatalogoSistema. */
    @NotNull
    @Column(name="CATSIS_FECHAREGISTRO", updatable = false)
    private Date fechaRegistro;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "CATSIS_IDENTIDAD")
    private Entidad entidad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSalidaHtml() {
        return salidaHtml;
    }

    public void setSalidaHtml(String salidaHtml) {
        this.salidaHtml = salidaHtml;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }
}
