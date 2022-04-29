package and5.abrar.mvpnews

import and5.abrar.mvpnews.adapter.AdapterNEws
import and5.abrar.mvpnews.model.getAllNewsItem
import and5.abrar.mvpnews.presenter.NewsPresenter
import and5.abrar.mvpnews.presenter.NewsView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),NewsView {
    private  lateinit var  presenter: NewsPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = NewsPresenter(this)
        presenter.getDataNews()
    }

    override fun onSuccess(pesan: String, news: List<getAllNewsItem>) {
        rvNews.layoutManager = LinearLayoutManager(this)
        rvNews.adapter = AdapterNEws(news)
    }

    override fun onError(pesan: String) {
        Toast.makeText(this,pesan,Toast.LENGTH_LONG).show()
    }
}