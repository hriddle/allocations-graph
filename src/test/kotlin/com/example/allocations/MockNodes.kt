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

object MockPersonNode {
    val jake = PersonNode(name = "Jake")
    val amy = PersonNode(name = "Amy")
    val terry = PersonNode(name = "Terry")
    val rosa = PersonNode(name = "Rosa")
}

object MockProductNode {
    val fullBoyle = ProductNode(name = "Full Boyle")
    val puzzleMaster = ProductNode(name = "The Puzzle Master")
    val terryKitties = ProductNode(name = "Terry Kitties")
    val coralPalms = ProductNode(name = "Coral Palms")
}

object MockWorkedOnRelationship {
    val fullBoyleSergeantTerry = WorkedOn(durationInWeeks = 12, role = "SERGEANT", product = fullBoyle, person = terry)
    val fullBoyleDetectiveAmy = WorkedOn(durationInWeeks = 24, role = "DETECTIVE", product = fullBoyle, person = amy)
    val fullBoyleDetectiveJake = WorkedOn(durationInWeeks = 12, role = "DETECTIVE", product = fullBoyle, person = jake)
    val puzzleMasterDetectiveAmy = WorkedOn(durationInWeeks = 52, role = "DETECTIVE", product = puzzleMaster, person = amy)
    val terryKittiesDetectiveAmy = WorkedOn(durationInWeeks = 12, role = "DETECTIVE", product = terryKitties, person = amy)
    val terryKittiesSergeantTerry = WorkedOn(durationInWeeks = 12, role = "SERGEANT", product = terryKitties, person = terry)
}
