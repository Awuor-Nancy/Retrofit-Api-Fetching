package pic_book.com.myposts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pic_book.com.myposts.databinding.PostsListItemBinding
import retrofit2.http.POST

class PostAdapter(var context: Context,var postsList: List<Post>):
    RecyclerView.Adapter<PostViewHolder>(){

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
                var binding =
                    PostsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return PostViewHolder(binding)
            }

//                      display items on Recycler view
            override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
                var currentPost = postsList.get(position)
                holder.binding.tvUserId.text = currentPost.UserId.toString()
                holder.binding.tvPostId.text = currentPost.id.toString()
                holder.binding.tvPostTitle.text = currentPost.title
                holder.binding.tvPostBody.text = currentPost.body

        // acticating a cardPost when clicked takes you to another activity.
                val context = holder.itemView.context
                holder.binding.cvPosts.setOnClickListener {
                    val intent =Intent(context, commentsActivity::class.java)
                    intent.putExtra("POST_ID", currentPost.id)
                    context.startActivity(intent)

                }
            }
            override fun getItemCount(): Int {
                return postsList.size
            }
    }
  class PostViewHolder(var binding : PostsListItemBinding):
     RecyclerView.ViewHolder(binding.root)




