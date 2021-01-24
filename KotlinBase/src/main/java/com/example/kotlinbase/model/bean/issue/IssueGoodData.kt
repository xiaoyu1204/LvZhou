package com.example.kotlinbase.model.bean.issue

data class IssueGoodData(
    val count: Int,
    val currentPage: Int,
    val `data`: List<Data>,
    val pageSize: Int,
    val totalPages: Int
){
    data class Data(
        val id: Int,
        val name: String,
        val sort: Int,
        val title: String,
        val url: Any
    )
}
