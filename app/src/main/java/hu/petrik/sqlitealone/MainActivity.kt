package hu.petrik.sqlitealone

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.TextView
import hu.petrik.sqlitealone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.btnKereses.setOnClickListener {
            FCompanion.swapActivity(this,AdatKeresesActivity())
        }

        bind.btnFelvetel.setOnClickListener {
            FCompanion.swapActivity(this,AdatFelvetelActivity())
        }


        bind.btnListazas.setOnClickListener {
            //FCompanion.palinkaListaz(bind.layoutLista)
            val ki = ArrayList<TextView>()
            while (bind.layoutLista.childCount>0){
                bind.layoutLista.removeViewAt(0)
            }

            for (palinka in FCompanion.palinkak(this)){
                val temp = TextView(bind.layoutLista.context)
                temp.text = palinka.toString()
                bind.layoutLista.addView(temp)
                Log.d("Palinka",palinka.toString())
            }
            Log.d("Esemény","Lezárult")
        }
    }
}