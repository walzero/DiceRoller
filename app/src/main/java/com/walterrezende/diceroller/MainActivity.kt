package com.walterrezende.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        findViewById<Button>(R.id.roll_button)?.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        findViewById<ImageView>(R.id.dice_image)?.setImageResource(throwDice().getFace())
    }

    private fun throwDice(): Dice = Dice.values().random()

    private fun Dice.getFace() = this.resourceId

    private enum class Dice(@DrawableRes val resourceId: Int) {
        OneDice(R.drawable.dice_1),
        TwoDice(R.drawable.dice_2),
        ThreeDice(R.drawable.dice_3),
        FourDice(R.drawable.dice_4),
        FiveDice(R.drawable.dice_5),
        SixDice(R.drawable.dice_6)
    }
}