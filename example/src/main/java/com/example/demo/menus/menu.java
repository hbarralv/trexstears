package com.example.demo.menus;

import com.example.demo.platos.plato;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Getter @Setter @AllArgsConstructor


@Entity
@Table(name="menus")
@NoArgsConstructor
public class menu implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre_menu")
    private String nombre;

    @Column(name = "precio")
    private Double precio;

    @Column(name="platos")
    private String platos;

//    @ManyToMany(mappedBy="menus", fetch=FetchType.LAZY)
//    private Set<plato> platos = new HashSet<>();

//    @ManyToMany(mappedBy="pedidos", fetch=FetchType.LAZY)
//    private Set<menu> menus = new HashSet<>();

//    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.PERSIST)
//    @JoinTable(name="pedidos_menus",
//            joinColumns = {
//                    @JoinColumn(name="pedido_id", referencedColumnName="id",
//                            nullable=false, updatable=false)
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name="menu_id", referencedColumnName="id",
//                            nullable=false, updatable=false)
//            })
//    private Set<Pedido> pedidos = new HashSet<>();

//    @ManyToOne
//    @JoinColumn(name = "id_restaurante", nullable = false, updatable = false)
//    private restaurante restaurante;

    @Override
    public String toString() {
        return "menu{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }


}
