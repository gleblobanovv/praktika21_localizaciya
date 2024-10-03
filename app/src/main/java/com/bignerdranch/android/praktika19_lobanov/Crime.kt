package com.bignerdranch.android.praktika19_lobanov

import java.time.LocalDateTime
import java.util.UUID

data class Crime(val id: UUID= UUID.randomUUID(), var title:String,var isSloved:Boolean,val date:LocalDateTime) {
}