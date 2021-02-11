package com.example.mvvmsampleproject.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmsampleproject.data.db.entities.CURRENT_USER_ID
import com.example.mvvmsampleproject.data.db.entities.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(user: User): Long

    @Query("SELECT * From user Where uid = $CURRENT_USER_ID")
    fun getUser(): LiveData<User>


}