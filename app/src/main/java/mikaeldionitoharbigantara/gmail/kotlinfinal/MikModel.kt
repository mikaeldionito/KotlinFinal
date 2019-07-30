package mikaeldionitoharbigantara.gmail.kotlinfinal

data class MikModel (var id: Long?, var nama: String?, var jurusan:String?, var alamat:String?){
    companion object {
        const val TABLE_MAHASISWA : String = "TABLE_MAHASISWA"
        const val ID : String = "ID_"
        const val NAMA : String = "NAMA"
        const val JURUSAN : String = "JURUSAN"
        const val ALAMAT : String = "ALAMAT"
    }
}