package danilem.app.com.endlesslist.ui

import danilem.app.com.endlesslist.model.ElephantData

interface ElephantView {
    fun showAllElephants(data: List<ElephantData>)
}