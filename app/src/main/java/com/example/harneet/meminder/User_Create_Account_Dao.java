package com.example.harneet.meminder;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Harneet on 12/6/2017.
 */

@Dao
public interface User_Create_Account_Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addUser(User_Create_Account user_create_account);

    @Query("select * from user_create_account")
    public List<User_Create_Account> getAllUser();

    @Query("select * from user_create_account where id = id")
    public List<User_Create_Account> getUser();

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateUser(User_Create_Account user_create_account);

    @Query("delete from user_create_account")
    void removeAllUsers();
}