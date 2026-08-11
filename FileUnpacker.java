import javax.swing.*;
import java.awt.event.*;
import java.io.*;

class FileUnpacker
{
    public static void main(String A[])
    {
        JFrame frame = new JFrame("File Unpacker Application");

        JLabel fileLabel = new JLabel("Enter File Name : ");
        fileLabel.setBounds(50, 50, 150, 30);

        JTextField fileTextField = new JTextField();
        fileTextField.setBounds(200, 50, 150, 30);

        JButton unpackButton = new JButton("Unpack Files");
        unpackButton.setBounds(150, 100, 150, 30);

        frame.setLayout(null);

        frame.add(fileLabel);
        frame.add(fileTextField);
        frame.add(unpackButton);

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        unpackButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String packFileName = fileTextField.getText();

                    File fpackobj = new File(packFileName);

                    if(fpackobj.exists())
                    {
                        FileInputStream fiobj =
                            new FileInputStream(fpackobj);

                        byte Header[] = new byte[100];

                        int iRet = 0;

                        while((iRet = fiobj.read(Header, 0, 100)) != -1)
                        {
                            String strHeader = new String(Header);

                            System.out.println("Header is : " + strHeader);

                            strHeader = strHeader.trim();
                            strHeader = strHeader.replaceAll("\\s+", " ");

                            String Tokens[] = strHeader.split(" ");

                            String FileName = Tokens[0];
                            int FileSize = Integer.parseInt(Tokens[1]);

                            System.out.println("File name : " + FileName);
                            System.out.println("File size : " + FileSize);

                            File NewFile = new File(FileName);

                            NewFile.createNewFile();

                            FileOutputStream foobj =
                                new FileOutputStream(NewFile);

                            byte Buffer[] = new byte[FileSize];

                            fiobj.read(Buffer, 0, FileSize);

                            for(int j = 0; j < FileSize; j++)
                            {   
                                Buffer[j] = (byte)(Buffer[j] ^ 'A');
                            }


                            foobj.write(Buffer, 0, FileSize);

                            foobj.close();
                        }

                        fiobj.close();

                        JOptionPane.showMessageDialog(
                            frame,
                            "Files Unpacked Successfully..!"
                        );
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(
                            frame,
                            "There is no such packed file..!"
                        );
                    }
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(
                        frame,
                        "Error : " + ex.getMessage()
                    );

                    ex.printStackTrace();
                }
            }
        });
    }
}