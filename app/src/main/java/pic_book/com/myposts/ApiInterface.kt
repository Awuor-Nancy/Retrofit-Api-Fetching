package pic_book.com.myposts


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiInterface {
    @GET("posts")
    fun getPosts(): Call<List<Post>>

    @GET("/Posts/{postId}")
    fun getPostsById(@Path("postId") postId:Int): Call<Post>

    @GET("/Comments")
    fun getComments(): Call<List<Comment>>
  }



