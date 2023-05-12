package br.com.erpsystem.msproduct.controllers;

import br.com.erpsystem.msproduct.dto.http.request.CreateProductRequestDTO;
import br.com.erpsystem.msproduct.dto.http.request.UpdateStockRequestDTO;
import br.com.erpsystem.msproduct.dto.http.request.WithdrawFromStockRequestDTO;
import br.com.erpsystem.msproduct.dto.http.response.CreateProductResponseDTO;
import br.com.erpsystem.msproduct.dto.http.response.FindProductResponseDTO;
import br.com.erpsystem.msproduct.dto.http.response.UpdateStockResponseDTO;
import br.com.erpsystem.msproduct.dto.http.response.WithdrawFromStockResponseDTO;
import br.com.erpsystem.msproduct.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FindProductResponseDTO> findProductById(@PathVariable("id") String id){
        log.info("ProductController.findProductById - Start - Product Id: {}", id);
        FindProductResponseDTO response = productService.findProductById(UUID.fromString(id));
        log.info("ProductController.findProductById - End");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateProductResponseDTO> createProduct(@Valid @RequestBody CreateProductRequestDTO createProductRequestDTO){
        log.info("ProductController.createProduct - Start - createProductRequestDTO : {}", createProductRequestDTO);
        CreateProductResponseDTO response = productService.createProduct(createProductRequestDTO);
        log.info("ProductController.createProduct - End");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping(value = "/withdraw", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WithdrawFromStockResponseDTO> withdrawFromStock(@Valid @RequestBody WithdrawFromStockRequestDTO withdrawFromStockRequestDTO){
        log.info("ProductController.withdrawFromStock - Start - ProductId : {}, Withdrawn Amount: {}", withdrawFromStockRequestDTO.getProductId(), withdrawFromStockRequestDTO.getQuantity());
        WithdrawFromStockResponseDTO response = productService.withdrawFromStock(withdrawFromStockRequestDTO);
        log.info("ProductController.withdrawFromStock - End");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping(value = "/updateStock", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UpdateStockResponseDTO> updateStock(@Valid @RequestBody UpdateStockRequestDTO updateStockRequestDTO){
        log.info("ProductController.updateStock - Start - ProductId : {}, Update Quantity: {}", updateStockRequestDTO.getProductId(), updateStockRequestDTO.getQuantity());
        UpdateStockResponseDTO response = productService.updateStock(updateStockRequestDTO);
        log.info("ProductController.updateStock - End");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
