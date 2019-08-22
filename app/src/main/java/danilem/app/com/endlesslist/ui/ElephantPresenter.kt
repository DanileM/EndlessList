package danilem.app.com.endlesslist.ui

import android.content.Context
import danilem.app.com.endlesslist.model.ElephantData
import danilem.app.com.endlesslist.repository.ElephantRepository
import danilem.app.com.endlesslist.util.disposeBy
import io.reactivex.disposables.CompositeDisposable

class ElephantPresenter(private val elephantRepository: ElephantRepository) {

    private val disposable = CompositeDisposable()
    private var view: ElephantView? = null

    open fun attachView(view: ElephantView) {
        this.view = view
    }

    open fun detachView(view: ElephantView) {
        disposable.clear()
        if (this.view == view) {
            this.view = null
        }
    }

    fun getAllElephants() {
        elephantRepository.getElephantData().subscribe({
            view?.showAllElephants(it)
        }, {
            view?.showError(it.localizedMessage)
        }).disposeBy(disposable)
    }
}