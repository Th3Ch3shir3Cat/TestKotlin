package com.kotlin.testkotlin.repository

import com.kotlin.testkotlin.entity.TestEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface TestEntityRepository : CrudRepository<TestEntity, UUID>{}