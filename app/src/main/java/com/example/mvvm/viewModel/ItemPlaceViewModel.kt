package com.example.mvvm.viewModel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.mvvm.model.ListPlaceResponseModel

class ItemPlaceViewModel(model: ListPlaceResponseModel.PlaceModel) : ViewModel() {

    var title: ObservableField<String> = ObservableField()
    var location: ObservableField<String> = ObservableField()
    var image: ObservableField<String> = ObservableField()

    init {
        title.set(model.name)
        location.set(model.location)
        image.set(model.image)

    }
}