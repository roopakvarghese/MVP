package test.sumskar.com.mvp.presenter.WikiService

import test.sumskar.com.mvp.model.SearchModel

interface WikiUpPresenter {
    interface View{
        fun wikiSuccess(search: List<SearchModel>)
        fun wikiError()
    }
    interface Presenter{
        fun doWikicall(search : String,mView : View)
    }
}