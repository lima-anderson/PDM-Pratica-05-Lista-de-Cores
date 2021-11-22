package com.example.criadordecores

import java.io.Serializable

class DescricaoCor : Serializable {
    val id: Int
    var nome: String
    var numero: String

    constructor(nome: String, numero: String){
        this.id = -1
        this.nome = nome
        this.numero = numero
    }

    constructor(id: Int, nome: String, numero: String){
        this.id = id
        this.nome = nome
        this.numero = numero
    }

    constructor() {
        this.id = -1
        this.nome = "Branco"
        this.numero = "255.255.255"
    }

    override fun toString(): String {
        return "$nome" +
                "\n$numero"
    }
}