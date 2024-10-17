package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.random.Random

class DieFragment : Fragment() {

    lateinit var dieTextView: TextView

    var dieSides: Int = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getInt(Companion.DIE_SIDE).run {
                dieSides = this
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rollDie()
        view.setOnClickListener{
            rollDie()
        }
    }

    fun rollDie() {
        dieTextView.text = Random.nextInt(1, dieSides+1).toString()
    }

    companion object {
        const val DIE_SIDE = "sidenumber"

        fun newInstance(sides: Int): DieFragment {
            return DieFragment().apply {
                arguments  = Bundle().apply { putInt(Companion.DIE_SIDE, sides) }
            }
        }

    }
}