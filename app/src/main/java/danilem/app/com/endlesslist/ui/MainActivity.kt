package danilem.app.com.endlesslist.ui

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import danilem.app.com.endlesslist.R
import danilem.app.com.endlesslist.model.ElephantData
import danilem.app.com.endlesslist.network.RetrofitService
import danilem.app.com.endlesslist.repository.ElephantRepositoryProvider
import danilem.app.com.endlesslist.ui.adapter.ElephantAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity(), ElephantView {

    private var elephantPresenter: ElephantPresenter? = null
    private lateinit var rvElephantsList: RecyclerView
    private lateinit var elephantAdapter: ElephantAdapter
    private lateinit var elephantList: MutableList<ElephantData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        elephantList = mutableListOf()

        initPresenter()
        getElephantList()
        findViews()
    }

    fun initPresenter() {
        val requestInterface = RetrofitService.getRequestInterface()
        requestInterface?.let {
            val repository = ElephantRepositoryProvider.getElephantRepository(it)
            repository?.let { elephantRepository ->
                elephantPresenter = ElephantPresenter(elephantRepository)
            }
        }
    }

    fun findViews() {
        rvElephantsList = rv_list
    }

    fun initRecyclerView() {
        elephantAdapter = ElephantAdapter(elephantList)

        rvElephantsList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = elephantAdapter
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    fun getElephantList() {
        elephantPresenter?.getAllElephants()
    }

    override fun onStart() {
        super.onStart()
        elephantPresenter?.attachView(this)
    }

    override fun showAllElephants(data: List<ElephantData>) {
        if (data.size >= 25) {
            elephantList.addAll(data.subList(0, 25))
        } else {
            elephantList.addAll(data)
        }
        initRecyclerView()
    }

    override fun showError(error: String) {

    }

    override fun onStop() {
        super.onStop()
        elephantPresenter?.detachView(this)
    }
}
