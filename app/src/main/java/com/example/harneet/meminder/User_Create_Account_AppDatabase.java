package com.example.harneet.meminder;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by Harneet on 12/7/2017.
 */

@Database(entities = {User_Create_Account.class}, version = 1, exportSchema = false)
public abstract class User_Create_Account_AppDatabase extends RoomDatabase {
    private static  User_Create_Account_AppDatabase INSTANCE;

    public abstract User_Create_Account_Dao user_create_account_dao();

    public static User_Create_Account_AppDatabase getDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context, User_Create_Account_AppDatabase.class, "User Create_Account Database")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE = null;
    }
}