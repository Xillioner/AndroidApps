package com.example.dialogdemo

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class MyDialog:DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder=AlertDialog.Builder(this.requireActivity()!!)
        builder.setMessage("Make a selection")
            .setPositiveButton("Ok",{dialog,id ->

        }).setNegativeButton("Cancel",{dialog,id ->

            })
        //return super.onCreateDialog(savedInstanceState)
        return builder.create()
    }
}