package com.walterrezende.diceroller

import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.walterrezende.diceroller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val diceValues by lazy { Dice.values() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setOnClickListeners()
    }

    /***
     * sets the necessary onClickListeners for activity_main
     */
    private fun setOnClickListeners() = binding.run {
        rollButton.setOnClickListener { rollDice() }
    }

    /***
     * Gets a random dice face and shows it's image
     */
    private fun rollDice() = binding.run {
        diceImage.setImageResource(throwDice().checkFace())
    }

    /***
     * Generates a random dice value based on all possible values
     */
    private fun throwDice(): Dice = diceValues.random()

    /***
     * extension function to get resourceId based on a Dice value
     */
    private fun Dice.checkFace() = this.resourceId

    private enum class Dice(@DrawableRes val resourceId: Int) {
        OneDice(R.drawable.dice_1),
        TwoDice(R.drawable.dice_2),
        ThreeDice(R.drawable.dice_3),
        FourDice(R.drawable.dice_4),
        FiveDice(R.drawable.dice_5),
        SixDice(R.drawable.dice_6)
    }
}