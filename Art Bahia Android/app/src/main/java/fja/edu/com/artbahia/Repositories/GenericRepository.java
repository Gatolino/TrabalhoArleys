package fja.edu.com.artbahia.Repositories;

import android.content.Context;
import fja.edu.com.artbahia.Util.SQLiteUtil;

public abstract class GenericRepository<T> {
    protected SQLiteUtil sqliteUtil;

    public GenericRepository(Context context) {
        sqliteUtil = new SQLiteUtil(context);
    }

    // CRUD
    public abstract void Save(T object);
    public abstract T GetById(int id);
    //public abstract void Delete(int id);
}
