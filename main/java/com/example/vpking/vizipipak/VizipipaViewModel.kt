package com.example.vpking.vizipipak

import android.app.Application
import androidx.lifecycle.*
import com.example.vpking.dao.VizipipaDao
import com.example.vpking.dao.VizipipaSave
import kotlinx.coroutines.launch

class VizipipaViewModel(
    val database: VizipipaDao,
    application: Application) :
    AndroidViewModel(application)  {

    private val vizipipak = database.getAllVizipipa()
    var vpnev = ""
    private val _navigateToListView = MutableLiveData<Boolean>()
    val navigateToListView: LiveData<Boolean>
        get() = _navigateToListView
    fun onVPClicked(id: Boolean) {
        _navigateToListView.value = id
    }

    val vizipipaString = Transformations.map(vizipipak) { vizipipas ->
        //formatVP(vizipipas, application.resources)
    }

    /*private suspend fun insert(vizipipa: VizipipaSave) {
        database.insert(vizipipa)
    }*/

    private val _result = MutableLiveData<Vizipipa>()
    val properties: LiveData<Vizipipa>
        get() = _result

    fun saveVP() : Boolean{
        if(_result.value!=null){
            viewModelScope.launch {
                var vp = VizipipaSave()
                vp.nev= _result.value?.nev ?: ""
                /*result.fname= _result.value?.fname ?: ""
                result.percentage= _result.value?.percentage ?: 0
                result.result   = _result.value?.result ?: ""*/

                database.insert(vp)
            }
            return true
        }
        return false
    }

    }

   /* fun saveResult() : Boolean{
        if(_result.value!=null){
            viewModelScope.launch {
                var result = LoveResultSave()
                result.sname= _result.value?.sname ?: ""
                result.fname= _result.value?.fname ?: ""
                result.percentage= _result.value?.percentage ?: 0
                result.result   = _result.value?.result ?: ""

                database.insert(result)
            }
            return true
        }
        return false
    }

    fun getResult() {
        if (!name1.equals("") && !name2.equals("")) {
            viewModelScope.launch {
                _status.value = ApiStatus.LOADING
                try {
                    _result.value =
                        LoveApi.loveService.getLoveResult(name1 as String, name2 as String)
                    _status.value = ApiStatus.DONE
                } catch (e: Exception) {
                    _status.value = ApiStatus.ERROR
                    _result.value = null
                }
            }
        }
    }*/