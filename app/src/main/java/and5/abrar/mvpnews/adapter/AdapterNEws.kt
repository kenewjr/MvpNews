package and5.abrar.mvpnews.adapter

import and5.abrar.mvpnews.R
import and5.abrar.mvpnews.model.getAllNewsItem
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_news.view.*

class AdapterNEws(private  var datanews :List<getAllNewsItem>):RecyclerView.Adapter<AdapterNEws.ViewHolder>() {
    class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewitem = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news,parent, false)
        return ViewHolder(viewitem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(datanews!![position].image)
            .into(holder.itemView.gambarnews)
        holder.itemView.judulnews.text = datanews!![position].title
        holder.itemView.tanggalNews.text = datanews!![position].createdAt
        holder.itemView.Author.text = datanews!![position].author
    }

    override fun getItemCount(): Int {
      return datanews.size
    }
}