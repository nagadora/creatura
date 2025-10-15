# Shota Kuramoto - Live2D応募用ポートフォリオ

本リポジトリは、Live2D株式会社への応募に際して提出するポートフォリオです。  
Cubism Editor の実使用にもとづき、「アップデート運用の最適化」と「旧版利用の現実に寄り添う機能提供」を中心に、提案と小規模検証を整理しています。

---

## 構成概要
- `proposals/` : 提案ドキュメント（今回の主題：自動アップデート段階導入／旧版向け機能バックポートの期間限定サブスク）  
- `showcase/`  : 提案に紐づく小規模検証（起動時選択UIモック、通知・差分配信の疑似実装など）  
- `assets/`    : 補足資料（UIワイヤー、図、軽量サンプル）

---

## 提案（主題）
- **Cubism Editor：自動アップデーターの段階導入と、旧版向け“機能バックポート”の期間限定サブスクリプション化**  
  **背景：** 企業事情による旧版運用と、セキュリティ更新・体験差の両立が課題。  
  **施策：**
  1. 自動更新は任意適用（通知→適用／組織ポリシーでON/OFF）  
  2. 新機能の一部を旧版へ“非破壊”でバックポート（最長2年の時限サブスク）  
  3. 初回起動時の選択UI（今すぐ更新／後で通知／更新せず機能のみ適用）  
  4. 告知・移行ガイドの整備（起動時、メール、プレスリリース）

**期待効果：** セキュリティ水準の底上げ、分断下の体験格差の緩和、移行インセンティブの設計、旧版需要の収益化。  
参照：[`proposals/auto-updater-backport/README.md`](proposals/auto-updater-backport/README.md)

---

## showcase概要（検証内容）
`showcase/updaterchoice/Main.kt` では、  
**Cubism Editor 起動時の「更新選択UI」挙動を模擬**し、ユーザー選択内容を JSON に記録する処理を実装しています。

**主な検証要素：**
- Kotlinでの入出力とファイル書き込み  
- kotlinx.serialization を用いた JSON 化処理  
- 入力選択肢と内部状態のマッピング設計（update_now / remind_later / no_update_partial_feature）  
- 今後の UI 実装・差分配信処理への橋渡しを想定  

> このサンプルは、UI構成・保存フローの設計意図を明示するための**最小実装**であり、  
> 実務段階での「非破壊更新ロジック」「ユーザー通知連携」への展開を見据えています。

---

## 技術スタック・制作環境
- Kotlin / JVM 1.9.24  
- Gradle 9.x（ShadowJar 利用）・Java Toolchain 21  
- Unity 2022.3 / C#  
- WebGL / TypeScript（検証用）  
- Live2D Cubism Editor 5.x  

---

## 意図
- 旧版運用の現実とセキュリティ・UXの要請を両立させる、**現実的導線の設計**  
- “最小実装→社内検証→パイロット提供→集約” の段階論で、運用負荷と分断固定化を抑制  
- 海外ユーザーにも通じる明快な選択UI／告知で、配布と広報の整合を意識  

---

## 参考
- 提案本文：[`proposals/auto-updater-backport/`](proposals/auto-updater-backport/)  
- showcase Kotlin実装：[`showcase/updaterchoice/Main.kt`](showcase/updaterchoice/Main.kt)  
- ライセンス：[`LICENSE`](LICENSE)

---

## 注記
- 本リポジトリは個人的な見解・検証であり、Live2D社内情報や非公開資料は含みません。  

© 2025 Shota Kuramoto  
