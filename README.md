# 🚀 Aplikasi Chat AI dengan Spring Boot + Google Gemini

Aplikasi ini adalah web app full-stack sederhana yang berfungsi sebagai antarmuka chat untuk berinteraksi secara langsung dengan **Google Gemini API**. Proyek ini dibangun menggunakan **Java Spring Boot** untuk backend dan **HTML, CSS, serta JavaScript** untuk frontend.

Tujuan dari proyek ini adalah untuk mendemonstrasikan cara mengintegrasikan layanan AI generatif ke dalam aplikasi web modern, mulai dari penanganan permintaan API hingga penyajian respons ke pengguna secara dinamis.

![image](https://github.com/user-attachments/assets/dfaeb702-f490-4793-87e8-38eece58d2ee)


---

## ✨ Fitur Utama

- **Antarmuka Chat Real-time:** Pengguna dapat mengirim pesan dan menerima balasan dari AI secara langsung.
- **Backend Tangguh:** Dibangun menggunakan Spring Boot untuk menangani logika bisnis dan komunikasi dengan API eksternal.
- **Integrasi Gemini API:** Terhubung secara aman ke Google Gemini API untuk mendapatkan respons cerdas dari model bahasa.
- **Desain Responsif:** Tampilan bersih yang dapat beradaptasi di berbagai ukuran layar menggunakan Bootstrap 5.
- **Indikator Pengetikan:** Memberikan umpan balik visual kepada pengguna saat AI sedang memproses jawaban.

---

## 🔧 Teknologi yang Digunakan

### Backend:
- Java 17  
- Spring Boot 3  
- Spring Web  
- Maven  

### Frontend:
- HTML5  
- CSS3  
- JavaScript (Vanilla)  
- Bootstrap 5  

### Layanan AI:
- Google Gemini API

---

## ⚙️ Instalasi dan Konfigurasi

Ikuti langkah-langkah berikut untuk menjalankan proyek ini di lingkungan lokal:

### Prasyarat:
- JDK 17 atau lebih tinggi  
- Apache Maven  
- API Key dari **[Google AI Studio](https://aistudio.google.com/)**

Konfigurasi API Key:
Buka file src/main/resources/application.properties

Ubah nilainya sebagai berikut:

gemini.api.key=YOUR_API_KEY_HERE
gemini.api.url=https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent

🔌 Struktur API
Aplikasi ini memiliki satu endpoint utama:

Endpoint: POST /api/chat

Deskripsi: Menerima pesan dari pengguna dan mengembalikan respons dari Google Gemini AI.
{
  "message": "Halo, apa kabar?"
}

{
  "reply": "Kabar baik! Ada yang bisa saya bantu hari ini?"
}

💡 Ide Pengembangan Selanjutnya
Riwayat Obrolan: Simpan percakapan ke dalam database (H2, PostgreSQL, dll).

Autentikasi Pengguna: Sistem login agar tiap user memiliki riwayat sendiri.

Streaming Response: Tampilkan respons AI secara bertahap (real-time streaming).

Peningkatan UI/UX: Tambahkan mode gelap, ikon, animasi, dan tema.
