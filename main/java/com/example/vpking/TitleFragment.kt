package com.example.vpking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.vpking.databinding.TitleFragmentBinding

class TitleFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<TitleFragmentBinding>(inflater, R.layout.title_fragment, container, false)
        binding.vizipipakButton.setOnClickListener { view: View ->
            view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToVpFragment())
        }
        binding.izekButton.setOnClickListener { view: View ->
            //view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToListFragment())
        }
        setHasOptionsMenu(true)
        return binding.root
    }
}