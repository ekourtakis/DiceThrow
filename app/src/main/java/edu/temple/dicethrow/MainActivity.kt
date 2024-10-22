package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportFragmentManager.findFragmentById(R.id.dieContainer) !is DieFragment)
            supportFragmentManager
                .beginTransaction()
                .add(R.id.dieContainer, DieFragment.newInstance(20))
                .commit()
    }

    fun buttonClicked(){
        (supportFragmentManager.findFragmentById(R.id.dieContainer) as DieFragment).rollDie()
    }
}