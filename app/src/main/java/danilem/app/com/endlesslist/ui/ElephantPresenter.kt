package danilem.app.com.endlesslist.ui

import android.view.View
import danilem.app.com.endlesslist.model.ElephantData
import danilem.app.com.endlesslist.util.UiUtil
import io.reactivex.disposables.CompositeDisposable

class ElephantPresenter : ElephantView {

    private val disposable = CompositeDisposable()
    private val uiUtil: UiUtil? = null
    private var view: View? = null

    open fun attachView(view: View) {
        this.view = view
    }

    open fun detachView(view: View) {
        if (this.view == view) {
            this.view = null
        }
    }
    override fun showAllElephants(data: List<ElephantData>) {
        if (uiUtil?.isNetworkAvailable()!!) {

        }
    }
}