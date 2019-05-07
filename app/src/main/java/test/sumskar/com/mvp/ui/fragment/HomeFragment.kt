package test.sumskar.com.mvp.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*
import test.sumskar.com.mvp.R
import test.sumskar.com.mvp.adapter.RecyclerWikiAdapter
import test.sumskar.com.mvp.model.SearchModel
import test.sumskar.com.mvp.presenter.WikiService.WikiUpPresenter
import test.sumskar.com.mvp.presenter.WikiService.WikiUpPresenterImpl
import test.sumskar.com.mvp.ui.ActivityUtils

class HomeFragment : Fragment(),WikiUpPresenter.View, ActivityUtils.OnItemClickCallback {


    var presenter: WikiUpPresenter.Presenter?=null
    var searchdata : String?=null
    private var callback : ActivityUtils.OnItemClickCallback?=null
    companion object{
        fun newInstance():HomeFragment{
            return HomeFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initobjects()
        callingObjects()
    }

    private fun initobjects() {
        presenter=WikiUpPresenterImpl()
        initRecycler()
    }

    private fun initRecycler() {
        rv_wiki.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

    }

    private fun callingObjects() {
        btn_search.setOnClickListener {
            searchdata = search_text.text.trim().toString()
            presenter?.doWikicall(searchdata!!,this)
        }
    }

   /* fun setListners(call : ActivityUtils.OnItemClickCallback){
        this.callback=call
    }*/

    override fun wikiSuccess(search : List<SearchModel>) {
        setupWki(search)
    }

    private fun setupWki(search: List<SearchModel>) {
        val recyclerWikiAdapter1 = RecyclerWikiAdapter()
        recyclerWikiAdapter1.setWikidata(search)
        recyclerWikiAdapter1.setListners(this)
        rv_wiki.adapter=recyclerWikiAdapter1
    }

    override fun wikiError() {
    }

    override fun onItemClick(view: View, `object`: Any, position: Int) {
        callback?.onItemClick(view,`object`,position)
             if (`object` is SearchModel){
                 val objectSearchValue=`object` as SearchModel
                Log.d("clicked",objectSearchValue.title)
             }
    }

}