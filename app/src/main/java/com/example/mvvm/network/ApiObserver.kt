package com.example.mvvm.network

import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class ApiObserver<T> constructor(private val compositeDisposable: CompositeDisposable) :
    Observer<T> {

    override fun onComplete() {

    }

    override fun onSubscribe(d: Disposable) {
        compositeDisposable.add(d)
    }

    override fun onNext(t: T) {
        OnApiSuccess(t)
    }


    override fun onError(e: Throwable) {
        OnApiError(e)
    }

    abstract fun OnApiSuccess(data: T)
    abstract fun OnApiError(er: Throwable)
}