package com.sthore.msOperador.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pedido")
public class Pedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false)
  private int status;

  @Column(nullable = false, columnDefinition = "DECIMAL(19,2)")
  private BigDecimal total;

  @Column(name = "fecha_pedido", nullable = false)
  private String fechaPedido;

  @Column(name = "usuario_telefono", nullable = false, length = 20)
  private String usuarioTelefono;

  @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<PedidoDetalle> detalles;

  // Constructor por defecto
  public Pedido() {
  }

  // Constructor con parámetros
  public Pedido(int status, BigDecimal total, String usuarioTelefono, List<PedidoDetalle> detalles) {
    this.status = status;
    this.total = total;
    this.fechaPedido = fechaPedido;
    this.usuarioTelefono = usuarioTelefono;
    this.detalles = detalles;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public BigDecimal getTotal() {
    return total;
  }

  public void setTotal(BigDecimal total) {
    if (Objects.isNull(total)) {
      total = BigDecimal.ZERO;
    }
    this.total = total;
  }

  public String getFechaPedido() {
    return fechaPedido;
  }

  public void setFechaPedido(String fechaPedido) {
    this.fechaPedido = fechaPedido;
  }

  public String getUsuarioTelefono() {
    return usuarioTelefono;
  }

  public void setUsuarioTelefono(String usuarioTelefono) {
    if (Objects.isNull(usuarioTelefono)) {
      usuarioTelefono = "";
    }
    this.usuarioTelefono = usuarioTelefono;
  }

  public List<PedidoDetalle> getDetalles() {
    return detalles;
  }

  public void setDetalles(List<PedidoDetalle> detalles) {
    this.detalles = detalles;
  }
}
