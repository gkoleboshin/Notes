package conntent

data class Post(override val id:Long,
                val type: PostType,
                val content:String,
                val likes:Int = 0,
                override var isDelete:Boolean = false): Content(id,isDelete)
