package com.example.eventm

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaScannerConnection
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.webkit.PermissionRequest
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.net.toFile
import com.example.eventm.Model.editProfil.EditProfil
import com.example.evntm.Common.Common
import com.example.myapp.Remote.IMyAPI
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.DexterError
import com.karumi.dexter.listener.PermissionRequestErrorListener
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.vansuita.pickimage.bean.PickResult
import com.vansuita.pickimage.bundle.PickSetup
import com.vansuita.pickimage.dialog.PickImageDialog
import com.vansuita.pickimage.listeners.IPickResult
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.activity_quiz.view.*
import kotlinx.android.synthetic.main.activity_register.*
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.*
import java.util.*

class EditActivity : AppCompatActivity(), IPickResult {

    private lateinit var image : File
    private lateinit var filepath : Uri


    internal lateinit var mEdit : IMyAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        mEdit=Common.api

        requestMultiplePermissions()

        edit_profil_img.setOnClickListener{
            PickImageDialog.build(PickSetup().setWidth(100).setHeight(100)).show(supportFragmentManager)
        }

        btn_yes.setOnClickListener {

            EditUsers(
                nameEdit.text.toString(),
                organiEdit.text.toString(),
                jobEdit.text.toString(),
                image,
                emailEdit.text.toString(),
                phoneEdit.text.toString()
                )
        }
    }


    private fun requestMultiplePermissions() {
        Dexter.withActivity(this)
            .withPermissions(
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
            .withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport) {
                    // check if all permissions are granted
                    if (report.areAllPermissionsGranted()) {
                        Toast.makeText(
                            applicationContext,
                            "All permissions are granted by user!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    // check for permanent denial of any permission
                    if (report.isAnyPermissionPermanentlyDenied()) {
                        // show alert dialog navigating to Settings
                        //openSettingsDialog();
                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: MutableList<com.karumi.dexter.listener.PermissionRequest>?,
                    token: PermissionToken?
                ) {
                    if (token != null) {
                        token.continuePermissionRequest()
                    }
                }
            }).withErrorListener(object : PermissionRequestErrorListener {
                override fun onError(error: DexterError) {
                    Toast.makeText(applicationContext, "Some Error! ", Toast.LENGTH_SHORT).show()
                }
            })
            .onSameThread()
            .check()
    }

    fun EditUsers(name: String, organisasi:String,jobtitle:String,image:File,email:String,PhoneNumber:String){
        val mName = RequestBody.create("text/plain".toMediaTypeOrNull(), name)
        val mOrganisasi = RequestBody.create("text/plain".toMediaTypeOrNull(), organisasi)
        val mJobtitle = RequestBody.create("text/plain".toMediaTypeOrNull(), jobtitle)
        val mEmail = RequestBody.create("text/plain".toMediaTypeOrNull(), email)
        val mPhoneNume = RequestBody.create("text/plain".toMediaTypeOrNull(), PhoneNumber)
        val filepart = MultipartBody.Part
            .createFormData("user_image", image.name, RequestBody
                .create("image/*".toMediaTypeOrNull(), image))



        mEdit.getEditProf(getID(),mName,mOrganisasi,mJobtitle,filepart,mEmail,mPhoneNume)
            .enqueue(object : Callback<EditProfil> {
                override fun onFailure(call: Call<EditProfil>, t: Throwable) {
                    Log.e("errornya", t!!.message.toString())
                    Toast.makeText(this@EditActivity,t!!.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<EditProfil>, response: Response<EditProfil>) {
                    Log.e("responsenya ", response.body().toString())
                    if(response.isSuccessful){
                        Toast.makeText(this@EditActivity, "behasil", Toast.LENGTH_LONG).show()
                        onBackPressed()// saat di klik balik kehalaman awal
                    }
                }

            })
    }

    override fun onPickResult(r: PickResult?) {
        if (r!!.error == null) {

            val filepath = r.uri
            edit_profil_img.setImageURI(filepath)
            image = File(r.path)
            edit_profil_img.setImageBitmap(BitmapFactory.decodeFile(image.absolutePath))

            Log.d("OnPickResult", "onPickResult: filepath $filepath")

        } else {
            Log.d("OnPickResult", "onPickResult: error image picker " + r.error)
            Toast.makeText(this, r.error.toString(), Toast.LENGTH_LONG).show();
        }
    }

}