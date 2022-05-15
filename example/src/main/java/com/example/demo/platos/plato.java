package com.example.demo.platos;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.example.demo.menus.menu;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter @Setter @AllArgsConstructor

@Entity
@Table(name="platos")
public class plato {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="codigo", nullable=false)
    private String codigo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precioVenta")
    private Double precioVenta;

    // relacion muchos a muchos con menus
    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.PERSIST)
    @JoinTable(name="platos_menus",
            joinColumns = {
                    @JoinColumn(name="plato_id", referencedColumnName="id",
                            nullable=false, updatable=false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name="menu_id", referencedColumnName="id",
                            nullable=false, updatable=false)
            })
    private Set<menu> menus = new HashSet<>();

    public plato() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        plato plato = (plato) o;
        return Objects.equals(id, plato.id) && Objects.equals(codigo, plato.codigo) && Objects.equals(descripcion, plato.descripcion) && Objects.equals(precioVenta, plato.precioVenta) && Objects.equals(menus, plato.menus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigo, descripcion, precioVenta, menus);
    }

    @Override
    public String toString() {
        return "plato{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precioVenta=" + precioVenta +
                '}';
    }
}