package mx.com.plantilla.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by dzuniga on 27/04/2017.
 */
@Entity
@Table(name = "catalogogeneral")
public class CatalogoGeneral implements Serializable {
    private Long id;
    private String codigo;
    private String descripcion;
    private Entidad entidad;
    private Boolean activo;
    private Date fechaRegistro;
    private String salidaHtml;
    private BigDecimal valor;

    @Id
    @Column(name = "cat_id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "cat_codigo", nullable = false, length = 50)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Column(name = "cat_descripcion", nullable = false, length = 200)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @ManyToOne
    @JoinColumn(name = "cat_identidad", nullable = false)
    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "cat_activo", nullable = false)
    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Column(name = "cat_fecharegistro", nullable = false)
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Column(name = "cat_salidahtml", nullable = true, length = 200)
    public String getSalidaHtml() {
        return salidaHtml;
    }

    public void setSalidaHtml(String salidaHtml) {
        this.salidaHtml = salidaHtml;
    }

    @Column(name = "cat_valor", nullable = true, precision = 4)
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
