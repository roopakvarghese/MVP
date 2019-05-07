package test.sumskar.com.mvp.adapter

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.wiki_adapter.view.*
import test.sumskar.com.mvp.R
import test.sumskar.com.mvp.model.SearchModel
import test.sumskar.com.mvp.ui.ActivityUtils

class RecyclerWikiAdapter : RecyclerView.Adapter<RecyclerWikiAdapter.ViewHolder>() {
    private var search : List<SearchModel>?=null
    private var listner : ActivityUtils.OnItemClickCallback?=null

    fun setWikidata(searchList: List<SearchModel>){
        this.search=searchList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val root: View =LayoutInflater.from(p0.context).inflate(R.layout.wiki_adapter,p0,false)
        return ViewHolder(root)
    }

    override fun getItemCount(): Int {
        return search?.size?:0
    }

    override fun onBindViewHolder(viewHolder:ViewHolder, position: Int) {
        val get = search?.get(position)
        viewHolder.title.text= get?.title
        if (listner!=null){
            viewHolder.bind(position, get!!, listner!!)
        }

    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var title : TextView =itemView.tv_title
        var layout : CardView =itemView.item_layout
        fun bind(position: Int,get:SearchModel,listner:ActivityUtils.OnItemClickCallback){
            layout.setOnClickListener {
                listner?.onItemClick(it,get,position)
            }
        }
    }
    fun setListners(listners:ActivityUtils.OnItemClickCallback){
        this.listner=listners
    }
}