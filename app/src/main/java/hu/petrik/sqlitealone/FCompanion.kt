package hu.petrik.sqlitealone

import android.app.Activity
import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.children

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

        fun showToast(context: Activity, message: String) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }

        /*private */fun palinkak(context: Activity): List<Palinka> {
            val db = SQLiteAssistant(context)
            val kurzor: Cursor = db.listaz()
            val list = ArrayList<Palinka>()
            while (kurzor.moveToNext()) {
                kurzor.moveToNext()
                list.add(Palinka(kurzor.getInt(0),kurzor.getString(0), kurzor.getString(1), kurzor.getInt(2)))
            }
            return list
        }

        fun palinkaListaz(hova: LinearLayout) {
            val ki = ArrayList<TextView>()
            hova.removeAllViewsInLayout()
            for (palinka in palinkak(hova.context as Activity)){
                val temp = TextView(hova.context)
                temp.text = palinka.toString()
                hova.addView(temp)
            }
        }
    }
}