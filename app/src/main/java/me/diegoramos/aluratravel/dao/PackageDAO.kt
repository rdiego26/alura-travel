package me.diegoramos.aluratravel.dao

import me.diegoramos.aluratravel.model.Package
import java.math.BigDecimal

object PackageDAO {

    val data: List<Package> = listOf()

    fun getList(): List<Package> =
        listOf(
            Package("São Paulo", "sao_paulo_sp", 2, BigDecimal(243.99)),
             Package("Belo Horizonte", "belo_horizonte_mg", 3,  BigDecimal(421.50)),
             Package("Recife", "recife_pe", 4,  BigDecimal(754.20)),
             Package("Rio de Janeiro", "rio_de_janeiro_rj", 6,  BigDecimal(532.55)),
             Package("Salvador", "salvador_ba", 5,  BigDecimal(899.99)),
             Package("Foz do Iguaçu", "foz_do_iguacu_pr", 1,  BigDecimal(289.90))
        )
}