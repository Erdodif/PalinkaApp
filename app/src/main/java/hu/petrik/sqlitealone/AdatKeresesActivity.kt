package hu.petrik.sqlitealone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hu.petrik.sqlitealone.databinding.ActivityAdatKeresesBinding

class AdatKeresesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind = ActivityAdatKeresesBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.btnVissza.setOnClickListener {
            this.onBackPressed()
        }
    }

    override fun onBackPressed(){
        FCompanion.swapActivity(this,MainActivity())
    }
}