package com.example.criadordecores

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var btnAdd: FloatingActionButton
    private lateinit var lvMainCores: ListView
    private lateinit var lista: ArrayList<DescricaoCor>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.lista = arrayListOf()

        this.btnAdd = findViewById(R.id.btnAdd)
        this.lvMainCores = findViewById(R.id.lvMainCores)

//        this.lvMainCores.adapter = ArrayAdapter<DescricaoCor>(this, android.R.layout.simple_list_item_1, this.lista)
        this.lvMainCores.adapter = DescricaoCorAdapter(this, this.lista) // change 1


//        val descricaoResultado = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
//            if (it.resultCode == RESULT_OK){
//                val descricao = it.data?.getSerializableExtra("DescricaoCor") as DescricaoCor
//                (this.lvMainCores.adapter as ArrayAdapter<DescricaoCor>).add(descricao)
//            }
//        }

        val descricaoResultado = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                val descricao = it.data?.getSerializableExtra("DescricaoCor") as DescricaoCor
                this.lista.add(descricao)
                (this.lvMainCores.adapter as BaseAdapter).notifyDataSetChanged()
            }
        }// change 2
        
//        this.btnAdd.setOnClickListener{
//            val intent = Intent(this, EscolherCorActivity::class.java)
//            descricaoResultado.launch(intent)
//        }

        this.btnAdd.setOnClickListener{
            val intent = Intent(this, EscolherCorActivity::class.java)
            descricaoResultado.launch(intent)
        }
    }
}