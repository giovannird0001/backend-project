package com.sthore.msOperador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.sthore.msOperador.models.Categorias;
import com.sthore.msOperador.models.Product;
import com.sthore.msOperador.service.CategoriaService;
import com.sthore.msOperador.service.PedidoService;
import com.sthore.msOperador.service.ProductService;

@Component
public class ApplicationStartupListener {
  @Autowired
  private ProductService productService;
  @Autowired
  private CategoriaService categoriasErvice;
  @Autowired
  private JdbcTemplate jdbcTemplate;

  @EventListener(ApplicationReadyEvent.class)
  public void onApplicationReadyEvent(ApplicationReadyEvent event) {

    System.out.println("gio La aplicación ha iniciado y está lista para ser utilizada.");
    if (isTableExists("product")) {
      System.out.println("La tabla 'product' existe en la base de datos.");
      List<Product> sampleProducts = ApplicationStartupListener.getSampleProducts();
      productService.saveSampleProducts(sampleProducts);
    } else {
      System.out.println("La tabla 'product' NO existe en la base de datos.");
      List<Product> sampleProducts = ApplicationStartupListener.getSampleProducts();
      productService.saveSampleProducts(sampleProducts);
    }

    if (isTableExists("categorias")) {
      System.out.println("La tabla 'categorias' existe en la base de datos.");
      List<Categorias> catego = ApplicationStartupListener.getSampleCategorias();
      categoriasErvice.saveSampleCategorias(catego);
    } else {
      System.out.println("La tabla 'categorias' NO existe en la base de datos.");
      List<Categorias> catego = ApplicationStartupListener.getSampleCategorias();
      categoriasErvice.saveSampleCategorias(catego);
    }
  }

  private boolean isTableExists(String tableName) {

    String sql = "SELECT COUNT(*) FROM information_schema.tables WHERE table_name = ?";

    int count = jdbcTemplate.queryForObject(sql, Integer.class, tableName);

    return count > 0;
  }

  private boolean isTableExists2(String tableName) {

    String sql = "SELECT COUNT(*) FROM information_schema.tables WHERE table_name = ?";

    int count = jdbcTemplate.queryForObject(sql, Integer.class, tableName);

    return count > 0;
  }

  public static List<Product> getSampleProducts() {
    List<Product> productList = new ArrayList<>();

    for (int i = 1; i <= 20; i++) {
      Product product = new Product();
      product.setName("Producto " + i);
      product.setPrice(10.0 * i);
      product.setDescription("Descripción del producto " + i);
      product.setImageUrl("url_imagen_" + i);

      productList.add(product);
    }

    return productList;
  }

  public static List<Categorias> getSampleCategorias() {
    List<Categorias> categoriasList = new ArrayList<>();

    for (int i = 1; i <= 20; i++) {
      Categorias categoria = new Categorias();
      categoria.setName("Categoria " + String.valueOf(i));
      categoria.setImageUrl("url_imagen_" + String.valueOf(i));

      categoriasList.add(categoria);
    }

    return categoriasList;
  }

}
