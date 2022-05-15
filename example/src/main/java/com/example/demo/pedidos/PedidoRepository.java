package com.example.demo.pedidos;

import com.example.demo.pedidos.Pedido;
import com.example.demo.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    Pedido findById(String Id);
}
