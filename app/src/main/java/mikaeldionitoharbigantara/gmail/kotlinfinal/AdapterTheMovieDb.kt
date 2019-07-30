package mikaeldionitoharbigantara.gmail.kotlinfinal

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_movie.view.*

class AdapterTheMovieDb(private val context: Context, private var resultTheMovieDb: ArrayList<Result>) : RecyclerView.Adapter<AdapterTheMovieDb.ViewHolderTheMovieDb>() {
    private val TAG = javaClass.simpleName

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderTheMovieDb =
        ViewHolderTheMovieDb(
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent,false)
        )

    override fun onBindViewHolder(holder: ViewHolderTheMovieDb, position: Int) {
        val resultItem = resultTheMovieDb[position]
        // mendeklarasikan posisi pada saat terhubung pada layout pada item_movie.xml
        Glide
            .with(context)
            .load(BuildConfig.BASE_URL_IMAGE + resultItem.poster_path)
            .into(holder.itemView.image_view_poster_item_movie)
        // mendeklarasikan sebuah gambar yang terhubung ke dalam layout
        holder
            .itemView
            .text_view_title_movie_item_movie
            .text = resultItem.original_title
        // mendeklarasikan sebuah title dari setiap judul movie yang terdapat pada database movie
        holder
            .itemView
            .text_view_vote_average_item_movie
            .text = resultItem.vote_average.toString()
        // mendeklarasikan rating dari setiap film yang diambil dari database Movie
        holder
            .itemView
            .text_view_release_date_item_movie
            .text = resultItem.release_date
        // mendeklarasikan tahun rilis dari setiap film yang diambil dari database Movie
        holder
            .itemView
            .text_view_overview_value_item_movie
            .text = resultItem.overview
        // mendeklarasiakn Overvie yang diambil dari database movie
    }

    override fun getItemCount(): Int = resultTheMovieDb.size

    fun refreshAdapter(resultTheMovieDb: List<Result>) {
        this.resultTheMovieDb.addAll(resultTheMovieDb)
        notifyItemRangeChanged(0, this.resultTheMovieDb.size)
    }
    // Fungsi untuk melakukan Refresh setiap ada judul Film yang baru

    inner class ViewHolderTheMovieDb(itemView: View): RecyclerView.ViewHolder(itemView)

}