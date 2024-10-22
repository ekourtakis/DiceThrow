package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.random.Random

class DieFragment : Fragment() {

    private lateinit var dieTextView: TextView

    private var dieSides: Int = 6
    private var rollVal: Int = 0
    private val BUNDLE_KEY = "BUNDLE_KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getInt(DIE_SIDE).run {
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
        savedInstanceState?.run {
            rollVal = getInt(BUNDLE_KEY)
            dieTextView.text = rollVal.toString()
            return
        }

        rollDie()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(BUNDLE_KEY, rollVal)
    }

    fun rollDie() {
        rollVal = Random.nextInt(1, dieSides+1)
        dieTextView.text = rollVal.toString()
    }

    companion object {
        const val DIE_SIDE = "sidenumber"

        fun newInstance(sides: Int): DieFragment {
            return DieFragment().apply {
                arguments  = Bundle().apply { putInt(DIE_SIDE, sides) }
            }
        }

    }
}