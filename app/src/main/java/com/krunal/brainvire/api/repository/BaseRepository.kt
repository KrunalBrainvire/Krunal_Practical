package com.krunal.brainvire.api.repository

import io.reactivex.disposables.CompositeDisposable

abstract class BaseRepository {

    protected var disposable: CompositeDisposable = CompositeDisposable()


    open fun clearDisposable() {
        if (disposable != null) {
            disposable.dispose()
        }
    }


}