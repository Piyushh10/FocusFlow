package com.example.studysmart.di

import android.app.Application
import androidx.room.Room
import com.example.studysmart.data.local.AppDatabase
import com.example.studysmart.data.local.SessionDao
import com.example.studysmart.data.local.SubjectDao
import com.example.studysmart.data.local.TaskDao
import com.example.studysmart.data.local.NoteDatabase
import com.example.studysmart.data.repository.NoteRepositoryImpl
import com.example.studysmart.domain.repository.NoteRepository
import com.example.studysmart.domain.use_case.NoteUseCases
import com.example.studysmart.domain.use_case.GetNotes
import com.example.studysmart.domain.use_case.DeleteNote
import com.example.studysmart.domain.use_case.AddNote
import com.example.studysmart.domain.use_case.GetNote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Provides
    @Singleton
    fun provideDatabase(
        application: Application
    ): AppDatabase {
        return Room
            .databaseBuilder(
                application,
                AppDatabase::class.java,
                "studysmart.db"
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideSubjectDao(database: AppDatabase): SubjectDao {
        return database.subjectDao()
    }

    @Provides
    @Singleton
    fun provideTaskDaoDao(database: AppDatabase): TaskDao {
        return database.taskDao()
    }

    @Provides
    @Singleton
    fun provideSessionDao(database: AppDatabase): SessionDao {
        return database.sessionDao()
    }

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository),
            getNote = GetNote(repository)
        )
    }
}
//AppModule ki jagah database module