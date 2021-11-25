package hu.petrik.sqlitealone

enum class DB(private val nev: String) {
    NAME("palinkabazis.db"),
    TABLE("palinka"),
    COL_ID("id"),
    COL_FOZO("fozo"),
    COL_GYUMOLCS("gyumolcs"),
    COL_ALKOHOL("alkohol");

    companion object {
        const val VERSION: Int =1
    }

    override fun toString(): String {
        return this.nev
    }
}