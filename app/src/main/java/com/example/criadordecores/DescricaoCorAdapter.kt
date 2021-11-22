package com.example.criadordecores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class DescricaoCorAdapter (var contexto: Context, var lista: ArrayList<DescricaoCor>) : BaseAdapter() {
    override fun getCount(): Int {
        return this.lista.count()
    }

    override fun getItem(position: Int): Any {
        return this.lista.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = if (convertView == null){
            LayoutInflater.from(this.contexto).inflate(R.layout.descricao_cor_layout, parent, false)
        }else{
            convertView
        }

        val descricoCor = this.lista.get(position)

        val tvNomeDaCor = view.findViewById<TextView>(R.id.tvNomeDaCOr)
        val tvNumeroDaCor = view.findViewById<TextView>(R.id.tvNumeroDaCor)

        tvNomeDaCor.text = descricoCor.nome
        tvNumeroDaCor.text = "RGB: ${descricoCor.numero}"

        view.minimumHeight = 100

        return view
    }
}