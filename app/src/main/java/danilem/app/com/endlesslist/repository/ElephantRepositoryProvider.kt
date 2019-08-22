package danilem.app.com.endlesslist.repository

import danilem.app.com.endlesslist.network.RequestInterface

class ElephantRepositoryProvider {
    companion object {
        private var instance : ElephantRepository? = null

        fun getElephantRepository(requestInterface: RequestInterface) : ElephantRepository?{
            if(instance == null){
                instance = ElephantRepositoryImpl(requestInterface)
            }
            return instance
        }
    }
}