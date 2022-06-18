package com.yuri.pereira.harmoapp

import java.io.Serializable

data class Prato(
    val nome:String,
    val foto: String,
    val listaCervejas : List<Cerveja>
): Serializable {
}