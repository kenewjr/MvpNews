package and5.abrar.mvpnews.presenter

import and5.abrar.mvpnews.model.getAllNewsItem
import and5.abrar.mvpnews.network.ApiClient
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsPresenter(val view: NewsView) {
    fun getDataNews(){
        ApiClient.instance.getAllnews()
            .enqueue(object : Callback<List<getAllNewsItem>> {
                override fun onResponse(
                    call: Call<List<getAllNewsItem>>,
                    response: Response<List<getAllNewsItem>>
                ) {
                    if (response.isSuccessful){
                        view.onSuccess(response.message(),response.body()!!)
                    }else{
                        view.onError(response.message())

                    }

                }

                override fun onFailure(call: Call<List<getAllNewsItem>>, t: Throwable) {
                    view.onError(t.message!!)
                }

            })
    }
}