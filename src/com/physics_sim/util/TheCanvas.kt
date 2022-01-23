package com.physics_sim.util

import com.physics_sim.Main
import com.physics_sim.geometrics.Point
import com.physics_sim.geometrics.Vector
import com.physics_sim.physicals.Particle
import com.physics_sim.physicals.SpringPair
import com.physics_sim.util.Constants.Companion.PARTICLE_RADIUS
import com.physics_sim.util.Constants.Companion.PPU
import java.awt.*
import java.awt.Graphics
import kotlin.math.roundToInt

class TheCanvas(background: Color) : Canvas() {

    init {
        this.background = background
    }

    override fun paint(g: Graphics) {
        Main.computeAndDraw(g)
    }

    companion object {
        fun drawVector(g: Graphics, v: Vector, arrow: Boolean = false, l: Double = 1.0, h: Double = 1.0, color: Color = v.color) {
            if (color.alpha != 0){
                g.color = color
                g.drawLine(v.start.x.roundToInt(), v.start.y.roundToInt(), v.end.x.roundToInt(), v.end.y.roundToInt())
                if (arrow) {
                    g.drawLine((v.end.x - h * (v.end.y - v.start.y) - l * (v.end.x - v.start.x)).roundToInt(), (v.end.y + h * (v.end.x - v.start.x) - l * (v.end.y - v.start.y)).roundToInt(), v.end.x.roundToInt(), v.end.y.roundToInt())
                    g.drawLine((v.end.x + h * (v.end.y - v.start.y) - l * (v.end.x - v.start.x)).roundToInt(), (v.end.y - h * (v.end.x - v.start.x) - l * (v.end.y - v.start.y)).roundToInt(), v.end.x.roundToInt(), v.end.y.roundToInt())
                }
            }
        }

        /*fun drawBarriers(g: Graphics, v: Array<Barrier>) {
            for (barrier in v) {
                if (barrier.color.alpha != 0) {
                    g.color = when (GRAPHICS){
                        FAST -> Color(barrier.color.red * barrier.color.alpha/255, barrier.color.green * barrier.color.alpha/255, barrier.color.blue * barrier.color.alpha/255)
                        FANCY -> barrier.color
                    }

                    when (barrier.shape) {
                        Shape.LINE -> {
                            g.drawLine((barrier.line.start.x * Constants.PPU).roundToInt(), (barrier.line.start.y * Constants.PPU).roundToInt(), (barrier.line.end.x * Constants.PPU).roundToInt(), (barrier.line.end.y * Constants.PPU).roundToInt())
                            g.drawOval(((barrier.center.x - barrier.radius) * Constants.PPU).toInt(), ((barrier.center.y - barrier.radius) * Constants.PPU).toInt(), (2 * barrier.radius * Constants.PPU).toInt(), (2 * barrier.radius * Constants.PPU).toInt())
                            g.drawRect((barrier.topLeft.x * Constants.PPU).toInt(), (barrier.topLeft.y * Constants.PPU).toInt(), ((barrier.bottomRight.x - barrier.topLeft.x) * Constants.PPU).toInt(), ((barrier.bottomRight.y - barrier.topLeft.y) * Constants.PPU).toInt())
                        }
                        Shape.CIRCLE -> {
                            g.drawOval(((barrier.center.x - barrier.radius) * Constants.PPU).toInt(), ((barrier.center.y - barrier.radius) * Constants.PPU).toInt(), (2 * barrier.radius * Constants.PPU).toInt(), (2 * barrier.radius * Constants.PPU).toInt())
                            g.drawRect((barrier.topLeft.x * Constants.PPU).toInt(), (barrier.topLeft.y * Constants.PPU).toInt(), ((barrier.bottomRight.x - barrier.topLeft.x) * Constants.PPU).toInt(), ((barrier.bottomRight.y - barrier.topLeft.y) * Constants.PPU).toInt())
                        }
                        Shape.RECTANGLE -> g.drawRect((barrier.topLeft.x * Constants.PPU).toInt(), (barrier.topLeft.y * Constants.PPU).toInt(), ((barrier.bottomRight.x - barrier.topLeft.x) * Constants.PPU).toInt(), ((barrier.bottomRight.y - barrier.topLeft.y) * Constants.PPU).toInt())
                    }
                }
            }
        }

        fun drawFields(g: Graphics, v: Array<Field>) {
            for (field in v) {
                if (field.color.alpha != 0){
                    g.color = when (GRAPHICS){
                        FAST -> Color(field.color.red * field.color.alpha/255, field.color.green * field.color.alpha/255, field.color.blue * field.color.alpha/255)
                        FANCY -> field.color
                    }
                    when (field.shape) {
                        Shape.CIRCLE -> {
                            g.fillOval(((field.center.x - field.radius) * Constants.PPU).toInt(), ((field.center.y - field.radius) * Constants.PPU).toInt(), (2 * field.radius * Constants.PPU).toInt(), (2 * field.radius * Constants.PPU).toInt())
                            g.fillRect((field.topLeft.x * Constants.PPU).toInt(), (field.topLeft.y * Constants.PPU).toInt(), ((field.bottomRight.x - field.topLeft.x) * Constants.PPU).toInt(), ((field.bottomRight.y - field.topLeft.y) * Constants.PPU).toInt())
                        }
                        Shape.RECTANGLE -> g.fillRect((field.topLeft.x * Constants.PPU).toInt(), (field.topLeft.y * Constants.PPU).toInt(), ((field.bottomRight.x - field.topLeft.x) * Constants.PPU).toInt(), ((field.bottomRight.y - field.topLeft.y) * Constants.PPU).toInt())
                        else -> {}
                    }
                }
            }
        }*/

        fun drawPoint(g: Graphics, p: Point, r: Int, color: Color) {
            if (color.alpha != 0) {
                g.color = color
                g.fillOval(p.x.roundToInt() - r, p.y.roundToInt() - r, 2 * r, 2 * r)
            }
        }
        fun drawBoxAroundPoint(g: Graphics, p: Point, r: Int, color: Color) {
            if (color.alpha != 0) {
                g.color = color
                g.fillRect(p.x.roundToInt() - r, p.y.roundToInt() - r, 2 * r, 2 * r)
            }
        }
        fun drawParticle(g: Graphics, p: Particle) {
            drawPoint(g, p.pos * PPU, (PARTICLE_RADIUS * PPU).toInt(), p.color)
        }
        fun drawSpringPair(g: Graphics, p: SpringPair) {
            drawVector(g, Vector(p.particle1.pos * PPU, p.particle2.pos * PPU, Color.WHITE))
            drawParticle(g, p.particle1)
            drawParticle(g, p.particle2)
        }
    }
}