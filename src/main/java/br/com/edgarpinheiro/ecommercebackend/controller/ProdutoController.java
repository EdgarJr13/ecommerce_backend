package br.com.edgarpinheiro.ecommercebackend.controller;

import br.com.edgarpinheiro.ecommercebackend.model.Produto;
import br.com.edgarpinheiro.ecommercebackend.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin(origins = "http://localhost:8081")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/novo_produto")
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

    @GetMapping("/obter_produto_id/{id}")
    public ResponseEntity<Produto> obterProdutoPorId(@PathVariable Long id) {
        Optional<Produto> produto = produtoService.obterProdutoPorId(id);

        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }

    @GetMapping
    @RequestMapping("/buscar")
    public List<Produto> buscarProdutos(@RequestParam("search") String searchTerm) {
        List<Produto> produtosEncontrados = produtoService.buscarProdutos(searchTerm);
        return produtosEncontrados;
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
