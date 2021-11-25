package hu.petrik.sqlitealone

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteAssistant(
    context: Context?
) : SQLiteOpenHelper(context, DB.NAME.toString(), null, DB.VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val sql = """CREATE TABLE ${DB.TABLE}(
                    | ${DB.COL_ID} INTEGER PRIMARY KEY AUTOINCREMENT,
                    | ${DB.COL_FOZO} TEXT NOT NULL,
                    | ${DB.COL_GYUMOLCS} TEXT NOT NULL,
                    | ${DB.COL_ALKOHOL} INTEGER NOT NULL,
                    | UNIQUE (${DB.COL_FOZO},${DB.COL_GYUMOLCS})
                    | )""".trimMargin()
        db.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXIST ${DB.TABLE}")
        onCreate(db)
    }

    fun listaz(): Cursor {
        val db = readableDatabase
        return db.rawQuery("SELECT * FROM ${DB.TABLE}", null)
    }

    fun hozzaad(fozo: String, gyumolcs: String, alkoholtartalom: Int) :Boolean{
        val db = readableDatabase
        val values = ContentValues()
        values.put(DB.COL_FOZO.name,fozo)
        values.put(DB.COL_GYUMOLCS.name,gyumolcs)
        values.put(DB.COL_ALKOHOL.name,alkoholtartalom)
        return db.insert(DB.TABLE.name,null,values) == (-1).toLong()
    }

    fun keres(fozo: String, gyumolcs: String): Int? {
        val db = readableDatabase
        val sql = """SELECT ${DB.COL_ALKOHOL}
                    |FROM ${DB.TABLE}
                    |WHERE ${DB.COL_FOZO} = $fozo AND ${DB.COL_GYUMOLCS} = $gyumolcs
                    | )""".trimMargin()
        val kurzor = db.rawQuery(sql,null)
        val ki:Int?
        if (kurzor.count == 0){
            ki = null
        }
        else{
            ki = kurzor.getInt(0)
        }
        return ki
    }
}