package br.com.erpsystem.msproduct.services;

import br.com.erpsystem.msproduct.dto.ProductDTO;
import br.com.erpsystem.msproduct.dto.http.request.CreateProductRequestDTO;
import br.com.erpsystem.msproduct.dto.http.request.UpdateStockRequestDTO;
import br.com.erpsystem.msproduct.dto.http.request.WithdrawFromStockRequestDTO;
import br.com.erpsystem.msproduct.dto.http.response.CreateProductResponseDTO;
import br.com.erpsystem.msproduct.dto.http.response.FindProductResponseDTO;
import br.com.erpsystem.msproduct.dto.http.response.UpdateStockResponseDTO;
import br.com.erpsystem.msproduct.dto.http.response.WithdrawFromStockResponseDTO;
import br.com.erpsystem.msproduct.entity.Product;
import br.com.erpsystem.msproduct.mapper.ProductMapper;
import br.com.erpsystem.msproduct.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    @Override
    public FindProductResponseDTO findProductById(UUID id) {
        log.info("ProductServiceImpl.findProductById - Start - Product Id: {}", id);
        ProductDTO productDTO = mapper.productToProductDTO(productRepository.findById(id).orElse(new Product()));
        log.info("ProductServiceImpl.findProductById - End");
        return FindProductResponseDTO.builder().productDTO(productDTO).build();
    }

    @Override
    public CreateProductResponseDTO createProduct(CreateProductRequestDTO createProductRequestDTO) {
        log.info("ProductServiceImpl.createProduct - Start - createProductRequestDTO Id: {}", createProductRequestDTO);
        Product savedProduct = productRepository.save(mapper.productDTOToProduct(createProductRequestDTO.getProductDTO()));
        log.info("ProductServiceImpl.createProduct - End");
        return CreateProductResponseDTO.builder().productDTO(mapper.productToProductDTO(savedProduct)).build();
    }

    @Override
    public WithdrawFromStockResponseDTO withdrawFromStock(WithdrawFromStockRequestDTO withdrawFromStockRequestDTO) {
        log.info("ProductServiceImpl.withdrawFromStock - Start - Product Id: {}, Withdraw Amount: {}", withdrawFromStockRequestDTO.getProductId(), withdrawFromStockRequestDTO.getQuantity());
        Integer quantityToRemove = withdrawFromStockRequestDTO.getQuantity();
        UUID productId = UUID.fromString(withdrawFromStockRequestDTO.getProductId());
        ProductDTO productDTO = mapper.productToProductDTO(productRepository.findById(productId).get());
        int newTotal = productDTO.getQuantityInStock() - quantityToRemove;
        productDTO.setQuantityInStock(Math.max(newTotal, 0));
        ProductDTO savedProductDTO = mapper.productToProductDTO(productRepository.save(mapper.productDTOToProduct(productDTO)));
        log.info("ProductServiceImpl.withdrawFromStock - End");
        return withdrawResponseBuilder(withdrawFromStockRequestDTO.getProductId(), savedProductDTO.getQuantityInStock());
    }

    @Override
    public UpdateStockResponseDTO updateStock(UpdateStockRequestDTO updateStockRequestDTO) {
        ProductDTO productDTO = mapper.productToProductDTO(productRepository.findById(UUID.fromString(updateStockRequestDTO.getProductId())).get());
        Integer newTotal = productDTO.getQuantityInStock() + updateStockRequestDTO.getQuantity();
        productDTO.setQuantityInStock(newTotal);
        ProductDTO savedProductDTO = mapper.productToProductDTO(productRepository.save(mapper.productDTOToProduct(productDTO)));
        return updateStockResponseBuilder(productDTO.getId().toString(), savedProductDTO.getQuantityInStock());
    }

    public WithdrawFromStockResponseDTO withdrawResponseBuilder(String productId, Integer newTotal){
        return WithdrawFromStockResponseDTO.builder()
                .productId(productId)
                .productInStock(newTotal).build();
    }

    public UpdateStockResponseDTO updateStockResponseBuilder(String productId, Integer newTotal){
        return UpdateStockResponseDTO.builder()
                .productId(productId)
                .productInStock(newTotal).build();
    }
}
