# File Packer and Unpacker with Encryption

A Java-based desktop application that allows users to **pack multiple files from a folder into a single file** and later **unpack the files back to their original form**.

The application uses **XOR-based encryption and decryption** to protect file data during the packing and unpacking process.

---

## 📌 Project Description

The **File Packer and Unpacker** is a Java Swing-based desktop application developed to demonstrate:

* File handling
* File packing and unpacking
* Java Swing GUI
* Java I/O streams
* XOR encryption and decryption
* Byte-level file operations

The application consists of two modules:

### 1. File Packer

The File Packer takes a folder as input and combines multiple files into a single packed file.

For each file, it stores:

* File name
* File size
* Encrypted file contents

A fixed-size **100-byte header** is created for each file. The header contains the file name and file size, followed by the encrypted file data.

### 2. File Unpacker

The File Unpacker takes the packed file as input and extracts the files stored inside it.

It:

1. Reads the 100-byte header.
2. Extracts the file name and file size.
3. Reads the encrypted file data.
4. Performs XOR decryption.
5. Recreates the original file.

---

## ✨ Features

* 🖥️ Simple Java Swing GUI
* 📦 Pack multiple files into a single file
* 📂 Unpack files from a packed file
* 🔐 XOR-based encryption during packing
* 🔓 XOR-based decryption during unpacking
* 📄 Stores file name and file size in the header
* 💾 Uses Java File I/O streams
* ⚡ Byte-level file processing
* ⚠️ Displays success and error messages
* 📁 Supports different types of files

---

## 🔐 XOR Encryption and Decryption

The project uses the **XOR (`^`) operator** for basic encryption and decryption.

### Encryption

During packing, each byte of the file is XORed with the key `'A'`.


### Decryption

During unpacking, the same XOR operation is performed to retrieve the original data.

### Working

```text
Original Data
      ↓
Data ^ Key
      ↓
Encrypted Data
      ↓
Encrypted Data ^  key
      ↓
Original Data
```

XOR works in both directions because:

```text
DATA ^ KEY ^ KEY = DATA
```

> **Note:** This XOR implementation is for educational purposes and should not be considered strong encryption for real-world security.

---

## 🛠️ Technologies Used

* **Java**
* **Java Swing**
* **Java AWT**
* **Java File I/O**
* **XOR Operator (`^`)**

---

## 📂 Project Structure

```text
File-Packer-Unpacker/
│
├── FilePacker.java
├── FileUnpacker.java
└── README.md
```

---

## 🚀 How to Run

### Step 1: Compile FilePacker

```bash
javac FilePacker.java
```

### Step 2: Run FilePacker

```bash
java FilePacker
```

Enter:

```text
Folder Name: path/to/folder
File Name: Packed.dat
```

Click:

**Pack Files**

The files will be packed and encrypted into the packed file.

---

### Step 3: Compile FileUnpacker

```bash
javac FileUnpacker.java
```

### Step 4: Run FileUnpacker

```bash
java FileUnpacker
```

Enter:

```text
File Name: Packed.dat
```

Click:

**Unpack Files**

The application will decrypt and extract the original files.

---

## 🔄 Working Example

Suppose the folder contains:

```text
Documents/
├── file1.txt
├── file2.txt
└── file3.txt
```

After packing:

```text
Documents/
├── file1.txt
├── file2.txt
├── file3.txt
└── Packed.dat
```

The `Packed.dat` file contains:

```text
100-byte Header
Encrypted File 1 Data

100-byte Header
Encrypted File 2 Data

100-byte Header
Encrypted File 3 Data
```

After unpacking:

```text
file1.txt
file2.txt
file3.txt
```

The original file contents are restored through XOR decryption.

---

## 🧠 Working Principle

### 📦 Packing Process

```text
Folder
   ↓
Read Files
   ↓
Get File Name + File Size
   ↓
Create 100-Byte Header
   ↓
Read File Data
   ↓
XOR Encryption
   ↓
Write Header + Encrypted Data
   ↓
Packed File
```

### 📂 Unpacking Process

```text
Packed File
     ↓
Read 100-Byte Header
     ↓
Get File Name + File Size
     ↓
Read Encrypted Data
     ↓
XOR Decryption
     ↓
Create Original File
     ↓
Extracted Files
```

---

## 📋 File Header Format

Each file stored in the packed file has a **100-byte header**.

The header contains:

```text
File Name + File Size + Padding Spaces
```

Example:

```text
sample.txt 1500
```

The remaining space is filled with spaces until the header reaches 100 bytes.

This allows the unpacker to know:

* Which file is being extracted
* How many bytes should be read for that file

---

## 🎯 Learning Objectives

This project helps in understanding:

* Java Swing GUI development
* Event handling using `ActionListener`
* File and directory handling
* `FileInputStream`
* `FileOutputStream`
* Byte-level file operations
* File packing and unpacking
* XOR encryption and decryption
* Reading and writing binary data
* Exception handling
* Desktop application development

---

## ⚠️ Security Note

The application uses a fixed XOR key:

```text
'A'
```

This is a **basic educational encryption technique** and is **not secure cryptography**.

For real-world applications, stronger encryption algorithms such as **AES** should be used.

---

## 📸 Application

### File Packer

The File Packer GUI allows the user to enter the folder path and packed file name.

### File Unpacker

The File Unpacker GUI allows the user to enter the packed file name and extract the original files.

---

## 👨‍💻 Author

**Mayur Kishor Ahire**

---

