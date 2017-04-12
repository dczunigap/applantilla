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
@Table(name="Entidad")
public class Entidad implements Serializable{
    /**
     * Identificador único del registro.
     */
    @Id
    @Column(name = "entidad_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Clave única de identificación de la Entidad. */
    @NotNull
    @Length(max = 50, min = 4)
    @Column(name="entidad_codigo", updatable = false)
    private String codigo;

    /** Nombre de la Entidad. */
    @NotNull
    @Length(max = 100, min = 4)
    @Column(name="entidad_tabla")
    private String tabla;

    /** Descripición de uso para la salida en html. */
    @NotNull
    @Length(max = 50, min = 4)
    @Column(name="entidad_salidahtml")
    private String salidaHtml;

    /** Bandera booleana que indica si la Entidad pertenece al modelo de BD. */
    @NotNull
    @Column(name="entidad_modelo")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean modelo;

    /** Fecha de registro de la Entidad. */
    @NotNull
    @Column(name="entidad_fechaRegistro", updatable = false)
    private Date fechaRegistro;

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

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getSalidaHtml() {
        return salidaHtml;
    }

    public void setSalidaHtml(String salidaHtml) {
        this.salidaHtml = salidaHtml;
    }

    public Boolean getModelo() {
        return modelo;
    }

    public void setModelo(Boolean modelo) {
        this.modelo = modelo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
