package com.physics_sim

import com.physics_sim.geometrics.Point
import com.physics_sim.geometrics.Vector
import com.physics_sim.physicals.Field
import com.physics_sim.physicals.Particle
import com.physics_sim.physicals.SpringPair
import com.physics_sim.util.Constants
import com.physics_sim.util.Constants.Companion.SCALE_HEIGHT
import com.physics_sim.util.Constants.Companion.randomPos
import com.physics_sim.util.Constants.Companion.system
import com.physics_sim.util.VectorSpace
import java.awt.Color
import java.awt.Graphics
import kotlin.math.PI

fun main() {

    system.springPairs = arrayOf(SpringPair(Particle(randomPos()), Particle(randomPos()), 10.0, 1.0))
    system.fields = arrayOf(Field({0.7}, { Vector(this, Point(this.x, SCALE_HEIGHT/2)) } ))
    val screen = VectorSpace()
}

object Main {

    fun computeAndDraw(g: Graphics) {
        g.color = Color.BLACK
        g.fillRect(0, 0, Constants.WIDTH, Constants.HEIGHT)
        while (true) {
            //Draw Frame
            Thread.sleep(1)
            system.draw(g)

            //Compute Next Frame
            system.simulate()
        }
    }
}