package com.scs.coronaproximity.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "districts")
data class Districts(
    var ags: String,
    var name: String,
    var county: String,
    var population: Int,
    var cases: Int,
    var deaths: Int,
    var casesPerWeek: Int,
    var deathsPerWeek: Int,
    var recovered: Int,
    var weekIncidence: Float,
    var casesPer100k: Float,
    var delta_cases: Int,
    var delta_deaths: Int,
    var delta_recovered: Int) {@PrimaryKey(autoGenerate = true)
var id: Int=0}
