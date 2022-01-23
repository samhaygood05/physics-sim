package com.physics_sim.util

import com.physics_sim.util.Constants
import com.physics_sim.util.TheCanvas
import javax.swing.JFrame
import java.awt.BorderLayout
import java.awt.Color

class VectorSpace : JFrame {

    private val canvas = TheCanvas(Color.BLACK)

    constructor() {
        layout = BorderLayout()
        setSize(Constants.WIDTH, Constants.HEIGHT)
        title = "Vector Space"
        add("Center", canvas)
        defaultCloseOperation = EXIT_ON_CLOSE
        setLocationRelativeTo(null)
        isVisible = true
    }
    constructor(width: Int, height: Int) {
        layout = BorderLayout()
        setSize(width, height)
        title = "Vector Space"
        add("Center", canvas)
        defaultCloseOperation = EXIT_ON_CLOSE
        setLocationRelativeTo(null)
        isVisible = true
    }
}