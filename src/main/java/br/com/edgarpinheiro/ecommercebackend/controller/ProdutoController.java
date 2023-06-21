package br.com.edgarpinheiro.ecommercebackend.controller;

import br.com.edgarpinheiro.ecommercebackend.model.Produto;
import br.com.edgarpinheiro.ecommercebackend.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }
    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }
}
