package com.physics_sim.geometrics

import kotlin.math.round

class Point {

    var x: Double
    var y: Double
    constructor(x: Double = 0.0, y: Double = 0.0) {
        this.x = x
        this.y = y
    }
    constructor(x: Int, y: Int) {
        this.x = x.toDouble()
        this.y = y.toDouble()
    }

    operator fun plus(that: Point) = Point(this.x + that.x, this.y + that.y)

    operator fun minus(that: Point) = Point(this.x - that.x, this.y - that.y)

    operator fun times(that: Double) = Point(this.x * that, this.y * that)
    operator fun times(that: Int) = Point(this.x * that, this.y * that)
    operator fun Double.times(that: Point) = that * this

    operator fun div(that: Double) = this * (1.0/that)

    fun dist(that: Point = Point()) = Vector(this, that).magnitude()
    fun disp(that: Vector) = Vector(that.start, this).perp(that)

    fun inside(k: BoundingBox): Boolean = x <= k.a.x.coerceAtLeast(k.b.x) && x >= k.a.x.coerceAtMost(k.b.x) && y <= k.a.y.coerceAtLeast(k.b.y) && y >= k.a.y.coerceAtMost(k.b.y)

    override fun toString(): String = "( ${round(x * 10000) / 10000} , ${round(x * 10000) / 10000} )"

}