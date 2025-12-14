package tw.edu.pu.tcyang.selfiegesture

import android.content.Context
import androidx.camera.core.CameraSelector
import androidx.camera.view.LifecycleCameraController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class PreviewViewModel : ViewModel() {
    // 保存相機控制器
    var cameraController by
    mutableStateOf<LifecycleCameraController?>(null)
        private set

    // 建立並設定 LifecycleCameraController 的方法
    fun setupCameraController(context: Context) {
        if (cameraController == null) {
            cameraController =
                LifecycleCameraController(context)  // 創建實例

            // 設定前置鏡頭(自拍)
            cameraController?.cameraSelector =
                CameraSelector.DEFAULT_FRONT_CAMERA
        }
    }

    // 釋放相機資源的方法
    fun releaseCameraController() {
        cameraController?.unbind()
        cameraController = null
    }
}