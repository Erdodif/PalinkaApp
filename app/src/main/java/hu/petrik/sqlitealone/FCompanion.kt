package hu.petrik.sqlitealone

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast

class FCompanion {
    companion object {
        fun swapActivity(from: Activity, to: Activity, extras: Bundle? = null) {
            val intent = Intent(from, to::class.java)
            if (extras !== null) {
                intent.putExtra("all", extras)
            }
            from.startActivity(intent)
            from.finish()
        }

        fun showToast(context: Activity, message: String){
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }
}