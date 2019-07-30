package mikaeldionitoharbigantara.gmail.kotlinfinal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_lihat__sqlite.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

class LihatActivity_SQLite : AppCompatActivity() {
    private lateinit var adapter: MikAdapter
    private var mahasiswa = ArrayList<MikModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lihat__sqlite)

        adapter = MikAdapter(this,mahasiswa)
        recyclerView.adapter = adapter

        getData()
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun getData() {
        database.use {
            mahasiswa.clear()
            var result = select(MikModel.TABLE_MAHASISWA)
            var dataMahasiswa = result.parseList(classParser<MikModel>())
            mahasiswa.addAll(dataMahasiswa)
            adapter.notifyDataSetChanged()
        }
    }
}
