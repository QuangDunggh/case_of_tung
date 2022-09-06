package com.cg.model.dto;

import com.cg.model.ImageProduct;
import com.cg.model.Product;
import com.cg.service.category.CategoryServiceImpl;
import com.cg.service.category.ICategoryService;
import com.cg.service.product.ProductServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDTO {

    private Long id;

    private String nameProduct;

    private BigDecimal price;

    private Long category;

    private String categoryName;

    private String description;

    public Product toProduct() {
        ICategoryService categoryService = new CategoryServiceImpl();
        Product product = new Product();
        product.setIdProduct(id);
        product.setNameProduct(nameProduct);
        product.setPrice(price);
        product.setDescription(description);

        return product;
    }


}
