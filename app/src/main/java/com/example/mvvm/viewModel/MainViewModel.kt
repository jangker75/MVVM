package com.example.mvvm.viewModel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.model.ListPlaceResponseModel
import com.example.mvvm.model.Mahasiswa
import com.example.mvvm.network.MainRepository

class MainViewModel : ViewModel() {

    private val repository = MainRepository()

    var listPlace: MutableLiveData<ListPlaceResponseModel> = MutableLiveData()
    var error: MutableLiveData<Throwable> = MutableLiveData()

    fun getListPlace() {
        repository.requestListPlace({
            listPlace.postValue(it)
        }, {
            error.postValue(it)
        })

    }

    override fun onCleared() {
        super.onCleared()
        repository.onDestroy()
    }
}