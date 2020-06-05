package com.mrpintos8.pokedexregistration

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.media.AudioAttributesCompat.fromBundle
import com.mrpintos8.pokedexregistration.PokemonInfoArgs.fromBundle
import com.mrpintos8.pokedexregistration.databinding.FragmentPokemonInfoBinding

/**
 * A simple [Fragment] subclass.
 */
class PokemonInfo : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentPokemonInfoBinding>(inflater,
        R.layout.fragment_pokemon_info, container, false)


        return binding.root
    }

}
