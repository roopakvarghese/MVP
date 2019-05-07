package test.sumskar.com.mvp.model

import java.time.temporal.TemporalQuery

object WikiModel {
    data class Result(val query: Query)
    data class Query(val searchinfo: SearchInfo)
    data class SearchInfo(val totalhits: Int)
}