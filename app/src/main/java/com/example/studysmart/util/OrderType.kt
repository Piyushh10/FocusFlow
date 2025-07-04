package com.example.studysmart.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}