package com.kotlin.testkotlin.entity

import java.util.*
import javax.persistence.*

@Table(name = "testentity")
@Entity
data class TestEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID? = null,
    @Column(name="documentid")
    var documentId: UUID? = null,
    @Column(name="dictionaryvalueid")
    var dictionaryValueId: UUID? = null,
    @Column(name="sortorder")
    var sortOrder: String? = null
    ) {
    @Column(name = "testid")
    var testId: UUID? = null
    @Column(name = "testname")
    var testName: String = "Test"
}
