package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //find the button in the layout
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener()
        {
            //do dice roll when the app starts
            rollDice()
        }
    }
    //roll the dice and update the screen
    private fun rollDice()
    {
        //create dice with 6 sides
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //find ImageView in layout
        val discImage: ImageView = findViewById(R.id.imageView)

        //discImage.setImageResource(R.drawable.dice_2)
        //val resultTextView: TextView = findViewById(R.id.imageView)
        //resultTextView.text = diceRoll.toString()   //convert random int to string

        //determine which drawable resource id to use based on th edice roll
        val drawableResource = when (diceRoll)
        {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        ///update the ImageView with the correct drawable resource ID
        discImage.setImageResource(drawableResource)

        // Update the content description
        discImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int)
{

    fun roll(): Int {
        return (1..numSides).random()
    }
}