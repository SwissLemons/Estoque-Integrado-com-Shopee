package com.example.demo.produto;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;
    
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@GetMapping
    public List<Produto> getAllProdutos() {
        return produtoService.getAllProdutos();
    }

    @GetMapping("/{codigoProduto}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable String codigoProduto) {
        return produtoService.getProdutoByCodigoProduto(codigoProduto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createProduto(@RequestBody Produto produto) {
        try {
            Produto createdProduto = produtoService.createProduto(produto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdProduto);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Erro: Código de produto já existe ou violação de restrição de unicidade.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PatchMapping("/{codigoProduto}")
    public ResponseEntity<?> updateProduto(@PathVariable String codigoProduto, @RequestBody Produto produto) {
        try {
            return produtoService.updateProduto(codigoProduto, produto)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Erro: Código de produto já existe ou violação de restrição de unicidade.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    
    @DeleteMapping("/{codigoProduto}")
    public ResponseEntity<?> deleteProduto(@PathVariable String codigoProduto) {
        try {
            produtoService.deleteProduto(codigoProduto); // Lógica de remoção no service
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204 - Removido com sucesso
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erro: Produto com ID " + codigoProduto + " não encontrado.");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Erro: Não foi possível excluir o produto. Ele pode estar relacionado a outras entidades.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro inesperado ao excluir produto: " + e.getMessage());
        }
    }
}
