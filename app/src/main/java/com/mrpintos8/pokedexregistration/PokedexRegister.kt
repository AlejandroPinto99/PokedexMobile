package com.mrpintos8.pokedexregistration

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.mrpintos8.pokedexregistration.databinding.FragmentPokedexRegisterBinding

/**
 * A simple [Fragment] subclass.
 */
class PokedexRegister : Fragment() {

    private lateinit var database: FirebaseDatabase
    private lateinit var auth: FirebaseAuth
    private lateinit var dbReference: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var binding =  DataBindingUtil.inflate<FragmentPokedexRegisterBinding>(inflater,
        R.layout.fragment_pokedex_register, container, false)

        database = FirebaseDatabase.getInstance()
        auth = FirebaseAuth.getInstance()
        dbReference = database.reference.child("Pokedex")

        binding.btnRegistration.setOnClickListener {
            val pokemon_name: String = binding.etPokemonName.text.toString()
            val first_type: String = binding.etPokemonFirstType.text.toString()
            val second_type: String = binding.etPokemonSecondType.text.toString()
            val region: String = binding.etOriginRegion.text.toString()

            if(!TextUtils.isEmpty(pokemon_name) && !TextUtils.isEmpty(first_type) && !TextUtils.isEmpty(region)){
                binding.progressBarRegister.visibility = View.VISIBLE

                val pokemonDB = dbReference.child(pokemon_name)
                pokemonDB.child("Name: ").setValue(pokemon_name)
                pokemonDB.child("First Type: ").setValue(first_type)
                pokemonDB.child("Second Type: ").setValue(second_type)
                pokemonDB.child("Region: ").setValue(region)
            }

            Toast.makeText(activity, "Registro exitoso", Toast.LENGTH_SHORT).show()
            binding.progressBarRegister.visibility = View.GONE

        }


        return binding.root
    }


}
