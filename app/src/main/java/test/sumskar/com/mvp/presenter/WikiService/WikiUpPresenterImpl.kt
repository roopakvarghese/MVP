package test.sumskar.com.mvp.presenter.WikiService

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import test.sumskar.com.mvp.Services.GetDataService
import test.sumskar.com.mvp.Services.RetrofitClientInstance
import test.sumskar.com.mvp.model.BaseResponce
import test.sumskar.com.mvp.model.SearchModel

class WikiUpPresenterImpl : WikiUpPresenter.Presenter {
    override fun doWikicall(search: String,mView : WikiUpPresenter.View) {
        val service = RetrofitClientInstance.getRetrofitInstance()?.create(GetDataService::class.java)
        val call = service?.getWikiData("query", "json", "search", search)
        call?.enqueue(object : Callback<BaseResponce>{
            override fun onFailure(call: Call<BaseResponce>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<BaseResponce>, response: Response<BaseResponce>) {
                    if (response.isSuccessful){
                        var body: BaseResponce? = response.body()
                        var search: List<SearchModel> = body?.query!!.search
                        mView.wikiSuccess(search)
                    }
            }
        })
       /* call?.enqueue(object : Callback<BaseResponce>{
            override fun onFailure(call: Call<BaseResponce>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<BaseResponce>, response: Response<BaseResponce>) {
                if(response.isSuccessful){
                    val body = response.body()
                    if(body is BaseResponce){
                        var search1 = body.query.search.get(0).title
                        Log.d("search result", search1)
                    }
                }
            }

        })*/
       /* call?.enqueue(object : Callback<BaseResponce> {
            override fun onResponse(call: Call<BaseResponce>, response:BaseResponce) {


                if (response.isSuccessful) {
                    val bod = response.body()
                    Log.d("message",body)

                }
            }

            override fun onFailure(call: Call<BaseResponce>, t: Throwable) {
                Log.d("message>", t.message)

            }
        })*/
    }
}