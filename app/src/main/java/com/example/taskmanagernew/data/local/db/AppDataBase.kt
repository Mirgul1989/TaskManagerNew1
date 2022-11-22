package com.example.taskmanagernew.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.taskmanagernew.data.model.Task

@Database(entities = [Task::class], version = 1)
 abstract class AppDataBase : RoomDatabase(){
     abstract fun taskDao():TaskDao

}