package com.example.vpking.vizipipak

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.vpking.dao.VizipipaDao

class VizipipaViewModelFactory(
    private val dataSource: VizipipaDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VizipipaViewModel::class.java)) {
            return VizipipaViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}