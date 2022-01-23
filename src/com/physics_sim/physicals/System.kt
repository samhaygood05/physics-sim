package com.physics_sim.physicals

import com.physics_sim.geometrics.Vector
import com.physics_sim.util.Constants.Companion.HEIGHT
import com.physics_sim.util.Constants.Companion.SHOW_FPS
import com.physics_sim.util.Constants.Companion.SHOW_TRAILS
import com.physics_sim.util.Constants.Companion.SPF
import com.physics_sim.util.Constants.Companion.WIDTH
import com.physics_sim.util.TheCanvas
import java.awt.Color
import java.awt.Graphics

class System(var springPairs: Array<SpringPair> = arrayOf(), var fields: Array<Field> = arrayOf(), var frame: Long = 0) {
    fun simulate() {
        //Calculate the new positions of every particle
        frame++
        for (springPair in springPairs) {
            var force1 = Vector()
            var force2 = Vector()
            for (field in fields) {
                val fieldForce = field.fieldForce
                val velocityScalar = field.velocityScalar
                force1 += springPair.particle1.pos.fieldForce()
                force2 += springPair.particle2.pos.fieldForce()
                if (!springPair.particle1.fixedVel) springPair.particle1.vel = springPair.particle1.vel * (((springPair.particle1.pos.velocityScalar() - 1) * SPF) + 1)
                if (!springPair.particle2.fixedVel) springPair.particle2.vel = springPair.particle2.vel * (((springPair.particle2.pos.velocityScalar() - 1) * SPF) + 1)
            }
            springPair.applyForce(force1, force2)
            springPair.applyVel()
            springPair.capPos()
        }

        //Apply the new positions of every particle
        for (springPair in springPairs) {
            springPair.applyPos()
        }
    }
    fun draw(g: Graphics) {
        if (!SHOW_TRAILS) {
            g.color = Color.BLACK
            g.fillRect(0, 0, WIDTH, HEIGHT)
            if (SHOW_FPS){
                g.color = Color.BLACK
                g.fillRect(0, 0, 55, 15)
            }
        }
        if (springPairs.isNotEmpty()) {
            for (springPair in springPairs) {
                TheCanvas.drawSpringPair(g, springPair)
            }
        }
    }
}