package danilem.app.com.endlesslist.repository

import danilem.app.com.endlesslist.model.ElephantData
import danilem.app.com.endlesslist.network.RequestInterface
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ElephantRepositoryImpl(private val requestInterface: RequestInterface) : ElephantRepository {
    override fun getElephantData(): Single<List<ElephantData>> {
        return requestInterface.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}