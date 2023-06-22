package br.com.edgarpinheiro.ecommercebackend.controller;

import br.com.edgarpinheiro.ecommercebackend.model.Produto;
import br.com.edgarpinheiro.ecommercebackend.repository.ProdutoRepository;
import br.com.edgarpinheiro.ecommercebackend.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/novo_produto/")
    public ResponseEntity<Produto> novoProduto(@RequestBody Produto produto) {
        Produto novoProduto = produtoService.novoProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }

    @PutMapping("/atualizar_produto/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        Produto produto = produtoService.atualizarProduto(id, produtoAtualizado);

        if (produto != null) {
            return ResponseEntity.ok(produto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }

    @DeleteMapping("/deletar_produto/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        boolean excluido = produtoService.deletarProduto(id);

        if (excluido) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
