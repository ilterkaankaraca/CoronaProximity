package com.scs.coronaproximity.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.scs.coronaproximity.api.CoronaData
import kotlinx.coroutines.flow.Flow

@Dao
interface DatabaseDao {
    @Query("SELECT * FROM districts ORDER BY id ASC")
    fun readData(): Flow<List<Districts>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAgsData(coronaData: CoronaData )
}