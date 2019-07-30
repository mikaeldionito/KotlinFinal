package mikaeldionitoharbigantara.gmail.kotlinfinal

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiTheMovieDb {
    @GET("movie/now_playing")
    fun getNowPlaying(
        @Query("api_key") apiKey : String = BuildConfig.API_KEY,
        @Query("language") language : String = BuildConfig.LANGUAGE,
        @Query("page") page : Int
    ): Observable<TheMovieDb>
}
// Mendeklarasikan Aturan Koneksi pada setiap data pada database ke layout dengan kode API yang terdapat di Build.Gradle
