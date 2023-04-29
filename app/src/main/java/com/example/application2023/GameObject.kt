package com.example.application2023

open class GameObject(private var x: Int,private var y: Int) {
    //Quand on aura avancer dans le codage, il faudra faire en sorte que tous les objets heritent d'une classe commune
    fun getX(): Int {
        return x
    }

    fun setX(a: Int) {
        x=a
    }

    fun getY(): Int {
        return y
    }

    fun setY(a: Int) {
        y=a
    }

}