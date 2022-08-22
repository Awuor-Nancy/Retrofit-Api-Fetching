package pic_book.com.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import pic_book.com.myposts.databinding.ActivityCommentsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class commentsActivity : AppCompatActivity() {
    lateinit var binding: ActivityCommentsBinding

    var postId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCommentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        Invoke the functions
        obtainPostId()
        fetchPostById()
        setUpToolbar()
        fetchComments()
    }
    fun obtainPostId(){
        postId = intent.extras?.getInt("POST_ID") ?: 0

    }

    fun fetchPostById (){
        var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        val request = apiClient.getPostsById(postId)
        request.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if(response.isSuccessful){
                    var post = response.body()
                    binding.tvHeading.text = post?.title
                    binding.tvBodyComments.text = post?.body
                }
            }
            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(baseContext, t.message,Toast.LENGTH_LONG).show()
            }
        })
    }
    fun setUpToolbar(){
        setSupportActionBar(binding.toolbar2)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    fun fetchComments (){
        var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        val request = apiClient.getComments()
        request.enqueue(object : Callback <List<Comment>> {
            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
               if(response.isSuccessful){
                   var comments = response.body()?: emptyList()
                   displayComments(comments)
               }
            }

            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    fun displayComments(commentlist: List<Comment>) {
        var commentAdapter=CommentAdapter(commentlist)
        binding.rvcomments.layoutManager=LinearLayoutManager(this)
        binding.rvcomments.adapter=commentAdapter

    }
}

