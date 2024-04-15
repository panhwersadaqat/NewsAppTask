package com.example.newsappmvvmexample.presenter.di

import android.app.Application
import androidx.room.Room
import com.example.newsappmvvmexample.data.db.ArticleDao
import com.example.newsappmvvmexample.data.db.ArticleDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 14/04/24.
 */
@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Singleton
    @Provides
    fun provideNewsDataBase(app: Application): ArticleDataBase {
        return Room.databaseBuilder(app,ArticleDataBase::class.java,"news_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsDao(articleDataBase: ArticleDataBase): ArticleDao {
        return articleDataBase.getArticleDao()
    }
}