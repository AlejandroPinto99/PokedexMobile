package com.mrpintos8.pokedexregistration.DataModel

import com.google.firebase.database.DataSnapshot
import java.lang.Exception

class Pokemon(snapshot: DataSnapshot) {
    lateinit var pokemon_name : String
    lateinit var first_type : String
    lateinit var second_type : String
    lateinit var region : String

    init {
        try{
                val data : HashMap<String, Any> = snapshot.value as HashMap<String, Any>
            pokemon_name = data["Name: "] as String
            first_type = data["First Type: "] as String
            second_type = data["Second Type: "] as String
            region = data["Region: "] as String
        } catch(e : Exception){
            e.printStackTrace()
        }
    }
}