package br.com.jumarket.sistema.autoatendimento.servicos.implementos

import br.com.jumarket.sistema.autoatendimento.entidade.Categorias
import br.com.jumarket.sistema.autoatendimento.excecao.ExcecaoNegocio
import br.com.jumarket.sistema.autoatendimento.repositorio.RepositorioCategoria
import br.com.jumarket.sistema.autoatendimento.servicos.IServicosCategorias
import org.springframework.stereotype.Service

@Service
class ServicosCategorias(
    private val repositorioCategoria: RepositorioCategoria
) : IServicosCategorias {
    override fun salvarCategoria(categorias: Categorias): Categorias = this.repositorioCategoria.save(categorias)

    override fun consultarCategoria(id: Long): Categorias = this.repositorioCategoria.findById(id).orElseThrow {
        throw ExcecaoNegocio("Id $id não encontrada")
    }

    override fun consultarTodasCategorias(): List<Categorias> = this.repositorioCategoria.consultarTodasCategorias()

    override fun apagarCategoria(id: Long) {
        val categorias: Categorias = this.consultarCategoria(id)
        this.repositorioCategoria.delete(categorias)
    }
}