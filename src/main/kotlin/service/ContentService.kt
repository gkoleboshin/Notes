package service

import conntent.Content

open class ContentService<T: Content> {
    protected val items = mutableListOf<T>()

    fun add(item:T){
        items.add(item)
    }

    fun update(updateItem:T):Boolean{
        for ((index,item) in items.withIndex()){
            if (item.id==updateItem.id){
                items[index] = updateItem
                return true
            }
        }
        return false
    }

    fun delete(deleteItem: T):Boolean{
        for(item in items){
            if (item.id==deleteItem.id){
                item.isDelete = true
                return true
            }
        }
        return false
    }

    fun getById(id:Long):T?{
        return items.findLast { it.id == id && !it.isDelete }
    }

    fun getList():List<T>{
        return items
    }



}