package com.example.criadordecores

import android.content.ContentValues
import android.content.Context

class DescricaoCorDAO {
    private var banco: BancoHelper

    constructor(context: Context){
        this.banco = BancoHelper(context)
    }

    fun insert(descricaoCor: DescricaoCor){
        val cv = ContentValues()
        cv.put("nome", descricaoCor.nome)
        cv.put("numero", descricaoCor.numero)
        this.banco.writableDatabase.insert("DescricaoCor", null, cv)
    }

    fun count(): Int{
        val sql = "select count(id) from DescricaoCor"
        val cursor = this.banco.readableDatabase.rawQuery(sql,null)
        cursor.moveToFirst()
        return cursor.getInt(0)
    }

    fun get(): ArrayList<DescricaoCor>{
        val lista = arrayListOf<DescricaoCor>()
        val colunas = arrayOf("id", "nome", "numero")

        val cursor = this.banco.readableDatabase.query("DescricaoCor", colunas, null, null, null, null, null)
        cursor.moveToFirst()

        for (i in 1..cursor.count){
            val id = cursor.getInt(0)
            val nome = cursor.getString(1)
            val numero = cursor.getString(2)
            lista.add(DescricaoCor(id, nome, numero))
            cursor.moveToNext()
        }

        return lista
    }

    fun get(id: Int): DescricaoCor?{
        val colunas = arrayOf("id", "nome", "numero")
        val where = "id = ?"
        val pWhere = arrayOf(id.toString())

        val cursor = this.banco.readableDatabase.query("DescricaoCor", colunas, where, pWhere, null, null, null)

        cursor.moveToFirst()

        if (cursor.count == 1){
            val id = cursor.getInt(0)
            val nome = cursor.getString(1)
            val numero = cursor.getString(2)
            return DescricaoCor(id, nome, numero)
        }
        return null
    }

    fun delete(id: Int){
        val where = "id = ?"
        val pWhere = arrayOf(id.toString())
        this.banco.writableDatabase.delete("DescricaoCor", where, pWhere)
    }

    fun update(descricaoCor: DescricaoCor){
        val where = "id = ?"
        val pWhere = arrayOf(descricaoCor.id.toString())
        val cv = ContentValues()
        cv.put("nome", descricaoCor.nome)
        cv.put("numero", descricaoCor.numero)

        this.banco.writableDatabase.update("DescricaoCor", cv, where, pWhere)
    }
}