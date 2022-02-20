package conntent

data class Note(override val id:Long,
                val ownerId:Long,
                val content:String,
                val comments:MutableList<Comment>,
                override var isDelete:Boolean = false): Content(id,isDelete)