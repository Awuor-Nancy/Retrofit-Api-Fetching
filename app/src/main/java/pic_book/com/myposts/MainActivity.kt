package pic_book.com.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import pic_book.com.myposts.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchPosts()

    }
    fun fetchPosts() {
            val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
            val request = retrofit.getPosts()

        //ceate a callback function to wait for request to be sent and response received
            request.enqueue(object: Callback<List<Post>>{
                override fun onResponse(call: Call<List<Post>>, response:
                Response<List<Post>>) {
                    //if response is successful will notify a user that its successful and gives back response
                    if (response.isSuccessful){
                        var posts = response.body()
//                        if (posts!= null){
//                            displayPosts(posts)
//                        }

                        Toast.makeText(baseContext, "fetched ${posts!!.size} posts", Toast.
                        LENGTH_LONG).show()
                        var getPost7 = PostAdapter(baseContext, posts)
                        Log.d("Tag",posts.toString())
                        binding.rvPosts.adapter = getPost7
                        binding.rvPosts.layoutManager = LinearLayoutManager(baseContext)
                    }
                }
                //id response is an error it will bring back error message and notify user.
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

            }
        })
    }

 }