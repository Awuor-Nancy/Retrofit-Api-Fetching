package pic_book.com.myposts

data class Post(
var UserId: Int,
var id: Int,
var title: String,
var body: String
)
data class Comment(
    var postId: Int,
    var id: Int,
    var name: String,
    var email: String,
    var body: String
)
fun comparePosts(post1:Post,post2:Post,post3:Post): Post{
    //Do something
    return post1
}
fun compareComments(comment1:Comment,comment2:Comment,comment3:Comment): Comment{
    //Do something
    return  comment3
}

