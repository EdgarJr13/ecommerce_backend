package br.com.edgarpinheiro.ecommercebackend.service;

import br.com.edgarpinheiro.ecommercebackend.model.Produto;
import br.com.edgarpinheiro.ecommercebackend.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto novoProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Optional<Produto> produtoPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto atualizarProduto(Long id, Produto produtoAtualizado) {
        Optional<Produto> produtoExistente = produtoRepository.findById(id);

        if (produtoExistente.isPresent()) {
            Produto produto = produtoExistente.get();
            produto.setNome(produtoAtualizado.getNome());
            produto.setDescricao(produtoAtualizado.getDescricao());
            produto.setValor(produtoAtualizado.getValor());

            return produtoRepository.save(produto);
        }

        return null;
    }

    public boolean deletarProduto(Long id) {
        Optional<Produto> produtoExistente = produtoRepository.findById(id);

        if (produtoExistente.isPresent()) {
            produtoRepository.deleteById(id);
            return true;
        }

        return false;
    }

}
