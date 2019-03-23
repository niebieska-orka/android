package niebieskaorka.boradgames.ui

import android.app.DownloadManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Vibrator
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.google.android.gms.vision.CameraSource
import com.google.android.gms.vision.Detector
import com.google.android.gms.vision.barcode.Barcode
import com.google.android.gms.vision.barcode.BarcodeDetector
import niebieskaorka.boradgames.R
import java.lang.Exception
import kotlin.concurrent.thread
import kotlin.contracts.contract

class QrScanner : AppCompatActivity() {
    lateinit var cameraPreview: SurfaceView
    lateinit var barcodeDetector: BarcodeDetector
    lateinit var cameraSource: CameraSource
    val requestCameraPermissionID = 1001

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            requestCameraPermissionID -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.checkSelfPermission(
                            applicationContext,
                            android.Manifest.permission.CAMERA
                        ) != PackageManager.PERMISSION_GRANTED
                    ) {
                        println("NIe ma uprawnien")
                        return
                    }

                    try {
                        cameraSource.start(cameraPreview.holder)
                    } catch (e: Exception) {
                        print("XDD zepsuło sie")
                    }
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.qr_screen)

        cameraPreview = findViewById(R.id.camera_preview)
        barcodeDetector = BarcodeDetector.Builder(this)
            .setBarcodeFormats(Barcode.QR_CODE)
            .build()
        cameraSource = CameraSource.Builder(this, barcodeDetector)
            .setRequestedPreviewSize(256, 256)
            .build()

        cameraPreview.holder.addCallback(object : SurfaceHolder.Callback {
            override fun surfaceCreated(holder: SurfaceHolder?) {
                if (ActivityCompat.checkSelfPermission(
                        applicationContext,
                        android.Manifest.permission.CAMERA
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    val permissions = arrayOf(android.Manifest.permission.CAMERA)
                    ActivityCompat.requestPermissions(this@QrScanner, permissions, 0)
                    return
                }
                try {
                    cameraSource.start(cameraPreview.holder)
                } catch (e: Exception) {
                    print("XDD zepsuło sie")
                }
            }

            override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {
            }

            override fun surfaceDestroyed(holder: SurfaceHolder?) {
                cameraSource.stop()
            }

        })

        barcodeDetector.setProcessor(object : Detector.Processor<Barcode> {
            override fun release() {
            }

            override fun receiveDetections(detections: Detector.Detections<Barcode>) {
                val qrCodes = detections.detectedItems

                if (qrCodes.size() != 0) {
                    thread(start = true) {
                        val vibratorService = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                        vibratorService.vibrate(1000)

                        println(qrCodes.valueAt(0).displayValue)
                        // Uruchamianie resta
                    }
                }
            }
        })
    }
}