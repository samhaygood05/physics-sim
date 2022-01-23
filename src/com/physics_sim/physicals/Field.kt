package com.physics_sim.physicals

import com.physics_sim.Main
import com.physics_sim.geometrics.Vector
import com.physics_sim.util.scalarField
import com.physics_sim.util.vectorField
import com.physics_sim.geometrics.Point
import java.awt.Color
import kotlin.math.pow

class Field(var velocityScalar: scalarField = { 1.0 }, var fieldForce: vectorField = {Vector()}) {


    override fun toString(): String {
            return "${scalarFieldToString(velocityScalar)}, ${vectorFieldToString(fieldForce)}"
    }
}

fun attractiveField(center: Point, strength: Double): vectorField = {
    Vector(this, center).norm() * strength * (Vector(this, center).magnitude()).pow(2)
}

fun vectorFieldToString(fieldForce: vectorField): String {
    return "Pos -> Vel"
}
fun scalarFieldToString(fieldForce: scalarField): String {
    return "Pos -> Scalar"
}
