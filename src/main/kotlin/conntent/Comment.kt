package conntent

data class Comment(override val id:Long,
                   val postOrNotesId:Long,
                   val text:String,
                   override var isDelete:Boolean = false): Content(id,isDelete)
