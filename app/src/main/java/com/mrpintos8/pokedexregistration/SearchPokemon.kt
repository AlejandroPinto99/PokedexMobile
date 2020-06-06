package com.mrpintos8.pokedexregistration

import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.google.firebase.database.*
import com.mrpintos8.pokedexregistration.databinding.FragmentSearchPokemonBinding

/**
 * A simple [Fragment] subclass.
 */
class SearchPokemon : Fragment() {

    private lateinit var dbReference: DatabaseReference


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Inflando la vista
        var binding = DataBindingUtil.inflate<FragmentSearchPokemonBinding>(
            inflater,
            R.layout.fragment_search_pokemon, container, false
        )



        //Register botton event
        binding.btnRegister.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_search_destination_to_pokedexRegister)
        }



        binding.btnSearch.setOnClickListener { view: View ->

        }

        return binding.root
    }

}
