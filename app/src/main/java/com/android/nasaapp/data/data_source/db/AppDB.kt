package com.android.nasaapp.data.data_source.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.nasaapp.data.DataEntity

@Database(entities = [DataEntity::class], version = 1)
abstract class AppDb : RoomDatabase() {

    abstract fun appDao(): AppDao

//   /******* Implementation is in DbModule *******/

//    companion object {
//        @Volatile
//        private var INSTANCE: AppDb? = null
//
//        fun getDatabase(context: Context): AppDb {
//            return INSTANCE ?: synchronized(this) {
//                Room.databaseBuilder(context.applicationContext, AppDb::class.java, "nasa_db")
//                    .build()
//                    .also { INSTANCE = it }
//            }
//        }
//    }
}
