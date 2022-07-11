package com.example.notetoself

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import com.example.notetoself.databinding.DialogShowNoteBinding

class DialogShowNote:DialogFragment() {
    private lateinit var binding: DialogShowNoteBinding
    private var note: Note? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogShowNoteBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(binding.root.context)

        val txtTitle = binding.txtTitle
        txtTitle.text = note!!.title

        val txtDescription = binding.txtDescription
        txtDescription.text = note!!.description

        val txtImportant = binding.textViewImportant
        val txtTodo = binding.textViewToDo
        val txtIdea = binding.textViewIdea

        if (!note!!.important) {
            txtImportant.visibility = View.GONE
        }

        if (!note!!.todo) {
            txtTodo.visibility = View.GONE
        }

        if (!note!!.idea) {
            txtIdea.visibility = View.GONE
        }

        val btnOk = binding.btnOk

        builder.setView(binding.root).setMessage("Your Note")

        btnOk.setOnClickListener {
            dismiss()
        }

        return builder.create()
    }

    fun sendNoteSelected(noteSelected: Note) {
        note = noteSelected
    }
}