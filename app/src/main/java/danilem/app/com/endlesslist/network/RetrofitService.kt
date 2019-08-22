package danilem.app.com.endlesslist.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

    companion object {
        const val URL = "https://elephant-api.herokuapp.com"

        private var sRequestInterface: RequestInterface? = null

        fun create(): RequestInterface? {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URL)
                .build()

            sRequestInterface = retrofit.create(RequestInterface::class.java)

            return sRequestInterface
        }

        fun getRequestInterface(): RequestInterface? {
            var requestInterface = sRequestInterface
            if (requestInterface == null) {
                synchronized(RetrofitService::class.java) {
                    requestInterface = sRequestInterface
                    if (requestInterface == null) {
                        sRequestInterface = create()
                        requestInterface = sRequestInterface
                    }
                }
            }
            return requestInterface
        }
    }
}