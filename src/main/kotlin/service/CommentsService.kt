package service

import conntent.Comment

class CommentsService:ContentService<Comment>(){
        fun getMutableList(NoteOrPostID:Long):MutableList<Comment>{
        return items.filter{ it.postOrNotesId==NoteOrPostID && !it.isDelete }.toMutableList()
    }
}