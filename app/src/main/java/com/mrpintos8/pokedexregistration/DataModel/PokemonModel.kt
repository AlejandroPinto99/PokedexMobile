package com.mrpintos8.pokedexregistration.DataModel

import android.util.Log
import com.google.firebase.database.*
import java.lang.Exception
import java.util.*

object PokemonModel : Observable() {
    private var mValueDataListener : ValueEventListener? = null
    private var mPokemonList: ArrayList<Pokemon>? = ArrayList()

    private fun getDatabaseRef() : DatabaseReference? {
        return FirebaseDatabase.getInstance().reference.child("Pokemon")
    }

    init {
        if(mValueDataListener != null) {
            getDatabaseRef()?.removeEventListener(mValueDataListener!!)
        }
        mValueDataListener = null
       Log.i("PokemonModel", "data init")

        mValueDataListener = object: ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                try{
                        Log.i("PokemonModel", "data updated")
                    val data : ArrayList<Pokemon> = ArrayList()
                    if (dataSnapshot != null){
                        for(snapShot : DataSnapshot in  dataSnapshot.children){
                            try{
                                data.add(Pokemon(snapShot))
                            } catch(e : Exception){
                                    e.printStackTrace()
                            }
                        }
                        mPokemonList = data
                        Log.i("PokemonModel", "data updated, there are: " + mPokemonList!!.size + " Pokemons")
                        setChanged()
                        notifyObservers()
                    }
                } catch(e : Exception){
                    e.printStackTrace()
                }
            }

            override fun onCancelled(p0: DatabaseError) {
                if(p0 != null){
                    Log.i("PokemonModel", "Canceled")
                }
            }

        }
        getDatabaseRef()?.addValueEventListener(mValueDataListener as ValueEventListener)
    }

    private fun getData() : ArrayList<Pokemon>? {

        return mPokemonList
    }
}