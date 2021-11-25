package hu.petrik.sqlitealone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hu.petrik.sqlitealone.databinding.ActivityAdatFelvetelBinding

class AdatFelvetelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind = ActivityAdatFelvetelBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.btnRogzit.setOnClickListener {
            val db = SQLiteAssistant(this)
            val fozo = bind.inputLayoutFozo.editText?.text.toString()
            val gyumolcs = bind.inputLayoutGyumolcs.editText?.text.toString()
            val alkoholTartalom = bind.inputLayoutAlkohol.editText?.text.toString()
            if (fozo !== "" && gyumolcs !== "" && alkoholTartalom !== "") {
                if (db.hozzaad(fozo, gyumolcs, alkoholTartalom.toInt())) {
                    FCompanion.showToast(this, "Sikeres rögzítés!")
                } else {
                    FCompanion.showToast(this, "Sikertelen rögzítés!")
                }
            } else {
                FCompanion.showToast(this, "Hibás")
            }
        }

        bind.btnVissza.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        FCompanion.swapActivity(this, MainActivity())
    }
}