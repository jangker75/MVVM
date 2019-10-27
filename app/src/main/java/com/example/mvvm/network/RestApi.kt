package com.example.mvvm.network

import com.example.mvvm.model.ListPlaceResponseModel
import io.reactivex.Observable
import retrofit2.http.GET

interface RestApi {
    @GET("Sample.json")
    fun getListPlace(): Observable<ListPlaceResponseModel>
}