package hu.petrik.sqlitealone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hu.petrik.sqlitealone.databinding.ActivityAdatFelvetelBinding

class AdatFelvetelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind = ActivityAdatFelvetelBinding.inflate(layoutInflater)
        setContentView(bind.root)
    }
}