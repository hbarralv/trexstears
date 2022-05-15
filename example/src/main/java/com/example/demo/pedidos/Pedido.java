package com.example.demo.pedidos;

import com.example.demo.security.model.User;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

@Getter @Setter @AllArgsConstructor

@Entity
@Table(name="pedidos")
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="fecha")
    private String fecha;

//    @ManyToOne
//    @JoinColumn(name = "id_usuario", nullable = false, updatable = false)
//    private User usuario;

    @Column(name="usuario")
    private String usuario;

    @Column(name="platos")
    private String platos;

}