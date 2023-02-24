package edu.ucsd.cse110.lab6app;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TodoListItemDao {
    @Insert
    List<Long> insertAll(List<TodoListItem> todoListItem);
    @Insert
    long insert(TodoListItem todoListItem);

    @Query("SELECT `order` + 1 FROM `todo_list_items` ORDER BY `order` DESC LIMIT 1")
    int getOrderForAppend();

    @Query("SELECT * FROM `todo_list_items` WHERE `id`=:id")
    TodoListItem get(long id);

    @Query("SELECT * FROM `todo_list_items` ORDER BY `order`")
    List<TodoListItem> getAll();

    @Query("SELECT * FROM `todo_list_items` ORDER BY `order`")
    LiveData<List<TodoListItem>> getAllLive();

    @Update
    int update(TodoListItem todoListItem) ;

    @Delete
    int delete(TodoListItem todoListItem);

}