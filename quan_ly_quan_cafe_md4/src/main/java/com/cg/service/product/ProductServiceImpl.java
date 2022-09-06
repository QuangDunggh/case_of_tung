package com.cg.service.product;

import com.cg.model.ImageProduct;
import com.cg.model.Product;
import com.cg.model.dto.ProductDTO;
import com.cg.repository.ProductRepository;
import com.cg.service.category.ICategoryService;
import com.cg.service.imageProduct.ImageProductService;
import com.cg.service.uploadImage.IUploadImageProductService;
import com.cg.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private UploadUtils utils;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ICategoryService categoryService;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product createProduct(ProductDTO productDTO) {
        Product product = productDTO.toProduct();
        product.setCategory(categoryService.findById(productDTO.getCategory()).get());
        productRepository.save(product);
        return product;
    }

    @Override
    public List<ProductDTO> findAllProductDTO() {
        return productRepository.findAllProductDTO();

    }

    @Override
    public List<ProductDTO> findAllProductLock() {
        return productRepository.findAllProductLock();

    }

    @Override
    public Optional<ProductDTO> findProductDTOById(Long id) {
        return productRepository.findProductDTOById(id);

    }
}
