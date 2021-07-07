package com.scs.coronaproximity.database

import com.scs.coronaproximity.SearchActivity
import com.scs.coronaproximity.api.CoronaData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(private val databaseDao: DatabaseDao) : SearchActivity() {
    fun readData(): Flow<List<Districts>>{
        return databaseDao.readData()
    }
    suspend fun insertAgsData(coronaData: CoronaData){
        return databaseDao.insertAgsData(coronaData);
    }
}