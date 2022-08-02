package com.kotlin.testkotlin.controller

import com.kotlin.testkotlin.entity.TestEntity
import com.kotlin.testkotlin.service.TestEntityService
import com.kotlin.testkotlin.util.TestEntityUtil
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.net.URI

@RestController
class TestRestController(private val service: TestEntityService,
                            private val testUtil: TestEntityUtil
                         ) {

    @PostMapping("/addEntity")
    fun postEntity(@RequestBody entity: TestEntity) : ResponseEntity<TestEntity> {
        val location: URI = URI.create(String.format("/addEntity/%s", service.createEntity(entity).id))
        return ResponseEntity.created(location).build()
    }

    @GetMapping("/getEntities")
    fun getAllEntities() : MutableIterable<TestEntity> = service.allTestEntity()

    @GetMapping("/getEntity/{id}")
    fun getEntity(@PathVariable id: String): TestEntity {
        return service.findEntity(testUtil.getEntityIdFromString(id)).orElseThrow{ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found")}
    }

    @PatchMapping("/updateEntity/{id}")
    fun updateEntity(@RequestBody testEntity: TestEntity, @PathVariable id: String) : ResponseEntity<TestEntity>{
        service.saveEntity(testEntity, testUtil.getEntityIdFromString(id))
        return ResponseEntity.ok(testEntity)
    }

    @DeleteMapping("/deleteEntity/{id}")
    fun deleteEntity(@PathVariable id: String) {
        return service.deleteEntity(testUtil.getEntityIdFromString(id))
    }

}