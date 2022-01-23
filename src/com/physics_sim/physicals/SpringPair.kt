package com.physics_sim.physicals

import com.physics_sim.geometrics.Vector

class SpringPair(var particle1: Particle, var particle2: Particle, var length: Double, var k: Double) {

    fun applyForce(force1: Vector = Vector(), force2: Vector = Vector()) {
        val d = particle1.pos.dist(particle2.pos) - length
        particle1.applyForce(force1 + (Vector(particle1.pos, particle2.pos).norm() * d * k))
        particle2.applyForce(force2 - (Vector(particle1.pos, particle2.pos).norm() * d * k))
    }
    fun applyVel() {
        particle1.applyVel()
        particle2.applyVel()
    }
    fun applyPos() {
        particle1.pos = particle1.nextPos
        particle2.pos = particle2.nextPos
    }
    fun capPos() {
        particle1.capPos()
        particle2.capPos()
    }
}