package com.sthore.msOperador.Controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sthore.msOperador.models.Pedido;
import com.sthore.msOperador.service.PedidoService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
@RefreshScope
@Getter
@Setter

@CrossOrigin(origins = "*")
public class PedidoController {
  @Autowired
  private PedidoService pedidoService; // Asegúrate de tener un servicio (PedidoService) que maneje la lógica de
                                       // negocio.

  // Endpoint para crear un nuevo pedido
  @PostMapping("/crear")
  public ResponseEntity<String> crearPedido(@RequestBody Pedido pedido) {
    pedidoService.crearPedido(pedido);
    return ResponseEntity.ok("Pedido creado con éxito");
  }

  // Endpoint para obtener todos los pedidos
  @GetMapping("/todos")
  public ResponseEntity<List<Pedido>> obtenerTodosPedidos() {
    List<Pedido> pedidos = pedidoService.obtenerTodosPedidos();
    return ResponseEntity.ok(pedidos);
  }

  // Endpoint para obtener un pedido por su ID
  @GetMapping("/{id}")
  public ResponseEntity<Pedido> obtenerPedidoPorId(@PathVariable int id) {
    Pedido pedido = pedidoService.obtenerPedidoPorId(id);
    if (pedido != null) {
      return ResponseEntity.ok(pedido);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  // Endpoint para actualizar un pedido por su ID
  @PutMapping("/{id}")
  public ResponseEntity<String> actualizarPedido(@PathVariable int id, @RequestBody Pedido pedidoActualizado) {
    if (pedidoService.actualizarPedido(id, pedidoActualizado)) {
      return ResponseEntity.ok("Pedido actualizado con éxito");
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  // Endpoint para eliminar un pedido por su ID
  @DeleteMapping("/{id}")
  public ResponseEntity<String> eliminarPedido(@PathVariable int id) {
    if (pedidoService.eliminarPedido(id)) {
      return ResponseEntity.ok("Pedido eliminado con éxito");
    } else {
      return ResponseEntity.notFound().build();
    }
  }

}
