package com.example.basicclasses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val friendlyDestroyer=Destroyer("Invincible")
        val friendlyCarrier = Carrier("Indomitable")

        val enemyDestroyer = Destroyer("Grey Death")
        val enemyCarrier = Carrier("Big grey Death")

        val friendlyShipyard = ShipYard()
        friendlyDestroyer.takeDamage(enemyDestroyer.shootShell())
        friendlyDestroyer.takeDamage(enemyCarrier.launchAerialAttack())

        enemyCarrier.takeDamage(friendlyCarrier.launchAerialAttack())
        enemyCarrier.takeDamage(friendlyDestroyer.shootShell())

        Log.d("${friendlyDestroyer.name} ammo = ","${friendlyDestroyer.ammo}")
        Log.d("${friendlyCarrier.name} attacks = ","${friendlyCarrier.attacksRemaining}")

        friendlyShipyard.serviceCarrier(friendlyCarrier)
        friendlyShipyard.serviceDestroyer(friendlyDestroyer)

        Log.d("${friendlyDestroyer.name} ammo = ","${friendlyDestroyer.ammo}")
        Log.d("${friendlyCarrier.name} attacks = ","${friendlyCarrier.attacksRemaining}")

        enemyDestroyer.takeDamage(friendlyDestroyer.shootShell())
        enemyDestroyer.takeDamage(friendlyCarrier.launchAerialAttack())
        enemyDestroyer.takeDamage(friendlyDestroyer.shootShell())
    }
}