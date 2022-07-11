package com.example.notetoself

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.notetoself.databinding.DialogNewNoteBinding

class DialogNewNote:DialogFragment() {

    private lateinit var binding:DialogNewNoteBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        binding = DialogNewNoteBinding.inflate(layoutInflater)
        var builder=AlertDialog.Builder(binding.root.context)

        val editTitle = binding.editTitle
        val editDescription = binding.editDescription
        val checkBoxIdea = binding.checkBoxIdea
        val checkBoxTodo = binding.checkBoxToDo
        val checkBoxImportant = binding.checkBoxImportant
        val btnCancel = binding.btnCancel
        val btnOk = binding.btnDialogOk

        builder.setView(binding.root).setMessage("Add a new note")
        btnCancel.setOnClickListener{
            dismiss()
        }
        btnOk.setOnClickListener {
            val newNote = Note()
            newNote.title = editTitle.text.toString()
            newNote.description = editDescription.text.toString()

            newNote.idea = checkBoxIdea.isChecked
            newNote.todo = checkBoxTodo.isChecked
            newNote.important = checkBoxImportant.isChecked

            val callingActivity =  activity as MainActivity?
            callingActivity!!.createNewNote(newNote)
            dismiss()
        }
        return builder.create()
    }

}