package com.walterrezende.diceroller

import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setOnClickListeners()
    }

    /***
     * sets the necessary onClickListeners for activity_main
     */
    private fun setOnClickListeners() {
        roll_button?.setOnClickListener {
            rollDice()
        }
    }

    /***
     * Gets a random dice face and shows it's image
     */
    private fun rollDice() {
        dice_image?.setImageResource(throwDice().getFace())
    }

    /***
     * Generates a random dice value based on all possible values
     */
    private fun throwDice(): Dice = Dice.values().random()

    /***
     * extension function to get resourceId based on a Dice value
     */
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