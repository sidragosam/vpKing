package com.example.vpking.vizipipak

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.vpking.R
import com.example.vpking.TitleFragmentDirections
import com.example.vpking.dao.VizipipaDatabase
import com.example.vpking.databinding.TitleFragmentBinding
import com.example.vpking.databinding.VizipipaPageBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [VizipipaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VizipipaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<VizipipaPageBinding>(inflater, R.layout.vizipipa_page, container, false)
        binding.vpAddOpenButton.setOnClickListener { view: View ->
            view.findNavController().navigate(VizipipaFragmentDirections.actionVizipipaPageToVizipipaAddFragment())
        }
        //binding.izekButton.setOnClickListener { view: View ->
            //view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToListFragment())
        //}
        /*val dataSource =
        val viewModelFactory = VizipipaViewModelFactory(dataSource)*/
        setHasOptionsMenu(true)
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment VizipipaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VizipipaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}