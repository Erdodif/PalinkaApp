package hu.petrik.sqlitealone

class Palinka(
    private var id: Int,
    private var fozo: String,
    private var gyumolcs: String,
    private var alkoholTartalom: Int
) {
    fun getId():Int{
        return this.id
    }
    fun getFozo():String{
        return this.fozo
    }
    fun getGyumolcs():String{
        return this.gyumolcs
    }
    fun getAlkoholTartalom():Int{
        return this.alkoholTartalom
    }

    override fun toString(): String {
        return "ID: $id\nFőző: $fozo\nGyümölcs: $gyumolcs\n Alkoholtartalom: $alkoholTartalom%"
    }
}