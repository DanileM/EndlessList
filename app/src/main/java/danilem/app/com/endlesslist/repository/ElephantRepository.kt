package danilem.app.com.endlesslist.repository

import danilem.app.com.endlesslist.model.ElephantData
import io.reactivex.Single

interface ElephantRepository {
    fun getElephantData() : Single<List<ElephantData>>
}