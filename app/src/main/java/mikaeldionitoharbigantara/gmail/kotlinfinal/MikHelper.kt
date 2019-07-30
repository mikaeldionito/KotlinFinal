package mikaeldionitoharbigantara.gmail.kotlinfinal

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*


class MikHelper(ctx : Context) : ManagedSQLiteOpenHelper(ctx, "Mahasiswa.db", null, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable(MikModel.TABLE_MAHASISWA,true, MikModel.ID to INTEGER+ PRIMARY_KEY+ AUTOINCREMENT,
            MikModel.NAMA to TEXT,
            MikModel.JURUSAN to TEXT,
            MikModel.ALAMAT to TEXT
            )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable(MikModel.TABLE_MAHASISWA,true)
    }

    companion object {
        private var instance: MikHelper? = null
        @Synchronized
        fun getInstance(ctx: Context) : MikHelper{
            if (instance == null) {
                instance = MikHelper(ctx.applicationContext)
            }
            return instance as MikHelper
        }
    }
}
val Context.database : MikHelper
get() = MikHelper.getInstance(applicationContext)