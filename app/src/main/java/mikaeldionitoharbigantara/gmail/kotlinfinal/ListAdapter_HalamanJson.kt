package mikaeldionitoharbigantara.gmail.kotlinfinal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListAdapter_HalamanJson(val context: Context, val list: ArrayList<Dataku>):BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view : View = LayoutInflater.from(context).inflate(R.layout.row_layout,parent,false)
        val id = view.findViewById<TextView>(R.id.txt_id)
        val nama = view.findViewById<TextView>(R.id.txt_nama)
        val email = view.findViewById<TextView>(R.id.txt_email)
        val lokasi = view.findViewById<TextView>(R.id.txt_lokasi)

        id.text = list[position].id.toString()
        nama.text = list[position].nama.toString()
        email.text = list[position].email.toString()
        lokasi.text = list[position].lokasi.toString()

        return view

    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }
}