import conntent.Comment
import conntent.Note
import service.CommentsService
import service.NotesService
import kotlin.collections.toMutableList as toMutableList1

fun main() {
  var serviceNotes = NotesService()
  val serviceComments = CommentsService()
  serviceComments.add(Comment(1,3,"1"))
  serviceComments.add(Comment(2,3,"2"))

  serviceNotes.add(Note(1,1,"s d r&r",serviceComments.getMutableList(1)))
  serviceNotes.add(Note(2,1,"s d r&r", serviceComments.getMutableList(2)))
  serviceNotes.add(Note(3,1,"s d r&r",serviceComments.getMutableList(3)))
  println(serviceNotes.getList())
  serviceComments.delete(Comment(2,3,"2"))
  serviceNotes = deleteNote(Note(2,1,"s d r&r",serviceComments.getMutableList(2)),serviceNotes,serviceComments)
  serviceNotes.update(Note(3,2,"S d r&r", serviceComments.getMutableList(3)))
  println(serviceNotes.getById(2))

}

fun deleteNote(note:Note,serviceNotes:NotesService,serviceComments:CommentsService):NotesService {
  serviceNotes.delete(note)
  val deleteComments = serviceComments.getMutableList(note.id)
  deleteComments.forEach { it.isDelete=true}
  serviceNotes.update(note.copy(isDelete = true, comments = deleteComments))
  return serviceNotes
}



