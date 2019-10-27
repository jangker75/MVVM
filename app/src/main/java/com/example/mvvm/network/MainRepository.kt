package com.example.mvvm.network

import com.example.mvvm.model.ListPlaceResponseModel
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainRepository {

    private val apiService = ServiceFactory.create()
    private val compositeDisposable = CompositeDisposable()
    fun requestListPlace(onResult: (ListPlaceResponseModel) -> Unit, onError: (Throwable) -> Unit) {
        apiService.getListPlace()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ApiObserver<ListPlaceResponseModel>(compositeDisposable) {
                override fun OnApiSuccess(data: ListPlaceResponseModel) {
                    onResult(data)
                }

                override fun OnApiError(er: Throwable) {
                    onError(er)
                }
            })

    }

    fun onDestroy(){
        compositeDisposable.clear()
    }
}