package com.example.taskmanagernew.data.local.db

import androidx.room.*
import com.example.taskmanagernew.data.model.Task

@Dao


interface TaskDao {

    @Query("SELECT*FROM task")
    fun getAllTask():List<Task>

        @Insert
        fun insert (task: Task)
        @Delete
        fun delete(task: Task)
        @Update
        fun update(task: Task)
}