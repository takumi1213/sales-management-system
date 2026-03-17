# Sales Management App（営業管理アプリ）

## 📌 概要
顧客・案件（商談）・商談メモを管理できるシンプルな営業管理アプリです。  
営業活動の可視化と、情報の一元管理を目的として開発しました。

---

## 🚀 機能一覧

### 👤 顧客管理
- 顧客一覧表示
- 顧客登録
- 顧客詳細表示

### 💼 案件（商談）管理
- 案件登録（顧客ごと）
- 案件一覧表示
- 案件詳細表示
- ステータス管理（提案中 / 交渉中 / 受注 / 失注）

### 📝 商談メモ
- メモ登録
- メモ一覧表示
- 作成日時の自動保存

---

## 🖥️ 画面イメージ

### 顧客一覧
（ここにスクショ貼る）

### 顧客詳細
（ここにスクショ貼る）

### 案件詳細
（ここにスクショ貼る）

---

## 🛠️ 使用技術

### バックエンド
- Java 17
- Spring Boot
- Spring Data JPA

### フロントエンド
- Thymeleaf
- Bootstrap

### データベース
- H2 Database

---

## 📂 ER図（簡易）

Customer（顧客）
↓ 1対多  
Deal（案件）
↓ 1対多  
Memo（メモ）

---

## ブラウザアクセス
http://localhost:8080/customers

---

## 🔧 セットアップ方法

```bash
git clone https://github.com/your-username/sales-management.git
cd sales-management
./gradlew bootRun