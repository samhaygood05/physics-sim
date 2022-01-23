package com.physics_sim.util

import com.physics_sim.util.EdgeBehavior.*
import com.physics_sim.util.Graphics.*
import com.physics_sim.geometrics.Point
import com.physics_sim.geometrics.Vector
import kotlin.math.PI
import kotlin.math.pow

class Constants {

    companion object {

        // Math Constants
        @JvmField val TWO_PI_SQUARED = 2 * PI.pow(2.0)

        // Screen Constants
        const val WIDTH = 1200
        const val HEIGHT = 1200 / 16 * 9
        @JvmField val CENTER = Point((WIDTH / 2).toDouble(), (HEIGHT / 2).toDouble())

        // Simulation Constants
        const val SPF = 0.00001
        const val PPU = 50
        const val SCALE_WIDTH = WIDTH.toDouble() / PPU
        const val SCALE_HEIGHT = HEIGHT.toDouble() / PPU
        @JvmField val begin: Double = System.currentTimeMillis() / 1000.0

        @JvmField val SCALED_CENTER = Point(SCALE_WIDTH / 2, SCALE_HEIGHT / 2)
        @JvmField val EDGE_BEHAVIOR = BORDER


        // Interaction Constants
        const val CHARGE_FORCE = .5
        const val DELTA_CHARGE_FORCE = 1 * SPF
        const val PARTICLE_RADIUS = 0.3
        const val PUSHBACK_FORCE = -0.01
        const val MAX_VEL = 100.0
        const val MAX_CHARGE = 5.0
        const val ATTRACTOR_CHARGE = 10.0

        // Graphics Constants
        @JvmField val GRAPHICS = FAST
        const val SHOW_TRAILS = false

        // Debug Constants
        const val DEBUG = false
        const val PARTICLE_DEBUG = true
        const val BARRIER_DEBUG = false
        const val FIELD_DEBUG = false
        const val SHOW_FPS = true

        @JvmField var system: com.physics_sim.physicals.System = com.physics_sim.physicals.System()

        // Functions
        @JvmStatic fun randomPos() = Point(Math.random() * SCALE_WIDTH, Math.random() * SCALE_HEIGHT)
    }
}

typealias vectorField = Point.() -> Vector
typealias scalarField = Point.() -> Double

enum class EdgeBehavior {
    BORDER, LOOP, NOTHING
}

enum class Graphics {
    FAST, FANCY
}