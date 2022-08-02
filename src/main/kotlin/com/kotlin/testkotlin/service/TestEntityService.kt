package com.kotlin.testkotlin.service

import com.kotlin.testkotlin.entity.TestEntity
import com.kotlin.testkotlin.repository.TestEntityRepository
import org.slf4j.LoggerFactory
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import java.util.*


@Service
class TestEntityService(val db: TestEntityRepository) {

    private final val logger = LoggerFactory.getLogger(this.javaClass)

    fun allTestEntity() : MutableIterable<TestEntity> = db.findAll()

    fun findEntity(id: UUID): Optional<TestEntity> = db.findById(id)

    fun createEntity(testEntity: TestEntity) : TestEntity {
        testEntity.testId = UUID.randomUUID()
        testEntity.testName += " " + testEntity.testId
        return db.save(testEntity)
    }

    fun saveEntity(testEntity: TestEntity, id: UUID) : TestEntity {
        return db.save(testEntity.copy(id))
    }

    fun deleteEntity(id: UUID){
        try {
            return db.deleteById(id)
        }catch (ex: EmptyResultDataAccessException){
            logger.error("Not found entity")
            throw java.lang.RuntimeException(ex.message)
        }
    }

}