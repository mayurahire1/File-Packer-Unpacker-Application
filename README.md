# File Packer and Unpacker 

A Java-based desktop application that allows users to **pack multiple files from a folder into a single file** and later **unpack the files back to their original form**.

The project uses **Java Swing** for the graphical user interface and **Java I/O streams** for reading and writing files.

## 📌 Project Description

The File Packer and Unpacker application is designed to demonstrate file handling and GUI programming in Java.

The application consists of two modules:

### 1. File Packer

The File Packer takes a folder as input and combines all the files present inside the folder into a single packed file.

For each file, the application stores:

* File name
* File size
* File contents

A fixed-size **100-byte header** is created for each file. The header contains the file name and file size, followed by the actual file data.

### 2. File Unpacker

The File Unpacker takes the packed file as input and extracts all the files stored inside it.

It reads the 100-byte header, identifies the file name and file size, and then reads the corresponding file data to recreate the original file.

## ✨ Features

* Simple and user-friendly Swing GUI
* Pack multiple files into a single file
* Unpack files from a packed file
* Stores file name and file size in the header
* Uses Java File I/O streams
* Displays success and error messages
* Supports different types of files

## 🛠️ Technologies Used

* **Java**
* **Java Swing**
* **Java AWT Event Handling**
* **Java File I/O**
* `FileInputStream`
* `FileOutputStream`
* `JFrame`
* `JLabel`
* `JTextField`
* `JButton`
* `JOptionPane`

## 📂 Project Structure

```text
File-Packer-Unpacker/
│
├── FilePacker.java
├── FileUnpacker.java
└── README.md
```

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

* Folder name/path
* Packed file name

Then click **Pack Files**.

### Step 3: Compile FileUnpacker

```bash
javac FileUnpacker.java
```

### Step 4: Run FileUnpacker

```bash
java FileUnpacker
```

Enter the packed file name and click **Unpack Files**.

## 🔄 Working Example

Suppose a folder contains:

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

The `Packed.dat` file contains the information and data of all three files.

When the packed file is unpacked, the original files are recreated:

```text
file1.txt
file2.txt
file3.txt
```

## 🧠 Working Principle

### Packing

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
Write Header + Data
   ↓
Packed File
```

### Unpacking

```text
Packed File
     ↓
Read 100-Byte Header
     ↓
Get File Name + File Size
     ↓
Read File Data
     ↓
Create Original File
     ↓
Extracted Files
```

## 🎯 Learning Objectives

This project helps understand:

* Java Swing GUI development
* Event handling using `ActionListener`
* File and directory handling
* `FileInputStream` and `FileOutputStream`
* Byte-level file operations
* Reading and writing binary data
* Exception handling
* Basic application development in Java


## 👨‍💻 Author

**Mayur Kishor Ahire**

## 📄 License

This project is available for educational and learning purposes.
