package br.com.erpsystem.msproduct.mapper;

import br.com.erpsystem.msproduct.dto.ProductDTO;
import br.com.erpsystem.msproduct.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO productToProductDTO(Product product);
    Product productDTOToProduct(ProductDTO productDTO);
}
