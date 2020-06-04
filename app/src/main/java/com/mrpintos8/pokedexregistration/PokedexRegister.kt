package com.mrpintos8.pokedexregistration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.mrpintos8.pokedexregistration.databinding.FragmentPokedexRegisterBinding

/**
 * A simple [Fragment] subclass.
 */
class PokedexRegister : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var binding =  DataBindingUtil.inflate<FragmentPokedexRegisterBinding>(inflater,
        R.layout.fragment_pokedex_register, container, false)


        return binding.root
    }

}
