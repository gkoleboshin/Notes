import conntent.Comment
import conntent.Note
import org.junit.Test

import org.junit.Assert.*
import service.CommentsService
import service.NotesService

class MainKtTest {

    @Test
    fun if_delete_note_then_delete_comments() {
        val notesService = NotesService()
        val commentsService = CommentsService()

        commentsService.add(Comment(1,3,"1"))
        commentsService.add(Comment(2,3,"2"))
        val note1 = Note(1,1,"s d r&r",commentsService.getMutableList(1))
        val note2 = Note(2,1,"s d r&r", commentsService.getMutableList(2))
        val note3 = Note(3,1,"s d r&r",commentsService.getMutableList(3))
        notesService.add(note1)
        notesService.add(note2)
        notesService.add(note3)
        notesService.delete(note2)
        val deleteComments = commentsService.getMutableList(note2.id)
        deleteComments.forEach { it.isDelete=true}
        notesService.update(note2.copy(isDelete = true, comments = deleteComments))
        val resault = notesService.getList().first{note:Note->note.id==note2.id}.comments.filter {comment:Comment -> !comment.isDelete }.toList().isEmpty()
        assertTrue(resault)
    }
}