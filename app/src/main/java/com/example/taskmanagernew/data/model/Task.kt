package com.example.taskmanagernew.data.model

import java.io.Serializable


data class Task(
    var title:String?=null,
    var desc:String?=null
)  : Serializable