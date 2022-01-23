package com.physics_sim.physicals

import com.physics_sim.geometrics.Point
import com.physics_sim.geometrics.Vector
import com.physics_sim.util.Constants
import com.physics_sim.util.EdgeBehavior.*
import java.awt.Color

class Particle(var pos: Point, var lastPos: Point = pos, var nextPos: Point = pos,
               var vel: Vector = Vector(),
               var mass: Double = 1.0, var color: Color = Color.ORANGE, var fixedVel: Boolean = false) {

    fun applyForce(force: Vector) {
        if (!fixedVel){
            vel += force * mass
            if (vel.magnitude() > Constants.MAX_VEL) {
                vel = vel.norm() * Constants.MAX_VEL
            }
        }
    }
    fun applyVel(updateLastPos: Boolean = true) {
        if (updateLastPos) lastPos = pos
        nextPos += (vel.center() * Constants.SPF).end
    }
    fun capPos() {
        when (Constants.EDGE_BEHAVIOR) {
            LOOP -> {
                if (nextPos.x >= Constants.SCALE_WIDTH) {
                    nextPos.x = nextPos.x % Constants.SCALE_WIDTH
                } else if (nextPos.x < 0) {
                    nextPos.x = nextPos.x % Constants.SCALE_WIDTH + Constants.SCALE_WIDTH
                }
                if (nextPos.y >= Constants.SCALE_HEIGHT) {
                    nextPos.y = nextPos.y % Constants.SCALE_HEIGHT
                } else if (nextPos.y < 0) {
                    nextPos.y = nextPos.y % Constants.SCALE_HEIGHT + Constants.SCALE_HEIGHT
                }
            }
            BORDER -> {
                if (nextPos.x >= Constants.SCALE_WIDTH) {
                    vel = Vector(Point(vel.x(), -vel.y()))
                    nextPos = Point(Constants.SCALE_WIDTH - 0.001, nextPos.y)
                } else if (nextPos.x < 0) {
                    vel = Vector(Point(vel.x(), -vel.y()))
                    nextPos = Point(0.001, nextPos.y)
                }
                if (nextPos.y >= Constants.SCALE_HEIGHT) {
                    vel = Vector(Point(-vel.x(), vel.y()))
                    nextPos = Point(nextPos.x, Constants.SCALE_HEIGHT - 0.001)
                } else if (nextPos.y < 0) {
                    vel = Vector(Point(-vel.x(), vel.y()))
                    nextPos = Point(nextPos.x, 0.001)
                }
            }
            NOTHING -> {}
        }
    }
}