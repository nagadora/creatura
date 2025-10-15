package showcase.updaterchoice

import java.io.File
import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * UpdaterChoice mock
 * Cubism Editor の「起動時選択UI」挙動をシミュレーションするコンソール版。
 * ユーザーの選択結果を JSON に保存し、後続フェーズ（通知・再実行）に引き継ぐ想定。
 */
@Serializable
data class UpdatePreference(
    val choice: String,      // ユーザーの選択（update_now / remind_later / no_update_partial_feature）
    val timestamp: String    // 実行時刻
)

fun main() {
    println("=== Cubism Editor Updater Mock ===")
    println("Select your update option:")
    println("1) Update now")
    println("2) Remind me later")
    println("3) Do not update (apply partial feature backport)")

    // --- 入力受付 ---
    print("Enter choice (1-3): ")
    val choice = readln().trim()

    // --- 入力値を判定し、内部的な文字列コードに変換 ---
    val pref = when (choice) {
        "1" -> "update_now"
        "2" -> "remind_later"
