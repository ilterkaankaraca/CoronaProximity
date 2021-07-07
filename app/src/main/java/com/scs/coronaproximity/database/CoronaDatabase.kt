package com.scs.coronaproximity.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Districts::class], version = 1, exportSchema = false)
abstract class CoronaDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao
}