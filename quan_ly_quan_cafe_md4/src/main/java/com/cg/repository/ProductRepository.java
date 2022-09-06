package com.cg.repository;

import com.cg.model.Product;
import com.cg.model.dto.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT new com.cg.model.dto.ProductDTO(" +
            "p.idProduct," +
            "p.nameProduct," +
            "p.price,p.category.idCategory," +
            "p.category.nameCategory," +
            "p.description) " +
            "FROM Product p " +
            "WHERE p.deleted = FALSE")
    List<ProductDTO> findAllProductDTO();

    @Query("SELECT new com.cg.model.dto.ProductDTO(" +
            "p.idProduct," +
            "p.nameProduct," +
            "p.price,p.category.idCategory," +
            "p.category.nameCategory," +
            "p.description) " +
            "FROM Product p " +
            "WHERE p.deleted = TRUE")
    List<ProductDTO> findAllProductLock();

    @Query("SELECT new com.cg.model.dto.ProductDTO(" +
            "p.idProduct," +
            "p.nameProduct," +
            "p.price,p.category.idCategory," +
            "p.category.nameCategory," +
            "p.description) " +
            "FROM Product p " +
            "WHERE p.deleted = FALSE AND p.idProduct=:id")
    Optional<ProductDTO> findProductDTOById(@Param("id") Long id);
}
