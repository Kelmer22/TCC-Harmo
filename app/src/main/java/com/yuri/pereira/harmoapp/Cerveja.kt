package com.yuri.pereira.harmoapp

import java.io.Serializable

data class Cerveja(
    val nome: String,
    val descricao: String,
    val tipo: String,
    val ingredientes: String,
    val alergicos: String,
    val mililitros:String,
    val harmonizacao: String,
    val teorAlcoolico: String,
    val ibu: String,
    val foto: String
) : Serializable {
}