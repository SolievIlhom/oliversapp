package com.oliverworks.myapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment

class FragmentMoviesList : Fragment() {
    private var listener:GoToDetailsListener? = null
    lateinit var constraintLayout: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_movies_list, container, false)
        constraintLayout = view.findViewById(R.id.mainBody)
        constraintLayout.setOnClickListener{
            goToDetails()
        }
        return view;
    }

    private fun goToDetails() {
        listener?.goToDetails()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is GoToDetailsListener){
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}