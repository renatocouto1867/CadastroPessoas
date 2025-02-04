package com.example.cadastropessoas.model.database;


import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.cadastropessoas.model.dao.PessoaDao;
import com.example.cadastropessoas.model.entity.Pessoa;


@Database(entities = {Pessoa.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public abstract PessoaDao pessoaDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    "pessoas_database"
            ).build();
        }
        return instance;
    }
}