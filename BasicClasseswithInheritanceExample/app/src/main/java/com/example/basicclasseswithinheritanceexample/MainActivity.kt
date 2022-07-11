package com.example.basicclasseswithinheritanceexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val friendlyDestroyer = Destroyer("Invincible")
        val friendlyCarrier = Carrier("Indomitable")

        val enemyDestroyer = Destroyer("Grey Death")
        val enemyCarrier = Carrier("Big Grey Death")

        val friendlyShipyard = ShipYard()

        friendlyDestroyer.takeDamage(enemyDestroyer.attack())
        friendlyDestroyer.takeDamage(enemyCarrier.attack())
        enemyCarrier.takeDamage(friendlyCarrier.attack())
        enemyCarrier.takeDamage(friendlyDestroyer.attack())

        friendlyDestroyer.showStats()
        friendlyCarrier.showStats()

        friendlyShipyard.serviceShip(friendlyCarrier)
        friendlyShipyard.serviceShip(friendlyDestroyer)

        friendlyDestroyer.showStats()
        friendlyCarrier.showStats()

        enemyDestroyer.takeDamage(friendlyDestroyer.attack())
        enemyDestroyer.takeDamage((friendlyCarrier.attack()))
        enemyDestroyer.takeDamage(friendlyDestroyer.attack())
    }
}