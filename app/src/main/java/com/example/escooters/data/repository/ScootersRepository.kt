package com.example.escooters.data.repository

import com.example.escooters.data.model.Scooter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ScootersRepository
    @Inject
    constructor()
{
        suspend fun getScooters(): Flow<List<Scooter>> = flow {
                emit(mutableListOf(Scooter("hi","hi", "hi", 3, isInUse = true, true,5)))
            }
        }

