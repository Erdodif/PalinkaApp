package hu.petrik.sqlitealone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
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
    }
}