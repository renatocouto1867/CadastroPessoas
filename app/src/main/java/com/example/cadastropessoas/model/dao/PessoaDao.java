package com.example.cadastropessoas.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.cadastropessoas.model.entity.Pessoa;

import java.util.List;

@Dao
public interface PessoaDao {
    @Insert
    void insert(Pessoa pessoa);

    @Query("SELECT * FROM pessoas")
    LiveData<List<Pessoa>> getAllPessoas();
}

