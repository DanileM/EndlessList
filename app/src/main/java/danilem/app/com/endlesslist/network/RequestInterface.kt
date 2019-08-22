package danilem.app.com.endlesslist.network

import danilem.app.com.endlesslist.model.ElephantData
import io.reactivex.Single
import retrofit2.http.GET

interface RequestInterface {

    @GET("/elephants")
    fun getData() : Single<List<ElephantData>>
}