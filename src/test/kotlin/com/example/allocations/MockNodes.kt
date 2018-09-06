package com.example.allocations

import com.example.allocations.MockPersonNode.amy
import com.example.allocations.MockPersonNode.jake
import com.example.allocations.MockPersonNode.terry
import com.example.allocations.MockProductNode.fullBoyle
import com.example.allocations.MockProductNode.puzzleMaster
import com.example.allocations.MockProductNode.terryKitties
import com.example.allocations.person.PersonNode
import com.example.allocations.product.ProductNode
import com.example.allocations.team.WorkedOn
import java.time.LocalDate

object MockPersonNode {
    val jake = PersonNode(id = 1, name = "Jake", company = "NYPD", role = "DETECTIVE", level = "DETECTIVE")
    val amy = PersonNode(id = 2, name = "Amy", company = "NYPD", role = "DETECTIVE", level = "DETECTIVE")
    val terry = PersonNode(id = 3, name = "Terry", company = "NYPD", role = "SERGEANT", level = "SERGEANT")
    val rosa = PersonNode(id = 4, name = "Rosa", company = "NYPD", role = "DETECTIVE", level = "DETECTIVE")
}

object MockProductNode {
    val fullBoyle = ProductNode(name = "Full Boyle")
    val puzzleMaster = ProductNode(name = "The Puzzle Master")
    val terryKitties = ProductNode(name = "Terry Kitties")
    val coralPalms = ProductNode(name = "Coral Palms")
}

object MockWorkedOnRelationship {
    val fullBoyleSergeantTerry = WorkedOn(startDate = LocalDate.of(2018, 1, 1), endDate = LocalDate.of(2018, 4, 1), company="NYPD", role = "SERGEANT", product = fullBoyle, person = terry)
    val fullBoyleDetectiveAmy = WorkedOn(startDate = LocalDate.of(2018, 1, 1), endDate = LocalDate.of(2018, 7, 1), company="NYPD", role = "DETECTIVE", product = fullBoyle, person = amy)
    val fullBoyleDetectiveJake = WorkedOn(startDate = LocalDate.of(2018, 1, 1), endDate = LocalDate.of(2018, 4, 1), company="NYPD", role = "DETECTIVE", product = fullBoyle, person = jake)
    val puzzleMasterDetectiveAmy = WorkedOn(startDate = LocalDate.of(2018, 1, 1), endDate = LocalDate.of(2019, 1, 1), company="NYPD", role = "DETECTIVE", product = puzzleMaster, person = amy)
    val terryKittiesDetectiveAmy = WorkedOn(startDate = LocalDate.of(2018, 1, 1), endDate = LocalDate.of(2018, 4, 1), company="NYPD", role = "DETECTIVE", product = terryKitties, person = amy)
    val terryKittiesSergeantTerry = WorkedOn(startDate = LocalDate.of(2018, 1, 1), endDate = LocalDate.of(2018, 4, 1), company="NYPD", role = "SERGEANT", product = terryKitties, person = terry)
}
