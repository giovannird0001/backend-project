package com.sthore.msOperador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sthore.msOperador.models.Pedido;
import com.sthore.msOperador.repository.PedidoRepository;

@Service
public class PedidoService {
  @Autowired
    private PedidoRepository pedidoRepository; // Asegúrate de tener un repositorio (PedidoRepository) para interactuar con la base de datos.

    // Método para crear un nuevo pedido
    public void crearPedido(Pedido pedido) {
        // Puedes realizar validaciones u operaciones adicionales antes de guardar el pedido en la base de datos, si es necesario.
        pedidoRepository.save(pedido);
    }

    // Método para obtener todos los pedidos
    public List<Pedido> obtenerTodosPedidos() {
        return pedidoRepository.findAll();
    }

    // Método para obtener un pedido por su ID
    public Pedido obtenerPedidoPorId(int id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    // Método para actualizar un pedido por su ID
    public boolean actualizarPedido(int id, Pedido pedidoActualizado) {
        Pedido pedidoExistente = pedidoRepository.findById(id).orElse(null);
        if (pedidoExistente != null) {
            // Actualizar los campos relevantes del pedido existente con los valores del pedido actualizado
            pedidoExistente.setStatus(pedidoActualizado.getStatus());
            pedidoExistente.setTotal(pedidoActualizado.getTotal());
            pedidoExistente.setFechaPedido(pedidoActualizado.getFechaPedido());
            pedidoExistente.setUsuarioTelefono(pedidoActualizado.getUsuarioTelefono());
            pedidoExistente.setProductos(pedidoActualizado.getProductos());

            // Guardar el pedido actualizado en la base de datos
            pedidoRepository.save(pedidoExistente);
            return true;
        } else {
            return false;
        }
    }

    // Método para eliminar un pedido por su ID
    public boolean eliminarPedido(int id) {
        if (pedidoRepository.existsById(id)) {
            // Eliminar el pedido de la base de datos si existe
            pedidoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
