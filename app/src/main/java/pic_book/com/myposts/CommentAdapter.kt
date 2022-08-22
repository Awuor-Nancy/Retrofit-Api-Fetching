package pic_book.com.myposts

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pic_book.com.myposts.databinding.CommentsListItemBinding

class CommentAdapter ( var commentsList: List<Comment>):
        RecyclerView.Adapter<CommentViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        var binding =
            CommentsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentViewHolder(binding)

    }
           //    display items on Recycler view
    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {

            var currentComment = commentsList.get(position)
            holder.binding.tvPostCommentId.text = currentComment.postId.toString()
            holder.binding.tvCommentId.text = currentComment.id.toString()
            holder.binding.tvCommentName.text = currentComment.name
            holder.binding.tvCommentEmail.text = currentComment.email
               holder.binding.tvCommentBody.text = currentComment.body

    }
    override fun getItemCount(): Int {
        return commentsList.size

    }
}
class CommentViewHolder(var binding: CommentsListItemBinding):
RecyclerView.ViewHolder(binding.root)
