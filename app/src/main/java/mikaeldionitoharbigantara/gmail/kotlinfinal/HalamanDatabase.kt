package mikaeldionitoharbigantara.gmail.kotlinfinal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.halaman_database.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.update
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class HalamanDatabase : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.halaman_database)

        var namaLama = intent.getStringExtra("namaLama")
        var jurusanLama = intent.getStringExtra("jurusanLama")
        var alamatLama = intent.getStringExtra("alamatLama")
        // deklarasi fungsi dari setiap string yang digunakan

        if (alamatLama.isNullOrEmpty()){
            buttonUpdate.isEnabled = false
        }else{
            buttonSimpan.isEnabled = false
            editText_nama.setText(namaLama)
            editText_jurusan.setText(jurusanLama)
            editText_alamat.setText(alamatLama)
        }
        // Fungsi jika pada Alamat KOsong maka akan menghapus data yang diinputkan
        buttonSimpan.setOnClickListener {
            addDataMahasiswa()
            clearData()
        }
        buttonLihat.setOnClickListener {
            startActivity<LihatActivity_SQLite>()
        }
        // mendeklarasikan sebua fungsi button Lihat
        buttonUpdate.setOnClickListener {
            database.use {
                update(MikModel.TABLE_MAHASISWA,
                    MikModel.NAMA to editText_nama.text.toString(),
                    MikModel.JURUSAN to editText_jurusan.text.toString(),
                    MikModel.ALAMAT to editText_alamat.text.toString())
                    .whereArgs("${MikModel.NAMA} = {nama}",
                        "nama" to namaLama
                    ).exec()
            }
            clearData()
            toast("Data Diupdate")
        }
        // Mendeklarasikan sebuah fungsi button Update.
    }

    private fun addDataMahasiswa() {
        database.use {
            insert(MikModel.TABLE_MAHASISWA,
                MikModel.NAMA to editText_nama.text.toString(),
                MikModel.JURUSAN to editText_jurusan.text.toString(),
                MikModel.ALAMAT to editText_alamat.text.toString()

            )
            toast("Data Sukses Disimpan!")
        }
        // mendeklarasikan sebuah funhsi tambah mahasiswa
    }

    fun clearData(){
        editText_nama.text.clear()
        editText_jurusan.text.clear()
        editText_alamat.text.clear()
    }
}
