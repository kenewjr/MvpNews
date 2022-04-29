package and5.abrar.mvpnews.presenter

import and5.abrar.mvpnews.model.getAllNewsItem

interface NewsView {
    fun onSuccess(pesan:String,news:List<getAllNewsItem>)
    fun onError(pesan: String)
}