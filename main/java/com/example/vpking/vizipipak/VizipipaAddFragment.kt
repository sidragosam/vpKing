package com.example.vpking.vizipipak

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.vpking.R
import com.example.vpking.dao.VizipipaDatabase
import com.example.vpking.databinding.VizipipaAddPageBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [VizipipaAddFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VizipipaAddFragment : Fragment() {
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
        //val binding = DataBindingUtil.inflate<VizipipaAddPageBinding>(inflater, R.layout.vizipipa_page, container, false)
        val binding: VizipipaAddPageBinding = DataBindingUtil.inflate(
            inflater, R.layout.vizipipa_add_page, container, false
        )

        val application = requireNotNull(this.activity).application

        val dataSource = VizipipaDatabase.getInstance(application).vizipipaDao

        val viewModelFactory = VizipipaViewModelFactory(dataSource)

        val vpViewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(VizipipaViewModel::class.java)

        binding.vizipipaViewModel = vpViewModel

        binding.vpTextInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                vpViewModel.vpnev=s.toString()
            }
        })

        binding.vpAddButton.setOnClickListener { view: View ->
            var result=vpViewModel.saveVP()
            if(result){
                vpViewModel.onVPClicked(true)
            }
            //val adapter = VizipipaAdapter( { id -> 1)
            //addVizipipa
        //view.findNavController().navigate(VizipipaFragmentDirections.actionVizipipaPageToVizipipaAddFragment())
        }
        //binding.izekButton.setOnClickListener { view: View ->
        //view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToListFragment())
        //}
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
         * @return A new instance of fragment VizipipaAddFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VizipipaAddFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}