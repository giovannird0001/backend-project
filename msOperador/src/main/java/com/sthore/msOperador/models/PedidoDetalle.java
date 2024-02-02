package com.sthore.msOperador.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pedido_detalle")
public class PedidoDetalle {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "code_product", nullable = false)
  private int codeProduct;

  @Column(name = "description_product", nullable = false, length = 50)
  private String descriptionProduct;

  @Column(nullable = false)
  private int cantidad;

  @Column(nullable = false)
  private BigDecimal price;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "pedido_id", nullable = false)
  private Pedido pedido;

  // Constructor por defecto
  public PedidoDetalle() {
  }

  // Constructor con parámetros
  public PedidoDetalle(int codeProduct, String descriptionProduct, int cantidad, BigDecimal price) {
    this.codeProduct = codeProduct;
    this.descriptionProduct = descriptionProduct;
    this.cantidad = cantidad;
    this.price = price;
  }

  // Getters y setters

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getCodeProduct() {
    return codeProduct;
  }

  public void setCodeProduct(int codeProduct) {
    this.codeProduct = codeProduct;
  }

  public String getDescriptionProduct() {
    return descriptionProduct;
  }

  public void setDescriptionProduct(String descriptionProduct) {
    this.descriptionProduct = descriptionProduct;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Pedido getPedido() {
    return pedido;
  }

  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }
}