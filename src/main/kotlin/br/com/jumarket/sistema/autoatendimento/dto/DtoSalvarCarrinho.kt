package br.com.jumarket.sistema.autoatendimento.dto

import br.com.jumarket.sistema.autoatendimento.entidade.Carrinho
import br.com.jumarket.sistema.autoatendimento.enumeracao.FormaPagamento
import io.swagger.v3.oas.annotations.Hidden
import org.jetbrains.annotations.NotNull
import java.util.*

@Hidden
class DtoSalvarCarrinho(
    @field:NotNull() val formaPagamento: FormaPagamento
) {
    fun paraEntidade(): Carrinho = Carrinho(
        formaPagamento = this.formaPagamento
    )

}
