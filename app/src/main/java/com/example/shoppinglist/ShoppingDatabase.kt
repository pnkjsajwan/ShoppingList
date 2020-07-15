package com.example.shoppinglist

import android.content.Context
import androidx.room.Database
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingDatabase : RoomDatabase() {
    abstract fun getShoppingDao(): ShoppingDao

    companion object {
        @Volatile
        private var instance: ShoppingDatabase? = null

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            ShoppingDatabase::class.java, "ShoppingDB.db"
        ).build()
    }
}