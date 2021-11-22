package com.example.criadordecores

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*


class EscolherCorActivity : AppCompatActivity() {

    private lateinit var view: View
    private lateinit var seekBarTOP: SeekBar
    private lateinit var seekBarMid: SeekBar
    private lateinit var seekBarBot: SeekBar
    private lateinit var btSalvar: Button
    private lateinit var btCancelar: Button
    private lateinit var etNomeDaCor: EditText
    private var numeroDaCor: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_escolher_cor)

        this.view = findViewById(R.id.view)
        this.seekBarTOP = findViewById(R.id.seekBarTOP)
        this.seekBarMid = findViewById(R.id.seekBarMid)
        this.seekBarBot = findViewById(R.id.seekBarBot)
        this.btSalvar = findViewById(R.id.btSalvar)
        this.btCancelar = findViewById(R.id.btCancelar)

        this.seekBarTOP.setOnSeekBarChangeListener(OnChange())
        this.seekBarMid.setOnSeekBarChangeListener(OnChange())
        this.seekBarBot.setOnSeekBarChangeListener(OnChange())

        this.btCancelar.setOnClickListener{ finish() }

        this.btSalvar.setOnClickListener{salvar()}

        this.etNomeDaCor = findViewById(R.id.etNomeDaCor)

    }

    private fun salvar() {
        val vermelho = this.seekBarTOP.progress
        val verde = this.seekBarMid.progress
        val azul = this.seekBarBot.progress

        val cor = Cor(vermelho, verde, azul)

        val nomeDaCor = etNomeDaCor.text.toString()
        val numeroDaCor = this.numeroDaCor

        val descricaoCor = DescricaoCor(nomeDaCor, numeroDaCor)

        val intent = Intent().apply {
            putExtra("Cor", cor)
            putExtra("DescricaoCor", descricaoCor)
        }
        setResult(RESULT_OK, intent)
        finish()
    }





    inner class OnChange:SeekBar.OnSeekBarChangeListener {

        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            this@EscolherCorActivity.view.setBackgroundColor(Color.rgb(this@EscolherCorActivity.seekBarTOP.progress,
                seekBarMid.progress, seekBarBot.progress))

//            this@EscolherCorActivity.tvNomeDaCor.setText("#" + Integer.toHexString(
//                Color.rgb(
//                    this@EscolherCorActivity.seekBarTOP.progress,
//                    seekBarMid.progress,
//                    seekBarBot.progress
//                )
//            ).toString().uppercase().substring(2))

            this@EscolherCorActivity.numeroDaCor = seekBarTOP.progress.toString() + "." +  seekBarMid.progress.toString() + "." + seekBarBot.progress.toString()


        }
        override fun onStartTrackingTouch(seekBar: SeekBar?) {}
        override fun onStopTrackingTouch(seekBar: SeekBar?) {}
    }

}