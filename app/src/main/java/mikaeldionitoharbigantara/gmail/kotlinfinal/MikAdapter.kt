package mikaeldionitoharbigantara.gmail.kotlinfinal

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_list.view.*
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MikAdapter(val context: Context, val items: ArrayList<MikModel>)
    : RecyclerView.Adapter<MikAdapter.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list,p0,false))
    }

    override fun getItemCount(): Int = items.size


    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bindItem(items[p1])
    }

    class ViewHolder(view : View) :RecyclerView.ViewHolder(view){
        fun bindItem(items : MikModel){
            itemView.namaMahasiswa.text = items.nama
            itemView.jurusanMahasiswa.text = items.jurusan
            itemView.alamatMahasiswa.text = items.alamat

            itemView.btnEdit.setOnClickListener {
                itemView.context.startActivity<HalamanDatabase>(
                    "namaLama" to items.nama,
                    "jurusanLama" to items.jurusan,
                    "alamatLama" to items.alamat
                )
            }
            itemView.btnHapus.setOnClickListener {
                itemView.context.database.use {
                    delete(MikModel.TABLE_MAHASISWA, "(${MikModel.NAMA}={nama})",
                        "nama" to items.nama.toString())
                }
                itemView.context.toast("Data Telah Dihapus!")

            }

        }
    }
}