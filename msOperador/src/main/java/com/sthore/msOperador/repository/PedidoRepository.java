package com.sthore.msOperador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sthore.msOperador.models.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    // Puedes agregar métodos personalizados de consulta si es necesario
}