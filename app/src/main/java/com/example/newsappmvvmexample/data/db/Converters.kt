package com.example.newsappmvvmexample.data.db

import androidx.room.TypeConverter
import com.example.newsappmvvmexample.data.model.Source

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 14/04/24.
 */

class Converters {
    @TypeConverter
    fun fromDataSource(source: Source): String {
        return source.name
    }
    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name,name)
    }
}