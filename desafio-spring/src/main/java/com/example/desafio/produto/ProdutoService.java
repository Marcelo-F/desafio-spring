package com.example.desafio.produto;

import com.example.desafio.produto.relatorio.AvaliacaoProdutoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;
    private Double medianota;

    List<AvaliacaoProdutoModel> listProdutoModel = new List<AvaliacaoProdutoModel>();


    public List<Produto> getTop10Notas() {


        int page = 0;
        int size = 10;
        Pageable pageable = PageRequest.of(page, size);
        Page<Produto> produtos = this.repository.findaAll(pageable);

        while (produtos.getTotalPages() > page) {

            for (Produto p : produtos) {

                this.mediaNota(p);

            }

            listProdutoModel.add()
            page++;
            pageable = PageRequest.of(page, size);
            produtos = this.repository.findaAll(pageable);
        }


        return Collections.emptyList();
    }


    public void mediaNota(Produto produto) {
        List<Produto> p = repository.findName(produto.getNome());
        Double nota = repository.sumNota(produto);
        Double medianota = p.size() / nota;

    }
}
